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
public class NukeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(Battleship.allowedItems == true){
			
			JOptionPane.showMessageDialog(null, "Nuke Pressed");
			
			
		}
		
		
	}
	
	
	

}
