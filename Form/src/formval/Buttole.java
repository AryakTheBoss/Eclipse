package formval;

import javax.swing.*;
import javax.swing.event.*;

public class Buttole extends JFrame implements ChangeListener {

   JButton b;
   
   public static void main (String[] args) {
      new Buttole();
   }

   public Buttole () {
      b = new JButton("Press me");
      b.addChangeListener(this);
      getContentPane().add(b);
      setSize(100,100);
      setVisible(true);
   }

   public void stateChanged (ChangeEvent e) {
      System.out.println("isArmed "+b.getModel().isArmed());
      System.out.println("isPressed "+b.getModel().isPressed());
      System.out.println("isRollover "+b.getModel().isRollover());
      System.out.println();
   }

}
