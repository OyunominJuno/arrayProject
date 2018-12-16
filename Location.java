import java.util.Arrays;
/**
 * Stanley's stores location class that manages the list of customers and units
 *
 * @author Oyunomin Munkhkhurel
 * @version 1/9/2018
 */
public class Location {
    // instance variables 
    private String code;
    private Unit unit;
    private Customer customer;
    private Unit[][] unitArray;
    private Customer[] custArray;
    public int countEmpUnit;
    private final int ROW = 12, UNIT_STAN_ROW = 7, UNIT_HUM_ROW = 10, UNIT_TEMP_ROW = 12;
    private final int UNIT_STAN = 10, UNIT_HUM = 8, UNIT_TEMP = 6, MULTI_UNIT_DISCOUNT = 5;
    private double basePrice;
    /**
     * Constructor for objects of class Location
     * 
     * @throws  IllegalArgumentException if it gets null location code
     * @throws  IllegalArgumentException if it gets wrong pattern of string
     * @throws  IllegalArgumentException if it gets negative base price
     * 
     * @param   String  location code 
     * @param   Double  base price for each location
     */
    public Location(String code, double basePrice) {
        if (code == null) {
            throw new IllegalArgumentException("Location code cannot be null");
        }
        if (!code.matches("[A-Z]{2}[0-9]{2}[a-zA-Z]*")) {
            throw new IllegalArgumentException("invalid format (e.g., WA23Seattle)");
        }
        if (basePrice < 0) {
            throw new IllegalArgumentException("base price cannot be negative");
        }
        this.code = code;
        this.basePrice = basePrice;
        unitArray = new Unit[ROW][];
        
        for (int row = 0; row < UNIT_STAN_ROW; row++) {
            unitArray[row] = new Unit [UNIT_STAN];
            for (int unit = 0; unit < UNIT_STAN; unit++) {
                unitArray[row][unit] = new Standard(8, 8, 6, this);
            }
        }
        
        for (int row = UNIT_STAN_ROW; row < UNIT_HUM_ROW; row++) {
            unitArray[row] = new Unit [UNIT_HUM];
            for (int unit = 0; unit < UNIT_HUM; unit++) {
                unitArray[row][unit] = new Humidity(8, 8, 6, this);
            }
        }
        
        for (int row = UNIT_HUM_ROW; row < UNIT_TEMP_ROW; row++) {
            unitArray[row] = new Unit [UNIT_TEMP];
            for (int unit = 0; unit < UNIT_TEMP; unit++) {
                unitArray[row][unit] = new Temperature(8, 8, 6, this);
            }
        }
        custArray = new Customer[100];
    }
    /**
     * Retrieves the code for the location
     *
     * @return    the code for location
     */
    public String getLocationCode() {
        return code;
    }
    
    /**
     * Retrieves the base price
     *
     * @return     base price
     */
    public double getBasePrice() {
        return basePrice;
    }
    
    /**
     * Retrieves the unit from the 2 dimensional array of Units
     *
     * @return    the unit
     */
    public Unit getUnit(int row, int unit) {
        return unitArray[row][unit];
    }
    
    /**
     * Retrieves the customer from the customer array
     *
     * @return    the customer
     */
    public Customer getCustomer(int index) {
        return custArray[index];
    }
    
    /** 
     * Retrieves number of customers we are currently having
     * 
     * @return    count of current customer
     */
    public int getCustomerCount() {
        int customerCount = 0;
        for (int idx = 0; idx < custArray.length; idx++){
            if(custArray[idx] != null){
                customerCount++;
            }
        }
        return customerCount;
    }
    
    /**
     * Adds the customer to the customer array
     *
     * @param    Customer   customer 
     */
     public void addCustomer(Customer customer) {
        //int size = 0;
        boolean tempo = true;
         for (int index = 0; index < custArray.length && tempo; index++) {
                if (custArray[index] == null) {
                custArray[index] = customer;
                //size++;
                tempo = false;
            }
        }
    }
    
