//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -  
//Lab  -
package pq;

import java.util.Scanner;

public class MonsterPQRunner
{
	public static Scanner s = new Scanner(System.in);
	public static void main ( String[] args )
	{
		//System.out.println("How many monsters u wanting to add?");
		//add test cases	
		MonsterPQ aa = new MonsterPQ();
		
		
		aa.add(new Monster(1,1,1));
		aa.add(new Monster(2,2,2));
		aa.add(new Monster(1,2,3));
		aa.add(new Monster(3,2,1));
		aa.add(new Monster(2,1,3));
		aa.add(new Monster(2,3,1));
		aa.add(new Monster(3,1,2));
		aa.add(new Monster(3,3,3));
		/*
		 * 111
		 * 222
		 * 123
		 * 321
		 * 213
		 * 231
		 * 312
		 * 333
		 */
		System.out.println(aa);
		System.out.println("Getmin - "+aa.getMin());
		System.out.println("removemin - "+aa.removeMin());
		System.out.println(aa);
		
		System.out.println("\n");
		
		System.out.println("Getmin - "+aa.getMin());
		System.out.println("removemin - "+aa.removeMin());
		System.out.println(aa);
		
	}
}