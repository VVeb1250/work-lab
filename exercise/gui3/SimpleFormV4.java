package kumying.teethawat.exercises.gui3;

import javax.swing.*;

public class SimpleFormV4 extends SimpleFormV3 {
    protected JMenuBar menuBar;
    protected JMenu fileMenu;
    protected JMenuItem newMI, openMI, quitMI;

    public SimpleFormV4(String title) {
        super(title);
    }

    public void addMenus() {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        newMI = new JMenuItem("New");
        openMI = new JMenuItem("Open");
        quitMI = new JMenuItem("Quit");
        menuBar.add(fileMenu);
        fileMenu.add(newMI);
        fileMenu.add(openMI);
        fileMenu.add(quitMI);
        this.setJMenuBar(menuBar);
    }
    public static void createAndShowGUI() {
        SimpleFormV4 window = new SimpleFormV4("SimpleFormV4");
        window.addComponents();
        window.addMenus();
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
