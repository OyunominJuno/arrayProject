

/**
 * This class for Stanley's store's customers 
 * 
 * @author Oyunomin Munkhkhurel
 * @version 1/4/2018
 */
public class Customer {
    // instance variables
    private String name;
    private String phoneNumber;
    private double accBalance;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String name, String phoneNumber, double accBalance) {
        setName(name);
        setPhoneNumber(phoneNumber);
        if(accBalance < 1){
         throw new IllegalArgumentException("Account Balance cannot be zero or below");
        }
        this.accBalance = accBalance;
    }

    /**
     * Retrieves the name of the customer
     * 
     * @return     String  the name of the customer
     */
    public String getName() {
        return name;
    }
    
    /**
     * Retrieves the phone number of the customer
     * 
     * @return     int  the phone number of the customer
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Retrieves the account balance of the customer
     * 
     * @return     double  the account balance of the customer
     */
    public double getAccBalance() {
        return accBalance;
    }
    
    /**
     * Changes the name of the customer
     * 
     * @param     String    the name of the customer
     */
    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Customer name cannot be null");
        }
        this.name = name;
    }
    
    /**
     * Changes the phone number of the customer
     * 
     * @param     int   the phone number of the customer
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("[0-9]{10}")) {
            throw new IllegalArgumentException("invalid or null phone number");
        }
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Charges the desired amount from the customer's account balance
     * 
     * @param   double   desired amount
     * @return  double   remaining account balance
     */
    public double charge(double amount) {
        
        if(amount < 0){
            throw new IllegalArgumentException("Cannot be below zero");
        }
     return accBalance += amount;   
    }
    
    /**
     * Credits the desired amount to the customer's account balance
     * 
     * @param   double   desired amount
     * @return  double   remaining account balance
     */
    public double credit(double amount) {
        if(amount > accBalance){
            throw new IllegalArgumentException("insufficient balance!");
        }
        if(amount < 0){
            throw new IllegalArgumentException("Cannot be below zero");
        }
        return accBalance -= amount;   
    }
    
    /**
     * Strings that fully states the information of customer
     * 
     * @return  String   full statements
     */
    public String toString() {
     String info = "";
     info += "Customer name:             " + name + "\n";
     info += "Customer phone number:     " + phoneNumber + "\n";
     info += "Customer account balance:  " + accBalance + "\n";
     return info;
    }
}
