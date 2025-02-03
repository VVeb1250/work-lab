package kumying.teethawat.lab8;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MobileDeviceV2 extends MobileDeviceV1{
    public MobileDeviceV2(String title) {
        super(title);
    }

    protected JPanel extraPanel;
    protected JLabel operatingSystemLabel, featuresLabel;
    protected JTextArea featuresTextArea;
    protected String[] options = {"Android", "iOS", "Windows", "Others"};
    protected JComboBox<String> operatingSystemComboBox = new JComboBox<>(options);

    @Override
    protected void addComponents() {
        super.addComponents(); // call old medhod
        MakeExtraPanel();
    }
    protected void MakeExtraPanel() {
        // intizise formPanel
        extraPanel = new JPanel();
        extraPanel.setLayout(new GridLayout(2, 2));
        // make obj.
            // operatingSystem
        operatingSystemLabel = new JLabel("Operating System:");
        operatingSystemComboBox.setSelectedIndex(0);
        operatingSystemComboBox.setEditable(false);
            // features
        featuresLabel = new JLabel("Features:");
        featuresTextArea = new JTextArea(3, 25);
        featuresTextArea.setLineWrap(true);
        featuresTextArea.setWrapStyleWord(true);
        JScrollPane featuresScrollPane = new JScrollPane(featuresTextArea); // warp by JScrollPane
        // add to frompanel
        extraPanel.add(operatingSystemLabel);
        extraPanel.add(operatingSystemComboBox);
        extraPanel.add(featuresLabel);
        extraPanel.add(featuresScrollPane);
        // add to main
        mainPanel.add(extraPanel, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        MobileDeviceV2 msw = new MobileDeviceV2("Mobile Device V2");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}

