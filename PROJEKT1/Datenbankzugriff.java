import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbankzugriff{
  
 public void NameGeben1(){
   String s="INSERT INTO Spielerliste (ID,Benutzername,Passwort,VerlaufNr,Betrag,Gewinn) VALUES ('1','emuguy','123','1','200','150')";
   datenbankzugriffTesten(s);
  }
  
  public void NameGeben2(){
    String s="SELECT Benutzername FROM Spielerliste WHERE ID==1";
    datenbankzugriffTesten(s);
  }


  public void datenbankzugriffTesten(String sqlAbfrage){
  Connection dbVerbindung = null;
  Statement sqlStatement = null;
  String sqlString =sqlAbfrage;
  ResultSet resultSet = null;

  
  try{
    Class.forName("org.sqlite.JBC");
    System.out.println("Treiber erfolgreich geladen ...");
  }
  catch(ClassNotFoundException e){
    System.out.println("Fehler beim Laden des Treibers " + e);
  }
  
  try{
    System.out.println("DB-Verbindung aufbauen ...");
    dbVerbindung =
    DriverManager.getConnection("jdbc:sqlite:test.db");
    System.out.println("Verbindung erfolgreich...");
  }
  catch(SQLException e){
    System.out.println("DB-Verbindungsfehler: "+e);
  }
  try{
    sqlStatement = dbVerbindung.createStatement();
    System.out.println("SQL-Statement erzeugen..");
    ResultSet rs = stmt.executeQuery("SELECT * FROM Spielerliste;");
    while(resultSet.next())
    System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
    resultSet.close();
    System.out.println("resultSet-Objekt zerstören...");
    sqlStatement.close();
    System.out.println("SQL-Statement-Objekt zerstören...");
    dbVerbindung.close();
    System.out.println("Verbindung geschlossen...");
  }
  catch(SQLException e){
    System.out.println("Fehler beim DB-Zugriff!" +e);
    }
  }
}
//https://javabeginners.de/Datenbanken/SQLite-Datenbank.php
  
  