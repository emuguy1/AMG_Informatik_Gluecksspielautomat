import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Bild extends JPanel{
    
    private BufferedImage b1=null;
    private int value = 0;
    public Bild(BufferedImage b){
        b1=b;
    }
    public Bild(BufferedImage b, int value){
        b1=b;
    }
    public int getValue(){
        return value;
    }
    protected void paintComponent(Graphics g){
        g.drawImage(b1, 0,0,null);
    
    }
}