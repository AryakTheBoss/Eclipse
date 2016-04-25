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

public class PQRunner
{
	public static void main ( String[] args )
	{
		YourPQ test = new YourPQ();

		Scanner keyboard=new Scanner(System.in);




		//loop to read in values and instantiate your Objects
		test.add(new Monster(1,1,1));
		test.add(new Monster(2,2,2));
		test.add(new Monster(1,2,3));
		test.add(new Monster(3,2,1));
		test.add(new Monster(2,1,3));
		test.add(new Monster(2,3,1));
		test.add(new Monster(3,1,2));
		test.add(new Monster(3,3,3));
		
		
	
	


		System.out.println(test);
		System.out.println("getMin() - " + test.getMin());
		System.out.println("removeMin() - " + test.removeMin());		
		System.out.println(test);
System.out.println("\n");
		
		System.out.println("Getmin - "+test.getMin());
		System.out.println("removemin - "+test.removeMin());
		System.out.println(test);
		
		
		//add more test cases
		
			
	}
}