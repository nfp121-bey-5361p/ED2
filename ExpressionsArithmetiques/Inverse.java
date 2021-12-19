public class Inverse extends ExpUnaire {
    
    public Inverse(Expression exp) {
        super(exp);
    }
    
    public int eval() {
        return -(exp.eval());
    }
    
    public String toString() {
        return "(-" + exp.toString() + ")";
    }
    
    public String postfixToString() {
        return exp.postfixToString() + " _";
    }
    
    public String prefixToString() {
        return "inv(" + exp.prefixToString() + ")";
    }
    
    public Object accept(Visiteur v) {
        return v.visiteInverse(this);
    }
    
}
