import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatenbankOeffnen {

    public static void main(String[] args) {

        Connection dbVerbindung = null;

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Treiber erfolgreich geladen...");
        } catch (ClassNotFoundException e) {
            System.out.println("Fehler beim Laden des Treibers" + e);
            System.exit(0);
        }
        try {
            dbVerbindung = DriverManager.getConnection("jdbc:odbc:Studenten-Datenbank", "", "");
            System.out.println("Verbindung erfolgreich...");
            dbVerbindung.close();
            System.out.println("Verbindung geschlossen...");
        } catch (SQLException e) {
            System.out.println("DB-Verbindungsfehler: " + e);
            System.exit(0);
        }
    }
}