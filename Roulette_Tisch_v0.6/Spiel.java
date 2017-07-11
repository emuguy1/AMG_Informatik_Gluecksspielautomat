
public class Spiel implements Model{
  private Datenbankzugriff db = new Datenbankzugriff();
  private String benutzer;
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
  public void spielen(){
    System.out.println((int) (Math.random()*37));
  }
  public int zufallszahlGenerieren(){
      return (int) (Math.random()*37); 
  }
  public int zahlVergleichen(int zahl,int gesetzterBertrag){
      if(zufallszahlGenerieren() == zahl){
          int ergebnis =gesetzterBertrag * 37;
          return ergebnis;
        }
      else if(istGerade(zahl)== true && istGerade(zufallszahlGenerieren()) == true ){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }
      else if(istGerade(zahl)== false && istGerade(zufallszahlGenerieren()) == false ){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }
      else if(isterstesdrittel(zahl)== true && isterstesdrittel(zufallszahlGenerieren()) == true ){
          int ergebnis =gesetzterBertrag * 3;
          return ergebnis;
      }
      else if(istzweitesdrittel(zahl)== true && istzweitesdrittel(zufallszahlGenerieren()) == true ){
          int ergebnis =gesetzterBertrag * 3;
          return ergebnis;
      }
      else if(istdrittesdrittel(zahl)== true && istdrittesdrittel(zufallszahlGenerieren()) == true ){
          int ergebnis =gesetzterBertrag * 3;
          return ergebnis;
      }
      else if(isterstereihe(zahl)== true && isterstereihe(zufallszahlGenerieren()) == true ){
          int ergebnis =gesetzterBertrag * 3;
          return ergebnis;
      }
      else if(istzweitereihe(zahl)== true && istzweitereihe(zufallszahlGenerieren()) == true ){
          int ergebnis =gesetzterBertrag * 3;
          return ergebnis;
      }
      else if(istrot(zahl)== true && istrot(zufallszahlGenerieren()) == true ){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }
      else if(istschwarz(zahl)== true && istschwarz(zufallszahlGenerieren()) == true ){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }
      else if(zahl == 0 && zufallszahlGenerieren() ==  0 ){
          int ergebnis =gesetzterBertrag * 2;
          return ergebnis;
      }
      else{
          return 0;
        }
  }
  public boolean istGerade(int zahl){
      int testInt = zahl;

      if (testInt%2 == 0) {
          return true;// gerade 
        }
        else {
            return false;// ungerade
    }
   }
  public boolean isterstesdrittel(int zahl){
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
  public boolean istzweitesdrittel(int zahl){
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
  public boolean istdrittesdrittel(int zahl){
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
  public boolean istdrittereihe(int zahl){
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
  public boolean istzweitereihe(int zahl){
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
  public boolean isterstereihe(int zahl){
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
  public boolean isterstehaelfte(int zahl){
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
  public boolean istzweitehaelfte(int zahl){
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
  public boolean istrot(int zahl){
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
  public boolean istschwarz(int zahl){
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