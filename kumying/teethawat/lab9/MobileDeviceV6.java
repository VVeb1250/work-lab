package kumying.teethawat.lab9;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Container;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

// Customize Labels
// Set font style to Arial, Bold, size 14.
// Set font color to Dark Blue (#000080).
// Apply the same font settings to all labels in the form.
// Customize Text Fields & Text Areas
// Set background color to Light Gray.
// Set font color to Dark Gray.
// Apply Italic Font Style for the text inside the text area.
// Ensure that the text area wraps text correctly.

// Customize Vendor List Appearance
// Set background color to Light Gray.
// Set font color to Dark Green (#006400).
// Set bold font style for vendor names.
// Change the selection background color to Yellow.
// Change the selection foreground color to Black.

// Customize Buttons
// Set the OK button background color to Green and text color to White.
// Set the Cancel button background color to Red and text color to White.


public class MobileDeviceV6 extends MobileDeviceV5{
    public MobileDeviceV6(String title) {
        super(title);
    }

    protected Font lebelFont = new Font("Arial", Font.BOLD, 14);
    protected Font textFieldsAndTextAreasFont;
    protected final Color DARK_BLUE = Color.decode("#000080");
    protected final Color DARK_GREEN = Color.decode("#006400");
    protected final Color LIGHT_YELLOW = Color.decode("#fffccc");

    @Override
    protected void addComponents() {
        super.addComponents(); // call old method
        customizeFont(mainPanel, lebelFont, DARK_BLUE);
        customizeTextFields(mainPanel, Color.LIGHT_GRAY, Color.DARK_GRAY, "Italic");
        customizeTextAreas(mainPanel, LIGHT_YELLOW, Color.DARK_GRAY, "Italic");
        customizeVendorListAppearance(deviceAvalable, Color.LIGHT_GRAY, DARK_GREEN, Font.BOLD, Color.YELLOW, Color.BLACK);
        customizeButtons(Color.WHITE, Color.GREEN, Color.WHITE, Color.RED);
    }
    public void customizeFont(Container container, Font font, Color color) {
        for (Component child : container.getComponents()) {
            if (child instanceof Container) {
                customizeFont((Container)child, font, color);
            }
            if (child instanceof JLabel) {
                child.setFont(font);
                child.setForeground(color);
            }
        }
    }
    public void customizeTextFields(Container container, Color backgroundColor, Color fontColor, String fontStyle) {
        // cuz everything is Container, Just check instanceof for modify progess
        for (Component child : container.getComponents()) {
            if (child instanceof Container) {
                customizeTextFields((Container)child, backgroundColor, fontColor, fontStyle);
            }
            if (child instanceof JTextField) {
                child.setBackground(backgroundColor);
                child.setForeground(fontColor);
                textFieldsAndTextAreasFont = new Font(fontStyle, child.getFont().getStyle(), child.getFont().getSize());
                child.setFont(textFieldsAndTextAreasFont);
            }
        }
    }
    public void customizeTextAreas(Container container, Color backgroundColor, Color fontColor, String fontStyle) {
        // cuz everything is Container, Just check instanceof for modify progess
        for (Component child : container.getComponents()) {
            if (child instanceof Container) {
                customizeTextAreas((Container)child, backgroundColor, fontColor, fontStyle);
            }
            if (child instanceof JTextArea) {
                child.setBackground(backgroundColor);
                child.setForeground(fontColor);
                textFieldsAndTextAreasFont = new Font(fontStyle, child.getFont().getStyle(), child.getFont().getSize());
                child.setFont(textFieldsAndTextAreasFont);
            }
        }
    }
    public void customizeVendorListAppearance(JList<String> vendorList, Color backgroundColor,  Color fontColor, int style, Color selectionBackground, Color selectionForeground) {
        // this check input if its JList<String>
        if (vendorList instanceof JList<?>) {
            JList<String> child = vendorList;
            child.setBackground(backgroundColor);
            child.setForeground(fontColor);
            textFieldsAndTextAreasFont = new Font(child.getFont().getName(), style, child.getFont().getSize());
            child.setFont(textFieldsAndTextAreasFont);
            child.setSelectionBackground(selectionBackground);
            child.setSelectionForeground(selectionForeground);
        }
    }
    public void customizeButtons(Color OKBackgroundColor, Color OKFontColor, Color CancelBackgroundColor, Color CancelFontColor) {
        submitButton.setBackground(OKBackgroundColor);
        submitButton.setForeground(OKFontColor);
        resetButton.setBackground(CancelBackgroundColor);
        resetButton.setForeground(CancelFontColor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        MobileDeviceV6 msw = new MobileDeviceV6("Mobile Device V6");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
