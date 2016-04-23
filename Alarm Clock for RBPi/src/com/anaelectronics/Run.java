/**
 * 
 */
package com.anaelectronics;




import com.anaelectronics.listeners.TimeHandler;

import java.awt.FontFormatException;
import java.io.IOException;

/**
 * @author ARYAK
 *
 */
public class Run {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public static void main(String[] args) throws IOException, FontFormatException  {
		// TODO Auto-generated method stub
		AlarmClock.openUI();
		TimeHandler.start();
		
		
	}
	
}
