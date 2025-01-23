/* this class extend from MobileDevice that had more 2 attbruite
 * storage and chip_name(static)
 */

package kumying.teethawat.lab7;

public class IPadAir extends MobileDevice {
    // att.
    private double storage;
    private static String CHIP_NAME = "Apple M2";
    // getter
    public double getStorage() { return storage; }
    public static String getCHIP_NAME() { return CHIP_NAME; }
    // setter
    public void setStorage(double storage) { this.storage = storage; }
    // constructor
    public IPadAir(String color, double prize, double storage) {
        this.color = color;
        this.price = prize;
        this.storage = storage;
    }
    // method (not a watch)
    public boolean isWatch() {
        return false;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        StringBuffer text = new StringBuffer();
        text.append("IPadAir ");
        text.append("[" + "color=" + this.getColor());
        text.append(", prize=" + this.getPrice());
        text.append(", stroage=" + this.getStorage());
        text.append(", chip=" + getCHIP_NAME() + "]");
        return text.toString();
    }
}
