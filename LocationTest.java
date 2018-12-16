import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LocationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LocationTest {
    Customer cust1 = new Customer("Oyu", "6788989670", 1000);
    Customer cust2 = new Customer("Foo", "1234567890", 500);
    Customer cust3 = new Customer("Marley", "9089080999", 30.55);
    /**
     * Default constructor for test class LocationTest
     */
    public LocationTest()
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
    public void testLocationConsandAccs() {
        Location loc1 = new Location("WA23Seattle", 25);
        assertEquals("WA23Seattle", loc1.getLocationCode());
        assertEquals(8, loc1.getUnit(5,8).getLength());
        assertEquals(8, loc1.getUnit(11, 0).getWidth());
        assertEquals(6, loc1.getUnit(5, 5).getHeight());
        assertEquals(25, loc1.getBasePrice(), 0.1);
        
        loc1.addCustomer(cust1);
        loc1.addCustomer(cust2);
        loc1.getUnit(9,1).rentUnit(cust1);
        loc1.getUnit(10, 5).rentUnit(cust2);
        
        assertEquals(cust1, loc1.getCustomer(0));
        assertEquals(2, loc1.getCustomerCount());
        assertEquals(104, loc1.getEmptyUnit().length);
        assertEquals(11, loc1.getEmptyUnitType("Temperature").length);
        loc1.chargeRent();
        assertEquals(967.25, loc1.getUnit(9,1).getCustomer().getAccBalance(), 0.1);
    }
    
    @Test (expected = IllegalArgumentException.class) 
    public void testPreCondCode1() {
        Location loc2 = new Location("WAA23Seattle", 25);
    }
    
    @Test (expected = IllegalArgumentException.class) 
    public void testPreCondCode2() {
        Location loc2 = new Location("23564815", 25);
    }
    
    
}