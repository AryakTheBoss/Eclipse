/**
 * 
 */
package linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author 17ap0497
 *
 */
public class Fruit {

	/**
	 * @param args
	 */
	private LinkedList<String> bowl;
	
	public Fruit(){
		
		bowl = new LinkedList<String>();
		bowl.addLast("apple");
		bowl.addLast("banana");
		bowl.addLast("cherry");
		bowl.addLast("lemon");
		bowl.addLast("lime");
		bowl.addLast("orange");
		bowl.addLast("papaya");
		bowl.addLast("strawberry");
		bowl.addLast("watermelon");
		
		
	}
	public void displayFruit(){
		
		ListIterator<String> k = bowl.listIterator();
		while(k.hasNext()){
			
			System.out.println(k.next());
			if(k.hasNext())
			k.next();
		}
		
	}
	public static void main(String[] args){
		
		Fruit f = new Fruit();
		f.displayFruit();
		
	}

}
