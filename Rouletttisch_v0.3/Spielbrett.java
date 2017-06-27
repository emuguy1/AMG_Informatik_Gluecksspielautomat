import javax.swing.*;
public class Spielbrett extends JFrame implements View{
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
	
	public Spielbrett(Controller c){
		controller = c;
		setControllerView();
		setTitle("Spielbrett");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		
		
		this.setVisible(true);
	}
	
    public void setControllerView(){
        controller.setView(this);
    }
    
    
    
}