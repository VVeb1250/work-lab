package kumying.teethawat.lab9;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ReadImage extends JPanel {
   BufferedImage img;
   int panelHeight, panelWidth;
   
   @Override public void paintComponent(Graphics g) { g.drawImage(img, 0 ,0, null); }
   public ReadImage(String filename) {
      try {
         img = ImageIO.read(new File(filename));
      } catch (IOException e) {
         e.printStackTrace(System.err);
      }
   }
   @Override
   public Dimension getPreferredSize() {
      if (img != null) {
         return new Dimension(img.getWidth(), img.getHeight());
      } else {
         return super.getPreferredSize();
      }
   }
   protected void setScaleFromPanel(JPanel panel) {
      panelHeight = panel.getHeight();
      panelWidth = panel.getWidth();
   }
}
