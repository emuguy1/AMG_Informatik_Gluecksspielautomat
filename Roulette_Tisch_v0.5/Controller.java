import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Controller implements ActionListener{
    public View view;
    public Model model;
    public Controller(Model m){
     model = m;   
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
                view = new Spielbrett(this,model);
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
                view = new Spielbrett(this, model);
                model.setView(view);
            }
            else{   
                //falls fehlgeschlagen
                ((Login)view).registrierungFehlgeschlagen();
            }
        }
        //Spielbrettbetrieb
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getMItem1()){
            //EINSTELLUNGEN
            
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getMItem3()){
            //HILFE
            JOptionPane.showMessageDialog((Spielbrett)view, "There are 10 types of people in the world: those who understand binary, those who don't \n and those who didn't expect this to be a base three joke.","Hilfe",JOptionPane.INFORMATION_MESSAGE);
            
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getMItem2()){
            //ABMELDEN
            view.dispose();
            view = new Login(this);
            model.setView(view);
        }else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getSpielenButton()){
            //SPIELEN
            model.spielen();
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB4()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=799;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB5()){
            ((Spielbrett)view).Coinsetzen2();
        }
    }
}



