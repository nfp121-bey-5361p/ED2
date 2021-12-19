
public class VisiteurAffichePostFixe extends VisiteurParDefaut {
    
    public VisiteurAffichePostFixe() {}
    
    @Override
    public Object visiteEntier(Entier n) {
        return n.toString();
    }
    
    @Override
    public Object visiteAddition(Addition a) {
        return evalExpr(a.e1) + " " + evalExpr(a.e2) + " +";
    }
    
    @Override
    public Object visiteSoustraction(Soustraction s) {
        return evalExpr(s.e1) + " " + evalExpr(s.e2) + " -";
    }
    
    @Override
    public Object visiteMultiplication(Multiplication m) {
        return evalExpr(m.e1) + " " + evalExpr(m.e2) + " *";
    }
    
    @Override
    public Object visiteDivision(Division d) {
        return evalExpr(d.e1) + " " + evalExpr(d.e2) + " /";
    }
    
    @Override
    public Object visiteInverse(Inverse i) {
        return evalExpr(i.exp) + " _";
    }
    
    @Override
    public Object visiteSuccesseur(Suc s) { 
        return evalExpr(s.exp) + " $"; 
    } 
    
    @Override
    public Object visitePredecesseur(Pre p) { 
        return evalExpr(p.exp) + " £"; 
    } 

    public String evalExpr(Expression e) {
        Visiteur v = new VisiteurAffichePostFixe();
        return (String)e.accept(v);
    }

}
