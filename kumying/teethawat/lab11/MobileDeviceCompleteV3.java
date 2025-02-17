package kumying.teethawat.lab11;

import java.awt.event.*;

import javax.swing.SwingUtilities;

public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 implements ComponentListener {
    public MobileDeviceCompleteV3(String title) {
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
        MobileDeviceCompleteV3 window = new MobileDeviceCompleteV3("Mobile Device Complete V3");
        window.addComponents();
        window.addMenus();
        window.setFrameFeatures();
        window.addListeners();
    }

    @Override
    public void addListeners() {
        super.addListeners();
        this.addComponentListener(this);
    }
    
    @Override
    public void componentHidden(ComponentEvent e) {
        //Invoked when the component has been made invisible.
        DisplayDialogMsg("Window is now invisible", "Message");
    }
    @Override
    public void componentMoved(ComponentEvent e) {
        //Invoked when the component's position changes.
        String msg = "Window moved to: " + "X=" + this.getX() + " Y=" + this.getY();
        DisplayDialogMsg(msg, "Message");
    }
    @Override
    public void componentResized(ComponentEvent e) {
        //Invoked when the component's size changes.
        String msg = "Window resized to: " + this.getWidth() + " x " + this.getHeight();
        DisplayDialogMsg(msg, "Message");
    }
    @Override
    public void componentShown(ComponentEvent e) {
        //Invoked when the component has been made visible.
        DisplayDialogMsg("Window is now visible", "Message");
    }
}