    /**
     * Retrieves unit in array rented by specific customer
     * 
     * @return      array of Units rented by specific customer
     */
    public Unit[] getUnitCustomer(Customer customer) {
        int countUnit = 0;
         for (int row = 0; row < unitArray.length; row++) {
            for(int unit = 0; unit < unitArray[row].length; unit++) {
                if (unitArray[row][unit].getCustomer().equals(customer)) {
                    countUnit++;
                }
            }
        }
        Unit[] unitCust = new Unit[countUnit];
        int index = 0;
        for (int row = 0; row < unitArray.length; row++) {
            for(int unit = 0; unit < unitArray[row].length; unit++) {
                if (unitArray[row][unit].getCustomer().equals(customer)) {
                    unitCust[index++] = unitArray[row][unit];
                }
            }
        }
        return unitCust;
    }
    
    /**
     * Creates another array that has empty units on it
     * 
     * @return      array of empty units
     */
    
    public Unit[] getEmptyUnit() {
        int countEmpUnit = 0;
        for (int row = 0; row < unitArray.length; row++) {
            for(int unit = 0; unit < unitArray[row].length; unit++) {
                if (unitArray[row][unit].getCustomer() == null) {
                    countEmpUnit++;
                }
            }
        }
        Unit[] empUnitArray = new Unit[countEmpUnit];
        int index = 0;
        for (int row = 0; row < unitArray.length; row++) {
            for(int unit = 0; unit < unitArray[row].length; unit++) {
                if (unitArray[row][unit].getCustomer() == null) {
                    empUnitArray[index++] = unitArray[row][unit];
                }
            }
        }
        return empUnitArray;
    }
    
    /**
     * Creates another array that has empty units by specified type
     * 
     * @return      array of empty units by specified type
     */
    
    public Unit[] getEmptyUnitType(String unitName) {
        int countEmpUnit = 0;
         for (int row = 0; row < unitArray.length; row++) {
            for(int unit = 0; unit < unitArray[row].length; unit++) {
                if (unitArray[row][unit].getCustomer() == null && unitArray[row][unit].getClass().getName().equals(unitName)) {
                    countEmpUnit++;
                }
            }
        }
        Unit[] empUnitArrayType = new Unit[countEmpUnit];
        int index = 0;
        for (int row = 0; row < unitArray.length; row++) {
            for(int unit = 0; unit < unitArray[row].length; unit++) {
                if (unitArray[row][unit].getCustomer() == null && unitArray[row][unit].getClass().getName().equals(unitName)) {
                    empUnitArrayType[index++] = unitArray[row][unit];
                }
            }
        }
        return empUnitArrayType;
    }
    
    /**
     * Charges monthly rent from all of the customers
     * 
     * return 
     */
    public void chargeRent() {
        int totalUnitCustRented = 0;
        for (int row = 0; row < unitArray.length; row++) {
            for(int unit = 0; unit < unitArray[row].length; unit++) {
                if (unitArray[row][unit].getCustomer() != null) {
                    unitArray[row][unit].chargeMonth();
                    if (getUnitCustomer(customer).length < 1) {
                        unitArray[row][unit].getCustomer().credit(unitArray[row][unit].chargeMonth() / 100 * MULTI_UNIT_DISCOUNT);
                    }
                }
            }
        }
    }
    
    /**
     * Prints every information of the location when requested
     * 
     * @return      information of location
     */
    public String toString() {
        String info = "";
        info += "Location code:                            " + code + "\n";
        info += "Location base price:                      " + getBasePrice() + "\n";
        info += "Current customers:                        " + getCustomerCount() + "\n";
        info += "Available Unit count:                     " + getEmptyUnit().length + "\n";
        info += "Available standard unit:                  " + getEmptyUnitType("Standard").length + "\n";
        info += "Available humidity-controlled unit:       " + getEmptyUnitType("Humidity").length + "\n";
        info += "Available temperature-controlled unit:    " + getEmptyUnitType("Temperature").length + "\n";
        return info;
    }
       
}
    
    

