
public class Spiel implements Model{
  private Datenbankzugriff db = new Datenbankzugriff();
  public Spiel()  {  
    //Objektvariablen initialisieren  
  }
  public void setView(View v){
    
  }
  public boolean anmelden(String benutzername, String passwort){
    return db.anmelden(benutzername , passwort);
  }
  public boolean registrieren(String benutzername, String passwort){
    return db.registrieren(benutzername , passwort);
  }
} // Ende der Klasse Spiel