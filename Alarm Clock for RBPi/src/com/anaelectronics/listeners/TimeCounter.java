/**
 * 
 */
package com.anaelectronics.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import com.anaelectronics.Globals;

/**
 * @author ARYAK
 *	This class counts the time
 */
public class TimeCounter implements Runnable{

	private static Thread t = null;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread thisThread = Thread.currentThread();
		while(t == thisThread){
		
			if(Globals.seconds < 59){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Globals.seconds++;
			}else{
				Globals.seconds = 0;
				Globals.minutes++;
			}
			
			if(Globals.minutes > 59){
				Globals.hours++;
				Globals.minutes = 0;
			}
			
			if(Globals.hours > 23){
				Globals.hours = 0;
			}
		convertTime();
		}
	}
	public static void start() throws IOException{
		getTimeFromServer();
		t = new Thread(new KeyboardListener());
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
		
		Globals.displayedTime += ""+(Globals.hours >= 12 ? Globals.hours-12 : Globals.hours)+":"+Globals.minutes+"  "+(Globals.PM ? "PM":"AM");
		
	}
	private static void getTimeFromServer() throws IOException{
		
		String TIME_SERVER = "time-c.nist.gov";   
		NTPUDPClient timeClient = new NTPUDPClient();
		InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
		TimeInfo timeInfo = timeClient.getTime(inetAddress);
		long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
		Date time = new Date(returnTime);
		System.out.println(time.toString());
		String[] ti = time.toString().split(" ")[3].split(":");
		
		Globals.hours = Integer.parseInt(ti[0]);
		Globals.minutes = Integer.parseInt(ti[1]);		
		Globals.seconds = Integer.parseInt(ti[2]);
		
	}
	
	
}
