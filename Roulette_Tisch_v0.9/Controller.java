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
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getBReset()){
            ((Spielbrett)view).reset();
            model.reset();
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getSpielenButton()){
            //SPIELEN 
            if(((Spielbrett)view).ready()&& model.ausreichendGeld()){
                int[] i = model.spielen();
                ((Spielbrett)view).kugelanimation(i[0],i[1]);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB1()){
            int i=839;
            int v=481;
            coinSetzen(i,v,"1",1);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB2()){
            int i=839;
            int v=529;
            coinSetzen(i,v,"2",2);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB3()){
            int i=839;
            int v=577;
            coinSetzen(i,v,"3",3);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB4()){
            int i=799;
            int v=481;
            coinSetzen(i,v,"4",4);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB5()){
            int i=799;
            int v=529;
            coinSetzen(i,v,"5",5);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB6()){
            int i=799;
            int v=577;
            coinSetzen(i,v,"6",6);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB7()){
            int i=760;
            int v=481;
            coinSetzen(i,v,"7",7);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB8()){
            int i=760;
            int v=529;
            coinSetzen(i,v,"8",8);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB9()){ 
            int i=760;
            int v=577;
            coinSetzen(i,v,"9",9);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB10()){
            int i=721;
            int v=481;
            coinSetzen(i,v,"10",10);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB11()){
            int i=721;
            int v=529;
            coinSetzen(i,v,"11",11);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB12()){
            int i=721;
            int v=577;
            coinSetzen(i,v,"12",12);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB13()){
            int i=681;
            int v=481;
            coinSetzen(i,v,"13",13);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB14()){
            int i=681;
            int v=529;
            coinSetzen(i,v,"14",14);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB15()){
            int i=681;
            int v=577;
            coinSetzen(i,v,"15",15);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB16()){
            int i=645;
            int v=481;
            coinSetzen(i,v,"16",16);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB17()){
            int i=645;
            int v=529;
            coinSetzen(i,v,"17",17);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB18()){
            int i=645;
            int v=577;
            coinSetzen(i,v,"18",18);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB19()){
            int i=607;
            int v=481;
            coinSetzen(i,v,"19",19);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB20()){
            int i=607;
            int v=529;
            coinSetzen(i,v,"20",20);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB21()){
            int i=607;
            int v=577;
            coinSetzen(i,v,"21",21);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB22()){
            int i=569;
            int v=481;
            coinSetzen(i,v,"22",22);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB23()){
            int i=569;
            int v=529;
            coinSetzen(i,v,"23",23);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB24()){
            int i=569;
            int v=577;
            coinSetzen(i,v,"24",24);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB25()){
            int i=530;
            int v=481;
            coinSetzen(i,v,"25",25);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB26()){
            int i=530;
            int v=529;
            coinSetzen(i,v,"26",26);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB27()){
            int i=530;
            int v=577;
            coinSetzen(i,v,"27",27);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB28()){
            int i=491;
            int v=481;
            coinSetzen(i,v,"28",28);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB29()){
            int i=491;
            int v=529;
            coinSetzen(i,v,"29",29);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB30()){
            int i=491;
            int v=577;
            coinSetzen(i,v,"30",30);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB31()){
            int i=453;
            int v=481;
            coinSetzen(i,v,"31",31);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB32()){
            int i=453;
            int v=529;
            coinSetzen(i,v,"32",32);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB33()){
            int i=453;
            int v=577;
            coinSetzen(i,v,"33",33);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB34()){
            int i=414;
            int v=481;
            coinSetzen(i,v,"34",34);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB35()){
            int i=414;
            int v=529;
            coinSetzen(i,v,"35",35);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB36()){
            int i=414;
            int v=577;
            coinSetzen(i,v,"36",36);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB37()){
            int i=375;
            int v=481;
            coinSetzen(i,v,"erstereihe",37);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB38()){
            int i=375;
            int v=529;
            coinSetzen(i,v,"zweitereihe",38);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB39()){
            int i=375;
            int v=577;
            coinSetzen(i,v,"drittereihe",39);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB40()){
            int i=414;
            int v=442;
            coinSetzen(i,v,"erstesdrittel",40);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB41()){
            int i=568;
            int v=442;
            coinSetzen(i,v,"zweitesdrittel",41);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB42()){
            int i=722;
            int v=442;
            coinSetzen(i,v,"drittesdrittel",42);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB43()){
            int i=414;
            int v=396;
            coinSetzen(i,v,"19-36",43);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB44()){
            int i=492;
            int v=396;
            coinSetzen(i,v,"ungerade",44);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB45()){
            int i=568;
            int v=396;
            coinSetzen(i,v,"schwarz",45);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB46()){
            int i=644;
            int v=396;
            coinSetzen(i,v,"rot",46);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB47()){
            int i=722;
            int v=396;
            coinSetzen(i,v,"gerade",47);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB48()){
            int i=800;
            int v=396;
            coinSetzen(i,v,"1-18",48);
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB49()){
            int i=880;
            int v=481;
            coinSetzen(i,v,"0",49);
        }
    }
    private void coinSetzen(int i,int v, String e,int index){
        if(((Spielbrett)view).getGesetzterCoin(index)!=null){
            ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(index));
            model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(index), e);
            ((Spielbrett)view).coinEntfernen(index-1);
        }
        else if(((Spielbrett)view).wertGeben()==1){
                ((Spielbrett)view).coinSetzen(index-1,((Spielbrett)view).weißerCoinSetzen(i,v));
                model.einsatzSetzen(e,1);
        }
        else if(((Spielbrett)view).wertGeben()==10){
                ((Spielbrett)view).coinSetzen(index-1,((Spielbrett)view).roterCoinSetzen(i,v));
                model.einsatzSetzen(e,10);
        }
        else if(((Spielbrett)view).wertGeben()==50){
                ((Spielbrett)view).coinSetzen(index-1,((Spielbrett)view).blauerCoinSetzen(i,v));
                model.einsatzSetzen(e,50);
        }
        else if(((Spielbrett)view).wertGeben()==100){
                ((Spielbrett)view).coinSetzen(index-1,((Spielbrett)view).grünerCoinSetzen(i,v));
                model.einsatzSetzen(e,100);
        }
        else if(((Spielbrett)view).wertGeben()==500){
                ((Spielbrett)view).coinSetzen(index-1,((Spielbrett)view).schwarzerCoinSetzen(i,v));
                model.einsatzSetzen(e,500);
        }
    }
}



