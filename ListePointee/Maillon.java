/**
 * 
 * @author TD NFP121
 * @version v 0.007
 */

class Maillon implements Iterable {
    private Object valeur;
    private Maillon suite;

    /**
     * création d'un nouveau maillon i.e. il est tout seul sans 'suite' (null)
     */
    public Maillon(Object valeur) {
        this.valeur = valeur;
        this.suite = null;
    }

    /**
     * ajout d'un nouveau maillon devant une chaine existante par la création d'un
     * nouveau maillon qui est 'accroché' à la chaine existante...
     */
    public Maillon(Object valeur, Maillon suite) {
        this.valeur = valeur;
        this.suite = suite;
    }

    public Object valeur() {
        return valeur;
    }

    public Maillon suite() {
        return suite;
    }

    public void modifSuite(Maillon m) {
        suite = m;
    }

    public boolean equals(Object that) {
        /*
         * à compléter
         */
        if (that == null) return false;
        if (!(that instanceof Maillon)) return false;
        
        return this.valeur == ((Maillon)that).valeur();
    }

    public String toString() {
        /*
         * à compléter
         */
        StringBuilder builder = new StringBuilder();
        builder.append("Maillon[valeur=")
               .append(valeur)
               .append(",suite=").append(suite).append("]");
        
        return builder.toString();
    }

    /*
     * on va avoir besoin d'énumérer les éléments d'une chaine de maillons et on
     * choisit pour cela un iterator implanté au moyen d'une classe anonyme cf. ci
     * dessous...
     */
    public java.util.Iterator iterator() {
        return new java.util.Iterator() {
            Maillon temp = Maillon.this;

            public boolean hasNext() {
                /*
                 * à compléter...
                 */
                return temp != null;
            }

            public Object next() {
                /*
                 * à compléter...
                 */
                Maillon m = temp;
                temp = temp.suite();
                return m.valeur();
            }

            public void remove() {// non implémenté
                throw new UnsupportedOperationException();
            }
        };
    }
}