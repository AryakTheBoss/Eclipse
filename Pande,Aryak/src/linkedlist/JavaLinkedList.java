package linkedlist;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

import static java.lang.System.*;

public class JavaLinkedList
{
	private LinkedList<Integer> list;

	public JavaLinkedList()
	{
		list = new LinkedList<Integer>();
	}

	public JavaLinkedList(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}

	public double getSum(  )
	{		
		
		return list.stream().mapToInt(Integer::intValue).sum();
	}

	public double getAvg(  )
	{
		return (double)list.stream().mapToInt(Integer::intValue).sum()/list.size();
	}

	public int getLargest()
	{
		int largest=Integer.MIN_VALUE;
		ListIterator<Integer> yo = list.listIterator();
		int y = 0;
		while(yo.hasNext()){
			y = yo.next();
			if(y > largest){
				largest = y;
			}
			
		}
		return largest;
	}

	public int getSmallest()
	{
		int smallest = Integer.MAX_VALUE;
		ListIterator<Integer> yo = list.listIterator();
		int y = 0;
		while(yo.hasNext()){
			y = yo.next();
			if(y < smallest){
				smallest = y;
			}
			
		}
		return smallest;
	}

	public String toString()
	{
		
		return Arrays.toString(list.toArray());
	}
}