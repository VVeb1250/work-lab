package kumying.teethawat.lab11;

import javax.swing.*;

import java.awt.*;

import polpinit.pattarawit.lab9.ReadImage;

public class MobileDeviceComplete extends JFrame{
    
    protected JTextField deviceNameField, brandField, priceField;
    protected JRadioButton smartphoneButton, tabletButton;
    protected JComboBox<String> osComboBox;
    protected JTextArea featuresTextArea;
    protected JList<String> vendorList;
    protected JSlider ratingSlider;
    protected JLabel imageLabel;
    //protected JPanel mainPanel, bottomPanel;
    protected JButton okButton, cancelButton, colorButton;
    
    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu, sizeMenu, colorMenu, fontMenu;
    protected JMenuItem newMI, openMI, saveMI, exitMI, smallMI, mediumMI, largeMI, xLargeMI, blackMI, redMI, greenMI, blueMI, font1MI, font2MI, font3MI;
    protected JPanel mainPanel, topPanel, middlePanel, bottomPanel, rbPanel, dbPanel, TAPanel, listPanel, sliderPanel, imagePanel, buttonPanel;



    public MobileDeviceComplete(String title) {
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
        MobileDeviceComplete window = new MobileDeviceComplete("Mobile Device Complete");
        window.addComponents();
        window.addMenus();
        window.setFrameFeatures();
    }

     protected void addComponents() {
        mainPanel = new JPanel(new BorderLayout());
        
        

        topPanel = new JPanel(new GridLayout(5, 2));
        // Device Info
        topPanel.add(new JLabel("Device Name:"));
        deviceNameField = new JTextField();
        topPanel.add(deviceNameField);

        topPanel.add(new JLabel("Brand:"));
        brandField = new JTextField();
        topPanel.add(brandField);

        topPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        topPanel.add(priceField);
        
        rbPanel = new JPanel();
        // Radio Buttons
        
        smartphoneButton = new JRadioButton("Smartphone");
        tabletButton = new JRadioButton("Tablet");
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(smartphoneButton);
        typeGroup.add(tabletButton);
        smartphoneButton.setSelected(true);
        rbPanel.add(smartphoneButton);
        rbPanel.add(tabletButton);
        topPanel.add(new JLabel("Type:"));
        topPanel.add(rbPanel);

        //dbPanel = new JPanel();
        // OS Selection
        topPanel.add(new JLabel("Operating System:"));
        osComboBox = new JComboBox<>(new String[]{"Android", "iOS", "Windows", "Linux"});
        topPanel.add(osComboBox);
        
        TAPanel = new JPanel(new GridLayout(1, 2));
        // Features
        TAPanel.add(new JLabel("Features:"));
        featuresTextArea = new JTextArea(3, 25);
        featuresTextArea.setLineWrap(true);
        featuresTextArea.setWrapStyleWord(true);
        TAPanel.add(new JScrollPane(featuresTextArea));

        listPanel = new JPanel(new GridLayout(1, 2));
        // Vendor Selection
        listPanel.add(new JLabel("The device is available at:"));
        vendorList = new JList<>(new String[]{"AIS", "True", "DTAC", "Shopee"});
        vendorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        vendorList.setSelectedIndex(0);
        listPanel.add(new JScrollPane(vendorList));
        
        sliderPanel = new JPanel(new BorderLayout());
        // Rating Slider
        sliderPanel.add(new JLabel("Rate the device (0-10):"), BorderLayout.NORTH);
        ratingSlider = new JSlider(0, 10, 5);
        ratingSlider.setMajorTickSpacing(1);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setPaintLabels(true);
        sliderPanel.add(ratingSlider, BorderLayout.CENTER);


        middlePanel = new JPanel(new BorderLayout());
        //middlePanel.add(new JLabel("Rate the device (0-10):"));
        middlePanel.add(TAPanel, BorderLayout.NORTH);
        middlePanel.add(listPanel, BorderLayout.CENTER);
        middlePanel.add(sliderPanel, BorderLayout.SOUTH);
        
        
        
        bottomPanel = new JPanel(new BorderLayout());

        imagePanel = new ReadImage("S25-ultra.jpg");
        imagePanel.setPreferredSize(new Dimension(600, 450));

        buttonPanel = new JPanel();
        // Buttons
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        bottomPanel.add(imagePanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel);
        
        // Image Panel
        //imageLabel = new JLabel();
        //imageLabel.setHorizontalAlignment(JLabel.CENTER);
        //imageLabel.setPreferredSize(new Dimension(400, 300));
        
        //bottomPanel = new JPanel(new BorderLayout());
        //bottomPanel.add(imageLabel, BorderLayout.CENTER);
        //bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }
    
    protected void addMenus() {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        newMI = new JMenuItem("New");
        openMI = new JMenuItem("Open");
        saveMI = new JMenuItem("Save");
        exitMI = new JMenuItem("Exit");
        fileMenu.add(newMI);
        fileMenu.add(openMI);
        fileMenu.add(saveMI);
        fileMenu.add(exitMI);
        
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    protected void setFrameFeatures() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
