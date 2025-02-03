package kumying.teethawat.lab8;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MySimpleWindow extends JFrame {
    protected JButton resetButton, submitButton;
    protected JPanel mainPanel, buttonPanel;

    public MySimpleWindow(String title) {
        super(title);
    }

    protected void addComponents() {
        resetButton = new JButton("Cancel"); // Cancel bt
        submitButton = new JButton("OK"); // OK bt
        mainPanel = new JPanel(); // make main panel
        buttonPanel = new JPanel(); // make bt p

        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel); // set mainpanel to buttonPanel

        add(mainPanel);
    }
    protected void setFrameFeatures() {
        // set setFrameFeature option
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
    // main running
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
