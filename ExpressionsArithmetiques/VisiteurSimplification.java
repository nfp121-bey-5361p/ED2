
public class VisiteurSimplification extends VisiteurParDefaut {
    
    public VisiteurSimplification() {}
    
    @Override
    public Object visiteAddition(Addition a){
        if ((a.e1 instanceof Entier) && (((Entier)a.e1).n == 1)) {
            return new Suc(a.e2);
        } else {
            if ((a.e2 instanceof Entier) && (((Entier)a.e2).n == 1)) {
                return new Suc(a.e1);
            } else {
                return a;
            }
        }
    }
    
    public Object visiteSoustraction(Soustraction s){
        if ((s.e1 instanceof Entier) && (((Entier)s.e1).n == 1)){
            return new Pre(s.e2);
        } else {
            if ((s.e1 instanceof Entier) && (((Entier)s.e1).n == 1)) {
                return new Pre(s.e1);
            } else {
                return s;
            }
        }
    }
}
