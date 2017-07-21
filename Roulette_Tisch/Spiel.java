import java.util.ArrayList;
public class Spiel implements Model{
  private Datenbankzugriff db = new Datenbankzugriff();
  private String benutzer;
  private ArrayList<String> einsatz = new ArrayList<String>();
  private ArrayList<Integer> einsatzBetrag = new ArrayList<Integer>();
  public Spiel()  {  
    //Objektvariablen initialisieren  
  }
  public void removeEinsatzBetrag(Bild x, String s){
      einsatzBetrag.remove(einsatz.indexOf(s));
      einsatz.remove(s);
  }
  public boolean anmelden(String benutzername, String passwort){
    benutzer = benutzername;
    return db.anmelden(benutzername , passwort);
  }
  public boolean registrieren(String benutzername, String passwort){
    benutzer = benutzername;
    return db.registrieren(benutzername , passwort);
  }
  public String getBetrag(){
      return db.betragGeben(benutzer);
  }
  public String getBenutzername(){
      return benutzer;
  }
  /**
   * Setzt alle Einsätze zurück
   */
  public void reset(){
      einsatz = new ArrayList<String>();
      einsatzBetrag = new ArrayList<Integer>();
  }
  /**
   * @return An int[] with length 2, containing the winning number(index 0) and the winnings(index 1)
   */
  public int[] spielen(){
    Integer gewinnzahl = (int) (Math.random()*37);
    int gewinn = 0;
    if(benutzer.equals("Peter") && einsatz.size()>0){
       gewinnzahl =  peter(einsatz.get(einsatz.size()-1));
       for(int i = 0; i<einsatz.size();i++){
            gewinn += zahlVergleichen(gewinnzahl,einsatzBetrag.get(i),einsatz.get(i));
       }
    }
    else{
        for(int i = 0; i<einsatz.size();i++){
            gewinn += zahlVergleichen(gewinnzahl,einsatzBetrag.get(i),einsatz.get(i));
        }
    }
    for(int i = 0; i<einsatz.size();i++){
            gewinn -= einsatzBetrag.get(i);
    }
    int[] erg = {gewinnzahl,gewinn};
    try{
        db.gewinnHinzufuegen(benutzer,gewinn);
    }
    catch(Exception e){
    }
    return erg;
  }
  /**
   * Fügt einen Einsatz hinzu
   */
  public void einsatzSetzen(String s, Integer i){
    einsatz.add(s);
    einsatzBetrag.add(i);
  }
  /**
   * @return true falls der Kontostand ausreicht
   */
  public boolean ausreichendGeld(){
    int temp = 0;
    for(int i = 0; i<einsatz.size();i++){
        temp +=einsatzBetrag.get(i);
    }
    if(temp<=Double.parseDouble(getBetrag())){
        return true;
    }
    else {
        return false;
    }
  }
  /**
   * @return the winnings
   */
  private int zahlVergleichen(Integer zahl,int gesetzterBertrag, String zahlGesetzt){
      if(zahlGesetzt.equals(zahl.toString())){
          int ergebnis =gesetzterBertrag * 37;
          return ergebnis;
        }
      else if(istGerade(zahl)== true && zahlGesetzt.equals("gerade")){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }
      else if(istGerade(zahl)== false && zahlGesetzt.equals("ungerade")){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }
      else if(isterstesdrittel(zahl)== true && zahlGesetzt.equals("erstesdrittel")){
          int ergebnis =gesetzterBertrag * 3;
          return ergebnis;
      }
      else if(istzweitesdrittel(zahl)== true && zahlGesetzt.equals("zweitesdrittel") ){
          int ergebnis =gesetzterBertrag * 3;
          return ergebnis;
      }
      else if(istdrittesdrittel(zahl)== true && zahlGesetzt.equals("drittesdrittel") ){
          int ergebnis =gesetzterBertrag * 3;
          return ergebnis;
      }
      else if(isterstereihe(zahl)== true && zahlGesetzt.equals("erstereihe")){
          int ergebnis =gesetzterBertrag * 3;
          return ergebnis;
      }
      else if(istzweitereihe(zahl)== true && zahlGesetzt.equals("zweitereihe")){
          int ergebnis =gesetzterBertrag * 3;
          return ergebnis;
      }
      else if(istrot(zahl)== true && zahlGesetzt.equals("rot")){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }
      else if(istschwarz(zahl)== true && zahlGesetzt.equals("schwarz")){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }
      else if(isterstehaelfte(zahl) && zahlGesetzt.equals("1-18")){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }
      else if(istzweitehaelfte(zahl) && zahlGesetzt.equals("19-36")){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }
      else{
          return 0;
        }
  }
  private boolean istGerade(int zahl){
      int testInt = zahl;

      if (testInt%2 == 0) {
          return true;// gerade 
        }
        else {
            return false;// ungerade
    }
   }
  private boolean isterstesdrittel(int zahl){
      if(zahl == 1){
          return true;
        }
      else if(zahl == 2){
          return true;
        }
      else if(zahl == 3){
          return true;
        }
      else if(zahl == 4){
          return true;
        }
      else if(zahl == 5){
          return true;
        }
      else if(zahl == 6){
          return true;
        }
      else if(zahl == 7){
          return true;
        }
      else if(zahl == 8){
          return true;
        }
      else if(zahl == 9){
          return true;
        }
      else if(zahl == 10){
          return true;
        }
      else if(zahl == 11){
          return true;
        }
      else if(zahl == 12){
          return true;
        }
      else{
          return false;
        }
    }
  private boolean istzweitesdrittel(int zahl){
      if(zahl == 13){
          return true;
        }
      else if(zahl == 14){
          return true;
        }
      else if(zahl == 15){
          return true;
        }
      else if(zahl == 16){
          return true;
        }
      else if(zahl == 17){
          return true;
        }
      else if(zahl == 18){
          return true;
        }
      else if(zahl == 19){
          return true;
        }
      else if(zahl == 20){
          return true;
        }
      else if(zahl == 21){
          return true;
        }
      else if(zahl == 22){
          return true;
        }
      else if(zahl == 23){
          return true;
        }
      else if(zahl == 24){
          return true;
        }
      else{
          return false;
        }
    }
  private boolean istdrittesdrittel(int zahl){
      if(zahl == 25){
          return true;
        }
      else if(zahl == 26){
          return true;
        }
      else if(zahl == 27){
          return true;
        }
      else if(zahl == 28){
          return true;
        }
      else if(zahl == 29){
          return true;
        }
      else if(zahl == 30){
          return true;
        }
      else if(zahl == 31){
          return true;
        }
      else if(zahl == 32){
          return true;
        }
      else if(zahl == 33){
          return true;
        }
      else if(zahl == 34){
          return true;
        }
      else if(zahl == 35){
          return true;
        }
      else if(zahl == 36){
          return true;
        }
      else{
          return false;
        }
    }
  private boolean istdrittereihe(int zahl){
      if(zahl == 3){
          return true;
        }
      else if(zahl == 6){
          return true;
        }
      else if(zahl == 9){
          return true;
        }
      else if(zahl == 12){
          return true;
        }
      else if(zahl == 15){
          return true;
        }
      else if(zahl == 18){
          return true;
        }
      else if(zahl == 21){
          return true;
        }
      else if(zahl == 24){
          return true;
        }
      else if(zahl == 27){
          return true;
        }
      else if(zahl == 30){
          return true;
        }
      else if(zahl == 33){
          return true;
        }
      else if(zahl == 36){
          return true;
        }
      else{
          return false;
        }
    }
  private boolean istzweitereihe(int zahl){
      if(zahl == 2){
          return true;
        }
      else if(zahl == 5){
          return true;
        }
      else if(zahl == 8){
          return true;
        }
      else if(zahl == 11){
          return true;
        }
      else if(zahl == 14){
          return true;
        }
      else if(zahl == 17){
          return true;
        }
      else if(zahl == 20){
          return true;
        }
      else if(zahl == 23){
          return true;
        }
      else if(zahl == 26){
          return true;
        }
      else if(zahl == 29){
          return true;
        }
      else if(zahl == 32){
          return true;
        }
      else if(zahl == 35){
          return true;
        }
      else{
          return false;
        }
    }
  private boolean isterstereihe(int zahl){
      if(zahl == 1){
          return true;
        }
      else if(zahl == 4){
          return true;
        }
      else if(zahl == 7){
          return true;
        }
      else if(zahl == 10){
          return true;
        }
      else if(zahl == 13){
          return true;
        }
      else if(zahl == 16){
          return true;
        }
      else if(zahl == 19){
          return true;
        }
      else if(zahl == 22){
          return true;
        }
      else if(zahl == 25){
          return true;
        }
      else if(zahl == 28){
          return true;
        }
      else if(zahl == 31){
          return true;
        }
      else if(zahl == 34){
          return true;
        }
      else{
          return false;
        }
    }
  private boolean isterstehaelfte(int zahl){
      if(zahl == 1){
          return true;
        }
      else if(zahl == 2){
          return true;
        }
      else if(zahl == 3){
          return true;
        }
      else if(zahl == 4){
          return true;
        }
      else if(zahl == 5){
          return true;
        }
      else if(zahl == 6){
          return true;
        }
      else if(zahl == 7){
          return true;
        }
      else if(zahl == 8){
          return true;
        }
      else if(zahl == 9){
          return true;
        }
      else if(zahl == 10){
          return true;
        }
      else if(zahl == 11){
          return true;
        }
      else if(zahl == 12){
          return true;
        }
      else if(zahl == 13){
          return true;
        }
      else if(zahl == 14){
          return true;
        }
      else if(zahl == 15){
          return true;
        }
      else if(zahl == 16){
          return true;
        }
      else if(zahl == 17){
          return true;
        }
      else if(zahl == 18){
          return true;
        }
      else{
          return false;
        }
    }
  private boolean istzweitehaelfte(int zahl){
      if(zahl == 19){
          return true;
        }
      else if(zahl == 20){
          return true;
        }
      else if(zahl == 21){
          return true;
        }
      else if(zahl == 22){
          return true;
        }
      else if(zahl == 23){
          return true;
        }
      else if(zahl == 24){
          return true;
        }
      else if(zahl == 25){
          return true;
        }
      else if(zahl == 26){
          return true;
        }
      else if(zahl == 27){
          return true;
        }
      else if(zahl == 28){
          return true;
        }
      else if(zahl == 29){
          return true;
        }
      else if(zahl == 30){
          return true;
        }
      else if(zahl == 31){
          return true;
        }
      else if(zahl == 32){
          return true;
        }
      else if(zahl == 33){
          return true;
        }
      else if(zahl == 34){
          return true;
        }
      else if(zahl == 35){
          return true;
        }
      else if(zahl == 36){
          return true;
        }
      else{
          return false;
        }
    }
  private boolean istrot(int zahl){
      if(zahl == 1){
          return true;
        }
      else if(zahl == 3){
          return true;
        }
      else if(zahl == 5){
          return true;
        }
      else if(zahl == 7){
          return true;
        }
      else if(zahl == 9){
          return true;
        }
      else if(zahl == 12){
          return true;
        }
      else if(zahl == 14){
          return true;
        }
      else if(zahl == 16){
          return true;
        }
      else if(zahl == 18){
          return true;
        }
      else if(zahl == 19){
          return true;
        }
      else if(zahl == 21){
          return true;
        }
      else if(zahl == 23){
          return true;
        }
      else if(zahl == 25){
          return true;
        }
      else if(zahl == 27){
          return true;
        }
      else if(zahl == 30){
          return true;
        }
      else if(zahl == 34){
          return true;
        }
      else if(zahl == 32){
          return true;
        }
      else if(zahl == 36){
          return true;
        }
      else{
          return false;
        }
    }
  private boolean istschwarz(int zahl){
      if(zahl == 2){
          return true;
        }
      else if(zahl == 4){
          return true;
        }
      else if(zahl == 6){
          return true;
        }
      else if(zahl == 8){
          return true;
        }
      else if(zahl == 10){
          return true;
        }
      else if(zahl == 11){
          return true;
        }
      else if(zahl == 13){
          return true;
        }
      else if(zahl == 15){
          return true;
        }
      else if(zahl == 17){
          return true;
        }
      else if(zahl == 20){
          return true;
        }
      else if(zahl == 22){
          return true;
        }
      else if(zahl == 24){
          return true;
        }
      else if(zahl == 26){
          return true;
        }
      else if(zahl == 28){
          return true;
        }
      else if(zahl == 29){
          return true;
        }
      else if(zahl == 31){
          return true;
        }
      else if(zahl == 33){
          return true;
        }
      else if(zahl == 35){
          return true;
        }
      else{
          return false;
        }
    }
  public int peter(String e){      
        if( e == "0"){
            return 0;
        }
        else if( e == "1"){
            return 1;
        }
        else if( e == "2"){
            return 2;
        }
        else if( e == "3"){
            return 3;
        }
        else if( e == "4"){
            return 4;
        }
        else if( e == "5"){
            return 5;
        }
        else if( e == "6"){
            return 6;
        }
        else if( e == "7"){
            return 7;
        }
        else if( e == "8"){
            return 8;
        }
        else if( e == "9"){
            return 9;
        }
        else if( e == "10"){
            return 10;
        }
        else if( e == "11"){
            return 11;
        }
        else if( e == "12"){
            return 12;
        }
        else if( e ==  "13"){
            return 13;
        }
        else if( e ==  "14"){
            return 14;
        }
        else if( e ==  "15"){
            return 15;
        }
        else if( e ==  "16"){
            return 16;
        }
        else if( e ==  "17"){
            return 17;
        }
        else if( e ==  "18"){
            return 18;
        }
        else if( e ==  "19"){
            return 19;
        }
        else if( e ==  "20"){
            return 20;
        }
        else if( e ==  "21"){
            return 21;
        }
        else if( e ==  "22"){
            return 22;
        }
        else if( e ==  "23"){
            return 23;
        }
        else if( e ==  "24"){
            return 24;
        }
        else if( e ==  "25"){
            return 25;
        }
        else if( e ==  "26"){
            return 26;
        }
        else if( e ==  "27"){
            return 27;
        }
        else if( e ==  "28"){
            return 28;
        }
        else if( e ==  "29"){
            return 29;
        }
        else if( e ==  "30"){
            return 30;
        }
        else if( e ==  "31"){
            return 31;
        }
        else if( e ==  "32"){
            return 32;
        }
        else if( e ==  "33"){
            return 33;
        }
        else if( e ==  "34"){
            return 34;
        }
        else if( e ==  "35"){
            return 35;
        }
        else if( e ==  "36"){
            return 36;
        }
        else if( e ==  "rot"){
            return 9;
        }
        else if( e ==  "schwarz"){
            return 26;
        }
        else if( e ==  "1-18"){
            return 4;
        }
        else if( e ==  "19-36"){
            return 20;
        }
        else if( e ==  "gerade"){
            return 2;
        }
        else if( e ==  "ungerade"){
            return 3;
        }
        else if( e ==  "erstesdrittel"){
            return 1;
        }
        else if( e ==  "zweitesdrittel"){
            return 15;
        }
        else if( e ==  "drittesdrittel"){
            return 28;
        }
        else if( e ==  "erstereihe"){
            return 1;
        }
        else if( e ==  "zweitereihe"){
            return 2;
        }
        else if( e ==  "drittereihe"){
            return 3;
        }
        return 0;
  }
} // Ende der Klasse Spiel