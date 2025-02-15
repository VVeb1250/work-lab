package kumying.teethawat.lab10;

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MobileDeviceV10 extends MobileDeviceV9 implements ListSelectionListener, ChangeListener {
    public MobileDeviceV10(String title) {
        super(title);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        operatingSystemComboBox.addActionListener(this);
        deviceAvalable.addListSelectionListener(this);
        deviceRatingSlider.addChangeListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == operatingSystemComboBox) { selectedOSAction(); }
    }
    public void selectedOSAction() {
        String selectedOS = (String) operatingSystemComboBox.getSelectedItem(); // getSelectedItem follow assingment suggestion
        String msg = "You selected Operating System: " + selectedOS;
        JOptionPane.showMessageDialog(this, msg, "OS Selection" ,JOptionPane.INFORMATION_MESSAGE);
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == deviceAvalable) {
            if (!e.getValueIsAdjusting()) {
                String msg = "Device is available at: " + getselectedVendors();
                JOptionPane.showMessageDialog(this, msg, "Vendor Selection" ,JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        String msg = "New rating: " + deviceRatingSlider.getValue();
        JOptionPane.showMessageDialog(this, msg, "Rating Adjustment" ,JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        MobileDeviceV10 msw = new MobileDeviceV10("Mobile Device V10");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
    }
}
