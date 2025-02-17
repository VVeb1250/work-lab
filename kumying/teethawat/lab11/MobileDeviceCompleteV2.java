package kumying.teethawat.lab11;

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener {
    public MobileDeviceCompleteV2(String title) {
            super(title);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            public void run(){
                createAndShowGUI();
            }
        }));
    }

    public static void createAndShowGUI() {
        MobileDeviceCompleteV2 window = new MobileDeviceCompleteV2("Mobile Device Complete V2");
        window.addComponents();
        window.addMenus();
        window.setFrameFeatures();
        window.addListeners();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == deviceNameField) {
            String msg = "You pressed Enter in Device Name field: " + deviceNameField.getText();
            DisplayDialogMsg(msg, "Notification"); 
        } 
        if (src == brandField) { 
            String msg = "Brand field says: " + brandField.getText();
            DisplayDialogMsg(msg, "Notification"); 
        } 
        if (src == priceField) { 
            String msg = "Price entered: " + priceField.getText();
            DisplayDialogMsg(msg, "Notification"); 
        } 
    }
    public void addListeners() {
        // protected JTextField deviceNameField, brandField, priceField;
        deviceNameField.addActionListener(this);
        brandField.addActionListener(this);
        priceField.addActionListener(this);
    }

    public void DisplayDialogMsg(String msg, String title) {
        JOptionPane.showMessageDialog(this, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
