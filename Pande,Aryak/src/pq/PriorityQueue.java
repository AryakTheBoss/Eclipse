package pq;

import java.util.Queue;

public interface PriorityQueue<E>{

	boolean isEmpty(); 

	void add(E x); 

	E poll();

	//Retrieves, but does not remove, the head of this queue, returning null if this queue is empty. 

	E peek();

	//Retrieves and removes the head of this queue, or null if this queue is empty. 

	int size();
	
}
