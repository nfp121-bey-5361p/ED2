

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ListeP_RecTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListeP_RecTest {
    
    ListePointInterface li;
    
    /**
     * Default constructor for test class ListeP_RecTest
     */
    public ListeP_RecTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        li = new ListeP_Rec();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
        li = null;
    }
    
    

    @Test
    public void testAddingElements()
    {
        li.cons(new Integer(1));
        li.cons(new Integer(1));
        li.cons(new Integer(3));
        assertEquals(3, li.car());
    }

    @Test
    public void testCdr()
    {
        li.cons(new Integer(1));
        li.cons(new Integer(2));
        li.cons(new Integer(3));
        ListeP_Rec listeP_R1 = new ListeP_Rec();
        listeP_R1.cons(new Integer(1));
        listeP_R1.cons(new Integer(2));
        li.cdr();
        assertEquals(true, li.equals(listeP_R1));
    }
}


