package compiler;

abstract class Operators {
    abstract <R> R accept(Visitor<R> visitor);

    interface Visitor<R> {
        R checkNoneOp(Token op);

        R checkUnaryOp(Token op, Token first);

        R checkBinaryOp(Token op, Token first, Token second);

        R checkTernaryOp(Token op, Token first, Token second, Token third);
    }

    static class None extends Operators {
        final Token opcode;

        None(Token opcode) {
            this.opcode = opcode;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.checkNoneOp(this.opcode);
        }
    }

    static class Ternary extends Operators {
        final Token first;
        final Token second;
        final Token third;
        final Token opcode;

        Ternary(Token opcode, Token first, Token second, Token third) {
            this.opcode = opcode;
            this.third = third;
            this.first = first;
            this.second = second;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.checkTernaryOp(this.opcode, this.first, this.second, this.third);
        }
    }

       static class Unary extends Operators {
        final Token opcode;
        final Token first;

        Unary(Token opcode, Token first) {
            this.opcode = opcode;
            this.first = first;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.checkUnaryOp(this.opcode, this.first);
        }
    }

    static class Binary extends Operators {
        final Token opcode;
        final Token first;
        final Token second;

        Binary(Token opcode, Token first, Token second) {
            this.opcode = opcode;
            this.first = first;
            this.second = second;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.checkBinaryOp(this.opcode, this.first, this.second);
        }
    }

}
