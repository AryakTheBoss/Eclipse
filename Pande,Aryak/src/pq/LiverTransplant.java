/**
 * 
 */
package pq;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 17ap0497
 *
 */
public class LiverTransplant implements PriorityQueue<Patient>{
	
	private LinkedList<Patient> rekt = new LinkedList<Patient>();

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return rekt.isEmpty();
	}

	@Override
	public void add(Patient x) {
		// TODO Auto-generated method stub
		if(isEmpty())
			rekt.addLast(x);
		else if(rekt.getFirst().compareTo(x) == 1)
			rekt.addFirst(x);
		else if(rekt.getFirst().compareTo(x) == 0)
			rekt.addFirst(x);
		else
			rekt.addLast(x);
		
		
		
		
		
	}

	
	@Override
	public Patient poll() {
		
	
		return rekt.poll();
	
	}

	@Override
	public Patient peek() {
		// TODO Auto-generated method stub
		return rekt.peek();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return rekt.size();
	}

	public String toString(){
		
		return rekt.toString();
		
	}
			
			
	
	
}
