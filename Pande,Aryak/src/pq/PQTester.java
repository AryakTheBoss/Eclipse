//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -  
package pq;
import java.util.Collections;
import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PQTester
{
	private PriorityQueue<String> pQueue = new PriorityQueue<String>();

	public PQTester()
	{
	}

	public PQTester(String list)
	{
		setPQ(list);
	}

	public void setPQ(String list)
	{
		String[] betas = list.split(" ");
		//System.out.println(Arrays.toString(betas)); 
		for(int i=0;i<betas.length;i++){
			pQueue.add(betas[i]);
		}
	}
	
	public Object getMin()
	{
		return pQueue.peek();
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