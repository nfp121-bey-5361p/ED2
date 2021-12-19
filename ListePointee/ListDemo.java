import java.util.*;
/**
 * Write a description of class ListDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListDemo {
    public static void main(String[] args) {
        ListePointInterface l = new ListeP_Java();
        
        l.cons(new Integer(1));
        l.cons(new Integer(2));
        l.cons(new Integer(3));
        l.cons(new Integer(4));
        
        /*
        System.out.println(l.car());
        l.cdr();
        System.out.println(l.car());
        l.cdr();
        System.out.println(l.car());
        l.cdr();
        System.out.println(l.car());
        l.cdr();
       */
      
        
        ListeP_Rec o = new ListeP_Rec();
    
        o.cons(new Integer(5));
        o.cons(new Integer(6));
        o.cons(new Integer(7));
        o.cons(new Integer(8));

        Iterator it = o.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // for (Object obj = it.next(); it.hasNext();) {
        //     System.out.println(obj);
        // }
        
        
        
        //System.out.println("long avant = " + l.longueur());
        
         //l.conc(o);
        
         //System.out.println("long apres = " + l.longueur());
         System.out.println(l);
        // l.renverse();
        /*int i = l.longueur();
        for (int j = 0; j < i; j++) {
         System.out.println(l.car());
         l.cdr();
        }*/
        
        //System.out.println("1 membre de l? " + l.membre(new Integer(1)));
        //System.out.println("200 membre de l? " + l.membre(new Integer(200)));
        //Iterator<Object> it = ((ListeP_Rec)l).iterator();
        //while (it.hasNext()) {
        //    System.out.println(it.next());
        //}
        l.conc(o);
        System.out.println(l);
    }
}
