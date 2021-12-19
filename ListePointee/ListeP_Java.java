import java.util.*;

/**
 * Décrivez votre classe ListeP_Java ici.
 * 
 * @author TD3 NFP121
 * @version 0.007
 */
public class ListeP_Java implements ListePointInterface, Iterable {
    private int lg;
    private LinkedList liste = new LinkedList();

    public Object car() {
        return liste.getFirst();
    }

    public void cdr() {
        liste.removeFirst();
        lg--;
    }

    public void cons(Object objet) {
        liste.addFirst(objet);
        lg++;
    }

    public void conc(ListePointInterface li) {
        /*
         * à compléter...
         */
        if (li == null) return;
        int longueur = li.longueur();
        if (longueur == 0) return;
        
        for (int i = 0; i < longueur; i++) {
            liste.addFirst(li.car());
            li.cdr();
            lg++;
        }
    }

    public void renverse() {
        /*
         * à compléter...
         */
        Iterator it = liste.descendingIterator();
        LinkedList newListe = new LinkedList();
        while (it.hasNext()) {
            newListe.add(it.next());
        }
        liste = newListe;
    }

    public boolean membre(Object objet) {
        /*
         * à compléter...
         */
        if (objet == null) return false;
        return liste.contains(objet);
    }

    public boolean listeVide() {
        return liste.isEmpty();
    }

    public int longueur() {
        return liste.size();
    }

    public Iterator<Object> iterator() {
        return this.liste.iterator();
    }

    public String toString() {
        return liste.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof ListePointInterface)) return false;
        return liste.equals((ListePointInterface) obj);
    }
}
