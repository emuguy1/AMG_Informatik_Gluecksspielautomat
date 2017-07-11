
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
  
} // Ende der Klasse Spiel