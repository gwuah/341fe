package compiler;

public enum TokenType {
    COMMA,
    ARROW,
    REGISTER, NUMBER,
    LOAD, LOADI, STORE, LSHIFT, RSHIFT,
    ADD, MULT, SUB, OUTPUT, NOP,
    ERROR, EOF
}
