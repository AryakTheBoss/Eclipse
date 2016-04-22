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
		
	}
	public static void start(){
		t = new Thread(new KeyboardListener());
		t.start();
	}
	public static void pause() throws InterruptedException{
		t.wait();
	}
	public static void resume(){
		
	}
}
