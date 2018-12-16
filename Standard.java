
/**
 * Standard type of unit provided by Stanley's storage.
 *
 * @author  Oyunomin Munkhkhurel
 * @version 2018/01/05
 */
public class Standard extends Unit{
    // instance variables
    Location loc;
    private final double STANDARD_PRICE = 75.0;
    /**
     * Constructor for objects of class StandardUnit
     */
    public Standard(int length, int width, int height, Location loc) {
        super(length, width ,height);
        this.loc = loc;
        // initialise instance variables
    }

    /**
     * Calculates price for standard type of unit
     *
     * @return    calculated final price for the unit
     */
    @Override
    public double calculatePrice() {
        return loc.getBasePrice() + STANDARD_PRICE;
    }
    
    @Override
    public String toString() {
        String info = "";
        info += "Unit type:       " + this.getClass().getName() + "\n";
        info += super.toString();
        return info;
    }
}
