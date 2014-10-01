/**
 * 
 */
package com.javaboss.elements;

/**
 * @author UnityBoss
 *
 */
public class CounterThread implements Runnable {
	
	private volatile boolean running = true;
	public CounterThread(){}
	@Override
	public void run() {
		for(;;){
			while(running == false){;;}
		Comps.timer.nextCount();
		try{
		Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		

		}
		}
	 
	 public void pause() throws InterruptedException{
		 
		 running = false;
		 
	 }
	 public void resume(){
		 
		 running = true;
	 }
	 
	 public static void m(){
		 (new Thread(new CounterThread())).start();
	 }
	
    }


