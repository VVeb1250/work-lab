package kumying.teethawat.lab9;

import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import kumying.teethawat.lab8.MobileDeviceV3;

public class MobileDeviceV4 extends MobileDeviceV3 {
    
    public MobileDeviceV4(String title) {
        super(title);
    }

    // fileMenuList : menuitems {0-3}
    // sizeSubmenuList : menuitems {4-7}
    // colorSubmenuList : menuitems {8-11}
    // fontSubmenuList : menuitems {12-14}
    
    // making list for using in menubar
    protected String[] fileImageList = {
        "kumying/teethawat/lab9/image/new_icon.png", 
        "kumying/teethawat/lab9/image/open_icon.png", 
        "kumying/teethawat/lab9/image/save_icon.png", 
        "kumying/teethawat/lab9/image/exit_icon.png"}; // path image
    protected int[] sizeList = {10, 14, 18, 22}; // number size
    protected Color[] colorList = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE}; // color
    protected String[] fontList = {"Serif", "SansSerif", "Monospaced"}; // font

    @Override
    protected void addMenus() {
        super.addMenus();
        ChangeFileImage(fileImageList);
        ChangeSizeMenu(sizeList);
        ChangeColorMenu(colorList);
        ChangeFontMenu(fontList);
    }
    protected void ChangeFileImage(String[] fileImageList) {
        // newMI.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/new_icon.png")));
        for (int i = 0; i < 4; i++) {
            JMenuItem item = menuitems.get(i);
            item.setIcon(new ImageIcon(getClass().getClassLoader().getResource(fileImageList[i])));
        }
    }
    protected void ChangeSizeMenu(int[] sizeList) {
        // smallMI.setFont(new Font("Arial", Font.PLAIN, 10));
        for (int i = 4; i < 8; i++) {
            JMenuItem item = menuitems.get(i);
            item.setFont(new Font("Arial", Font.PLAIN, sizeList[i-4]));
        }
    }
    protected void ChangeColorMenu(Color[] colorList) {
        // blackMI.setForeground(Color.BLACK);
        for (int i = 8; i < 12; i++) {
            JMenuItem item = menuitems.get(i);
            item.setForeground(colorList[i-8]);
        }
    }
    protected void ChangeFontMenu(String[] fontList) {
        // font1MI.setFont(new Font("Serif", Font.PLAIN, 14));
        for (int i = 12; i < 15; i++) {
            JMenuItem item = menuitems.get(i);
            item.setFont(new Font(fontList[i-12], Font.PLAIN, 14));
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
        MobileDeviceV4 msw = new MobileDeviceV4("Mobile Device V4");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
