public class VisiteurParDefaut implements Visiteur {
   
    public VisiteurParDefaut() {}

    public Object visiteEntier(Entier e) { return e; } 
    public Object visiteInverse(Inverse i) { return i; } 
    public Object visiteAddition(Addition a) { return a; } 
    public Object visiteSoustraction(Soustraction s) { return s; } 
    public Object visiteMultiplication(Multiplication m) { return m; } 
    public Object visiteDivision(Division d) { return d; } 
    public Object visiteSuccesseur(Suc s) { return s; } 
    public Object visitePredecesseur(Pre p) { return p; } 

}
