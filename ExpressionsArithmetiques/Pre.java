
public class Pre extends ExpUnaire {
    
    public Pre(Expression exp) {
        super(exp);
    }
    
    @Override
    public int eval() {
        return exp.eval() - 1;
    }
    
    @Override 
    public String toString() {
        return "(" + exp.toString() + "- 1)";
    }
    
    @Override 
    public String postfixToString() {
        return exp.toString() + " £";
    }
    
    @Override 
    public String prefixToString() {
        return "pre(" + exp.toString() + ")";
    }
    
    @Override
    public Object accept(Visiteur v) {
        return v.visitePredecesseur(this);
    }
}
