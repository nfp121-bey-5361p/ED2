import java.util.Iterator;

/**
 * Décrivez votre classe ListeP_T ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ListeP_Tab implements ListePointInterface {
    /**
     * ATTENTION, ATTENTION, il est plus facile d'ajouter des objets à la fin d'un
     * tableau qu'au début d'un tableau car en ajoutant au début il faudrait à
     * chaque fois décaler tous les éléments du tableau. Alors dans le tableau
     * d'implantation 'liste' la tête de liste est le dernier du tableau
     */

    // variables d'instance / attributs
    private Object[] tabImplantation;
    private int nbreElements; // nombre d'éléments de la liste, donc on aura toujours
                              // nbreElements&lt;=tabImplantation.length

    public ListeP_Tab() {
        tabImplantation = new Object[3]; // 3 ou n'importe quel autre nombre > 0 d'éléments
    }

    /**
     * retourne la tête de la tabImplantation. lecture seulement
     */
    public Object car() {
        if (nbreElements == 0) 
            throw new ListVideException();        
        return tabImplantation[nbreElements - 1];
    }

    /**
     * destruction du premier élément de la tabImplantation
     */
    public void cdr() {
        if (nbreElements == 0)
            throw new ListVideException();
        tabImplantation[nbreElements - 1] = null;
        nbreElements--;
    }

    /**
     * procédure : ajout d'un objet quelconque en début de tabImplantation
     */
    public void cons(Object objet) {
        int len = tabImplantation.length;
        if (nbreElements == len) {
            // use System.arraycopy to enlarge tabImplantation
            // Another implementation would increase the size of the array 
            // by a specified rate similar to the behavior of an ArrayList or Vector
            Object[] temp = new Object[len];
            System.arraycopy(tabImplantation, 0, temp, 0, len);
            tabImplantation = new Object[len+1];
            System.arraycopy(temp, 0, tabImplantation, 0, len);
        }
        
        tabImplantation[nbreElements] = objet;
        nbreElements++;
    }

    /**
     * procédure : concaténation d'une tabImplantation sur 'this' ATTENTION cette
     * version ne permet que la concaténation d'une 'ListeP_Tab' réfléchir à la
     * version générale...
     */
    public void conc(ListePointInterface lst) {
        /*
         * à compléter...
         * 
         */
        if (!(lst instanceof ListeP_Tab))
            throw new IllegalArgumentException("lst doit etre instance de ListeP_Tab");

        int nbreElementsCourant = nbreElements;
        Object[] temp = new Object[nbreElementsCourant];
        System.arraycopy(tabImplantation, 0, temp, 0, nbreElementsCourant);
        tabImplantation = new Object[nbreElementsCourant + lst.longueur()];
        System.arraycopy(temp, 0, tabImplantation, 0, nbreElementsCourant);
        
        int lstLongueur = lst.longueur();
        int tabIndex = 0;
        for (int i = 0; i < lstLongueur; i++) {
            tabImplantation[tabImplantation.length - 1 - tabIndex] = lst.car();
            lst.cdr();
            tabIndex++;
        }
         
        nbreElements = nbreElements + lstLongueur;
    }

    /**
     * procédure : retourner une tabImplantation sur elle même
     */
    public void renverse() {
        if (nbreElements != 0 && nbreElements != 1) {
            Object[] temp = new Object[nbreElements];
            for (int i = 0; i < nbreElements; i++) {
                temp[i] = tabImplantation[nbreElements - 1 - i];
            }

            tabImplantation = temp;
        }
    }

    /**
     * prédicat : objet est-il membre de la liste ? ATTENTION à ne pas comparer
     * n'importe quoi et obtenir "un false silencieux"
     */
    public boolean membre(Object objet) {
        /*
         * à compléter... un vrai casse-tête !!!
         */
        if (objet == null)
            return false;

        for (int i = 0; i < tabImplantation.length; i++) {
            if (objet.equals(tabImplantation[i]))
                return true;
        }

        return false;
    }

    public boolean listeVide() {
        return nbreElements == 0;
    }

    public int longueur() {
        return nbreElements;
    }

    // méthodes de services "imposées" par Java

    public String toString() {
        if (nbreElements == 0)
            return "[]";
        String s = "[";
        for (int i = nbreElements - 1; i < 0; i--) {
            s += tabImplantation[i].toString() + ",";
        }
        return s + tabImplantation[0] + "]";
    }

    public boolean equals(Object liste) {
        if (!(liste instanceof ListePointInterface)) {
            return false;
        }
        ListePointInterface lst = (ListePointInterface) liste;
        if (nbreElements != lst.longueur()) {
            return false;
        }

        /*
         * à compléter... avec soin.
         */
        boolean res = true;
        for (int i = 0; i < tabImplantation.length; i++) {
            if (!lst.membre(tabImplantation[i])) {
                res = false;
                break;
            }
        }

        return res;
    }
}

class ListVideException extends RuntimeException {}