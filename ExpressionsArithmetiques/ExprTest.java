
/**
 * Write a description of class ExprTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ExprTest {
    
    public static void main(String[] args) {
        Expression e = new Suc(new Addition(new Entier(1), 
            new Soustraction(new Multiplication(new Entier(2), new Inverse(new Entier(5))), 
            new Entier(3))));
            
        System.out.println(e.accept(new VisiteurAffichePreFixe()) + " = " + e.accept(new VisiteurEvaluation()));
    }
    
}
