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
			
			try {
				Player.saveGame("Torpedo",false);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			using = true;
			
		}
	}
	
	public static boolean getUsing(){return using;}
	public static void setUsing(boolean flag){using = flag;}
	

}
