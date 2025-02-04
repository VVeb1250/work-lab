package kumying.teethawat.lab9;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MobileDeviceV7 extends MobileDeviceV6 {
    public MobileDeviceV7(String title) {
        super(title);
    }

    JPanel imagePanel;

    @Override
    protected void addComponents() {
        super.addComponents(); // call old medhod
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
        imagePanel = new ReadImage("kumying/teethawat/lab9/image/S25-ultra.jpg");
        ultraExtraPanel.add(imagePanel);
        deviceRatingSlider.setValue(9);
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