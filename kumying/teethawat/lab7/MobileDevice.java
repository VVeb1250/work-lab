/* super class mobile device had att. like color and price
 * and had abstrac class iswatch for write in every child class
 */

package kumying.teethawat.lab7;

public abstract class MobileDevice {
    // att.
    protected String color;
    protected double price;
    // getter
    public String getColor() { return color; }
    public double getPrice() { return price; }
    // setter
    public void setColor(String color) { this.color = color; }
    public void setPrice(double prize) { this.price = prize; }
    // abstrac method
    abstract public boolean isWatch();
}
