package kumying.teethawat.lab12;

import java.io.*;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

// import java.awt.event.*;

import kumying.teethawat.lab7.MobileDevice;

public class MobileDeviceV15 extends MobileDeviceV14 {

        // update new member
    protected JMenu formatItem;
    protected JCheckBoxMenuItem textFormat, binaryFormat;
    // make new formatGroup
    protected ButtonGroup formatGroup;

    public MobileDeviceV15(String title) {
        super(title);
    }

    @Override
    public void addComponents() {
        super.addComponents();
        // init new obj.
        formatItem = new JMenu("Format");
        textFormat = new JCheckBoxMenuItem("Text", true);
        binaryFormat = new JCheckBoxMenuItem("Binary", false);
        // add to menu
        configMenu.add(formatItem); // add to config if you forgor
        formatItem.add(textFormat);
        formatItem.add(binaryFormat);
        // making group
        formatGroup = new ButtonGroup();
        formatGroup.add(textFormat);
        formatGroup.add(binaryFormat);
    }
    @Override
    public void addListeners() {
        super.addListeners();
        textFormat.addActionListener(this);
        binaryFormat.addActionListener(this);
    }
    @Override // old: read text only -> new: can read both
    public void handleMenuOpen() {
        fileChooser = new JFileChooser();
        // invoke for check user choose file?
        int Check = fileChooser.showOpenDialog(this);
        if (Check == JFileChooser.APPROVE_OPTION) { // if the user selects a file
            File fileSelected = fileChooser.getSelectedFile();
            // don't stun, Just check condition if textFormat.isSelected() do ReadFile(fileSelected) and return boolean for check condition
            // but is not textFormat.isSelected() do ReadFile(fileSelected) and also return boolean for check condition
            if (textFormat.isSelected() ? ReadFile(fileSelected) : ReadFileBinary(fileSelected)) {
                // pass with my own function
                String msg = "Opening: " + getFilePath();
                JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
                // ShowReadFile();
                StringBuffer msg1 = new StringBuffer();
                msg1.append("Read devices from the file " + getFilePath() + " are as follows:" + "\n");
                msg1.append(newData);
                JOptionPane.showMessageDialog(this, msg1.toString(), "Message" ,JOptionPane.INFORMATION_MESSAGE);
            } else if (!textFormat.isSelected() && !binaryFormat.isSelected()) { 
                JOptionPane.showMessageDialog(this, "Please provide format", "Message" ,JOptionPane.ERROR_MESSAGE); 
            }
        }
    }
    @Override // old: write text only -> new: can write both
    public void handleMenuSave() {
        fileChooser = new JFileChooser();
        // invoke for check user choose file?
        int Check = fileChooser.showSaveDialog(this);
        if (Check == JFileChooser.APPROVE_OPTION) { // if the user selects a file
            File fileSelected = fileChooser.getSelectedFile();
            // this also same as the upper
            if (textFormat.isSelected() ? WriteFile(fileSelected, mobileDevices) : WriteFileBinary(fileSelected, mobileDevices)) { // write from selected file (own function)
            // pass with my own function
            String msg = "Data is saved to " + getFilePath() + " successfully!";
            JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
            } else if (!textFormat.isSelected() && !binaryFormat.isSelected()) { 
                JOptionPane.showMessageDialog(this, "Please provide format", "Message" ,JOptionPane.ERROR_MESSAGE); 
            }
        }
    }

    public boolean ReadFileBinary(File file) {
        try {
            // start reader locate in < fileChooser.getSelectedFile() >
            newData = new StringBuffer(); // reset new data
            ObjectInputStream reader = new ObjectInputStream( new FileInputStream(file) );
            // read data
            @SuppressWarnings("unchecked")
            ArrayList<MobileDevice> newMobileDevices = (ArrayList<MobileDevice>) reader.readObject();
            // loop add new data display
            for (MobileDevice newMobileDevice : newMobileDevices) {
                // add new data
                newData.append(newMobileDevice.toString());
            }
            reader.close();
            return true;
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please provide a filename", "Message" ,JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found", "Message" ,JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading to file", "Message" ,JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Class MobileDevice not found in your file", "Message" ,JOptionPane.ERROR_MESSAGE);
        } return false;
    }
    public boolean WriteFileBinary(File file, ArrayList<MobileDevice> mobileDevices) {
        try {
            // start writer locate in < fileChooser.getSelectedFile() >
            ObjectOutputStream writer = new ObjectOutputStream( new FileOutputStream(file) );
            // write progess
            writer.writeObject(mobileDevices);
            writer.close();
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please provide a filename", "Message" ,JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found", "Message" ,JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file", "Message" ,JOptionPane.ERROR_MESSAGE);
        } return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        MobileDeviceV15 msw = new MobileDeviceV15("Mobile Device V15");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
        msw.addShortKeys();
    }
}

// code reference

// protected void AddItemToMenu(JMenu menu, String[] list) {
//     // just add each item to menu
//     for (int i = 0; i < list.length; i++) {
//         JMenuItem item = new JMenuItem(list[i]);
//         menu.add(item);
//         menuitems.add(item); // add menuitems to array for modify
//     }      
// }
// protected void AddSubmenuToMenu(JMenu menu,String[] listMenu, String[][] listSubMenu) {
//     for (int i = 0; i < listMenu.length; i++) {
//         JMenu item = new JMenu(listMenu[i]);
//         AddItemToMenu(item, listSubMenu[i]); // call to add item to sub menu
//         menu.add(item);
//     }      
// }