/**
 * 
 */
package com.anaelectronics.handlers;

import java.io.IOException;

import com.anaelectronics.AlarmClock;
import com.anaelectronics.Globals;

/**
 * @author ARYAK
 *	This checks when to sound alarm if its set and on
 */
public class AlarmHandler implements Runnable{
	

	private static Thread t = null;
	
	
@Override
public void run() {
	// TODO Auto-generated method stub
	
	Thread thisThread = Thread.currentThread();
	
	while(t == thisThread){
		
		
		
	}
	
}

public static void start() throws IOException{
	
	t = new Thread(new AlarmHandler());
	t.start();
}
public static void convertTime(){
	
	if(Globals.ahours >= 12)
		Globals.aPM = true;
	else
		Globals.aPM = false;
	
	if(Globals.ahours != 0)
	Globals.displayedAlarm = "Alarm: "+(Globals.ahours >= 12 ? Globals.ahours-12 : Globals.ahours)+":"+(Globals.aminutes < 10 ? "0"+Globals.aminutes : Globals.aminutes)+"  "+(Globals.aPM ? "PM":"AM");
	else
		Globals.displayedAlarm = "Alarm: "+(12)+":"+(Globals.aminutes < 10 ? "0"+Globals.aminutes : Globals.aminutes)+"  "+(Globals.aPM ? "PM":"AM");
}
public static void ring(){
	
}
public static void snooze(){
	
}
public static void stopAlarm(){
	
}
public static void off(){
	
	t = null;
	
}

}
