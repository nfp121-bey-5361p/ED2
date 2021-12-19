public class Entier extends ExpConstante {
    int n = 0;
    
    public Entier(int n) {
        this.n = n;
    }
    
    public int eval() {
        return n;
    }
    
    public String toString() {
        return Integer.toString(n);
    }    
    
    public String postfixToString() {
        return toString();
    }
    
    public String prefixToString() {
        return toString();
    }
    
    public Object accept(Visiteur v) {
        return v.visiteEntier(this);
    }
}
