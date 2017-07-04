import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Bild
 extends JComponent{
    
    private BufferedImage b1=null;
    
    public Bild(BufferedImage b){
        b1=b;
    }
    public void paintComponent(Graphics g){
        g.drawImage(b1, 40,40,null);
    
    }
}