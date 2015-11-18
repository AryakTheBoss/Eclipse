/**
 * 
 */
package doublell;

import mylinkedlist.ListNode;

/**
 * @author 17ap0497
 *
 */
public class DListIterator  { 

private DListNode current; 

private DListNode previous; 

private DLinkedList myList; 

private boolean canRemove; // for remove() method. true if OK to call 

	public DListIterator(DLinkedList list) { 

		myList = list; 

		current = null; 

		previous = null; 

		canRemove = false; 

	} 

@Override
public String toString(){
	
	String output="";

   	output += (current.getValue()+" ");
	   while(current.next() != null){
		   current = current.next();
		   output+=(current.getValue()+" ");
		 
		   
	   }
	   return output;
	
}

public boolean hasPrevious(){
	return previous != null;
}

public boolean hasNext() {
	return current.next() != null;
}

public Object next() {
	previous = current;
	current = current.next();
	return current.getValue();
}

public Object previous(){
	current = current.previous();
	
	return current;
}

public void remove() {
	
	previous.setNext(current.next());
	current = previous.next();
}

public void add(Object element) {
	current.setNext(new DListNode(element,current.next(),current));
}

public void set(Object element){
	
	current.setValue(element);
	
}

}
