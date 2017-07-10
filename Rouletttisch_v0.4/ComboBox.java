
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.*;
import javax.imageio.*;
public class ComboBox extends JPanel
                          implements ActionListener {
    JLabel picture;
 
    public ComboBox() {
        super(new BorderLayout());
 
        String[] petStrings = { "1", "10", "50", "100", "500" };
 
        //Create the combo box
        JComboBox petList = new JComboBox(petStrings);
        petList.setSelectedIndex(0);
        petList.addActionListener(this);
        petList.setBackground(new Color(30,114,37));
 
        //Set up the picture.
        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);
        updateLabel(petStrings[petList.getSelectedIndex()]);
        picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
 
        //The picture's size
        picture.setPreferredSize(new Dimension(177, 300+10));//größe ändern!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 
        //Lay out the demo.
        add(petList, BorderLayout.PAGE_START);
        add(picture, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
 
    /** Listens to the combo box. */
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String petName = (String)cb.getSelectedItem();
        updateLabel(petName);
    }
 
    protected void updateLabel(String name) {
        if(name.equals("1")){
            ImageIcon icon = createImageIcon(System.getProperty("user.dir")+"/´weißerCoin1.png");
            picture.setIcon(icon);
            picture.setToolTipText("A drawing of a " + name.toLowerCase());
        }
        else if(name.equals("10")){
            ImageIcon icon = createImageIcon(System.getProperty("user.dir")+"/´roterCoin1.png");
            picture.setIcon(icon);
            picture.setToolTipText("A drawing of a " + name.toLowerCase());
        }
        else if(name.equals("50")){
            ImageIcon icon = createImageIcon(System.getProperty("user.dir")+"/´blauerCoin1.png");
            picture.setIcon(icon);
            picture.setToolTipText("A drawing of a " + name.toLowerCase());
        }
        else if(name.equals("100")){
            ImageIcon icon = createImageIcon(System.getProperty("user.dir")+"/´grünerCoin1.png");
            picture.setIcon(icon);
            picture.setToolTipText("A drawing of a " + name.toLowerCase());
        }
        else if(name.equals("500")){
            ImageIcon icon = createImageIcon(System.getProperty("user.dir")+"/´schwarzerCoin1.png");
            picture.setIcon(icon);
            picture.setToolTipText("A drawing of a " + name.toLowerCase());
        }
        else{
        ImageIcon icon = createImageIcon(System.getProperty("user.dir")+"/"+name+".png");
        picture.setIcon(icon);
        picture.setToolTipText("A drawing of a " + name.toLowerCase());
        if (icon != null) {
            picture.setText(null);
        } else {
            picture.setText("Image not found");
        }
       }
    }
 
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        
        
            return new ImageIcon(path);
        
    }
}