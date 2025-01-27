package kumying.teethawat.lab8;

import javax.swing.*;
import java.awt.*;

public class MobileDeviceV1 extends MySimpleWindow {
    public MobileDeviceV1(String title) {
        super(title);
    }

    protected JLabel deviceNameLabel, brandDeviceNameLabel, priceDeviceNameLabel, typeDeviceNameLabel;
    protected JTextField deviceNameTextField, brandTedeviceNameTextField, priceTedeviceNameTextField;
    protected JRadioButton smartphoneRadioButton, ipadRadioButton;

    @Override
    protected void addComponents() {
        // intizise mainPanel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        MakeFromPanel();
        MakeButtonPanel();

        add(mainPanel);
    }
    protected void MakeFromPanel() {
        // intizise formPanel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2));
        // making obj.
            // lebel
        deviceNameLabel = new JLabel("Device Name:");
        brandDeviceNameLabel = new JLabel("Brand:");
        priceDeviceNameLabel = new JLabel("Price:");
        typeDeviceNameLabel = new JLabel("Type:");
            // textfield
        deviceNameTextField = new JTextField(15);
        brandTedeviceNameTextField = new JTextField(15);
        priceTedeviceNameTextField = new JTextField(15);
            // type button
        JPanel typePanel = new JPanel();
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
        formPanel.add(brandTedeviceNameTextField);
        formPanel.add(priceDeviceNameLabel);
        formPanel.add(priceTedeviceNameTextField);
        formPanel.add(typeDeviceNameLabel);
        formPanel.add(typePanel);
        // add to main
        mainPanel.add(formPanel, BorderLayout.NORTH);
    }
    protected void MakeButtonPanel() {
        // make obj.
        buttonPanel = new JPanel();
        resetButton = new JButton("Cancel");
        submitButton = new JButton("OK");
        // add to panel
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
        // add to main
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
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
