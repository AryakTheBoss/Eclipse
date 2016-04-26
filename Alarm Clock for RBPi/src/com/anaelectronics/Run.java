/**
 * 
 */
package com.anaelectronics;




import java.awt.FontFormatException;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.anaelectronics.handlers.TimeHandler;
import com.anaelectronics.listeners.AlarmSetListener;

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
		
	setLookAndFeel();
	AlarmSetListener.cal.set(Calendar.HOUR , 12);
	AlarmSetListener.cal.set(Calendar.AM_PM , Calendar.AM);
	AlarmSetListener.cal.set(Calendar.MINUTE , 0);
		AlarmClock.openUI();
		TimeHandler.start();
		
		
		
	}
	public static void setLookAndFeel(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}

	}
	
}
