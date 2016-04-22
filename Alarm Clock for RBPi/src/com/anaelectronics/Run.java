/**
 * 
 */
package com.anaelectronics;

import com.anaelectronics.listeners.KeyboardListener;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
/**
 * @author ARYAK
 *
 */
public class Run {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		getTimeFromServer();
		
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
		Globals.time = (Integer.parseInt(ti[0])*100)+(Integer.parseInt(ti[1]));
		System.out.println(Globals.time);
		
	}
}
