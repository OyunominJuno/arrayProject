

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

/**
 * The test class UnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UnitTest
{
    Location loc = new Location("CA56LosAngelos", 100.0);
    Customer cust1 = new Customer("Cind", "6808989320", 1000);
    Customer cust2 = new Customer("Juon", "8958955600", 250);
    /**
     * Default constructor for test class UnitTest
     */
    public UnitTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testStandardUnitConstAndAcss() {
     Standard unit1 = new Standard(44, 88, 88, loc);
     assertEquals(44, unit1.getLength());
     assertEquals(88, unit1.getWidth());
     assertEquals(88, unit1.getHeight());
     unit1.rentUnit(cust1);
     assertEquals(unit1.getCustomer(), cust1);
     assertEquals(unit1.getCustomer().getName(), "Cind");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testUnitInsufficientBalance() {
        Humidity unit2 = new Humidity(8, 44, 12, loc);
        unit2.rentUnit(cust2);
        unit2.chargeMonth();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testUnitPreCondLength() {
        Standard unit2 = new Standard(0, 88, 88, loc);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testUnitPreCondWidth() {
        Humidity unit3 = new Humidity(44, -2, 88, loc);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testUnitPreCondHeight() {
        Standard unit4 = new Standard(44, 88, -15, loc);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testUnitPreCondLengthMult4() {
        Standard unit5 = new Standard(23, 88, 88, loc);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testUnitPreCondWIdthMult4() {
        Humidity unit3 = new Humidity(88, 18, 88, loc);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testUnitPreCondHeightMult2() {
        Temperature unit3 = new Temperature(44, 16, 89, loc);
    }
    
    
}
