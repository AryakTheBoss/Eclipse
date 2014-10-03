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
public class SFListener implements ActionListener{

	private static boolean using = false;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(Battleship.allowedItems == true){
			
	System.out.println("Trying to use Ship Finder...");
	try {
		if(Player.saveGame("Ship Finder",false)){
			
			using = true;
			
		}
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
			
		}
	}
	
	public static boolean isUsing(){return using;}
	public static void setUsing(boolean flag){using = flag;}

}
