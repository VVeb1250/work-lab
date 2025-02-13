package kumying.teethawat.exercises.gui3;

import javax.swing.*;
import java.awt.*;

public class SimpleFormV3 extends SimpleFormV2 {
    protected String hobbiesStr[] = {"Running", "Reading", "Traveling"};
    protected JList<String> hobbiesLst;
    protected JScrollPane hobbiesScrollPane;
    protected JPanel hobbiesPanel, contentBottomPanel;
    protected JLabel hobbiesLabel;

    public SimpleFormV3(String title) {
        super(title);
    }

    public void initComponents() {
        hobbiesLst  = new JList<String>(hobbiesStr);
        hobbiesScrollPane = new JScrollPane(hobbiesLst);
        hobbiesLabel = new JLabel("Hobbies:");
        hobbiesPanel = new JPanel();

        contentBottomPanel = new JPanel();
    }
    public void addComponents() {
        super.addComponents();
        initComponents();

        hobbiesPanel.setLayout(new GridLayout(0,2));
        hobbiesPanel.add(hobbiesLabel);
        hobbiesPanel.add(hobbiesScrollPane);

        contentBottomPanel.setLayout(new BorderLayout());
        contentBottomPanel.add(hobbiesPanel, BorderLayout.NORTH);
        contentBottomPanel.add(buttonsPanel, BorderLayout.SOUTH);
        mainPanel.add(contentBottomPanel, BorderLayout.SOUTH);
    }

    public static void createAndShowGUI() {
        SimpleFormV3 window = new SimpleFormV3("SimpleFormV3");
        window.addComponents();
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
