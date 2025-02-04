package kumying.teethawat.lab9;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MobileDeviceV5 extends MobileDeviceV4 {
    public MobileDeviceV5(String title) {
        super(title);
    }

    protected JPanel ultraExtraPanel, deviceAvalablelPanel, deviceRatingPanel;
    protected JLabel deviceAvalableLabel, deviceRatingLabel;
    protected String[] vendors = {"AIS", "True", "DTAC", "Shopee"};
    protected JList<String> deviceAvalable = new JList<String>(vendors); // set deviceAvalable by vendors
    protected JSlider deviceRatingSlider;

    @Override
    protected void addComponents() {
        super.addComponents(); // call old method
        // make new layout
        ultraExtraPanel = new JPanel();
        ultraExtraPanel.setLayout(new BoxLayout(ultraExtraPanel, BoxLayout.Y_AXIS));
        // adding new component
        ultraExtraPanel.add(extraPanel);
        makeDeviceAvalable();
        makeDeviceRating();
        mainPanel.add(ultraExtraPanel, BorderLayout.CENTER);
    }
    public void makeDeviceAvalable() {
        deviceAvalablelPanel = new JPanel();
        deviceAvalablelPanel.setLayout(new GridLayout(1, 2));
        deviceAvalableLabel = new JLabel("The device is avalable at:");
        deviceAvalable.setVisibleRowCount(4);
        deviceAvalable.setSelectedIndex(0);
        deviceAvalable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane deviceAvalableScrollPane = new JScrollPane(deviceAvalable);
        deviceAvalablelPanel.add(deviceAvalableLabel);
        deviceAvalablelPanel.add(deviceAvalableScrollPane);
        ultraExtraPanel.add(deviceAvalablelPanel);
    }
    public void makeDeviceRating() {
        deviceRatingPanel = new JPanel();
        deviceRatingPanel.setLayout(new GridLayout(2, 1));
        deviceRatingLabel = new JLabel("Rate the device (0-10):");
        deviceRatingSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5); // min, max, defalutset
        deviceRatingSlider.setMajorTickSpacing(1);
        deviceRatingSlider.setPaintTicks(true);
        deviceRatingSlider.setPaintLabels(true);
        deviceRatingPanel.add(deviceRatingLabel);
        deviceRatingPanel.add(deviceRatingSlider);
        ultraExtraPanel.add(deviceRatingPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        MobileDeviceV5 msw = new MobileDeviceV5("Mobile Device V5");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
