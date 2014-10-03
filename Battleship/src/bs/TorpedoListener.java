/**
 * 
 */
package bs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * @author UnityBoss
 *
 */
public class TorpedoListener implements ActionListener{
	
	private static boolean using = false;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(Battleship.allowedItems == true){ //FIXME UPDATE MENU
			
	System.out.println("Trying to use Torpedo...");
			try {
				if(Player.saveGame("Torpedo",false)){
					
					using = true;
					
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
	}
	
	public static boolean getUsing(){return using;}
	public static void setUsing(boolean flag){using = flag;}
	

}
