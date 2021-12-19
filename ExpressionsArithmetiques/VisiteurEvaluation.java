public class VisiteurEvaluation extends VisiteurParDefaut {
    
    VisiteurEvaluation() {}
    
    public Object visiteEntier(Entier n){
        return new Integer(n.n);
    }
    
    public Object visiteInverse(Inverse i){
        return new Integer(-evalExpr(i.exp));
    }
    
    public Object visiteAddition(Addition a){
        return new Integer(evalExpr(a.e1)+evalExpr(a.e2)) ;
    }
    
    public Object visiteSoustraction(Soustraction s){
        return new Integer(evalExpr(s.e1)-evalExpr(s.e2)) ;
    }   
    
    public Object visiteMultiplication(Multiplication m){
        return new Integer(evalExpr(m.e1)*evalExpr(m.e2)) ;
    } 
    
    public Object visiteDivision(Division d){
        return new Integer(evalExpr(d.e1)/evalExpr(d.e2)) ;
    } 
    
    @Override
    public Object visiteSuccesseur(Suc s) { 
        return evalExpr(s.exp) + 1; 
    } 
    
    @Override
    public Object visitePredecesseur(Pre p) { 
        return evalExpr(p.exp) - 1; 
    } 

    
    public int evalExpr(Expression e){
        Visiteur v = new VisiteurEvaluation();
        return ((Integer)e.accept(v)).intValue();
    }
}
