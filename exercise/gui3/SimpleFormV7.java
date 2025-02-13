package kumying.teethawat.exercises.gui3;

import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class SimpleFormV7 extends SimpleFormV6 implements ItemListener {
    public SimpleFormV7(String title) {
        super(title);
    }

    @Override
    public void addMenus() {
        super.addMenus();
        newMI.setMnemonic(KeyEvent.VK_N);
        openMI.setMnemonic(KeyEvent.VK_O);
        quitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }
    @Override
    public String getMessage() {
        StringBuffer msg = new StringBuffer();
        msg.append(nameTxt.getText() + " lives at " + addrTxtArea.getText());
        msg.append(" gender is " + getGenderGroup());
        msg.append(" know these languages: " + getLanguages());
        return msg.toString();
    }
    public String getGenderGroup() {
        if (male.isSelected()) {
            return male.getText();
        } else if (female.isSelected()) {
            return female.getText();
        } else if (other.isSelected()) {
            return other.getText();
        } return null;
    }
    public String getLanguages() {
        StringBuffer msg = new StringBuffer();
        if (python.isSelected()) { msg.append(python.getText() + " "); }
        if (java.isSelected()) { msg.append(java.getText() + " "); }
        if (javascript.isSelected()) { msg.append(javascript.getText() + " "); }
        if (msg.isEmpty()) { return null; }
        return msg.substring(0, msg.length()-1).toString();
    }
    @Override
    public void addListeners() {
        super.addListeners();
        male.addItemListener(this);
        female.addItemListener(this);
        other.addItemListener(this);
        //
        newMI.addItemListener(this);
        openMI.addItemListener(this);
        quitMI.addItemListener(this);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object sorce = e.getSource();
        int state = e.getStateChange();
        String msg = " is selected";
        if (sorce == male && state == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(this, male.getText()+msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if (sorce == female && state == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(this, female.getText()+msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if (sorce == other && state == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(this, other.getText()+msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        //
        if (sorce == newMI) {
            JOptionPane.showMessageDialog(this, male.getText()+msg, "Menu New is clicked", JOptionPane.INFORMATION_MESSAGE);
        } else if (sorce == quitMI) {
            System.exit(0);
        }
    }
    
    public static void createAndShowGUI() {
        SimpleFormV7 window = new SimpleFormV7("SimpleFormV7");
        window.addComponents();
        window.addMenus();
        window.addListeners();
        window.setFrameFeatures();
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}