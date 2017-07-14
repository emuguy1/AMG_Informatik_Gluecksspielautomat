import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Controller implements ActionListener{
    private View view;
    private Model model;
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
            model = new Spiel();
            model.setView(view);
        }else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getSpielenButton()){
            //SPIELEN
            if(((Spielbrett)view).ready()&& model.ausreichendGeld()){
                int[] i = model.spielen();
                ((Spielbrett)view).kugelanimation(i[0],i[1]);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB1()){
            if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(1));
            }
            
            int i=839;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).coinSetzen(1,((Spielbrett)view).weißerCoinSetzen(i,v));
                model.einsatzSetzen("1",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).coinSetzen(1,((Spielbrett)view).roterCoinSetzen(i,v));
                model.einsatzSetzen("1",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).coinSetzen(1,((Spielbrett)view).blauerCoinSetzen(i,v));
                model.einsatzSetzen("1",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).coinSetzen(1,((Spielbrett)view).grünerCoinSetzen(i,v));
                model.einsatzSetzen("1",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).coinSetzen(1,((Spielbrett)view).schwarzerCoinSetzen(i,v));
                model.einsatzSetzen("1",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB2()){
            if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(2));
            }
            
            int i=839;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).coinSetzen(2,((Spielbrett)view).weißerCoinSetzen(i,v));
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
            if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(3));
            }
            int i=839;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).coinSetzen(3,((Spielbrett)view).weißerCoinSetzen(i,v));
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
            if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(4));
            }
            
            int i=799;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).coinSetzen(4,((Spielbrett)view).weißerCoinSetzen(i,v));
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
            if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(5));
            }
            int i=799;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).coinSetzen(5,((Spielbrett)view).weißerCoinSetzen(i,v));
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
            
            if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(6));
            }
            
           
            
            int i=799;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).coinSetzen(6,((Spielbrett)view).weißerCoinSetzen(i,v));
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
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(7));
                }
            }
            catch(Exception p){
                
            }
            
            int i=760;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).coinSetzen(7,((Spielbrett)view).weißerCoinSetzen(i,v));
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
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(8));
                }
            }
            catch(Exception p){
                
            }
            
            int i=760;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).coinSetzen(8,((Spielbrett)view).weißerCoinSetzen(i,v));
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
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(9));
                }
            }
            catch(Exception p){
                
            }
            
            int i=760;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).coinSetzen(9,((Spielbrett)view).weißerCoinSetzen(i,v));
                model.einsatzSetzen("9",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("9",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("9",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("9",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("9",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB10()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(10));
                }
            }
            catch(Exception p){
                
            }
            
            int i=721;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).coinSetzen(10,((Spielbrett)view).weißerCoinSetzen(i,v));
                model.einsatzSetzen("10",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("10",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("10",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("10",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("10",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB11()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(11));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=721;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("11",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("11",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("11",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("11",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("11",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB12()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(12));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=721;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("12",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("12",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("12",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("12",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("12",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB13()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(13));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=681;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("13",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("13",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("13",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("13",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("13",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB14()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(14));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=681;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("14",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("14",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("14",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("14",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("14",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB15()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(15));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=681;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("15",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("15",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("15",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("15",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("15",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB16()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(16));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=645;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("16",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("16",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("16",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("16",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("16",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB17()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(17));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=645;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("17",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("17",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("17",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("17",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("17",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB18()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(18));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=645;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("18",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("18",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("18",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("18",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("18",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB19()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(19));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=607;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("19",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("19",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("19",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("19",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("19",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB20()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(20));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=607;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("20",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("20",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("20",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("20",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("20",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB21()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(21));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=607;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("21",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("21",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("21",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("21",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("21",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB22()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(22));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=569;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("22",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("22",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("22",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("22",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("22",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB23()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(23));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=569;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("23",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("23",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("23",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("23",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("23",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB24()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(24));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=569;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("24",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("24",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("24",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("24",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("24",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB25()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(25));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=530;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("25",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("25",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("25",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("25",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("25",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB26()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(26));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=530;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("26",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("26",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("26",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("26",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("26",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB27()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(27));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=530;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("27",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("27",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("27",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("27",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("27",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB28()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(28));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=491;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("28",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("28",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("28",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("28",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("28",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB29()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(29));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=491;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("29",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("29",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("29",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("29",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("29",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB30()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(30));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=491;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("30",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("30",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("30",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("30",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("30",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB31()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(31));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=453;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("31",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("31",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("31",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("31",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("31",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB32()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(32));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=453;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("32",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("32",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("32",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("32",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("32",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB33()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(33));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=453;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("33",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("33",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("33",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("33",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("33",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB34()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(34));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=414;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("34",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("34",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("34",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("34",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("34",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB35()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(35));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=414;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("35",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("35",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("35",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("35",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("35",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB36()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(36));
                }
            }
            catch(Exception p){
                
            }
            
            int i=414;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("36",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("36",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("36",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("36",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("36",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB37()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(37));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=375;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("erstereihe",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("erstereihe",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("erstereihe",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("erstereihe",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("erstereihe",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB38()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(38));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=375;
            int v=529;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("zweitereihe",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("zweitereihe",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("zweitereihe",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("zweitereihe",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("zweitereihe",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB39()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(39));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=375;
            int v=577;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("drittereihe",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("drittereihe",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("drittereihe",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("drittereihe",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("drittereihe",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB40()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(40));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=414;
            int v=442;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("erstesdrittel",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("erstesdrittel",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("erstesdrittel",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("erstesdrittel",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("erstesdrittel",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB41()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(41));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=568;
            int v=442;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("zweitesdrittel",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("zweitesdrittel",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("zweitesdrittel",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("zweitesdrittel",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("zweitesdrittel",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB42()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(42));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=722;
            int v=442;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("drittesdrittel",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("drittesdrittel",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("drittesdrittel",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("drittesdrittel",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("drittesdrittel",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB43()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(43));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=414;
            int v=396;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("19-36",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("19-36",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("19-36",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("19-36",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("19-36",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB44()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(44));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=492;
            int v=396;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("ungerade",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("ungerade",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("ungerade",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("ungerade",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("ungerade",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB45()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(45));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=568;
            int v=396;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("schwarz",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("schwarz",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("schwarz",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("schwarz",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("schwarz",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB46()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(46));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=644;
            int v=396;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("rot",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("rot",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("rot",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("rot",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("rot",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB47()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(47));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=722;
            int v=396;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("gerade",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("gerade",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("gerade",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("gerade",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("gerade",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB48()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(48));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=800;
            int v=396;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("1-18",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("1-18",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("1-18",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("1-18",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("1-18",500);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB49()){
            try{
                if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                  ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(49));
                }
            }
            catch(Exception p){
                System.out.println("Andreas Mandl!");
            }
            
            int i=880;
            int v=481;
            if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).weißerCoinSetzen(i,v);
                model.einsatzSetzen("0",1);
            }
            else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).roterCoinSetzen(i,v);
                model.einsatzSetzen("0",10);
            }
            else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).blauerCoinSetzen(i,v);
                model.einsatzSetzen("0",50);
            }
            else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).grünerCoinSetzen(i,v);
                model.einsatzSetzen("0",100);
            }
            else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).schwarzerCoinSetzen(i,v);
                model.einsatzSetzen("0",500);
            }
        }
    }
}



