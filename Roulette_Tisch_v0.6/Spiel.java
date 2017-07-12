import java.util.ArrayList;
public class Spiel implements Model{
  private Datenbankzugriff db = new Datenbankzugriff();
  private String benutzer;
  private ArrayList<String> einsatz = new ArrayList<String>();
  private ArrayList<Integer> einsatzBetrag = new ArrayList<Integer>();
  public Spiel()  {  
    //Objektvariablen initialisieren  
  }
  public void setView(View v){
    
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
  public int[] spielen(){
    Integer gewinnzahl = (int) (Math.random()*37);
    System.out.println(gewinnzahl);
    int gewinn = 0;
    for(int i = 0; i<einsatz.size();i++){
        System.out.println("Gewinn: "+zahlVergleichen(gewinnzahl,einsatzBetrag.get(i),einsatz.get(i)));
        gewinn += zahlVergleichen(gewinnzahl,einsatzBetrag.get(i),einsatz.get(i));
    }
    int[] erg = {gewinnzahl,gewinn};
    return erg;
  }
  public void einsatzSetzen(String s, Integer i){
    einsatz.add(s);
    einsatzBetrag.add(i);
  }
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
      /*
      else if(zahl == 0 && zahlGesetzt ==  0 ){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }*/
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
} // Ende der Klasse Spiel