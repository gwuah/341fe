package com.iloc;

public class IRPrinter implements Operators.Visitor<String> {

    String print(Operators expr) {
        return expr.accept(this);
    }

     @Override
    public String checkUnaryOp(Token op, Token first) {
        return parenthesize(op.lexeme, first);
    }

    @Override
    public String checkBinaryOp(Token op, Token first, Token second) {
        return parenthesize(op.lexeme, first, second);
    }

    @Override
    public String checkTernaryOp(Token op, Token first, Token second, Token third) {
        return parenthesize(op.lexeme, first, second, third);
    }

    @Override
    public String checkNoneOp(Token op) {
        return parenthesize(op.lexeme);
    }

    private String parenthesize(String name, Token... ops) {
        StringBuilder builder = new StringBuilder();

        builder.append("[").append(name);
        for (Token op : ops) {
            builder.append(" {").
                    append(op.type).
                    append(" ").
                    append(op.lexeme).
                    append("}");
        }
        builder.append("]");

        return builder.toString();
    }
}
