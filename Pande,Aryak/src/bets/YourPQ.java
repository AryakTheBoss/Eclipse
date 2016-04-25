package bets;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

import pq.Monster;

public class YourPQ
{
	private PriorityQueue<Monster> pQueue = new PriorityQueue<Monster>();

	public YourPQ()
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