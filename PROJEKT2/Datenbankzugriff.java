import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbankzugriff{
  
  public void TestdatensatzEinfuegen(){
    String sql = "INSERT INTO Spielerliste(ID,Benutzername,Passwort,VerlaufNr,Betrag,Gewinn) VALUES(?,?,?,?,?,?)";
 
    try{
      datensatzEinfuegen(sql,1,"emugeil","123emuguy",1,200,50);
    }
    catch(SQLException e){
      System.out.println("Fehler beim Datensatz erstellen: "+e);
    }
  }
  
  public void sqlAbfrage(){
    String s="SELECT Benutzername FROM Spielerliste WHERE ID='2'";
    datenbankzugriffTestenString(s,1);
  }
  
  private void datensatzEinfuegen(String sqlAbfrage, int ID, String Benutzername, String Passwort, int VerlaufNr, double Betrag, double Gewinn ) throws SQLException{
    Connection dbVerbindung = null;
    Statement sqlStatement = null;
    String sqlString = sqlAbfrage;
    
    //Treiber laden
    try{
      Class.forName("org.sqlite.JBC");
      System.out.println("Treiber erfolgreich geladen ...");
    }
    catch(ClassNotFoundException e){
      System.out.println("Fehler beim Laden des Treibers " + e);
    }
    //Verbindung aufbauen
    try{
      System.out.println("DB-Verbindung aufbauen ...");
      dbVerbindung = DriverManager.getConnection("jdbc:sqlite:test4.db");
      System.out.println("Verbindung erfolgreich...");
    }
    catch(SQLException e){
      System.out.println("DB-Verbindungsfehler: "+e);
    }
    try {
      PreparedStatement pstmt = dbVerbindung.prepareStatement(sqlAbfrage);
      pstmt.setInt(1, ID);
      pstmt.setString(2, Benutzername);
      pstmt.setString(3, Passwort);
      pstmt.setInt(4, VerlaufNr);
      pstmt.setDouble(5, Betrag);
      pstmt.setDouble(6, Gewinn);
      pstmt.executeUpdate();
      
      dbVerbindung.close();
      System.out.println("Verbindung geschlossen...");
    }catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  
  public String datenbankzugriffTestenString(String sqlAbfrage, int x){
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
      DriverManager.getConnection("jdbc:sqlite:test4.db");
      System.out.println("Verbindung erfolgreich...");
    }
    catch(SQLException e){
      System.out.println("DB-Verbindungsfehler: "+e);
    }
    try{
      sqlStatement = dbVerbindung.createStatement();
      System.out.println("SQL-Statement erzeugen..");
      resultSet = sqlStatement.executeQuery(sqlString);
      while(resultSet.next()){
        return resultSet.getString(x);
      }  
    }
    catch(SQLException e){
      System.out.println("Fehler beim DB-Zugriff!" +e);
    }
    finally{
      try{
        resultSet.close();
        System.out.println("resultSet-Objekt zerstören...");
        sqlStatement.close();
        System.out.println("SQL-Statement-Objekt zerstören...");
        dbVerbindung.close();
        System.out.println("Verbindung geschlossen...");
      }
      catch(SQLException e){
        System.out.println("Fehler beim DB-Schließen!" +e);
      }
    }
    return null;
  }
  public int datenbankzugriffTestenint(String sqlAbfrage, int x){
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
      DriverManager.getConnection("jdbc:sqlite:test4.db");
      System.out.println("Verbindung erfolgreich...");
    }
    catch(SQLException e){
      System.out.println("DB-Verbindungsfehler: "+e);
    }
    try{
      sqlStatement = dbVerbindung.createStatement();
      System.out.println("SQL-Statement erzeugen..");
      resultSet = sqlStatement.executeQuery(sqlString);
      while(resultSet.next()){
        return resultSet.getInt(x);
      }  
    }
    catch(SQLException e){
      System.out.println("Fehler beim DB-Zugriff!" +e);
    }
    finally{
      try{
        resultSet.close();
        System.out.println("resultSet-Objekt zerstören...");
        sqlStatement.close();
        System.out.println("SQL-Statement-Objekt zerstören...");
        dbVerbindung.close();
        System.out.println("Verbindung geschlossen...");
      }
      catch(SQLException e){
        System.out.println("Fehler beim DB-Schließen!" +e);
      }
    }
    return 0;
  }
  
  public boolean Registrieren(String Benutzername, String Passwort){
    if(DatensatzVergleichen(Benutzername)==false){
      return false;
    }
    else{
      
    int ID=IDkreieren();
    String sql = "INSERT INTO Spielerliste(ID,Benutzername,Passwort,VerlaufNr,Betrag,Gewinn) VALUES(?,?,?,?,?,?)";
 
    try{
      datensatzEinfuegen(sql,ID,Benutzername,Passwort,ID,500,0);
    }
    catch(SQLException e){
      System.out.println("Fehler beim Datensatz erstellen: "+e);
    }
    return true;
    }
  }
  
  public boolean DatensatzVergleichen(String Name){
    //for(int i=0;<=i;i++){
    String s="SELECT Benutzername FROM Spielerliste WHERE Benutzername='"+Name+"';";
    String vergleichswert=datenbankzugriffTestenString(s,1);
    if(vergleichswert==null){
      return true;
    }
    else{
      return false;
    }
  }
  
  
  public int IDkreieren(){
    String s="SELECT MAX(ID) FROM Spielerliste";
    int maxID=datenbankzugriffTestenint(s,1);
    return maxID+1;
  }
  
  
  public boolean Anmelden(String Name, String wort){
   String s="SELECT Benutzername FROM Spielerliste WHERE (Benutzername='"+Name+"' AND Passwort='"+wort+"')  ;";
    String vergleichswert=datenbankzugriffTestenString(s,1);
    if(vergleichswert==null){
      return false;
    }
    else{
      return true;
    }
  }
  /*
  BetragGeben
  Gewinngeben
  BenutzerNameGeben
  PasswortGeben
  IDGeben
  Anfangsmethode :1.benutzer
  Spielen : Zahl generien,Gwéwinn berechnen,
  
  */
}

//https://javabeginners.de/Datenbanken/SQLite-Datenbank.php
  
  