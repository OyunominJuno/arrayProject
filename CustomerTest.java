

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CustomerTest
{
    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
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
    public void testCustomerConstAndAcssr() {
     Customer cust1 = new Customer("Marley", "6808989680", 30.55);
     assertEquals("Marley", cust1.getName());
     assertEquals("6808989680", cust1.getPhoneNumber());
     assertEquals(30.55, cust1.getAccBalance(), 0.01);
    }
    
    @Test
    public void testCustomerConstAndMutators() {
     Customer cust2 = new Customer("Marley", "6808989680", 30.55);
     cust2.setName("Bob");
     cust2.setPhoneNumber("2067878680");
     assertEquals("Bob", cust2.getName());
     assertEquals("2067878680", cust2.getPhoneNumber());
     cust2.charge(100);
     assertEquals(130.55, cust2.getAccBalance(), 0.01);
     cust2.credit(90);
     assertEquals(40.55, cust2.getAccBalance(), 0.01);
    }
    
    @Test (expected = IllegalArgumentException.class )
    public void testCustomerExceptionName() {
     Customer cust3 = new Customer(null, "5468989680", 30.55);
    }
    
    @Test (expected = IllegalArgumentException.class )
    public void testCustomerExceptionPhoneNumber1() {
     Customer cust3 = new Customer("Juno", "546898968", 30.55);
    }
    
    @Test (expected = IllegalArgumentException.class )
    public void testCustomerExceptionPhoneNumber2() {
     Customer cust3 = new Customer("Bigo", null, 30.55);
    }
    
    @Test (expected = IllegalArgumentException.class )
    public void testCustomerExceptionAccBalance() {
     Customer cust4 = new Customer("Marloo", "5468989680", 0);
    }
    
    @Test (expected = IllegalArgumentException.class )
    public void testCustomerExceptionCharge() {
     Customer cust5 = new Customer("Marloo", "5468989680", 1.0);
     cust5.credit(10.0);
    }
    
    @Test (expected = IllegalArgumentException.class ) 
    public void testCustomerCharge() {
        Customer cust6 = new Customer("Tsatsa", "5468989680", 150);
        cust6.charge(-1.0);
    }
}
