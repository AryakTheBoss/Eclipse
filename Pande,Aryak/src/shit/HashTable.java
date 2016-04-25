package shit;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

import static java.lang.System.*;

public class HashTable
{
	private TreeSet[] table;

	public HashTable( )
	{
		table = new TreeSet[10];
	}

	public void add(Integer obj)
	{
		System.out.println("add");
		int i = obj.hashCode();
		if(table[i%10] == null){
			table[i%10] = new TreeSet<Integer>();
		}
		table[i%10].add(obj);
		


	}

	public String toString()
	{
		String output="HASHTABLE\n";
int i =0;
		for(TreeSet<Integer> ll : table){
			
			output += "bucket "+(i++)+" "+ll.toString()+"\n";
			
			
		}








		return output;
	}
}