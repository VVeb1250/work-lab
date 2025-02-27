/* this for more understandable in interface implement
 * by using interface Comparator<CompareClass>
 */

package kumying.teethawat.lab7;

import java.util.Arrays;
import java.util.Comparator;

public class SortMobileDevices implements Comparator<MobileDevice> {
    public static void main(String[] args) {
        // Create array of mobile devices with test cases
        MobileDevice[] devices = new MobileDevice[7];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        // Same price, different storage
        devices[2] = new IPadAir("Space Gray", 19900.0, 128);
        devices[3] = new IPadAir("Silver", 19900.0, 64);
        // AppleWatches with different prices
        devices[4] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        // Same price, different models
        devices[5] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
        devices[6] = new AppleWatch("Gold", 12900.0, "Apple Watch Series 7");

        Arrays.sort(devices, new SortMobileDevices());

        System.out.println("Mobile devices sorted by multiple criteria:");
        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }

    @Override  // Using compare method to sort array
    public int compare(MobileDevice device1, MobileDevice device2) {
        // TODO Auto-generated method stub
        // first : compare valueof prize, if not equal return compareTo value.  
        // second : check instanceof, if not same return compare color.
        // thrid : if same do type casting. IPadAir check storage, then color. AppleWatch check color then model_name
        int valueCompare = Double.compare(device1.getPrice(), device2.getPrice());
        if (valueCompare == 0) {
            if (device1 instanceof IPadAir && device2 instanceof IPadAir) {
                IPadAir ipadAir1 = (IPadAir) device1;
                IPadAir ipadAir2 = (IPadAir) device2;
                int storageCompare = Double.compare(ipadAir1.getStorage(), ipadAir2.getStorage());
                if ( storageCompare == 0 ) {
                    int colorCompare = ipadAir1.getColor().compareTo(ipadAir2.getColor());
                    return colorCompare;
                }
                return storageCompare;
            } if (device1 instanceof AppleWatch && device2 instanceof AppleWatch) {
                AppleWatch appleWatch1 = (AppleWatch) device1;
                AppleWatch appleWatch2 = (AppleWatch) device2;
                int modelNameCompare = appleWatch1.getModelName().compareTo(appleWatch2.getModelName());
                if ( appleWatch1.getModelName() == appleWatch2.getModelName() ) {
                    int colorCompare = appleWatch1.getColor().compareTo(appleWatch2.getColor());
                    return colorCompare;
                }
                return modelNameCompare;
            }
            return device1.getColor().compareTo(device2.getColor());
        }
        return valueCompare;
    }
}
