import java.awt.Dimension;
import javax.swing.*;
import java.awt.Color;
public class Spielbrett extends JFrame implements View{
    /**
	 * The WIDTH of the JFrame:
	 */
	private final int WIDTH = 960;
	/**
	 * The HEIGHT of the JFrame:
	 */
	private final int HEIGHT = 660;
	private JButton b1 = new JButton("hi");
	private JButton b2 = new JButton("2");
	//Controller:
	private Controller controller;
	private JMenuBar menuBar = new JMenuBar();;
	private JMenu menu = new JMenu("Menü");
	public Spielbrett(Controller c){
		controller = c;
		setControllerView();
		setTitle("Spielbrett");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		//Hintergrundblid setzen
		setContentPane(new JLabel(new ImageIcon(System.getProperty("user.dir")+"/roulette.jpg")));
		//adding the ActionListener
		b1.addActionListener(controller);
		b2.addActionListener(controller);
		//adding components
		addB1();
		addB2();
		
		
		menuBar.add(menu);
		add(menuBar);
		
		
		this.setVisible(true);
	}
	
    public void setControllerView(){
        controller.setView(this);
    }
    
    private void addB1(){
		add(b1);
		b1.setBounds(300,800,30,30);
		//b1.setBackground(new Color(0,0,0,0));
		//b1.setBorder(null);
		//b1.setContentAreaFilled(false);
    }
	private void addB2(){
		add(b2);
		b2.setBounds(80,20,40,40);
	}
    
}