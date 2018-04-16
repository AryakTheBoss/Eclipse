/**
 * 
 */
package rng;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author parya
 * DO NOT CHANGE
 *
 */
public class RNG implements Runnable{
	
	
	private Random r = new Random();
	private BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(10);
	
	public RNG() {
		
		new Thread(this).start();
		
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("Im sexy");
		for(;;) {
			try {
				q.put(r.nextInt(65536));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}
		}
		
	}
	public int getCurrentRNG() throws InterruptedException {
		return q.take();
	}
	

}
