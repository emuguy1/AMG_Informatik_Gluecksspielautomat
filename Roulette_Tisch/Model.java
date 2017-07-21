
public interface Model
{
    boolean anmelden(String benutzername, String passwort);
    boolean registrieren(String benutzername, String passwort);
    String getBetrag();
    String getBenutzername();
    int[] spielen();
    void einsatzSetzen(String s, Integer i);
    boolean ausreichendGeld();
    void removeEinsatzBetrag(Bild x, String s);
    void reset();
}
