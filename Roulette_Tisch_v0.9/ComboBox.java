
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
    /**
     * Wert des ausgewählten Coins
     */
    private int wert=0;
    public ComboBox() {
        super(new BorderLayout());
 
        String[] zahlen = { "1", "10", "50", "100", "500" };
 
        //Create the combo box
        JComboBox petList = new JComboBox(zahlen);
        petList.addActionListener(this);
        petList.setBackground(new Color(30,114,37));
 
        //Set up the picture.
        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);
        updatePicture(zahlen[petList.getSelectedIndex()]);
        picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
 
        //The picture's size
        picture.setPreferredSize(new Dimension(177, 300+10));//größe ändern!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 
        //Lay out the combo box
        add(petList, BorderLayout.PAGE_START);
        add(picture, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
    /**
     * Listens to the ComboBox
     */
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String petName = (String)cb.getSelectedItem();
        updatePicture(petName);
    }
    /**
     * Updates the Picture
     */
    private void updatePicture(String name) {
       if(name.equals("1")){
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"/res/cbWeißerCoin.png");
            picture.setIcon(icon);
            picture.setToolTipText(name.toLowerCase()+"€ Jeton");
            wertSetzen(1);
        }
        else if(name.equals("10")){
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"/res/cbRoterCoin.png");
            picture.setIcon(icon);
            picture.setToolTipText(name.toLowerCase()+"€ Jeton");
            wertSetzen(10);
        }
        else if(name.equals("50")){
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"/res/cbBlauerCoin.png");
            picture.setIcon(icon);
            picture.setToolTipText(name.toLowerCase()+"€ Jeton");
            wertSetzen(50);
        }
        else if(name.equals("100")){
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"/res/cbGrünerCoin.png");
            picture.setIcon(icon);
            picture.setToolTipText(name.toLowerCase()+"€ Jeton");
            wertSetzen(100);
        }
        else if(name.equals("500")){
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"/res/cbSchwarzerCoin.png");
            picture.setIcon(icon);
            picture.setToolTipText(name.toLowerCase()+"€ Jeton");
            wertSetzen(500);
        }
    }
    private void wertSetzen(int i){
        wert=i;
    }
    public int wertGeben(){
        return wert;
    }
}