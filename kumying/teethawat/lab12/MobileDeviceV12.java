package kumying.teethawat.lab12;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.*;

import kumying.teethawat.lab10.MobileDeviceV11;

public class MobileDeviceV12 extends MobileDeviceV11 {
    public MobileDeviceV12(String title) {
        super(title);
    }

    @Override
    public void addComponents() {
        super.addComponents();
        // set name to text field
        deviceNameTextField.setName("Device name");
        brandDeviceNameTextField.setName("Brand");
        priceDeviceNameTextField.setName("Prize");
    }
    @Override
    public void addListeners() {
        super.addListeners();
        // add text field listener
        deviceNameTextField.addActionListener(this);
        brandDeviceNameTextField.addActionListener(this);
        priceDeviceNameTextField.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        // add listener
        Object srcObject = e.getSource();
        if (srcObject == deviceNameTextField) {
            handleNormalTextField(deviceNameTextField, brandDeviceNameTextField);
        } else if (srcObject == brandDeviceNameTextField) {
            handleNormalTextField(brandDeviceNameTextField, priceDeviceNameTextField);
        } else if (srcObject == priceDeviceNameTextField) {
            handlePosNumTextField(priceDeviceNameTextField, operatingSystemComboBox);
        }
   }

    public void handleNormalTextField(JTextField tf, JComponent nextComponent) {
        String msg;
        if (tf.getText().isEmpty()) {
            // empty condition
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
            msg = "Please enter some data in " + tf.getName();
        } else {
            // pass condition
            nextComponent.requestFocusInWindow();
            nextComponent.setEnabled(true);
            msg = tf.getName() + " is changed to " + tf.getText();
        } JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.INFORMATION_MESSAGE); // finally show dialog
    }
    public void handlePosNumTextField(JTextField tf, JComponent nextComponent) {
        String msg;
        if (tf.getText().isEmpty()) {
            // empty condition
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
            msg = "Please enter some data in " + tf.getName();
            JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                // make to double
                double PriceCheck = Double.parseDouble(tf.getText());
                if (PriceCheck < 0) {
                    // negatine condition
                    tf.requestFocusInWindow();
                    nextComponent.setEnabled(false);
                    msg = tf.getName() + " must be a positive number";
                } else {
                    // pass condition
                    nextComponent.requestFocusInWindow();
                    nextComponent.setEnabled(true);
                    msg = tf.getName() + " is changed to " + tf.getText();
                } JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                // error condition
                tf.requestFocusInWindow();
                nextComponent.setEnabled(false);
                msg = "Please enter a valid number in " + tf.getName();
                JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.ERROR_MESSAGE);   
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        MobileDeviceV12 msw = new MobileDeviceV12("Mobile Device V12");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
        msw.addShortKeys();
    }
}
