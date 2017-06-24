import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BackgroundImageJFrame extends JFrame
{
   JButton b1;
   JLabel l1;
   public BackgroundImageJFrame()
     {
      setTitle("Background Color for JFrame");
      setSize(960,640);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      
      setLayout(new BorderLayout());
      setContentPane(new JLabel(new ImageIcon("E:\\nice.jpg")));
      setLayout(new BorderLayout());
      l1=new JLabel(":");
      b1=new JButton("anmelden");
      b1.setMaximumSize(new Dimension(40,60));
      add(l1, BorderLayout.PAGE_START);
      add(b1,BorderLayout.PAGE_START);
      getContentPane().repaint();
      revalidate();
      repaint();
      setVisible(true);

    }
   public static void main(String args[]){
      new BackgroundImageJFrame();
   }
} 
//https://stackoverflow.com/questions/18777893/jframe-background-image; https://docs.oracle.com/javase/tutorial/uiswing/layout/problems.html