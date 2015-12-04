/**
 * 
 */
package bets;

import java.io.Serializable;
import java.util.Stack;
import java.util.Vector;

/**
 * @author 17ap0497
 *
 */
public class ArithmeticOPS extends Thread{
	
	private Stack<String> ops;
	private Stack<String> nums;
	
	
	Vector<String> queue = new Vector<String>();
	
	public ArithmeticOPS(){
		ops = null;
		nums = null;
		
	}
	
	public int parseExp(){
		
		return 0; //CALCULATE SOME SHIT
		
	}
	public synchronized void processQueue(){
		String arg = null;
		arg = queue.firstElement();
		queue.removeElementAt(0);
		
	}
	
	
	
	public synchronized void addToQueue(String arg) {
		queue.add(arg);
		notify();

	}

	public void run() {
		try {
			while (!interrupted()) {
				if (queue.isEmpty())
					wait();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}