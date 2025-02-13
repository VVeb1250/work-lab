package kumying.teethawat.exercises.gui3;

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class SimpleFormV5 extends SimpleFormV4 implements ActionListener {
    public SimpleFormV5(String title) {
        super(title);
    }

    public void addListeners() {
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == okButton) {
            JOptionPane.showMessageDialog(this, getMessage(), "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        if (src == cancelButton) {
            return;
        }
    }
    public String getMessage() {
        return nameTxt.getText() + " lives at " + addrTxtArea.getText();
    }

    public static void createAndShowGUI() {
        SimpleFormV5 window = new SimpleFormV5("SimpleFormV5");
        window.addComponents();
        window.addMenus();
        window.addListeners();
        window.setFrameFeatures();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
