from enum import Enum
from dataclasses import dataclass
from typing import Any


class TokenType(Enum):
    COMMA = 1
    COLON = 2
    LBRACKET = 3
    RBRACKET = 4
    STRING = 5
    NUMBER = 6
    TRUE = 7
    FALSE = 8
    NULL = 9
    LBRACE = 10
    RBRACE = 11
    EOF = 12
    UNDEFINED = 13


TOKEN_TYPES = {'[': TokenType.LBRACKET,
               ']': TokenType.RBRACKET,
               'false': TokenType.FALSE,
               'true': TokenType.TRUE,
               'null': TokenType.NULL,
               ':': TokenType.COLON,
               '{': TokenType.LBRACE,
               '}': TokenType.RBRACE,
               ',': TokenType.COMMA}


@dataclass
class Token:
    type: TokenType
    value: Any = None

    def __repr__(self):
        return self.type.name + ('' if self.value is None else f': {self.value}')


    # def __repr__(self):
    #     return f"Token({self.type}, value=" + (f'"{self.value}"' if isinstance(self.value, str) else str(self.value)) + ')'






