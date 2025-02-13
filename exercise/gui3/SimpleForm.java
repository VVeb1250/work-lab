package kumying.teethawat.exercises.gui3;

import javax.swing.*;
import java.awt.*;

public class SimpleForm extends JFrame {
    protected JPanel buttonsPanel, namePanel, addrPanel, mainPanel;
    protected JLabel nameLabel, addrLabel;
    protected JTextField nameTxt;
    protected JButton okButton, cancelButton;
    protected JTextArea addrTxtArea;
    protected JScrollPane addrScrollPane;

    public SimpleForm(String title) {
        super(title);
    }

    public void addComponents() {
        nameLabel = new JLabel("Name:");
        nameTxt = new JTextField("Teethawat", 15);
        mainPanel = (JPanel) this.getContentPane();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        addrLabel = new JLabel("Address:");
        addrTxtArea = new JTextArea(4, 12);
        addrScrollPane = new JScrollPane(addrTxtArea);

        mainPanel.setLayout(new BorderLayout());

        namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameTxt);

        addrPanel = new JPanel();
        addrTxtArea.setLineWrap(true);
        addrTxtArea.setWrapStyleWord(true);
        addrTxtArea.setText("Khon Kaen");
        addrPanel.add(addrLabel);
        addrPanel.add(addrScrollPane);

        buttonsPanel = new JPanel();
        buttonsPanel.add(okButton);
        buttonsPanel.add(cancelButton);

        mainPanel.add(namePanel, BorderLayout.NORTH);
        mainPanel.add(addrPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void setFrameFeatures() {
        // window.add(buttonsPanel);
        // window.setContentPane(buttonsPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleForm window = new SimpleForm("673-040-3900");
        window.addComponents();
        window.setFrameFeatures();
    }
}
