package kumying.teethawat.lab12;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import kumying.teethawat.lab7.MobileDevice;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class MobileDeviceV14 extends MobileDeviceV13 {
    protected JFileChooser fileChooser;
    protected StringBuffer newData; // foe show new data

    public MobileDeviceV14(String title) {
        super(title);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object srcObj = event.getSource();
        // {"New", "Open", "Save", "Exit"};  // menuitems {0-3}
        // use only Open and Save
        if (srcObj == menuitems.get(1)) {
            handleMenuOpen();
        } else if (srcObj == menuitems.get(2)) {
            handleMenuSave();
        } else {
            super.actionPerformed(event);
        }
    }
    public void handleMenuOpen() {
        fileChooser = new JFileChooser();
        // invoke for check user choose file?
        int Check = fileChooser.showOpenDialog(this);
        if (Check == JFileChooser.APPROVE_OPTION) { // if the user selects a file
            if (ReadFile(fileChooser.getSelectedFile())) { // read from selected file (own function)
                // pass with my own function
                String msg = "Opening: " + getFilePath();
                JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
                // ShowReadFile();
                StringBuffer msg1 = new StringBuffer();
                msg1.append("Read devices from the file " + getFilePath() + " are as follows:" + "\n");
                msg1.append(newData);
                JOptionPane.showMessageDialog(this, msg1.toString(), "Message" ,JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public void handleMenuSave() {
        fileChooser = new JFileChooser();
        // invoke for check user choose file?
        int Check = fileChooser.showSaveDialog(this);
        if (Check == JFileChooser.APPROVE_OPTION) { // if the user selects a file
            if (WriteFile(fileChooser.getSelectedFile(), mobileDevices)) { // write from selected file (own function)
            // pass with my own function
            String msg = "Data is saved to " + getFilePath() + " successfully!";
            JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    // own function
    @Override // old : get filename -> new : get AbsolutePath
    public String getFilePath() {
        return (fileChooser.getSelectedFile().getAbsolutePath());
    }
    public boolean ReadFile(File file) {
        try {
            // start reader locate in < fileChooser.getSelectedFile() >
            newData = new StringBuffer(); // reset new data
            BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(file), "UTF-8"
                    )
                    );
            // spilt data progess
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(":");
                int brandStartIndex = data[1].indexOf('(');
                int brandEndIndex = data[1].indexOf(')');
                String name = data[1].substring(1, brandStartIndex-1);
                String brand = data[1].substring(brandStartIndex + 1, brandEndIndex);
                String price = data[1].substring(brandEndIndex + 2, data[1].length() - 5);
                double pricenum = Double.parseDouble(price);
                // check SmartPhone or Tablet
                if (data[0].equalsIgnoreCase("SmartPhone")) {
                    mobileDevices.add(new SmartPhone(name, brand, pricenum));
                } else { mobileDevices.add(new Tablet(name, brand, pricenum));}
                // add new data
                newData.append(mobileDevices.getLast().toString() + "\n");
            }
            bufferedReader.close();
            return true;
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please provide a filename", "Message" ,JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found", "Message" ,JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading to file", "Message" ,JOptionPane.ERROR_MESSAGE);
        } return false;
    }
    public boolean WriteFile(File file, ArrayList<MobileDevice> mobileDevices) {
        try {
            // start writer locate in < fileChooser.getSelectedFile() >
            PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(
                    new FileOutputStream(file), "UTF-8"
                )
            );
            // write progess
            for (MobileDevice mobileDevice : mobileDevices) {
                writer.println(mobileDevice);
            }
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
        MobileDeviceV14 msw = new MobileDeviceV14("Mobile Device V14");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
        msw.addShortKeys();
    }
}
