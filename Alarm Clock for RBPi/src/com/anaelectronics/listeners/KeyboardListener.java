/**
 * 
 */
package com.anaelectronics.listeners;

/**
 * @author ARYAK
 *
 */
public class KeyboardListener implements Runnable{

	private static Thread t = null;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread thisThread = Thread.currentThread();
		while(t == thisThread){
		
			//Listen for keyboard
		
		}
	}
	public static void start(){
		t = new Thread(new KeyboardListener());
		t.start();
	}
	public static void stop() throws InterruptedException{
		t = null;
	}
	
}
