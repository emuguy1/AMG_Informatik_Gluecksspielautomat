import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Controller implements ActionListener{
	public View view;
	public Controller(){
		
	}
	public void setView(View v){
		view = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Anmeldung
		if(view.getClass() == Login.class && e.getSource() == ((Login)view).getB1()){
			
			//TODO
			
			//falls fehlgeschlagen
				((Login)view).anmeldenFehlgeschlagen();
		}
		//Registrierung
		else if(view.getClass() == Login.class && e.getSource() == ((Login)view).getB2()){
			
			//TODO
			
			//falls fehlgeschlagen
			((Login)view).registrierungFehlgeschlagen();
		}
		
	}

}
