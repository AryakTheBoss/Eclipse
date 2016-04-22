/**
 * 
 */
package com.anaelectronics;

/**
 * @author ARYAK
 * This class contains the global variables
 */
public class Globals {
	
	public static int time = 0;
	public static int alarm = -1;
	public static int hours = 0;
	public static int minutes = 0;
	public static int seconds = 0;
	public static String displayedTime = null;
	public static String displayedAlarm = null;
	public static final String alarmSymbol = "🔔"; //Symbol that'll be displayed when alarm is enabled
	public static boolean PM = false;
	public static long syncFrequency = 10800000; //(every 3 hours)(Changable by user)
	

}
