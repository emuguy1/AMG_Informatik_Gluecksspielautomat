
public interface Model
{
    boolean anmelden(String benutzername, String passwort);
    boolean registrieren(String benutzername, String passwort);
    void setView(View v);
    String getBetrag();
    String getBenutzername();
    void spielen();
    
    boolean istGerade(int zahl);
    boolean isterstesdrittel(int zahl);
    boolean istzweitereihe(int zahl);
    boolean isterstereihe(int zahl);
    boolean istzweitesdrittel(int zahl);
    boolean istdrittereihe(int zahl);
    boolean istdrittesdrittel(int zahl);
    boolean isterstehaelfte(int zahl);
    boolean istzweitehaelfte(int zahl);
    boolean istrot(int zahl);
    boolean istschwarz(int zahl);
}
