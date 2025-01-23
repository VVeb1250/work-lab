/* This class is extend from MobileDevice that adding modelName and Override tostring Medhod */

package kumying.teethawat.lab7;

public class AppleWatch extends MobileDevice {
    // att.
    private String modelName;
    // getter
    public String getModelName() { return modelName; }
    //setter
    public void setModelName(String modelName) { this.modelName = modelName; }
    //constructor
    public AppleWatch(String color, double prize, String modelName) {
        this.color = color;
        this.price = prize;
        this.modelName = modelName;
    }
    //method
    public boolean isWatch() {
        return true;
    }
    // tostring (override)
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        StringBuffer text = new StringBuffer();
        text.append("AppleWatch ");
        text.append("[" + "color=" + this.getColor());
        text.append(", prize=" + this.getPrice());
        text.append(", modelName=" + getModelName() + "]");
        return text.toString();
    }
}
