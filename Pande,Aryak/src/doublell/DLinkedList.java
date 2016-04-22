package doublell;



public class DLinkedList { 

private DListNode firstNode; 

private DListNode lastNode; 

/** 

 * Construct an empty list 

 */ 

public DLinkedList() { 

firstNode = null; 

lastNode = null; 

} 

/** 

 * Returns true if the list contains no elements 

 */ 

public boolean isEmpty(){
	
	return size() == 0;
	
	
}

/** 

 * Inserts the argument as the first element of this list. 

 */ 

public void addFirst(Object o) {
	
	DListNode temp = firstNode;
	if(firstNode == null){
		firstNode = new DListNode(o,null,null);
		
	}
	else{
		 firstNode = new DListNode(o,temp,null);
		
	}
	
}

/** 

 * Inserts the argument as the last element of this list. 

 */ 

public void addLast(Object o){
	
	DListNode temp = lastNode;
	if(lastNode == null){
		lastNode = new DListNode(o,null,null);
		
	}
	else
	{
		lastNode = new DListNode(o, null, temp);
	}
	
}

/** 

 * Removes and returns the first element of this list. 

 */ 

public Object removeFirst(){
	
	DListNode temp = firstNode;
	firstNode.setValue(null);
	return temp;
	
}

/** 

 * Removes and returns the last element of this list. 

 */ 

public Object removeLast(){
	
	DListNode temp = lastNode;
	lastNode.setValue(null);
	return temp;
	
}

/** 

 * Returns a String representation of the list. 

 */ 

public String toString(){
	
	String output = "";
	DListIterator iter = iterator();
	while (iter.hasNext())
	{
		
		output += iter.next().toString()+" ";
		
	}
	return output;
}

/** 

 * Returns the number of elements in the list as an int. 

 */

public int size() {
	
	DListIterator iter = iterator();
	int count = 0;
	while(iter.hasNext()){
		iter.next();
		count++;
	}
	return count;
	
}

/** 

 * Removes all of the elements from this list. 

 */ 

private void clear() { 
	/*DListIterator iter = iterator();
	while(iter.hasNext()){
		iter.next();
		iter.remove();
	}*/
	firstNode = null;
	lastNode = null;
}

/** 

 * Returns a DListIterator. 

 */ 

public DListIterator iterator() { 

return new DListIterator(this,firstNode); 

}
}
