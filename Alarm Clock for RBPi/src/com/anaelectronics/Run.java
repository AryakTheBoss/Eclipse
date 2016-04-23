/**
 * 
 */
package com.anaelectronics;




import java.awt.FontFormatException;
import java.io.IOException;

import com.anaelectronics.handlers.AlarmHandler;
import com.anaelectronics.handlers.TimeHandler;

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
