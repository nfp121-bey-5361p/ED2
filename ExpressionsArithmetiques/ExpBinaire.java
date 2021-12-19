public abstract class ExpBinaire extends Expression {

    Expression e1, e2;

    public ExpBinaire(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    
}