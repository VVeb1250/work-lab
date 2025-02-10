package kumying.teethawat.lab10;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MobileDeviceV9 extends MobileDeviceV8 {
    JFileChooser FileChooser;

    public MobileDeviceV9(String title) {
        super(title);
    }

    public void addListeners() {
        super.addListeners();
        for (JMenuItem menuitem : menuitems) {
            menuitem.addActionListener(this);
        }
    }
    // {"New", "Open", "Save", "Exit"};  // menuitems {0-3}
    // {"Size", "Color", "Font"};
    // {"Small", "Medium", "Large", "Extra Large"};  // menuitems {4-7}
    // {"Black", "Red", "Green", "Blue"};  // menuitems {8-11}
    // {"Font 1", "Font 2", "Font 3"};  // menuitems {12-14}
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        // {"New", "Open", "Save", "Exit"};  // menuitems {0-3}
        if (src == menuitems.get(0)) {
            super.resetAction();
        } else if (src == menuitems.get(1)) {
            openFileAction();
        } else if (src == menuitems.get(2)) {
            saveFileAction();
        } else if (src == menuitems.get(3)) {
            exitAction();
        // {"Size"};
        // {"Small", "Medium", "Large", "Extra Large"};  // menuitems {4-7}
        } else if (src == menuitems.get(4)) {
            adjustSize(mainPanel, sizeList[0]);
        } else if (src == menuitems.get(5)) {
            adjustSize(mainPanel, sizeList[1]);
        } else if (src == menuitems.get(6)) {
            adjustSize(mainPanel, sizeList[2]);
        } else if (src == menuitems.get(7)) {
            adjustSize(mainPanel, sizeList[3]);
        // {"Color"};
        // {"Black", "Red", "Green", "Blue"};  // menuitems {8-11}
        } else if (src == menuitems.get(8)) {
            adjustColor(mainPanel, colorList[0]);
        } else if (src == menuitems.get(9)) {
            adjustColor(mainPanel, colorList[1]);
        } else if (src == menuitems.get(10)) {
            adjustColor(mainPanel, colorList[2]);
        } else if (src == menuitems.get(11)) {
            adjustColor(mainPanel, colorList[3]);
        // {"Font"};
        // {"Font 1", "Font 2", "Font 3"};  // menuitems {12-14}
        } else if (src == menuitems.get(12)) {
            adjustFont(mainPanel, fontList[0]);
        } else if (src == menuitems.get(13)) {
            adjustFont(mainPanel, fontList[1]);
        } else if (src == menuitems.get(14)) {
            adjustFont(mainPanel, fontList[2]);
        } 
    }
    public void openFileAction() {
        FileChooser = new JFileChooser();
        // invoke for check user choose file?
        int Check = FileChooser.showOpenDialog(this);
        if (Check == JFileChooser.APPROVE_OPTION) { // if the user selects a file
            String msg = "Opening: " + getFilePath();
            JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        } else { return; }
    }
    public void saveFileAction() {
        FileChooser = new JFileChooser();
        int Check = FileChooser.showSaveDialog(this);
        if (Check == JFileChooser.APPROVE_OPTION) { // if the user selects a file
            String msg = "Data is saved to " + getFilePath() + " successfully!";
            JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        } else { return; }
    }
    public String getFilePath() {
        return (FileChooser.getSelectedFile().getAbsolutePath());
    }
    public void exitAction() {
        System.exit(0);
    }
    public void adjustSize(Container container, int size) {
        for (Component child : container.getComponents()) {
            if (child instanceof Container) {
                adjustSize((Container)child, size);
            }
            if (child instanceof JTextField || child instanceof JTextArea) {
                Font newfont = new Font(child.getFont().getFontName(), child.getFont().getStyle(), size);
                child.setFont(newfont);
            }
        }
    }
    public void adjustColor(Container container, Color fontColor) {
        for (Component child : container.getComponents()) {
            if (child instanceof Container) {
                adjustColor((Container)child, fontColor);
            }
            if (child instanceof JTextField || child instanceof JTextArea) {
                child.setForeground(fontColor);
            }
        }
    }
    public void adjustFont(Container container, String font) {
        for (Component child : container.getComponents()) {
            if (child instanceof Container) {
                adjustFont((Container)child, font);
            }
            if (child instanceof JTextField || child instanceof JTextArea) {
                Font newfont = new Font(font, child.getFont().getStyle(), child.getFont().getSize());
                child.setFont(newfont);
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
        MobileDeviceV9 msw = new MobileDeviceV9("Mobile Device V9");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
    }
}
