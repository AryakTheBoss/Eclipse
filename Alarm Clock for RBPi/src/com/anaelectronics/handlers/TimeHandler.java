/**
 * 
 */
package com.anaelectronics.handlers;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



import com.anaelectronics.AlarmClock;
import com.anaelectronics.Globals;

/**
 * @author ARYAK
 *	This class counts the time
 */
public class TimeHandler implements Runnable{

	private static Thread t = null;
	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	private static Calendar cal = null;
	private static String[] ti = null;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread thisThread = Thread.currentThread();
		while(t == thisThread){
		
		try {
			getTimeFromSystem();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		convertTime();
		AlarmClock.updateDisplay();
		//blinkColon();
	}
	}
	public static void blinkColon(){
		try {
			Thread.sleep(Globals.blinkDelay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Globals.displayColon = !Globals.displayColon;
		
		}
	

	public static void start() throws IOException{
		
		t = new Thread(new TimeHandler());
		t.start();
	}
	public static void stop(){
		t = null;
	}
	public static void convertTime(){
		
		if(Globals.hours >= 12)
			Globals.PM = true;
		else
			Globals.PM = false;
		
		Globals.displayedTime = ""+(Globals.hours >= 12 ? Globals.hours-12 : Globals.hours)+(Globals.displayColon ? ":" : " ")+(Globals.minutes < 10 ? "0"+Globals.minutes : Globals.minutes)+"  "+(Globals.PM ? "PM":"AM");
		
	}
	private static void getTimeFromSystem() throws IOException{
		
		
		 
		 cal = Calendar.getInstance();	       
	       
	        
		 ti = sdf.format(cal.getTime()).split(":");
		
		Globals.hours = Integer.parseInt(ti[0]);
		Globals.minutes = Integer.parseInt(ti[1]);		
		Globals.seconds = Integer.parseInt(ti[2]);
		 
	}
	
	
}
