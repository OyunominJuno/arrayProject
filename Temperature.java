
/**
 * Temperature controlled unit provided by Stanley's Storage
 *
 * @author   Oyunomin Munkhkhurel
 * @version  2018/01/05
 */
public class Temperature extends Unit{
    // instance variables 
    private Location loc;
    private final double TEMP_PRICE_PER_CUBE = 1.0;
    private final String CLASS_NAME = "Temperature controlled";
    /**
     * Constructor for objects of class Temperature
     */
    public Temperature(int length, int width, int height, Location loc) {
        super(length, width, height);
        this.loc = loc;
    }

    /**
     * Calculates price for temperature controlled type of unit
     *
     * @return    calculated final price for the unit
     */
    public double calculatePrice() {
        return loc.getBasePrice() + getLength() * getWidth() * getHeight() * TEMP_PRICE_PER_CUBE;
    }
    
    @Override
    public String toString() {
        String info = "";
        info += "Unit type:       " + this.getClass().getName() + "\n";
        info += super.toString();
        return info;
    }
}
