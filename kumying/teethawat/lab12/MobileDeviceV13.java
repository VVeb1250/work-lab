package kumying.teethawat.lab12;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import kumying.teethawat.lab7.MobileDevice;

import java.awt.event.*;
import java.util.ArrayList;

public class MobileDeviceV13 extends MobileDeviceV12 {
    protected JButton addButton, displayButton;
    protected ArrayList<MobileDevice> mobileDevices;

    public MobileDeviceV13(String title) {
        super(title);
    }

    @Override
    public void addComponents() {
        super.addComponents();
        // add follow assingment
        addButton = new JButton("Add");
        displayButton = new JButton("Display");
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);

        mobileDevices = new ArrayList<MobileDevice>();
    }
    @Override
    public void addListeners() {
        super.addListeners();
        // add lis.
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == addButton) {
            handleAddButton();
        } else if (src == displayButton) {
            handleDisplayButton();
        } else {
            // check top first
            super.actionPerformed(e);
        }
    }

    public void handleAddButton() {
        // get data in text field (use my own function)
        String name = handleGetTextInTextField(deviceNameTextField);
        String brand = handleGetTextInTextField(brandDeviceNameTextField);
        Double price = handleGetNumInTextField(priceDeviceNameTextField);
        String mobileDeviceType = smartphoneRadioButton.isSelected() ? "Smartphone" : "Tablet" ;
        // if some empty do return
        if (name == null || brand == null || Double.isNaN(price)) { return; }
        // add by check type
        if (smartphoneRadioButton.isSelected()) { mobileDevices.add(new SmartPhone(name, brand, price)); } 
        else { mobileDevices.add(new Tablet(name, brand, price)); }
        // notification
        String msg = mobileDeviceType + " " + name +  " is added";
        JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.INFORMATION_MESSAGE);
    }
    public void handleDisplayButton() {
        // msg start here
        StringBuffer msg = new StringBuffer();
        for (MobileDevice mobileDevice : mobileDevices) {
            // just display mobiledevice tostring
            msg.append(mobileDevice.toString() + "\n");
        }
        if (msg.isEmpty()) { 
            // no data condition
            JOptionPane.showMessageDialog(this, "No data", "Message" ,JOptionPane.INFORMATION_MESSAGE);
        } else { 
            // msg showup
            JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.INFORMATION_MESSAGE); 
        }
    }

    // own function
    public String handleGetTextInTextField(JTextField tf) {
        // get text from JTextField
        String text = tf.getText();
        if (text.isEmpty()){
            // empty condition
            tf.requestFocusInWindow();
            String msg = "Please enter some data in " + tf.getName();
            JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.INFORMATION_MESSAGE);
            return null; // return empty
        } return text; // pass condition
    }
    public Double handleGetNumInTextField(JTextField tf) {
        String msg;
        if (tf.getText().isEmpty()) {
            // empty condition
            tf.requestFocusInWindow();
            msg = "Please enter some data in " + tf.getName();
            JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                double PriceCheck = Double.parseDouble(tf.getText());
                if (PriceCheck < 0) {
                    // negative condition
                    tf.requestFocusInWindow();
                    msg = tf.getName() + " must be a positive number";
                    JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.INFORMATION_MESSAGE);
                } else { return PriceCheck; }
            } catch (NumberFormatException e) {
                // error condition
                tf.requestFocusInWindow();
                msg = "Please enter a valid number in " + tf.getName();
                JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.ERROR_MESSAGE);   
            }
        } return Double.NaN; // not pass any condition
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        MobileDeviceV13 msw = new MobileDeviceV13("Mobile Device V13");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
        msw.addShortKeys();
    }
}
