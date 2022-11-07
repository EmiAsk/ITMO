from tokens import Token, TokenType, TOKEN_TYPES


def retrieve_string(src):
    if not src.startswith('"'):
        return

    result = ''

    for s in src[1:]:
        if s == '"' and (not result or result[-1] != '\\'):
            return Token(TokenType.STRING, result), src[len(result) + 2:]
        result += s


def retrieve_number(src):
    result = ''

    for s in src:
        if not s.isdigit() and s != '.':
            break

        result += s

    if not result or result[0] == '.' or result[-1] == '.':
        return

    return Token(TokenType.NUMBER, float(result) if '.' in result else int(result)), src[len(result):]


def retrieve_token(word, src):
    if word not in TOKEN_TYPES:
        return

    if not src.startswith(word):
        return

    return Token(TOKEN_TYPES[word]), src[len(word):]


def lex(src: str):
    tokens = []

    while src:

        src = src.strip()
        token_found = False

        for match in (retrieve_number(src),
                      retrieve_string(src),
                      *(retrieve_token(token, src) for token in TOKEN_TYPES)):
            if match is not None:
                token_found = True
                token, src = match
                tokens.append(token)
                break

        if not token_found:
            raise SyntaxError("Illegal character")

    return tokens


