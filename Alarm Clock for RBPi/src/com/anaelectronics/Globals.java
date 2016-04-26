/**
 * 
 */
package com.anaelectronics;

/**
 * @author ARYAK
 * This class contains the global variables
 */
public class Globals {
	
	
	
	public static int hours = 0;
	public static int minutes = 0;
	public static int seconds = 0;
	public static int ahours = 0;
	public static int aminutes = 0; //These are hh:mm for the alarm	
	public static String displayedTime = null; //Time that is shown on the clock face
	public static String displayedAlarm = "12:00 AM"; //Alarm that is displayed on clock face
	public static final String alarmSymbol = ""; //Symbol that'll be displayed when alarm is enabled
	public static boolean PM = false; //is it PM or AM
	public static boolean aPM = false;
	public static String date = "";
	public static boolean displayColon = true; //ignore this
	public static int blinkDelay = 600; //ignore this
	public static boolean alarm = false; //is alarm on?
	public static boolean snoozed = false; //has it been snoozed?
	
	

}
