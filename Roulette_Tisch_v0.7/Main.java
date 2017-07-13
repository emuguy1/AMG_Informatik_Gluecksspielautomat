import javax.swing.*;
public class Main {
    
    
    public static void main(String[] args){
      Model m = new Spiel();
      Login l = new Login(new Controller(m));
        
    }
    
}
