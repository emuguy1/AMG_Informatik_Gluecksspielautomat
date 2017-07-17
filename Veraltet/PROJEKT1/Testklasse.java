import java.sql.*;
import java.util.*;


public class Testklasse{
  public void testen(){
    for(Enumeration<Driver>e=DriverManager.getDrivers();e.hasMoreElements();)
    System.out.println(e.nextElement().getClass().getName());
  }
}