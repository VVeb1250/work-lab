package polpinit.pattarawit.lab9;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;

public class ReadImage extends JPanel {
    BufferedImage img;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public ReadImage() {
        try {
            img = ImageIO.read(getClass().getResource("./images/Football.jpg"));
        } catch (IOException e) {
           e.printStackTrace(System.err);
        }
    }

    public ReadImage(String fileName) {
        String name = "./images/" + fileName;
        try {
            img = ImageIO.read(getClass().getResource(name));
        } catch (IOException e) {
           e.printStackTrace(System.err);
        }
    }
}
