/**
 * 
 */
package bs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JOptionPane;

/**
 * @author UnityBoss
 *
 */
public class RayListener implements ActionListener{
	
	private static boolean rayUsing = false;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(Battleship.allowedItems == true){
			System.out.println("Trying to use Ray...");
		try {
			Player.saveGame("Confusion Ray",false);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
			
		rayUsing = true;
			
		}
	}
	
	public static boolean isUsed(){return rayUsing;}
	public static void setUsed(boolean flag){rayUsing = flag;}
	
	

}
