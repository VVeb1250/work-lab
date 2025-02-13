package kumying.teethawat.exercises.gui3;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.*;

public class SimpleFormV6 extends SimpleFormV5 {
    protected JCheckBox python, java, javascript;
    protected JRadioButton male, female, other;
    protected JPanel languagesPanel, namePanel, addrPanel, genderPanel, contentPanel;
    protected JPanel languagesCheckboxes, genderRButtons;
    protected JLabel languagesLabel, genderLabel;
    protected ButtonGroup genderGroup;

    public SimpleFormV6(String title) {
        super(title);
    }

    public void initComponents() {
        super.initComponents();
        python = new JCheckBox("Python", true);
        java = new JCheckBox("Java", true);
        javascript = new JCheckBox("Javascript");
        languagesLabel = new JLabel("Languages:");
        languagesLabel.setVerticalAlignment(JLabel.TOP);
        languagesPanel = new JPanel();
        languagesCheckboxes = new JPanel();
        namePanel = new JPanel();
        addrPanel = new JPanel();
        genderRButtons = new JPanel();

        male = new JRadioButton("Male");
        female = new JRadioButton("Female", true);
        other = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        genderLabel = new JLabel("Gender:");
        genderPanel = new JPanel();
        contentPanel = new JPanel();
    }

    public void addComponents() {
        initComponents();
        super.addComponents();

        languagesCheckboxes.setLayout(new FlowLayout());
        languagesCheckboxes.add(python);
        languagesCheckboxes.add(java);
        languagesCheckboxes.add(javascript);

        genderRButtons.add(male);
        genderRButtons.add(female);
        genderRButtons.add(other);

        namePanel.setLayout(new GridLayout(0, 2));
        namePanel.add(nameLabel);
        namePanel.add(nameTxt);
        addrPanel.setLayout(new GridLayout(0, 2));
        addrPanel.add(addrLabel);
        addrPanel.add(addrScrollPane);

        languagesPanel.setLayout(new GridLayout(0, 2));
        languagesPanel.add(languagesLabel);
        languagesPanel.add(languagesCheckboxes);

        genderPanel.setLayout(new GridLayout(0, 2));
        genderPanel.add(genderLabel);
        genderPanel.add(genderRButtons, JPanel.LEFT_ALIGNMENT);

        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(namePanel, BorderLayout.NORTH);
        contentPanel.add(addrPanel, BorderLayout.CENTER);
        contentPanel.add(languagesPanel, BorderLayout.SOUTH);
        mainPanel.add(contentPanel, BorderLayout.NORTH);
        mainPanel.add(genderPanel, BorderLayout.CENTER);
        mainPanel.add(contentBottomPanel, BorderLayout.SOUTH);
    }

    public static void createAndShowGUI() {
        SimpleFormV6 window = new SimpleFormV6("SimpleFormV6");
        window.addComponents();
        window.addMenus();
        window.addListeners();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
