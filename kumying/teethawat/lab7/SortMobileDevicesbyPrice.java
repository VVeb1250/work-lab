package kumying.teethawat.lab7;

import java.util.Arrays;
import java.util.Comparator;

public class SortMobileDevicesbyPrice implements Comparator<MobileDevice> {
    public static void main(String[] args) {
        // Create array of mobile devices
        MobileDevice[] devices = new MobileDevice[4];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        devices[2] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        devices[3] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");

        // making sort
        Arrays.sort(devices, new SortMobileDevicesbyPrice());

        System.out.println("Mobile device sorted by prize:");
        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }

    // just using compare prize
    @Override
    public int compare(MobileDevice device1, MobileDevice devices2) {
        // TODO Auto-generated method stub
        return Double.valueOf(device1.getPrice()).compareTo(Double.valueOf(devices2.getPrice()));
    }
}
