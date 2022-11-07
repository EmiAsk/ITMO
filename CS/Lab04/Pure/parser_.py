from tokens import TokenType, Token
from typing import Iterator


class Parser:
    def __init__(self, tokens: Iterator[Token]):
        self.tokens = iter(tokens)
        self.cur_token = None
        self.advance()

    def advance(self):
        self.cur_token = next(self.tokens, None)

    def parse(self):
        result = self.parse_value()

        self.advance()

        if self.cur_token is not None or result == TokenType.UNDEFINED:
            raise SyntaxError("Invalid Syntax")

        if result == TokenType.EOF:
            return ''

        return result

    def parse_value(self):
        token = self.cur_token

        if token is None:
            return TokenType.EOF

        if token.type == TokenType.NUMBER:
            return token.value

        elif token.type == TokenType.STRING:
            return token.value

        elif token.type == TokenType.TRUE:
            return True

        elif token.type == TokenType.FALSE:
            return False

        elif token.type == TokenType.NULL:
            return None

        elif token.type == TokenType.LBRACKET:
            return self.parse_array()

        elif token.type == TokenType.LBRACE:
            return self.parse_object()

        return TokenType.UNDEFINED

    def parse_array(self):
        if self.cur_token.type != TokenType.LBRACKET:
            return

        self.advance()

        if self.cur_token is not None and self.cur_token.type == TokenType.RBRACKET:
            return []

        result = self.parse_comma_separated_values()

        if self.cur_token is None or self.cur_token.type != TokenType.RBRACKET:
            raise SyntaxError("Invalid Syntax")

        return [*result]

    def parse_comma_separated_values(self):
        value = self.parse_value()

        if value in (TokenType.UNDEFINED, TokenType.EOF):
            raise SyntaxError("Invalid Syntax")

        self.advance()

        if self.cur_token is None or self.cur_token.type != TokenType.COMMA:
            return [value]

        self.advance()

        return [value, *self.parse_comma_separated_values()]

    def parse_object(self):
        if self.cur_token.type != TokenType.LBRACE:
            return

        self.advance()

        if self.cur_token is not None and self.cur_token.type == TokenType.RBRACE:
            return {}

        result = self.parse_comma_separated_keyvalues()

        if self.cur_token is None or self.cur_token.type != TokenType.RBRACE:
            raise SyntaxError("Invalid Syntax")

        return {**result}

    def parse_comma_separated_keyvalues(self):
        keyvalue = self.parse_keyvalue()

        if keyvalue is None:
            raise SyntaxError("Invalid Syntax")

        self.advance()

        if self.cur_token is not None and self.cur_token.type != TokenType.COMMA:
            return keyvalue

        self.advance()

        return {**keyvalue, **self.parse_comma_separated_keyvalues()}

    def parse_keyvalue(self):

        if self.cur_token.type != TokenType.STRING:
            return

        key = self.cur_token.value

        self.advance()

        if self.cur_token is not None and self.cur_token.type != TokenType.COLON:
            return

        self.advance()

        value = self.parse_value()

        if value in (TokenType.UNDEFINED, TokenType.EOF):
            return

        return {key: value}


