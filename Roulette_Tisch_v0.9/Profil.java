import javax.swing.*;
import java.awt.Dimension;
public class Profil extends JFrame implements View{
    /**
     * The WIDTH of the JFrame:
     */
    private final int WIDTH = 960;
    /**
     * The HEIGHT of the JFrame:
     */
    private final int HEIGHT = 640;
    //MODEL
    private Model model;
    //CONTROLLER
    private Controller controller;
    private JLabel lPw1 = new JLabel("Neues Passwort:");
    private JTextField tfPw1 = new JTextField(14);
    private JLabel lPw2 = new JLabel("Neues Passwort bestätigen:");
    private JTextField tfPw2 = new JTextField(14);
    private JLabel lPw3 = new JLabel("Altes Passwort:");
    private JTextField tfPw3 = new JTextField(14);
    private JButton pwaendern = new JButton("Passwort ändern");
    public Profil(/*Controller c*/){
        //controller = c;
        setControllerView();
        setTitle("Profil");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        //Hintergrundblid setzen
        setContentPane(new JLabel(new ImageIcon(System.getProperty("user.dir")+"/res/nice2.png")));
        
        pwaendernHinzufuegen();
        
        setVisible(true);
    }
    public void setControllerView(){
        
    }
    private void pwaendernHinzufuegen(){
        int x = 30;
        add(tfPw1);
        Dimension size = tfPw1.getPreferredSize();
        tfPw1.setBounds((WIDTH/2)-((tfPw1.getPreferredSize().width)/2),250+x,size.width, size.height);
        add(lPw1);
        size = lPw1.getPreferredSize();
        lPw1.setBounds((WIDTH/2)-((tfPw1.getPreferredSize().width)/2),250+x-tfPw1.getPreferredSize().height,size.width, size.height);
        
        add(tfPw2);
        size = tfPw2.getPreferredSize();
        tfPw2.setBounds((WIDTH/2)-((tfPw2.getPreferredSize().width)/2),300+x,size.width, size.height);
        add(lPw2);
        size = lPw2.getPreferredSize();
        lPw2.setBounds((WIDTH/2)-((tfPw2.getPreferredSize().width)/2),300+x-tfPw2.getPreferredSize().height,size.width, size.height);
        
        add(tfPw3);
        size = tfPw3.getPreferredSize();
        tfPw3.setBounds((WIDTH/2)-((tfPw3.getPreferredSize().width)/2),200+x,size.width, size.height);
        add(lPw3);
        size = lPw3.getPreferredSize();
        lPw3.setBounds((WIDTH/2)-((tfPw3.getPreferredSize().width)/2),200+x-lPw3.getPreferredSize().height,size.width, size.height);
        
        pwaendern.addActionListener(controller);
        add(pwaendern);
        pwaendern.setBounds((WIDTH/2)-((tfPw3.getPreferredSize().width)/2),330+x,tfPw3.getPreferredSize().width, pwaendern.getPreferredSize().height);
    }
    /**
     * TODO:
     * PW ändern 
     * e-mail adresse
     * guthaben aufladen
     * 
     */
     
}
