//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -
package pq;
import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class MonsterPQ  
{
	private PriorityQueue<Monster> pQueue = new PriorityQueue<Monster>();

	public MonsterPQ()
	{
		
		
	}

	public void add(Monster obj)
	{
		
		pQueue.add(obj);
		
	}
	
	public Object getMin()
	{
		return pQueue.peek();
	}
	
	public Object removeMin()
	{
		return pQueue.remove();
	}
	
	public String getNaturalOrder()
	{
		String output="";
		while(!pQueue.isEmpty()){
			
			output+=pQueue.poll()+" ";
			
		}
		return output;			
	}
    public String toString(){
		
		return pQueue.toString();
		
	}
	//write a toString method
}