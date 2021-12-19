public abstract class Expression {
    public abstract int eval();
    public abstract String toString();
    public abstract String postfixToString();
    public abstract String prefixToString();
    public abstract Object accept(Visiteur v);
}