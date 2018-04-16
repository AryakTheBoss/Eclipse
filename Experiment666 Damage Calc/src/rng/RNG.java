/**
 * 
 */
package rng;

import java.util.Random;

/**
 * @author parya
 * DO NOT CHANGE
 *
 */
public class RNG implements Runnable{
	
	private int currentRNG = 0;
	private Random r = new Random();
	
	public RNG() {
		
		new Thread(this).start();
		
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("Im sexy");
		for(;;) {
			currentRNG = r.nextInt(65536);
		}
		
	}
	public int getCurrentRNG() {
		return currentRNG;
	}
	

}
