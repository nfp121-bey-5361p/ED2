public interface Visiteur {
    Object visiteEntier(Entier n);
    Object visiteInverse(Inverse i);
    Object visiteAddition(Addition a);
    Object visiteSoustraction(Soustraction s);
    Object visiteMultiplication(Multiplication m);
    Object visiteDivision(Division d);
    Object visiteSuccesseur(Suc s);
    Object visitePredecesseur(Pre p);
}
