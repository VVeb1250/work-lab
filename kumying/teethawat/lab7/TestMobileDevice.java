package kumying.teethawat.lab7;

public class TestMobileDevice {
    public static void main(String[] args) {
        IPadAir ipadAir1 = new IPadAir("Rose Gold", 19900.0, 64);
        IPadAir ipadAir2 = new IPadAir("Silver", 24900.0, 256);
        AppleWatch appleWatch1 = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        System.out.println("IPadAir chip name is " + IPadAir.getCHIP_NAME());
        if (ipadAir2.isWatch()) {
            System.out.println(ipadAir2 + " is a watch");
        } else {
            System.out.println(ipadAir2 + " is not a watch");
        }
        comparePrize(ipadAir1, ipadAir2);
        comparePrize(ipadAir1, appleWatch1);
    }

    public static void comparePrize(MobileDevice device1,MobileDevice device2) {
        if (device1.getPrice() < device2.getPrice()) {
            System.out.println(device1 + " is cheaper than " + device2);
        } else if (device1.getPrice() > device2.getPrice()) {
            System.out.println(device2 + " is cheaper than " + device1);
        } else {
            System.out.println(device1 + " is as cheap as " + device2);
        }
    }
}
