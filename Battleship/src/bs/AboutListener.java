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
public class AboutListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JOptionPane.showMessageDialog(null, "Battleship v3.1b\nMade by: DatJavaMaster(AryakTheBoss)\nIf you want to contribute to the development,\nPlease send me feedback at java.safe.dev@gmail.com");  
		
		
	}

}
