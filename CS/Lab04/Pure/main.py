from Pure.lexer import lex
from parser_ import Parser


source_filename = 'source.json'

with open(source_filename) as file:
    source_string = file.read()

tokens = lex(source_string)
parser = Parser(tokens)
result = parser.parse()

print(result)

