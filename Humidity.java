
/**
 * Humidity Controlled Unit by Stanley's Storage
 *
 * @author  Oyunomin Munkhkhurel
 * @version 2018/01/05
 */
public class Humidity extends Unit{
    // instance variables
    Location loc; 
    private final double TEMP_PRICE_PER_SQUARE = 5.0;
    private final String CLASS_NAME = "Humidity controlled";
    /**
     * Constructor for objects of class HumidityControlledUnit
     */
    public Humidity(int length, int width, int height, Location loc) {
        super(length, width, height);
        this.loc = loc;
    }

    /**
     * Calculates price for humidity controlled type of unit
     *
     * @return    calculated final price for the unit
     */
    public double calculatePrice() {
        return loc.getBasePrice() + getLength() * getWidth() * TEMP_PRICE_PER_SQUARE;
    }
    
    @Override
    public String toString() {
        String info = "";
        info += "Unit type:       " + CLASS_NAME + "\n";
        info += super.toString();
        return info;
    }
}
