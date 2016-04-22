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
 *
 */
public class ServerTimeChecker implements Runnable{

	
	private static Thread t = null;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(Globals.syncFrequency == -1)
			stop();
		
		Thread thisThread = Thread.currentThread();
		while(t == thisThread){
			
			try {
				Thread.sleep(Globals.syncFrequency);
				checkTimeWithServer();
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void start() throws IOException{
		
		t = new Thread(new KeyboardListener());
		t.start();
	}
	public static void stop(){
		t = null;
	}
	public static void checkTimeWithServer() throws IOException{
		
		String TIME_SERVER = "time-c.nist.gov";   
		NTPUDPClient timeClient = new NTPUDPClient();
		InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
		TimeInfo timeInfo = timeClient.getTime(inetAddress);
		long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
		Date time = new Date(returnTime);
		System.out.println(time.toString());
		String[] ti = time.toString().split(" ")[3].split(":"); //Split date returned into time only
		
		if(Globals.hours != Integer.parseInt(ti[0]) || Globals.minutes != Integer.parseInt(ti[1]) || Globals.seconds != Integer.parseInt(ti[2])){
			
			Globals.hours = Integer.parseInt(ti[0]);
			Globals.minutes = Integer.parseInt(ti[1]);		
			Globals.seconds = Integer.parseInt(ti[2]);
			
		}
		
		
	}
	
	
	
	

}
