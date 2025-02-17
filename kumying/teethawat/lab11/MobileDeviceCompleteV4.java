package kumying.teethawat.lab11;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV2{
    protected JMenuItem customMI;

    public MobileDeviceCompleteV4(String title) {
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
        MobileDeviceCompleteV4 window = new MobileDeviceCompleteV4("Mobile Device Complete V4");
        window.addComponents();
        window.addMenus();
        window.setFrameFeatures();
        window.addListeners();
    }

    @Override
    protected void addMenus() {
        super.addMenus();
        configMenu = new JMenu("Config");
        colorMenu = new JMenu("Color");
        customMI = new JMenuItem("Custom");
        colorMenu.add(customMI);
        configMenu.add(colorMenu);
        menuBar.add(configMenu);
    }
    @Override
    public void addListeners() {
        customMI.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == customMI) {
            Color oldColor = deviceNameField.getForeground();
            Color newColor = JColorChooser.showDialog(this, "Choose Text Color", oldColor);
            if (newColor == null) { return; }
            deviceNameField.setForeground(newColor); 
            brandField.setForeground(newColor); 
            priceField.setForeground(newColor); 
        }
    }
}
