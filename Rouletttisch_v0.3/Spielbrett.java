import javax.swing.*;
public class Spielbrett extends JFrame implements View{
    /**
	 * The WIDTH of the JFrame:
	 */
	private final int WIDTH = 960;
	/**
	 * The HEIGHT of the JFrame:
	 */
	private final int HEIGHT = 660;
	
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
		menuBar.add(menu);
		add(menuBar);
		
		
		this.setVisible(true);
	}
	
    public void setControllerView(){
        controller.setView(this);
    }
    
    
    
}