
public class VisiteurAffichePreFixe extends VisiteurParDefaut {
    public VisiteurAffichePreFixe() {}
    
    @Override
    public Object visiteEntier(Entier n) {
        return n.toString();
    }
    
    @Override
    public Object visiteAddition(Addition a) {
        return "add(" + evalExpr(a.e1) + ", " + evalExpr(a.e2) + ")";
    }
    
    @Override
    public Object visiteSoustraction(Soustraction s) {
        return "sous(" + evalExpr(s.e1) + ", " + evalExpr(s.e2) + ")";
    }
    
    @Override
    public Object visiteMultiplication(Multiplication m) {
        return "mult(" + evalExpr(m.e1) + "," + evalExpr(m.e2) + ")";
    }
    
    @Override
    public Object visiteDivision(Division d) {
        return "div(" + evalExpr(d.e1) + "," + evalExpr(d.e2) + ")";
    }
    
    @Override
    public Object visiteInverse(Inverse i) {
        return "inv(" + evalExpr(i.exp) + ")";
    }
    
    @Override
    public Object visiteSuccesseur(Suc s) { 
        return "suc(" + evalExpr(s.exp) + ")"; 
    } 
    
    @Override
    public Object visitePredecesseur(Pre p) { 
        return "pre(" + evalExpr(p.exp) + ")"; 
    } 

    
    public String evalExpr(Expression e) {
        Visiteur v = new VisiteurAffichePreFixe();
        return (String)e.accept(v);
    }
}
