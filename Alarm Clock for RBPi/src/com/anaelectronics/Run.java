/**
 * 
 */
package com.anaelectronics;


import com.anaelectronics.listeners.ServerTimeChecker;
import com.anaelectronics.listeners.TimeCounter;

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
		
		TimeCounter.start();
		ServerTimeChecker.start();
		AlarmClock.openUI();
	}
	
}
