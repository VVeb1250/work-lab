package kumying.teethawat.lab10;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;
import java.util.List;

import kumying.teethawat.lab9.MobileDeviceV7;

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener{
    ButtonGroup typeButtonGroup;

    public MobileDeviceV8(String title) {
        super(title);
    }
    public void addListeners() {
        resetButton.addActionListener(this);
        submitButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == submitButton) {
            JOptionPane.showMessageDialog(this, getMessage(), "Device Information", JOptionPane.INFORMATION_MESSAGE);
        }
        if (src == resetButton) {
            resetAction();
        }
    }
    public String getMessage() {
        return "Device Name: " + deviceNameTextField.getText() + "\r\n" + //
               "Brand: " + brandDeviceNameTextField.getText() + "\r\n" + //
               "Price: " + priceDeviceNameTextField.getText() + "\r\n" + //
               "Type: " + (smartphoneRadioButton.isSelected() ? smartphoneRadioButton.getText() : ipadRadioButton.getText()) + "\r\n" + //
               "Operating System: " + vendors[operatingSystemComboBox.getSelectedIndex()] + "\r\n" + //
               "Features: " + featuresTextArea.getText() + "\r\n" + //
               "Available at: " + getselectedVendors() + "\r\n" + //
               "Rating: " + deviceRatingSlider.getValue();
    }
    public String getselectedVendors() {
        List<String> selectedVendors = deviceAvalable.getSelectedValuesList();
        // Create a message showing the selected vendors
        if (selectedVendors.size() == 1) { return selectedVendors.get(0); }
        if (selectedVendors.size() == 0) { return null; }
        StringBuilder message = new StringBuilder();
        for (String vendor : selectedVendors) {
            message.append(vendor).append(", ");
        } return message.substring(0, message.length()-2).toString();
    }
    public void resetAction() {
        resetTextFieldAction(mainPanel);
        resetTextAreaAction(mainPanel);
        resetTypeAction();
        resetOperatingSystemAction();
        resetDeviceAvalableAction();
        resetSliderAction();
    }
    public void resetTextFieldAction(Container container) {
        for (Component child : container.getComponents()) {
            if (child instanceof Container) {
                resetTextFieldAction((Container)child);
            }
            if (child instanceof JTextField) {
                ((JTextField)child).setText("");
            }
        }
    }
    public void resetTextAreaAction(Container container) {
        for (Component child : container.getComponents()) {
            if (child instanceof Container) {
                resetTextAreaAction((Container)child);
            }
            if (child instanceof JTextArea) {
                ((JTextArea)child).setText("");
            }
        }
    }
    public void resetTypeAction() {
        smartphoneRadioButton.setSelected(true);
    }
    public void resetOperatingSystemAction() {
        operatingSystemComboBox.setSelectedIndex(0);
    }
    public void resetDeviceAvalableAction() {
        deviceAvalable.clearSelection();
    }
    public void resetSliderAction() {
        deviceRatingSlider.setValue(5);
    }
    @Override
    public void addComponents() {
        super.addComponents();
        // recreate type button lol my bruh
        typeButtonGroup = new ButtonGroup();
        typeButtonGroup.add(smartphoneRadioButton);
        typeButtonGroup.add(ipadRadioButton);
    }
  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        MobileDeviceV8 msw = new MobileDeviceV8("Mobile Device V8");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
    }
}
