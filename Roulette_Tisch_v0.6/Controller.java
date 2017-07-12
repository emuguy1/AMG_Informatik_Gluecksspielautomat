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
            ((Spielbrett)view).kugelanimation();
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB1()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=839;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("1",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("1",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("1",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("1",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("1",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB2()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=839;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("2",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("2",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("2",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("2",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("2",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB3()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=839;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("3",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("3",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("3",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("3",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("3",500);
            }
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
                model.einsatzSetzen("4",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("4",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("4",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("4",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("4",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB5()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=799;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("5",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("5",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("5",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("5",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("5",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB6()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=799;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("6",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("6",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("6",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("6",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("6",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB7()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=760;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("7",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("7",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("7",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("7",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("7",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB8()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=760;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("8",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("8",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("8",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("8",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("8",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB9()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=760;
            int v=577;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB10()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=721;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB11()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=721;
            int v=529;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB12()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=721;
            int v=577;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB13()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=681;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB14()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=681;
            int v=529;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB15()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=681;
            int v=577;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB16()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=645;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB17()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=645;
            int v=529;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB18()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=645;
            int v=577;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB19()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=607;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB20()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=607;
            int v=529;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB21()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=607;
            int v=577;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB22()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=569;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB23()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=569;
            int v=529;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB24()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=569;
            int v=577;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB25()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=530;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB26()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=530;
            int v=529;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB27()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=530;
            int v=577;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB28()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=491;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB29()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=491;
            int v=529;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB30()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=491;
            int v=577;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB31()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=453;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB32()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=453;
            int v=529;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB33()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=453;
            int v=577;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB34()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=414;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB35()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=414;
            int v=529;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB36()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=414;
            int v=577;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB37()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=375;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB38()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=375;
            int v=529;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB39()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=375;
            int v=577;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB40()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=414;
            int v=442;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB41()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=568;
            int v=442;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB42()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=722;
            int v=442;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB43()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=414;
            int v=396;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB44()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=492;
            int v=396;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB45()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=568;
            int v=396;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB46()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=644;
            int v=396;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB47()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=722;
            int v=396;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB48()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=800;
            int v=396;
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
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB49()){
            try{
                if(!(((Spielbrett)view).getAktuellerCoin()==null)){
                  ((Spielbrett)view).remove(((Spielbrett)view).getAktuellerCoin());
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=880;
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
    }
}



