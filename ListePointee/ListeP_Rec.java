import java.util.*;

/**
 * Décrivez votre classe ListeP_Rec ici.
 * 
 * @author TD NFP121
 * @version v0.0
 */
public class ListeP_Rec implements ListePointInterface {
    private int lg;
    private Maillon elem;

    /**
     * retourne la valeur du premier élément de la liste sans destruction remarque :
     * on ne peut pas obtenir la tête d'une liste vide
     */
    public Object car() {
        if (lg == 0) 
            throw new ListVideException();
        return elem.valeur();
    }

    /**
     * supprime la tete de la liste remarque : on ne peut pas supprimer la tête
     * d'une liste vide
     */
    public void cdr() {
        if (lg == 0) 
            throw new ListVideException();
        elem = elem.suite();
        lg--;
    }

    /**
     * ajoute 'obj' au début de la liste; la longueur de la liste est augmentée de 1
     */
    public void cons(Object obj) {
        /*
         * à compléter...
         */
        if (obj == null)
            throw new IllegalArgumentException("can't insert null");
        
        Maillon m = new Maillon(obj, elem);
        elem = m;
        lg++;
    }

    /**
     * ajoute en fin de liste la liste 'liste'
     */
    public void conc(ListePointInterface liste) {
        /*
         * à compléter...
         */
        if (liste == null) 
            throw new IllegalArgumentException("can't concatinate with null");
        
        int len = liste.longueur();
        Object[] temp = new Object[len];
        for (int i = 0; i < len; i++) {
            temp[len-1-i] = liste.car();
            liste.cdr();
        }
        
        for (int i = 0; i < len; i++) {
            cons(temp[i]);
        }
    }

    /**
     * retourne 'this'
     */
    public void renverse() {
        /*
         * à compléter...
         */
        // reverse a linked list
        if (elem == null)
            throw new ListVideException();
        
        Maillon curr = elem;
        Maillon p = elem;
        Maillon prev = null;
        while (p != null) {
            p = curr.suite();
            curr.modifSuite(prev); 
            prev = curr;
            curr = p;
        }
        elem = prev;
    }

    /**
     * 'objet' appartient-il à la liste ?
     */
    public boolean membre(Object objet) {
        /*
         * à compléter...
         */
        if (objet == null)
            throw new RuntimeException("object can't be null");
        
        for (Maillon maillon = elem; maillon != null; maillon = maillon.suite()) {
            if (objet.equals(maillon.valeur())) {
                return true;
            }
        }
        
        return false;
    }

    public boolean listeVide() {
        return lg == 0;
    }

    public int longueur() {
        return lg;
    }

    public String toString() {
        /*
         * à compléter...
         */
        if (elem == null) return "[]";
        String s = "[";
        Maillon p = elem;
        for (; p != null; p = p.suite()) {
            s += p.valeur() + ",";
        }
        s += "]";
        
        return s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ListePointInterface))
            return false;
        /*
         * à compléter...
         */
        ListePointInterface lst = (ListePointInterface) obj;
        for (Maillon maillon = elem; maillon != null; maillon = maillon.suite()) {
            if (lst.membre(maillon.valeur())) {
                return true;
            }
        }
        return false;
    }

    /*
     * on va avoir besoin d'énumérer les éléments d'une chaine de maillons et on
     * choisit pour cela un iterator implanté au moyen d'une classe anonyme cf. ci
     * dessous...
     */
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            Iterator<Object> maillonIterator = null;

            public boolean hasNext() {
                if (elem == null) {
                    return false;
                } else if (maillonIterator == null) {
                    maillonIterator = elem.iterator();
                }
                
                return maillonIterator.hasNext();
            }

            public Object next() {
                return maillonIterator.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    /*
     * ...
     * 
     */
    @Override
    public Object clone() {
        ListeP_Rec lst = new ListeP_Rec();
        // shallow copy
        //lst.elem = this.elem;
        //lst.lg = this.lg;
        
        // deep copy
        Iterator<Object> it = this.iterator();
        Maillon prev = null;
        while (it.hasNext()) {
            Object val = it.next();
            if (prev == null) {
                lst.elem = new Maillon(val, null);
                prev = lst.elem;
            } else {
                Maillon nvMaillon = new Maillon(val, null);
                prev.modifSuite(nvMaillon);
                prev = nvMaillon;
            }
        }
        
        
        return lst;
    }
}