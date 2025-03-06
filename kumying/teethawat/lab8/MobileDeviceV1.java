package kumying.teethawat.lab8;

import javax.swing.*;
import java.awt.*;

public class MobileDeviceV1 extends MySimpleWindow {
    public MobileDeviceV1(String title) {
        super(title);
    }

    protected JPanel formPanel, typePanel;
    protected JLabel deviceNameLabel, brandDeviceNameLabel, priceDeviceNameLabel, typeDeviceNameLabel;
    protected JTextField deviceNameTextField, brandDeviceNameTextField, priceDeviceNameTextField;
    protected JRadioButton smartphoneRadioButton, ipadRadioButton;

    @Override
    protected void addComponents() {
        super.addComponents();
        // intizise mainPanel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        MakeFromPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
    protected void MakeFromPanel() {
        // intizise formPanel
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2));
        // making obj.
            // lebel
        deviceNameLabel = new JLabel("Device Name:");
        brandDeviceNameLabel = new JLabel("Brand:");
        priceDeviceNameLabel = new JLabel("Price:");
        typeDeviceNameLabel = new JLabel("Type:");
            // textfield
        deviceNameTextField = new JTextField(15);
        brandDeviceNameTextField = new JTextField(15);
        priceDeviceNameTextField = new JTextField(15);
            // type button
        typePanel = new JPanel();
        ButtonGroup ButtonGroup = new ButtonGroup();
        smartphoneRadioButton = new JRadioButton("Smartphone");
        ipadRadioButton = new JRadioButton("Tablet");
        ButtonGroup.add(smartphoneRadioButton);
        ButtonGroup.add(ipadRadioButton);
        typePanel.add(smartphoneRadioButton);
        typePanel.add(ipadRadioButton);
        smartphoneRadioButton.setSelected(true);
        // add to frompanel
        formPanel.add(deviceNameLabel);
        formPanel.add(deviceNameTextField);
        formPanel.add(brandDeviceNameLabel);
        formPanel.add(brandDeviceNameTextField);
        formPanel.add(priceDeviceNameLabel);
        formPanel.add(priceDeviceNameTextField);
        formPanel.add(typeDeviceNameLabel);
        formPanel.add(typePanel);
        // add to main
        mainPanel.add(formPanel, BorderLayout.NORTH);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        MobileDeviceV1 msw = new MobileDeviceV1("Mobile Device V1");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
