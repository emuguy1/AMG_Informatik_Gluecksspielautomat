import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Bild
 extends JPanel{
    
    private BufferedImage b1=null;
    
    public Bild(BufferedImage b){
        b1=b;
    }
    protected void paintComponent(Graphics g){
        g.drawImage(b1, 0,0,null);
    
    }
}