package kumying.teethawat.lab8;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MobileDeviceV3 extends MobileDeviceV2 {
    public MobileDeviceV3(String title) {
        super(title);
    }
    // making list for using in menubar
    protected String[] fileMenuList = {"New", "Open", "Save", "Exit"};  // menuitems {0-3}
    protected String[] configMenuList = {"Size", "Color", "Font"};
    protected String[] sizeSubmenuList = {"Small", "Medium", "Large", "Extra Large"};  // menuitems {4-7}
    protected String[] colorSubmenuList = {"Black", "Red", "Green", "Blue"};  // menuitems {8-11}
    protected String[] fontSubmenuList = {"Font 1", "Font 2", "Font 3"};  // menuitems {12-14}
    protected String[][] configSubmenuList = {sizeSubmenuList, colorSubmenuList, fontSubmenuList};
    protected List<JMenuItem> menuitems = new ArrayList<JMenuItem>();  // add for ez to making Jmenuitem

    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu;

    @Override
    protected void addComponents() {
        super.addComponents(); // call old method
        addMenus(); // follow assingment
    }
    protected void addMenus() {
        // init
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        configMenu = new JMenu("Config");
        // add menuitem
        AddItemToMenu(fileMenu, fileMenuList);
        AddSubmenuToMenu(configMenu, configMenuList, configSubmenuList);
        // add menu to menubar
        menuBar.add(fileMenu);
        menuBar.add(configMenu);
        // set menu
        setJMenuBar(menuBar);
    }
    protected void AddItemToMenu(JMenu menu, String[] list) {
        // just add each item to menu
        for (int i = 0; i < list.length; i++) {
            JMenuItem item = new JMenuItem(list[i]);
            menu.add(item);
            menuitems.add(item); // add menuitems to array for modify
        }      
    }
    protected void AddSubmenuToMenu(JMenu menu,String[] listMenu, String[][] listSubMenu) {
        for (int i = 0; i < listMenu.length; i++) {
            JMenu item = new JMenu(listMenu[i]);
            AddItemToMenu(item, listSubMenu[i]); // call to add item to sub menu
            menu.add(item);
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
        MobileDeviceV3 msw = new MobileDeviceV3("Mobile Device V3");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
