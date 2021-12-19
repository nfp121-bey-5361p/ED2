
/**
 * Write a description of class Successeur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Suc extends ExpUnaire {
    
    public Suc(Expression exp) {
        super(exp);
    }
    
    @Override
    public int eval() {
        return exp.eval() + 1;
    }
    
    @Override 
    public String toString() {
        return "(" + exp.toString() + " + 1)";
    }
    
    @Override 
    public String postfixToString() {
        return exp.toString() + " $";
    }
    
    @Override 
    public String prefixToString() {
        return "suc(" + exp.toString() + ")";
    }
    
    @Override
    public Object accept(Visiteur v) {
        return v.visiteSuccesseur(this);
    }
}
