/**
 * 
 */
package bs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * @author UnityBoss
 *aer
 */
public class HelpListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JOptionPane.showMessageDialog(null, "Welcome to Battleship! \n Place ships on the board by selecting a ship and a direction and then placing it. \n once placed, pick the next ship. \n when all have been placed, press start.\n before clicking you can also visit the shop to buy Items that will help you win.\n you get money form sinking ships and lose money by cpu sinking yours. \n your data is obviosly saved. \nto take shots, simply click on the board that DOES NOT have the cyan ships on it.(IOW dont fire on your own board)\nHits are marked with red and misses are marked as blue.\n to use an item simply click the Items dropdown menu and click the item you would like to use \n then click where on the board you want to use it.", "Help", JOptionPane.INFORMATION_MESSAGE);     
		
	}

}
