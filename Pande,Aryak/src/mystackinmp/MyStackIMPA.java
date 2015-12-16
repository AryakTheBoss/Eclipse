/**
 * 
 */
package mystackinmp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 17ap0497
 *
 *
 */
public class MyStackIMPA implements MyStack{
	
	private LinkedList<Object> trash = new LinkedList<Object>();

	@Override
	public Object offer(Object item) {
		
		trash.addLast(item); 
		
		return item;
	}

	@Override
	public Object poll() {
		
		Object pop = trash.getLast();
		
		
		trash.removeLast();
		
		return pop;
	}

	@Override
	public Object peek() {
		
		return trash.getFirst();
	}

	@Override
	public boolean isEmpty() {
		
		return size() == 0;
	}

	@Override
	public int size() {		
		return trash.size();
	}

	@Override
	public int search(Object a) {			
		return trash.indexOf(a) == -1 ? -1 : trash.indexOf(a)+1;
	}
	public String toString(){
		
		return trash.toString();
		
	}
	

}
