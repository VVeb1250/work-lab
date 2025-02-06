package kumying.teethawat.lab9;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ReadImage extends JPanel {
   protected BufferedImage origimalImg; // original read img
   private Image img; // resized image
   private int imgWidth; // own width
   private int imgHeight; // own height

   public ReadImage(String filename) {
      // original scale
      try {
         origimalImg = ImageIO.read(new File(filename)); // read file
         // set size
         imgWidth = origimalImg.getWidth();
         imgHeight = origimalImg.getHeight();
         img = origimalImg.getScaledInstance(imgWidth, imgHeight, Image.SCALE_DEFAULT);
      } catch (IOException e) {
         e.printStackTrace(System.err);
      }
   }
   public ReadImage(String filename, float scale) {
      if (scale < 0) {
         System.err.println("NumberError: at " + "Readimage");
         System.err.println("// Can't put number lower 0");
         return;
      }
      // haved adjust scale
      try {
         origimalImg = ImageIO.read(new File(filename)); // read file
         // set size
         imgWidth = (int) (origimalImg.getWidth() * scale);
         imgHeight = (int) (origimalImg.getHeight() * scale);
         // resize progess
         img = origimalImg.getScaledInstance(imgWidth, imgHeight, Image.SCALE_DEFAULT);
      } catch (IOException e) {
         e.printStackTrace(System.err);
      }
   }
   @Override 
   public void paintComponent(Graphics g) { 
      super.paintComponent(g);
      g.drawImage(img, 0 ,0, null); 
   }
   public int getWidth() { return this.imgWidth; }
   public int getHeight() { return this.imgHeight; }
}
