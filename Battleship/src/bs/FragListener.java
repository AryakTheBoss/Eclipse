/**
 * 
 */
package bs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JOptionPane;
//dytj
/**
 * @author UnityBoss
 *
 */
public class FragListener implements ActionListener{

	private static boolean using = false;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(Battleship.allowedItems == true){
			
	System.out.println("Trying to use Frag Bomb...");
	try {
		Player.saveGame("Frag Bomb",false);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  
		
	using = true;
			
			
		}
	}
	
	public static boolean isUsing(){return using;}
	public static void setUsed(boolean flag){using = flag;}

}
