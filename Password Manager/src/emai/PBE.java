/**
 * 
 */
package emai;

/**
 * @author Aryak
 *
 */
import java.awt.Color;
import java.awt.Dimension;



//import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JPanel;


	

//import javax.swing.SwingUtilities;

	public class PBE extends JPanel {

	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		JProgressBar pbar;
		JLabel sdf = new JLabel();

		  static final int MY_MINIMUM = 0;

		  static final int MY_MAXIMUM = 100;

		  public PBE() {
		    pbar = new JProgressBar();
		    pbar.setPreferredSize(new Dimension(330,70));   
		 //  setLocation(0, 0);
		    pbar.setMinimum(MY_MINIMUM);
		    pbar.setMaximum(MY_MAXIMUM);
		    pbar.setForeground(Color.blue);
		    sdf.setText("Press Start!");
		   // sdf.setFont(f); 
		    add(sdf);
		    add(pbar);
		    
		  }

		  public void updateBar(int newValue,String per) {
		    pbar.setValue(newValue);
		    sdf.setText(per);
		    
		  }
		  public void setPrefSize(int width,int height){
			  
			  pbar.setPreferredSize(new Dimension(width,height));   
			  
		  }

	/*  public static void main(String args[]) {

	    final PBE it = new PBE();

	    JFrame frame = new JFrame("Progress Bar Example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setContentPane(it);
	    frame.pack();
	    frame.setVisible(true);

	    for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
	      final int percent = i;
	      try {
	        SwingUtilities.invokeLater(new Runnable() {
	          public void run() {
	            it.updateBar(percent);
	          }
	        });
	        java.lang.Thread.sleep(100);
	      } catch (InterruptedException e) {
	        ;
	      }
	    }
	  }*/
	  
	}
		
