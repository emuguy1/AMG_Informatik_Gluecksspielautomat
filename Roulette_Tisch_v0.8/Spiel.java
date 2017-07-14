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
    if(benutzer.equals("Andreas Mandl") && einsatz.size()>0){
      /* gewinnzahl =  andreasMandl(einsatz.get(einsatz.size()-1));
        for(int i = 0; i<einsatz.size();i++){
            System.out.println("Gewinn: "+zahlVergleichen(gewinnzahl,einsatzBetrag.get(i),einsatz.get(i)));
            gewinn += zahlVergleichen(gewinnzahl,einsatzBetrag.get(i),einsatz.get(i));
        }*/
    }
    else{
        for(int i = 0; i<einsatz.size();i++){
            System.out.println("Gewinn: "+zahlVergleichen(gewinnzahl,einsatzBetrag.get(i),einsatz.get(i)));
            gewinn += zahlVergleichen(gewinnzahl,einsatzBetrag.get(i),einsatz.get(i));
        }
    }
    int[] erg = {gewinnzahl,gewinn};
    
   
    for(int i = 0; i<einsatz.size();i++){
            gewinn -= einsatzBetrag.get(i);
        }
        try{
        db.GewinnHinzufuegen(benutzer,gewinn);
      }
      catch(Exception e){
      }
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
  /*public int andreasMandl(String ef){
    char e = '0';
      switch(e){
        case "0":{
            return 0;
        }
        case "1":{
            return 1;
        }
        case "2":{
            return 2;
        }
        case "3":{
            return 3;
        }
        case "4":{
            return 4;
        }
        case "5":{
            return 5;
        }
        case "6":{
            return 6;
        }
        case "7":{
            return 7;
        }
        case "8":{
            return 8;
        }
        case "9":{
            return 9;
        }
        case "10":{
            return 10;
        }
        case "11":{
            return 11;
        }
        case "12":{
            return 12;
        }
        case "13":{
            return 13;
        }
        case "14":{
            return 14;
        }
        case "15":{
            return 15;
        }
        case "16":{
            return 16;
        }
        case "17":{
            return 17;
        }
        case "18":{
            return 18;
        }
        case "19":{
            return 19;
        }
        case "20":{
            return 20;
        }
        case "21":{
            return 21;
        }
        case "22":{
            return 22;
        }
        case "23":{
            return 23;
        }
        case "24":{
            return 24;
        }
        case "25":{
            return 25;
        }
        case "26":{
            return 26;
        }
        case "27":{
            return 27;
        }
        case "28":{
            return 28;
        }
        case "29":{
            return 29;
        }
        case "30":{
            return 30;
        }
        case "31":{
            return 31;
        }
        case "32":{
            return 32;
        }
        case "33":{
            return 33;
        }
        case "34":{
            return 34;
        }
        case "35":{
            return 35;
        }
        case "36":{
            return 36;
        }
        case "rot":{
            return 9;
        }
        case "schwarz":{
            return 26;
        }
        case "1-18":{
            return 4;
        }
        case "19-36":{
            return 20;
        }
        case "gerade":{
            return 2;
        }
        case "ungerade":{
            return 3;
        }
        case "erstesdrittel":{
            return 1;
        }
        case "zweitesdrittel":{
            return 15;
        }
        case "drittesdrittel":{
            return 28;
        }
        case "erstereihe":{
            return 1;
        }
        case "zweitereihe":{
            return 2;
        }
        case "drittereihe":{
            return 3;
        }
      }
      return 0;
  }*/
} // Ende der Klasse Spiel