import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;
import javax.imageio.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Spielbrett extends JFrame implements View, ActionListener{
    /**
     * The WIDTH of the JFrame:
     */
    private final int WIDTH = 960;
    /**
     * The HEIGHT of the JFrame:
     */
    private final int HEIGHT = 690;
    //Model
    private Model model;
    //Controller:
    private Controller controller;
    //BUTTTONS
    private JButton b1 = new JButton();
    private JButton b2 = new JButton();
    private JButton b3 = new JButton();
    private JButton b4 = new JButton();
    private JButton b5 = new JButton();
    private JButton b6 = new JButton();
    private JButton b7 = new JButton();
    private JButton b8 = new JButton();
    private JButton b9 = new JButton();
    private JButton b10 = new JButton();
    private JButton b11 = new JButton();
    private JButton b12 = new JButton();
    private JButton b13 = new JButton();
    private JButton b14 = new JButton();
    private JButton b15 = new JButton();
    private JButton b16 = new JButton();
    private JButton b17 = new JButton();
    private JButton b18 = new JButton();
    private JButton b19 = new JButton();
    private JButton b20 = new JButton();
    private JButton b21 = new JButton();
    private JButton b22 = new JButton();
    private JButton b23 = new JButton();
    private JButton b24 = new JButton();
    private JButton b25 = new JButton();
    private JButton b26 = new JButton();
    private JButton b27 = new JButton();
    private JButton b28 = new JButton();
    private JButton b29 = new JButton();
    private JButton b30 = new JButton();
    private JButton b31 = new JButton();
    private JButton b32 = new JButton();
    private JButton b33 = new JButton();
    private JButton b34 = new JButton();
    private JButton b35 = new JButton();
    private JButton b36 = new JButton();
    private JButton b37 = new JButton();// erste Reihe
    private JButton b38 = new JButton();//zweite Reihe
    private JButton b39 = new JButton();//dritte Reihe
    private JButton b40 = new JButton();//erste zwölf
    private JButton b41 = new JButton();//zweite zwölf
    private JButton b42 = new JButton();//dritte zwölf
    private JButton b43 = new JButton();//19-36
    private JButton b44 = new JButton();//ungerade
    private JButton b45 = new JButton();//schwarz
    private JButton b46 = new JButton();//rot
    private JButton b47 = new JButton();//gerade
    private JButton b48 = new JButton();//1-18
    private JButton b49 = new JButton();//0
    //AUSWAHLFELD FÜR COINS
    private ComboBox comboBox = new ComboBox();
    //BILD
    private Bild bild;
    //SPIELEN BUTTON
    private JButton bSpielen = new JButton();
    //KUGEL POSITION
    private double grad = 270;
    private double increase = 0.5;
    private double decay = 0.0001;
    private Bild kugel;
    private Timer timer = new Timer(5, this);
    //MENÜBAR
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem mItem1 = new JMenuItem("Einstellungen");
    private JMenuItem mItem2 = new JMenuItem("Abmelden");
    private JMenuItem mItem3 = new JMenuItem("Hilfe");
    private JLabel lBetrag = new JLabel("Betrag: ");
    private JMenu mBenutzername= new JMenu();
    private JMenu menu = new JMenu("Menü");
    private Bild aktuellerCoin=null;
    public Spielbrett(Controller c, Model m){
        controller = new Controller(m);
        model = m;
        setControllerView();
        setTitle("Spielbrett");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        //Hintergrundblid setzen
        setContentPane(new JLabel(new ImageIcon(System.getProperty("user.dir")+"/roulette.jpg")));
        //adding the ActionListener
        b1.addActionListener(controller);
        b2.addActionListener(controller);
        b3.addActionListener(controller);
        b4.addActionListener(controller);
        b5.addActionListener(controller);
        b6.addActionListener(controller);
        b7.addActionListener(controller);
        b8.addActionListener(controller);
        b9.addActionListener(controller);
        b10.addActionListener(controller);
        b11.addActionListener(controller);
        b12.addActionListener(controller);
        b13.addActionListener(controller);
        b14.addActionListener(controller);
        b15.addActionListener(controller);
        b16.addActionListener(controller);
        b17.addActionListener(controller);
        b18.addActionListener(controller);
        b19.addActionListener(controller);
        b20.addActionListener(controller);
        b21.addActionListener(controller);
        b22.addActionListener(controller);
        b23.addActionListener(controller);
        b24.addActionListener(controller);
        b25.addActionListener(controller);
        b26.addActionListener(controller);
        b27.addActionListener(controller);
        b28.addActionListener(controller);
        b29.addActionListener(controller);
        b30.addActionListener(controller);
        b31.addActionListener(controller);
        b32.addActionListener(controller);
        b33.addActionListener(controller);
        b34.addActionListener(controller);
        b35.addActionListener(controller);
        b36.addActionListener(controller);
        b37.addActionListener(controller);
        b38.addActionListener(controller);
        b39.addActionListener(controller);
        b40.addActionListener(controller);
        b41.addActionListener(controller);
        b42.addActionListener(controller);
        b43.addActionListener(controller);
        b44.addActionListener(controller);
        b45.addActionListener(controller);
        b46.addActionListener(controller);
        b47.addActionListener(controller);
        b48.addActionListener(controller);
        b49.addActionListener(controller);
        comboBox.setBounds(20,325,350,350);
        comboBox.setBackground(new Color(30,114,37));
        add(comboBox);
        //adding components
        //addB4();
        //addB2();
        addFieldButtons();
        //SPIELEN BUTTON BILD SETZEN
        bSpielen.addActionListener(controller);
        bSpielen.setIcon(new ImageIcon(System.getProperty("user.dir")+"/spielen.png"));
        bSpielen.setBounds(505,300,258,85); 
        bSpielen.getModel().addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (bSpielen.getModel().isRollover()) {
                        bSpielen.setBorder(BorderFactory.createBevelBorder(1,Color.white,Color.gray,Color.gray,Color.white));
                    } else {
                        bSpielen.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                    }
                }
            });
        add(bSpielen);
        //MENÜ
        setUpMenu();
        //ROULETTERAD
        kugelBild();
        rouletterad();
        //kugelanimation();
        this.setVisible(true);
    }
    public void setUpMenu(){
        //ACTIONLISTENER
        mItem1.addActionListener(controller);
        mItem2.addActionListener(controller);
        mItem3.addActionListener(controller);
        //SET UP THE MENU 
        menu.add(mItem1);
        menu.add(mItem3);
        mBenutzername.add(mItem2);
        menuBar.add(menu);
        menuBar.add(Box.createRigidArea(new Dimension(0,30)));
        menuBar.add(Box.createHorizontalGlue()); 
        menuBar.add(lBetrag);
        menuBar.add(mBenutzername);
        menuBar.setBackground(new Color(255,255,255));
        menuBar.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.gray));
        benutzernameAnzeigen();
        betragAnzeigen();
        this.setJMenuBar(menuBar);
        
    }
    public void rouletterad(){
        try{
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"/roulettescheibe.jpg"));

            bild = new Bild(image); 
            bild.setBounds(460,12,347,274);
            add(bild);
            this.repaint();
        }
        catch(Exception e){
            System.out.println("Rouletteradfehler"+e);
        }
    }
    public void kugelanimation(){
       
       timer.start(); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {//633 149
        kugel((int)(Math.cos(Math.toRadians(grad))*100)+630,(int)(Math.sin(Math.toRadians(grad))*98)+149);
        grad += increase;
        increase -= decay;
        if(increase <= 0.0){
            timer.stop();
        }
    }
    public void kugel(int x, int y){
        kugel.setBounds(x,y,16,16);
        this.repaint();
    }
    public void kugelBild(){
        try{
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"/kugel.png"));
            
            kugel = new Bild(image); 
            kugel.setBounds(630,51,16,16);
            add(kugel);
            this.repaint(); 
        }
        catch(Exception e){
            System.out.println("Kugelfehler"+e);
        }
    }
    public void setControllerView(){
        controller.setView(this);
    }
    public void benutzernameAnzeigen(){
        String d = model.getBenutzername();
        mBenutzername.setText(d+"  ");
    }
    public void betragAnzeigen(){
        String d = model.getBetrag();
        lBetrag.setText("Betrag: "+d+"  ");
    }
    public void Coinsetzen(){
        try{
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"/kleinerroterCoin.png"));

            bild = new Bild(image); 
            bild.setBounds(600,400,100,100);
            add(bild);
            this.repaint();
        }
        catch(Exception e){
            
        }
    }
    public void Coinsetzen2(){
        try{
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"/schwarzerCoin.png"));

            bild = new Bild(image); 
            bild.setBounds(600,400,100,100);
            add(bild);
            this.repaint();
        }
        catch(Exception e){
        }
    }
    
    public void roterCoinSetzen(int i, int v){
       try{
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"/kleinerroterCoin.png"));

            bild = new Bild(image); 
            bild.setBounds(i,v,20,20);
            add(bild);
            this.repaint();
            aktuellerCoin=bild;
        }
        catch(Exception e){
        } 
    }
    public void grünerCoinSetzen(int i, int v){
        try{
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"/kleinergrünerCoin.png"));

            bild = new Bild(image); 
            bild.setBounds(i,v,20,20);
            add(bild);
            this.repaint();
            aktuellerCoin=bild;
        }
        catch(Exception e){
        }
    }
    public void weißerCoinSetzen(int i, int v){
        try{
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"/kleinerweißerCoin.png"));

            bild = new Bild(image); 
            bild.setBounds(i,v,20,20);
            add(bild);
            this.repaint();
            aktuellerCoin=bild;
        }
        catch(Exception e){
        }
    }
    public void blauerCoinSetzen(int i, int v){
        try{
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"/kleinerblauerCoin.png"));

            bild = new Bild(image); 
            bild.setBounds(i,v,20,20);
            add(bild);
            this.repaint();
            aktuellerCoin=bild;
        }
        catch(Exception e){
        }
    }
    public void schwarzerCoinSetzen(int i, int v){
        try{
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir")+"/kleinerschwarzerCoin.png"));

            bild = new Bild(image); 
            bild.setBounds(i,v,20,20);
            add(bild);
            this.repaint();
            aktuellerCoin=bild;
        }
        catch(Exception e){
        }
    }
    public JButton getB1(){
        return b1;
    }
    public JButton getB2(){
        return b2;
    }
    public JButton getB3(){
        return b3;
    }
    public JButton getB4(){
        return b4;
    }
    public JButton getB5(){
        return b5;
    }
    public JButton getB6(){
        return b6;
    }
    public JButton getB7(){
        return b7;
    }
    public JButton getB8(){
        return b8;
    }
    public JButton getB9(){
        return b9;
    }
    public JButton getB10(){
        return b10;
    }
    public JButton getB11(){
        return b11;
    }
    public JButton getB12(){
        return b12;
    }
    public JButton getB13(){
        return b13;
    }
    public JButton getB14(){
        return b14;
    }
    public JButton getB15(){
        return b15;
    }
    public JButton getB16(){
        return b16;
    }
    public JButton getB17(){
        return b17;
    }
    public JButton getB18(){
        return b18;
    }
    public JButton getB19(){
        return b19;
    }
    public JButton getB20(){
        return b20;
    }
    public JButton getB21(){
        return b21;
    }
    public JButton getB22(){
        return b22;
    }
    public JButton getB23(){
        return b23;
    }
    public JButton getB24(){
        return b24;
    }
    public JButton getB25(){
        return b25;
    }
    public JButton getB26(){
        return b26;
    }
    public JButton getB27(){
        return b27;
    }
    public JButton getB28(){
        return b28;
    }
    public JButton getB29(){
        return b29;
    }
    public JButton getB30(){
        return b30;
    }
    public JButton getB31(){
        return b31;
    }
    public JButton getB32(){
        return b32;
    }
    public JButton getB33(){
        return b33;
    }
    public JButton getB34(){
        return b34;
    }
    public JButton getB35(){
        return b35;
    }
    public JButton getB36(){
        return b36;
    }
    public JButton getB37(){
        return b37;
    }
    public JButton getB38(){
        return b38;
    }
    public JButton getB39(){
        return b39;
    }
    public JButton getB40(){
        return b40;
    }
    public JButton getB41(){
        return b41;
    }
    public JButton getB42(){
        return b42;
    }
    public JButton getB43(){
        return b43;
    }
    public JButton getB44(){
        return b44;
    }
    public JButton getB45(){
        return b45;
    }
    public JButton getB46(){
        return b46;
    }
    public JButton getB47(){
        return b47;
    }
    public JButton getB48(){
        return b48;
    }
    public JButton getB49(){
        return b49;
    }
    private void addFieldButtons(){
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b10);
        add(b11);
        add(b12);
        add(b13);
        add(b14);
        add(b15);
        add(b16);
        add(b17);
        add(b18);
        add(b19);
        add(b20);
        add(b21);
        add(b22);
        add(b23);
        add(b24);
        add(b25);
        add(b26);
        add(b27);
        add(b28);
        add(b29);
        add(b30);
        add(b31);
        add(b32);
        add(b33);
        add(b34);
        add(b35);
        add(b36);
        add(b37);
        add(b38);
        add(b39);
        add(b40);
        add(b41);
        add(b42);
        add(b43);
        add(b44);
        add(b45);
        add(b46);
        add(b47);
        add(b48);
        add(b49);
       
        b1.setBackground(new Color(0,0,0,0));
        b1.setBorder(null);
        b1.setContentAreaFilled(false);
        b2.setBackground(new Color(0,0,0,0));
        b2.setBorder(null);
        b2.setContentAreaFilled(false);
        b3.setBackground(new Color(0,0,0,0));
        b3.setBorder(null);
        b3.setContentAreaFilled(false);
        b4.setBackground(new Color(0,0,0,0));
        b4.setBorder(null);
        b4.setContentAreaFilled(false);
        b5.setBackground(new Color(0,0,0,0));
        b5.setBorder(null);
        b5.setContentAreaFilled(false);
        b6.setBackground(new Color(0,0,0,0));
        b6.setBorder(null);
        b6.setContentAreaFilled(false);
        b7.setBackground(new Color(0,0,0,0));
        b7.setBorder(null);
        b7.setContentAreaFilled(false);
        b8.setBackground(new Color(0,0,0,0));
        b8.setBorder(null);
        b8.setContentAreaFilled(false);
        b9.setBackground(new Color(0,0,0,0));
        b9.setBorder(null);
        b9.setContentAreaFilled(false);
        b10.setBackground(new Color(0,0,0,0));
        b10.setBorder(null);
        b10.setContentAreaFilled(false);
        b11.setBackground(new Color(0,0,0,0));
        b11.setBorder(null);
        b11.setContentAreaFilled(false);
        b12.setBackground(new Color(0,0,0,0));
        b12.setBorder(null);
        b12.setContentAreaFilled(false);
        b13.setBackground(new Color(0,0,0,0));
        b13.setBorder(null);
        b13.setContentAreaFilled(false);
        b14.setBackground(new Color(0,0,0,0));
        b14.setBorder(null);
        b14.setContentAreaFilled(false);
        b15.setBackground(new Color(0,0,0,0));
        b15.setBorder(null);
        b15.setContentAreaFilled(false);
        b16.setBackground(new Color(0,0,0,0));
        b16.setBorder(null);
        b16.setContentAreaFilled(false);
        b17.setBackground(new Color(0,0,0,0));
        b17.setBorder(null);
        b17.setContentAreaFilled(false);
        b18.setBackground(new Color(0,0,0,0));
        b18.setBorder(null);
        b18.setContentAreaFilled(false);
        b19.setBackground(new Color(0,0,0,0));
        b19.setBorder(null);
        b19.setContentAreaFilled(false);
        b20.setBackground(new Color(0,0,0,0));
        b20.setBorder(null);
        b20.setContentAreaFilled(false);
        b21.setBackground(new Color(0,0,0,0));
        b21.setBorder(null);
        b21.setContentAreaFilled(false);
        b22.setBackground(new Color(0,0,0,0));
        b22.setBorder(null);
        b22.setContentAreaFilled(false);
        b23.setBackground(new Color(0,0,0,0));
        b23.setBorder(null);
        b23.setContentAreaFilled(false);
        b24.setBackground(new Color(0,0,0,0));
        b24.setBorder(null);
        b24.setContentAreaFilled(false);
        b25.setBackground(new Color(0,0,0,0));
        b25.setBorder(null);
        b25.setContentAreaFilled(false);
        b26.setBackground(new Color(0,0,0,0));
        b26.setBorder(null);
        b26.setContentAreaFilled(false);
        b27.setBackground(new Color(0,0,0,0));
        b27.setBorder(null);
        b27.setContentAreaFilled(false);
        b28.setBackground(new Color(0,0,0,0));
        b28.setBorder(null);
        b28.setContentAreaFilled(false);
        b29.setBackground(new Color(0,0,0,0));
        b29.setBorder(null);
        b29.setContentAreaFilled(false);
        b30.setBackground(new Color(0,0,0,0));
        b30.setBorder(null);
        b30.setContentAreaFilled(false);
        b31.setBackground(new Color(0,0,0,0));
        b31.setBorder(null);
        b31.setContentAreaFilled(false);
        b32.setBackground(new Color(0,0,0,0));
        b32.setBorder(null);
        b32.setContentAreaFilled(false);
        b33.setBackground(new Color(0,0,0,0));
        b33.setBorder(null);
        b33.setContentAreaFilled(false);
        b34.setBackground(new Color(0,0,0,0));
        b34.setBorder(null);
        b34.setContentAreaFilled(false);
        b35.setBackground(new Color(0,0,0,0));
        b35.setBorder(null);
        b35.setContentAreaFilled(false);
        b36.setBackground(new Color(0,0,0,0));
        b36.setBorder(null);
        b36.setContentAreaFilled(false);
        b37.setBackground(new Color(0,0,0,0));
        b37.setBorder(null);
        b37.setContentAreaFilled(false);
        b38.setBackground(new Color(0,0,0,0));
        b38.setBorder(null);
        b38.setContentAreaFilled(false);
        b39.setBackground(new Color(0,0,0,0));
        b39.setBorder(null);
        b39.setContentAreaFilled(false);
        b40.setBackground(new Color(0,0,0,0));
        b40.setBorder(null);
        b40.setContentAreaFilled(false);
        b41.setBackground(new Color(0,0,0,0));
        b41.setBorder(null);
        b41.setContentAreaFilled(false);
        b42.setBackground(new Color(0,0,0,0));
        b42.setBorder(null);
        b42.setContentAreaFilled(false);
        b43.setBackground(new Color(0,0,0,0));
        b43.setBorder(null);
        b43.setContentAreaFilled(false);
        b44.setBackground(new Color(0,0,0,0));
        b44.setBorder(null);
        b44.setContentAreaFilled(false);
        b45.setBackground(new Color(0,0,0,0));
        b45.setBorder(null);
        b45.setContentAreaFilled(false);
        b46.setBackground(new Color(0,0,0,0));
        b46.setBorder(null);
        b46.setContentAreaFilled(false);
        b47.setBackground(new Color(0,0,0,0));
        b47.setBorder(null);
        b47.setContentAreaFilled(false);
        b48.setBackground(new Color(0,0,0,0));
        b48.setBorder(null);
        b48.setContentAreaFilled(false);
        b49.setBackground(new Color(0,0,0,0));
        b49.setBorder(null);
        b49.setContentAreaFilled(false);   
        b1.setBounds(839,481,38,46);
        b2.setBounds(839,529,38,46);
        b3.setBounds(839,577,38,46);
        b4.setBounds(799,481,38,46);
        b5.setBounds(799,529,38,46);
        b6.setBounds(799,577,38,46);
        b7.setBounds(760,481,38,46);
        b8.setBounds(760,529,38,46);
        b9.setBounds(760,577,38,46);
        b10.setBounds(721,481,38,46);
        b11.setBounds(721,529,38,46);
        b12.setBounds(721,577,38,46);
        b13.setBounds(681,481,38,46);
        b14.setBounds(681,529,38,46);
        b15.setBounds(681,577,38,46);
        b16.setBounds(645,481,35,46);
        b17.setBounds(645,529,35,46);
        b18.setBounds(645,577,35,46);
        b19.setBounds(607,481,35,46);
        b20.setBounds(607,529,35,46);
        b21.setBounds(607,577,35,46);
        b22.setBounds(569,481,35,46);
        b23.setBounds(569,529,35,46);
        b24.setBounds(569,577,35,46);
        b25.setBounds(530,481,35,46);
        b26.setBounds(530,529,35,46);
        b27.setBounds(530,577,35,46);
        b28.setBounds(491,481,35,46);
        b29.setBounds(491,529,35,46);
        b30.setBounds(491,577,35,46);
        b31.setBounds(453,481,35,46);
        b32.setBounds(453,529,35,46);
        b33.setBounds(453,577,35,46);
        b34.setBounds(414,481,35,46);
        b35.setBounds(414,529,35,46);
        b36.setBounds(414,577,35,46);
        b37.setBounds(375,481,35,46);
        b38.setBounds(375,529,35,46);
        b39.setBounds(375,577,35,46);
        b40.setBounds(414,442,153,36);
        b41.setBounds(568,442,153,36);
        b42.setBounds(722,442,155,36);
        b43.setBounds(414,396,75,45);
        b44.setBounds(492,396,76,45);
        b45.setBounds(568,396,75,45);
        b46.setBounds(644,396,76,45);
        b47.setBounds(722,396,75,45);
        b48.setBounds(800,396,76,45);
        b49.setBounds(880,481,55,143);
       
        
        
    }
    public JMenuItem getMItem1(){
        return mItem1;
    }
    public JMenuItem getMItem2(){
        return mItem2;
    }
    public JMenuItem getMItem3(){
        return mItem3;
    }
    public JButton getSpielenButton(){
        return bSpielen;
    }
    public int wertGeben(){
        return comboBox.wertGeben();
    }
    public Bild getAktuellerCoin(){
        return aktuellerCoin;
    }
}