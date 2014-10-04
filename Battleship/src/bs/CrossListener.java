/**
 * 
 */
package bs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author UnityBoss
 *
 */
public class CrossListener implements ActionListener{
	private static boolean using = false;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(Battleship.allowedItems == true){
			
			System.out.println("Trying to use Cross Fire...");
			try {
				Player.saveGame("Cross Fire",false);
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
