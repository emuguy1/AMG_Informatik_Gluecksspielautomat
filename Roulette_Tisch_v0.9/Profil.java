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
    private final int HEIGHT = 690;
    //MODEL
    private Model model;
    //CONTROLLER
    private Controller controller;
    private JLabel lPw1 = new JLabel("neues Passwort:");
    private JTextField tfPw1 = new JTextField(10);
    private JLabel lPw2 = new JLabel("neues Passwort bestätigen:");
    private JTextField tfPw2 = new JTextField(10);
    private JLabel lPw3 = new JLabel("altes Passwort:");
    private JTextField tfPw3 = new JTextField(10);
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
        
        add(tfPw);
        Dimension size = tfPw.getPreferredSize();
        tfPw.setBounds(300,400,size.width, size.height);
        add(lPw);
        size = lPw.getPreferredSize();
        lPw.setBounds(300,400-tfPw.getPreferredSize().height,size.width, size.height);
        setVisible(true);
    }
    public void setControllerView(){
        
    }
    private void pwaendernHinzufuegen(){
        add(tfPw);
        Dimension size = tfPw.getPreferredSize();
        tfPw.setBounds(300,400,size.width, size.height);
        add(lPw);
        size = lPw.getPreferredSize();
        lPw.setBounds(300,400-tfPw.getPreferredSize().height,size.width, size.height);        
    }
    /**
     * TODO:
     * PW ändern 
     * e-mail adresse
     * guthaben aufladen
     * 
     */
     
}
