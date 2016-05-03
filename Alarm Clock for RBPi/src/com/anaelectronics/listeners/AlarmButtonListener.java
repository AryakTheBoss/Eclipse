/**
 * 
 */
package com.anaelectronics.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.anaelectronics.AlarmClock;
import com.anaelectronics.handlers.AlarmHandler;

/**
 * @author ARYAK
 *
 */
public class AlarmButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(AlarmClock.alarmOn.isSelected()){
			try {
				AlarmHandler.start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else{
			AlarmHandler.off();
			AlarmHandler.snooze.setEnabled(true);
		}
		
	}

}
