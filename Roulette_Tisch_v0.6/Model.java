
public interface Model
{
    boolean anmelden(String benutzername, String passwort);
    boolean registrieren(String benutzername, String passwort);
    void setView(View v);
    String getBetrag();
    String getBenutzername();
    int[] spielen();
    void einsatzSetzen(String s, Integer i);
    
}
