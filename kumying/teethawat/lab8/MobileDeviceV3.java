package kumying.teethawat.lab8;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MobileDeviceV3 extends MobileDeviceV2 {
    public MobileDeviceV3(String title) {
        super(title);
    }
    // making list for using in menubar
    protected String[] fileMenuList = {"New", "Open", "Save", "Exit"};
    protected String[] configMenuList = {"Size", "Color", "Font"};
    protected String[] sizeSubmenuList = {"Small", "Medium", "Large", "Extra Large"};
    protected String[] colorSubmenuList = {"Black", "Red", "Green", "Blue"};
    protected String[] fontSubmenuList = {"Font 1", "Font 2", "Font 3"};
    protected String[][] configSubmenuList = {sizeSubmenuList, colorSubmenuList, fontSubmenuList};

    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu;

    @Override
    protected void addComponents() {
        // intizise mainPanel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        MakeMenuBar();
        MakeFromPanel();
        MakeExtraPanel();
        MakeButtonPanel();

        add(mainPanel);
    }
    protected void MakeMenuBar() {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        configMenu = new JMenu("Config");

        AddItemToMenu(fileMenu, fileMenuList);
        AddSubmenuToMenu(configMenu, configMenuList, configSubmenuList);

        menuBar.add(fileMenu);
        menuBar.add(configMenu);

        setJMenuBar(menuBar);
    }
    protected void AddItemToMenu(JMenu menu, String[] list) {
        for (int i = 0; i < list.length; i++) {
            JMenuItem item = new JMenuItem(list[i]);
            menu.add(item);
        }      
    }
    protected void AddSubmenuToMenu(JMenu menu,String[] listMenu, String[][] listSubMenu) {
        for (int i = 0; i < listMenu.length; i++) {
            JMenu item = new JMenu(listMenu[i]);
            AddItemToMenu(item, listSubMenu[i]);
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
