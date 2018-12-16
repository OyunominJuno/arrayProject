import java.util.Calendar;
import java.util.Date;
/**
 * Stanley's storage's unit
 *
 * @author Oyunomin Munkhkhurel
 * @version 1/5/2018
 */
public abstract class Unit {
    // instance variables 
    int width, height, length;
    private Customer customer;
    private Date date;
    Calendar cal = Calendar.getInstance();
    /**
     * Constructor for objects of class Unit
     * 
     * @throws  IllegalArgumentException if it gets negative length, width or height
     * @throws  IllegalArgumentException if it gets length or width that is not multiple of 4, or height, multiple of 2
     * 
     * @param  int  length of the unit
     * @param  int  width of the unit
     * @param  int  height of the unit
     */
    public Unit(int length, int width, int height) {
        if(width <= 0 || length <= 0 || height <= 0) {
            throw new IllegalArgumentException("cannot be below zero");
        }
        if(length % 4 != 0 || width % 4 !=0 || height % 2 != 0) {
            throw new IllegalArgumentException("length and width must be multiples of 4, height, multiples of 2");
        }
        this.width = width;
        this.length = length;
        this.height = height;
        
    }

    /**
     * Retrieves the width of the unit
     *
     * @return    width of the unit
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Retrieves the length of the unit
     *
     * @return    length of the unit
     */
    public int getLength() {
        return length;
    }
    
    /**
     * Retrieves the height of the unit
     *
     * @return    height of the unit
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Retrieves the customer who rented the unit
     *
     * @return    customer associated with the unit
     */
    public Customer getCustomer() {
        return customer;
    }
    
    /**
     * Retrieves the date unit rented
     *
     * @return     date unit rented
     */
    public Date getDate() {
        return date;
    }
    
    public abstract double calculatePrice();   
    
    /**
     * Rents unit and associates it to the customer and date
     * 
     * @param     Customer      customer who is renting
     * @param     Date          date unit renting
     */
    public void rentUnit(Customer customer){
        this.customer = customer;
        date = cal.getTime();
    }
    
    /**
     * Release the unit
     * 
     * return      the unit
     */
    public void releaseUnit(){
        customer = null;
        date = null;
    }
    
    /**
     * Charges the monthly cost from the customer's account balance
     * 
     * @param   double   desired amount
     * @return  double   remaining account balance
     */
    public double chargeMonth() {
        if(getCustomer().getAccBalance() < calculatePrice()){
            throw new IllegalArgumentException("insufficient balance!");
        }
        return getCustomer().getAccBalance() - calculatePrice();   
    }
    
    public String toString() {
        String info = "";
        info += "Width:           " + width + "\n";
        info += "Length:          " + length + "\n";
        info += "Height:          " + height + "\n";
        info += "Price:           " + calculatePrice() + "\n";
        info += "Customer rented: \n" + "\n" + customer+ "\n";
        info += "Date rented:     \n" + "\n" + date + "\n";
        return info;
    }
}
