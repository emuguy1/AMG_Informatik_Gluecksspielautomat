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
            int i=839;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(1)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(1));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(1), "1");
            }
            else{
                coinSetzen(i,v,"1",1);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB2()){
            
            int i=839;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(2)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(2));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(2), "2");
            }
            else{
                coinSetzen(i,v,"2",2);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB3()){
            int i=839;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(3)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(3));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(3), "3");
            }
            else{
                coinSetzen(i,v,"3",3);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB4()){
            int i=799;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(4)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(4));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(4), "4");
            }
            else{
                coinSetzen(i,v,"4",4);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB5()){
            int i=799;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(5)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(5));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(5), "5");
            }
            else{
                coinSetzen(i,v,"5",5);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB6()){
            int i=799;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(6)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(6));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(6), "6");
            }
            else{
                coinSetzen(i,v,"6",6);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB7()){
            int i=760;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(7)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(7));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(7), "7");
            }
            else{
                coinSetzen(i,v,"7",7);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB8()){
            int i=760;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(8)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(8));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(8), "8");
            }
            else{
                coinSetzen(i,v,"8",8);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB9()){
            
            int i=760;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(9)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(9));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(9), "9");
            }
            else{
                coinSetzen(i,v,"9",9);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB10()){
            int i=721;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(10)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(10));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(10), "10");
            }
            else{
                coinSetzen(i,v,"10",10);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB11()){
            int i=721;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(11)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(11));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(11), "11");
            }
            else{
                coinSetzen(i,v,"11",11);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB12()){
            int i=721;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(12)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(12));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(12), "12");
            }
            else{
                coinSetzen(i,v,"12",12);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB13()){
            int i=681;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(13)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(13));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(13), "13");
            }
            else{
                coinSetzen(i,v,"13",13);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB14()){
            int i=681;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(14)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(14));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(14), "14");
            }
            else{
                coinSetzen(i,v,"14",14);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB15()){
            int i=681;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(15)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(15));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(15), "15");
            }
            else{
                coinSetzen(i,v,"15",15);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB16()){
            int i=645;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(16)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(16));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(16), "16");
            }
            else{
                coinSetzen(i,v,"16",16);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB17()){
            int i=645;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(17)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(17));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(17), "17");
            }
            else{
                coinSetzen(i,v,"17",17);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB18()){
            int i=645;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(18)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(18));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(18), "18");
            }
            else{
                coinSetzen(i,v,"18",18);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB19()){
            int i=607;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(19)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(19));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(19), "19");
            }
            else{
                coinSetzen(i,v,"19",19);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB20()){
            int i=607;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(20)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(20));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(20), "20");
            }
            else{
                coinSetzen(i,v,"20",20);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB21()){
            int i=607;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(21)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(21));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(21), "21");
            }
            else{
                coinSetzen(i,v,"21",21);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB22()){
            int i=569;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(22)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(22));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(22), "22");
            }
            else{
                coinSetzen(i,v,"22",22);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB23()){
            int i=569;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(23)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(23));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(23), "23");
            }
            else{
                coinSetzen(i,v,"23",23);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB24()){
            int i=569;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(24)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(24));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(24), "24");
            }
            else{
                coinSetzen(i,v,"24",24);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB25()){
            int i=530;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(25)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(25));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(25), "25");
            }
            else{
                coinSetzen(i,v,"25",25);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB26()){
            int i=530;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(26)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(26));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(26), "26");
            }
            else{
                coinSetzen(i,v,"26",26);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB27()){
            int i=530;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(27)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(27));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(27), "27");
            }
            else{
                coinSetzen(i,v,"27",27);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB28()){
            int i=491;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(28)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(28));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(28), "28");
            }
            else{
                coinSetzen(i,v,"28",28);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB29()){
            int i=491;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(29)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(29));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(29), "29");
            }
            else{
                coinSetzen(i,v,"29",29);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB30()){
            int i=491;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(30)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(30));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(30), "30");
            }
            else{
                coinSetzen(i,v,"30",30);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB31()){
            int i=453;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(31)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(31));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(31), "31");
            }
            else{
                coinSetzen(i,v,"31",31);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB32()){
            int i=453;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(32)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(32));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(32), "32");
            }
            else{
                coinSetzen(i,v,"32",32);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB33()){
            int i=453;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(33)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(33));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(33), "33");
            }
            else{
                coinSetzen(i,v,"33",33);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB34()){
            int i=414;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(34)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(34));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(34), "34");
            }
            else{
                coinSetzen(i,v,"34",34);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB35()){
            int i=414;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(23)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(35));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(35), "35");
            }
            else{
                coinSetzen(i,v,"35",35);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB36()){
            int i=414;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(36)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(36));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(36), "36");
            }
            else{
                coinSetzen(i,v,"36",36);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB37()){
            int i=375;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(37)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(37));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(37), "erstereihe");
            }
            else{
                coinSetzen(i,v,"erstereihe",37);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB38()){
            int i=375;
            int v=529;
            if(((Spielbrett)view).getGesetzterCoin(38)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(38));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(38), "zweitereihe");
            }
            else{
                coinSetzen(i,v,"zweitereihe",38);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB39()){
            int i=375;
            int v=577;
            if(((Spielbrett)view).getGesetzterCoin(39)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(39));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(39), "drittereihe");
            }
            else{
                coinSetzen(i,v,"drittereihe",39);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB40()){
            int i=414;
            int v=442;
            if(((Spielbrett)view).getGesetzterCoin(40)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(40));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(40), "erstesdrittel");
            }
            else{
                coinSetzen(i,v,"erstesdrittel",40);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB41()){
            int i=568;
            int v=442;
            if(((Spielbrett)view).getGesetzterCoin(41)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(41));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(41), "zweitesdrittel");
            }
            else{
                coinSetzen(i,v,"zweitesdrittel",41);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB42()){
            int i=722;
            int v=442;
            if(((Spielbrett)view).getGesetzterCoin(42)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(42));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(42), "drittesdrittel");
            }
            else{
                coinSetzen(i,v,"drittesdrittel",42);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB43()){
            int i=414;
            int v=396;
            if(((Spielbrett)view).getGesetzterCoin(43)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(43));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(43), "19-36");
            }
            else{
                coinSetzen(i,v,"19-36",43);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB44()){
            int i=492;
            int v=396;
            if(((Spielbrett)view).getGesetzterCoin(44)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(44));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(44), "ungerade");
            }
            else{
                coinSetzen(i,v,"ungerade",44);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB45()){
            int i=568;
            int v=396;
            if(((Spielbrett)view).getGesetzterCoin(45)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(45));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(45), "schwarz");
            }
            else{
                coinSetzen(i,v,"schwarz",45);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB46()){
            int i=644;
            int v=396;
            if(((Spielbrett)view).getGesetzterCoin(46)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(46));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(46), "rot");
            }
            else{
                coinSetzen(i,v,"rot",46);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB47()){
            int i=722;
            int v=396;
            if(((Spielbrett)view).getGesetzterCoin(47)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(47));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(47), "gerade");
            }
            else{
                coinSetzen(i,v,"gerade",47);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB48()){
            int i=800;
            int v=396;
            if(((Spielbrett)view).getGesetzterCoin(48)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(48));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(48), "1-18");
            }
            else{
                coinSetzen(i,v,"1-18",48);
            }
        }
        else if(view.getClass() == Spielbrett.class&&e.getSource() == ((Spielbrett)view).getB49()){
            int i=880;
            int v=481;
            if(((Spielbrett)view).getGesetzterCoin(49)!=null){
                ((Spielbrett)view).remove(((Spielbrett)view).getGesetzterCoin(49));
                model.removeEinsatzBetrag(((Spielbrett)view).getGesetzterCoin(49), "0");
            }
            else{
                coinSetzen(i,v,"0",49);
            }
        }
    }
    
    private void coinSetzen(int i,int v, String e,int index){
        if(((Spielbrett)view).wertGeben()==1){
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



