import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements View{
	
	//Components:
	private JTextField tf1 = new JTextField(10);
	private JPasswordField tf2 = new JPasswordField(10);
	private JLabel l1 = new JLabel("Benutzername:");
	private JLabel l2 = new JLabel("Passwort:");
	private JButton b1 = new JButton("Anmelden");
	private JButton b2 = new JButton("Registrieren");
	/**
	 * The WIDTH of the JFrame:
	 */
	private final int WIDTH = 960;
	/**
	 * The HEIGHT of the JFrame:
	 */
	private final int HEIGHT = 640;
	
	//Controller:
	private Controller controller;
	
	public Login(Controller c){
		controller = c;
		setControllerView();
		setTitle("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		//Hintergrundblid setzen
		setContentPane(new JLabel(new ImageIcon(System.getProperty("user.dir")+"/nice.jpg")));
		
		//adding the ActionListener
		b1.addActionListener(controller);
		b2.addActionListener(controller);
		//adding components
		addL1();
		addL2();
		addTf1();
		addTf2();
		addB1();
		addB2();
		
		this.setVisible(true);
	}
	
	//Setzen der Komponenten an bestimmte Koordinaten
	private void addL1(){
		add(l1);
		Dimension size = l1.getPreferredSize();
		l1.setBounds((WIDTH/2)-((size.width+tf1.getPreferredSize().width)/2), HEIGHT/2,
		size.width, size.height);
	}
	private void addL2(){
		add(l2);
		Dimension size = l2.getPreferredSize();
		l2.setBounds((WIDTH/2)-((l1.getPreferredSize().width+tf2.getPreferredSize().width)/2), HEIGHT/2+(l1.getPreferredSize().height*2),
		size.width, size.height);
	}	
	private void addTf1(){
		add(tf1);
		Dimension size = tf1.getPreferredSize();
		tf1.setBounds((WIDTH/2)+l1.getPreferredSize().width-((size.width+l1.getPreferredSize().width)/2)+5, HEIGHT/2,
		size.width, size.height);
	}	
	private void addTf2(){
		add(tf2);
		Dimension size = tf2.getPreferredSize();
		tf2.setBounds((WIDTH/2)+l1.getPreferredSize().width-((size.width+l1.getPreferredSize().width)/2)+5, HEIGHT/2+(l1.getPreferredSize().height*2),
		size.width, size.height);
	}	
	private void addB1(){
		add(b1);
		Dimension size = b1.getPreferredSize();
		b1.setBounds((WIDTH/2)-((size.width+b2.getPreferredSize().width)/2), HEIGHT/2+((l1.getPreferredSize().height+l2.getPreferredSize().height)*2),
		size.width, size.height);
	}
	private void addB2(){
		add(b2);
		Dimension size = b2.getPreferredSize();
		b2.setBounds((WIDTH/2)+b1.getPreferredSize().width-((size.width+b1.getPreferredSize().width)/2), HEIGHT/2+((l1.getPreferredSize().height+l2.getPreferredSize().height)*2),
		size.width, size.height);
	}
	
	/**
	 * Fehlermeldung: Zeigt einen Dialog an
	 */
	public void anmeldenFehlgeschlagen(){
		JOptionPane.showMessageDialog(this, "Anmeldung fehlgeschlagen!!!");
	}
	/**
	 * Fehlermeldung: Zeigt einen Dialog an
	 */
	public void registrierungFehlgeschlagen() {
		JOptionPane.showMessageDialog(this, "Registrierung fehlgeschlagen!!!");
	}
	/**
	 * Gibt sich selbst an den Controller weiter
	 */
	@Override
	public void setControllerView() {
		controller.setView(this);
		
	}
	/** 
	 * @return Anmeldungsbutton
	 */
	public JButton getB1(){
		return b1;
	}
	/** 
	 * @return Registrierungsbutton
	 */
	public JButton getB2(){
		return b2;
	}
	public String getBenutzername(){
	   String bname = tf1.getText();
	   System.out.println(bname);
	   return bname;
	}
	public String getPasswort(){
	   System.out.println(tf2.getPassword());
	   return null;
	}
}
