package kumying.teethawat.lab9;

import java.awt.Dimension;

import javax.swing.SwingUtilities;

public class MobileDeviceV7 extends MobileDeviceV6 {
    public MobileDeviceV7(String title) {
        super(title);
    }

    protected ReadImage imageSamsungGalaxyS25Ultra;

    @Override
    protected void addComponents() {
        super.addComponents(); // call old medhod
        // just set text
        deviceNameTextField.setText("Samsung Galaxy S25 Ultra");
        brandDeviceNameTextField.setText("Samsung");
        priceDeviceNameTextField.setText("46,900");
        featuresTextArea.setText(
                        "- 200MP Camera\r\n" + //
                        "- 1TB Storage\r\n" + //
                        "- Snapdragon Gen 4 Processor\r\n" + //
                        "- 5000mAh Battery\r\n" + //
                        "- 6.8-inch AMOLED Display\r\n" + //
                        "- 120Hz Refresh Rate\r\n" + //
                        "- Fast Charging\r\n");
        // just set slider
        deviceRatingSlider.setValue(9);
        // image progess (explain in own class)
        imageSamsungGalaxyS25Ultra = new ReadImage("kumying/teethawat/lab9/image/S25-ultra.jpg", 0.45f); // take to my class
        imageSamsungGalaxyS25Ultra.setPreferredSize(new Dimension(imageSamsungGalaxyS25Ultra.getWidth(), imageSamsungGalaxyS25Ultra.getHeight())); // setsize (Width by picture, Height by own picture)
        ultraExtraPanel.add(imageSamsungGalaxyS25Ultra); // add to ultraextrapanel
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        MobileDeviceV7 msw = new MobileDeviceV7("Mobile Device V7");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}