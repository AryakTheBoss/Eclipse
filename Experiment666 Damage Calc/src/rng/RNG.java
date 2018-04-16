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
	public int getCurrentRNG() {
		return currentRNG;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;) {
			currentRNG = r.nextInt(65536);
		}
		
	}
	

}
