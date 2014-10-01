/**
 * 
 */
package com.javaboss.elements;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.javaboss.main.Game;

/**
 * This class checks the mouse button for clicks so you cant cheat :P
 * 
 * @author UnityBoss
 *
 */
public class TapListener implements MouseListener {
	
	
	private Game g = new Game();
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		//bleh
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		g.setPress(true);		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		g.setPress(false);
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
		g.setIn(true);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
		g.setIn(false);
		
	}

	

	
	
	
	

}
