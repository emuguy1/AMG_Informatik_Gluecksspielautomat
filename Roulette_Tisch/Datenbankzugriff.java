import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbankzugriff{
    
  public void sqlAbfrage(){
    String s="SELECT Benutzername FROM Spielerliste WHERE ID='2'";
    datenbankzugriffString(s,1);
  }
  private void datensatzEinfuegen(String sqlAbfrage, int ID, String Benutzername, String Passwort, int VerlaufNr, int Betrag, double Gewinn ) throws SQLException{
    Connection dbVerbindung = null;
    Statement sqlStatement = null;
    String sqlString = sqlAbfrage;
    
    //Treiber laden
    try{
      Class.forName("org.sqlite.JDBC");
      System.out.println("Treiber erfolgreich geladen ...");
    }
    catch(ClassNotFoundException e){
      System.out.println("Fehler beim Laden des Treibers " + e);
    }
    //Verbindung aufbauen
    try{
      System.out.println("DB-Verbindung aufbauen ...");
      dbVerbindung = DriverManager.getConnection("jdbc:sqlite:res/test4.db");
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

  
  public String datenbankzugriffString(String sqlAbfrage, int x){
    Connection dbVerbindung = null;
    Statement sqlStatement = null;
    String sqlString =sqlAbfrage;
    ResultSet resultSet = null;

  
    try{
      Class.forName("org.sqlite.JDBC");
      System.out.println("Treiber erfolgreich geladen ...");
    }
    catch(ClassNotFoundException e){
      System.out.println("Fehler beim Laden des Treibers " + e);
    }
    
    try{
      System.out.println("DB-Verbindung aufbauen ...");
      dbVerbindung =
      DriverManager.getConnection("jdbc:sqlite:res/test4.db");
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
  public int datenbankzugriffInt(String sqlAbfrage, int x){
    Connection dbVerbindung = null;
    Statement sqlStatement = null;
    String sqlString =sqlAbfrage;
    ResultSet resultSet = null;

  
    try{
      Class.forName("org.sqlite.JDBC");
      System.out.println("Treiber erfolgreich geladen ...");
    }
    catch(ClassNotFoundException e){
      System.out.println("Fehler beim Laden des Treibers " + e);
    }
    
    try{
      System.out.println("DB-Verbindung aufbauen ...");
      dbVerbindung =
      DriverManager.getConnection("jdbc:sqlite:res/test4.db");
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
 
  public boolean registrieren(String Benutzername, String Passwort){
    if(datensatzVergleichen(Benutzername)==false){
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
  
  public boolean datensatzVergleichen(String Name){
    //for(int i=0;<=i;i++){
    String s="SELECT Benutzername FROM Spielerliste WHERE Benutzername='"+Name+"';";
    String vergleichswert=datenbankzugriffString(s,1);
    if(vergleichswert==null){
      return true;
    }
    else{
      return false;
    }
  }
  
  
  public int IDkreieren(){
    String s="SELECT MAX(ID) FROM Spielerliste";
    int maxID=datenbankzugriffInt(s,1);
    return maxID+1;
  }
  
  
  public boolean anmelden(String Name, String wort){
    String s="SELECT Benutzername FROM Spielerliste WHERE (Benutzername='"+Name+"' AND Passwort='"+wort+"')  ;";
    String vergleichswert=datenbankzugriffString(s,1);
    if(vergleichswert==null){
      return false;
    }
    else{
      return true;
    }
    
  }
  public String betragGeben(String benutzername){
    String s="SELECT Betrag FROM Spielerliste WHERE Benutzername ='"+benutzername+"'";
    return datenbankzugriffString(s,1);
    
  }
  
  public void gewinnHinzufuegen(String Name,int Gewinn)throws SQLException{
    
    String s="UPDATE Spielerliste SET Betrag=Betrag+'"+Gewinn+"',Gewinn='"+Gewinn+"' WHERE Benutzername='"+Name+"';";
    try{
      datenbankzugriffTestenvoid(s);
    }
    catch(SQLException e){
      System.out.println("Fehler beim Update des Betrags!");
    }
  }
 
  private void datenbankzugriffTestenvoid(String sqlAbfrage) throws SQLException{
    Connection dbVerbindung = null;
    Statement sqlStatement = null;
    String sqlString = sqlAbfrage;
    
    //Treiber laden
    try{
      Class.forName("org.sqlite.JDBC");
      System.out.println("Treiber erfolgreich geladen ...");
    }
    catch(ClassNotFoundException e){
      System.out.println("Fehler beim Laden des Treibers " + e);
    }
    //Verbindung aufbauen
    try{
      System.out.println("DB-Verbindung aufbauen ...");
      dbVerbindung = DriverManager.getConnection("jdbc:sqlite:res/test4.db");
      System.out.println("Verbindung erfolgreich...");
    }
    catch(SQLException e){
      System.out.println("DB-Verbindungsfehler: "+e);
    }
    try {
      PreparedStatement pstmt = dbVerbindung.prepareStatement(sqlAbfrage);
    
      pstmt.executeUpdate();
      
      dbVerbindung.close();
      System.out.println("Verbindung geschlossen...");
    }catch (SQLException e) {
      System.out.println(e.getMessage());
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


  
  