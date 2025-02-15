package kumying.teethawat.lab10;

import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MobileDeviceV11 extends MobileDeviceV10 {
    public MobileDeviceV11(String title) {
        super(title);
    }

    // menuitems is list of these :
    // {"New", "Open", "Save", "Exit"};  // menuitems {0-3}
    public void addShortKeys() {
        // New
        menuitems.get(0).setMnemonic(KeyEvent.VK_N);
        menuitems.get(0).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        // Open
        menuitems.get(1).setMnemonic(KeyEvent.VK_O);
        menuitems.get(1).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        // Save
        menuitems.get(2).setMnemonic(KeyEvent.VK_S);
        menuitems.get(2).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        // Exit
        menuitems.get(3).setMnemonic(KeyEvent.VK_X);
        menuitems.get(3).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }
    @Override
    public void addListeners() {
        super.addListeners();
        ipadRadioButton.addActionListener(this);
        smartphoneRadioButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == ipadRadioButton) {
            String msg = ipadRadioButton.getText() + " is selected";
            JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.INFORMATION_MESSAGE);
        }
        if (src == smartphoneRadioButton) {
            String msg = ipadRadioButton.getText() + " is selected";
            JOptionPane.showMessageDialog(this, msg, "Message" ,JOptionPane.INFORMATION_MESSAGE);
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
        MobileDeviceV11 msw = new MobileDeviceV11("Mobile Device V11");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
        msw.addShortKeys();
    }
}
