/**
 * 
 */
package bs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
//d
/**
 * @author UnityBoss
 *
 */
public class NukeListener implements ActionListener{

	private static boolean using = false;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(Battleship.allowedItems == true){
			
			System.out.println("Trying to use Nuke...");
			try {
				if(Player.saveGame("Nuke",false)){
					
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
