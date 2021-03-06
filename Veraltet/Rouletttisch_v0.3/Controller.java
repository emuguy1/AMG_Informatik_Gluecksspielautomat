import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Controller implements ActionListener{
    public View view;
    public Model model;
    public Controller(){
        
    }
    public void setView(View v){
        view = v;
    }
    public void setModel(Model m){
       model = m;
       }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Anmeldung
        if(view.getClass() == Login.class && e.getSource() == ((Login)view).getB1()){
            if(model.anmelden(((Login)view).getBenutzername(),((Login)view).getPasswort())){
                //TODO
                view.dispose();
                view = new Spielbrett(/*this*/);
                model.setView(view);
                
            }
            else{   
                //falls fehlgeschlagen
                ((Login)view).anmeldenFehlgeschlagen();
            }
        }
        //Registrierung
        else if(view.getClass() == Login.class && e.getSource() == ((Login)view).getB2()){
           if(model.registrieren(((Login)view).getBenutzername(),((Login)view).getPasswort())){
                //TODO
                view.dispose();
                view = new Spielbrett(/*this*/);
                model.setView(view);
            }
            else{   
                //falls fehlgeschlagen
                ((Login)view).registrierungFehlgeschlagen();
            }
        }
        //Spielbrettbetrieb
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB4()){
            ((Spielbrett)view).Coinsetzen();
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB5()){
            ((Spielbrett)view).Coinsetzen2();
        }
           }
   }



