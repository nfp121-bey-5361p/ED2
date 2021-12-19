public class Division extends ExpBinaire {

    public Division(Expression e1, Expression e2) {
        super(e1, e2);
    }
    
    public int eval() {
        return e1.eval() / e2.eval();
    }
    
    public String toString() {
        return e1.toString() + "/" + e2.toString(); 
    }
    
    public String postfixToString() {
        return e1.postfixToString() + " " + e2.postfixToString() + " " + "/";
    }
    
    public String prefixToString() {
        return "div(" + e1.prefixToString() + ", " + e2.prefixToString() + ")";
    }
    
    public Object accept(Visiteur v) {
        return v.visiteDivision(this);
    }
}