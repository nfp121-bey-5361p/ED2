

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ListeP_TabTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListeP_TabTest {
    /**
     * Default constructor for test class ListeP_TabTest
     */
    public ListeP_TabTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
    }
    
    

    @Test
    public void testAddingElements()
    {
        ListeP_Tab listeP_T1 = new ListeP_Tab();
        listeP_T1.cons(new Integer(1));
        listeP_T1.cons(new Integer(2));
        listeP_T1.cons(new Integer(3));
        assertEquals(3, listeP_T1.car());
    }
}

