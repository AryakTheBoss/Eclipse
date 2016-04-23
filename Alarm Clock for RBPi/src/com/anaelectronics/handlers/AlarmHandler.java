/**
 * 
 */
package com.anaelectronics.handlers;

import java.io.IOException;

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
