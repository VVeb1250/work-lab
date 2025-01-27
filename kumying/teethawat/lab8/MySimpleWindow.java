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
        resetButton = new JButton("Cancel");
        submitButton = new JButton("OK");
        mainPanel = new JPanel();
        buttonPanel = new JPanel();

        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel);

        add(mainPanel);
    }
    protected void setFrameFeatures() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
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
