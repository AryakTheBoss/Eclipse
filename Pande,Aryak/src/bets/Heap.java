package bets;
import java.util.List;
import java.util.ArrayList;

import static java.lang.System.*;

public class Heap
{
	private List<Integer> list;
	

	public Heap()
	{
		
		list = new ArrayList<Integer>();
		list.add(null);
	}

	public void add(int value)
	{
		list.add(value);
		swapUp(list.size()-1);
	}

   public void swapUp(int bot)
   {
	  // System.out.println(bot);
	  
	   while(bot>0){
		   int parent = bot/2;
		   //System.out.println(parent);
		   if(list.get(parent) == null)
			   break;
		   if(list.get(parent) < list.get(bot)){
			   swap(parent,bot);
			   bot = parent;
		   }else{
			   break;
		   }
	   }
	   
	   
	}

	public void remove( )
	{
		list.set(1,list.get(list.size()-1));
		list.remove(list.size()-1);
		swapDown(list.size());
	}

	public void swapDown(int top)
	{
		
		int max = 1;
		while(top <list.size()){
			int left = top*2;
			int right = top*2+1;
			
			if(list.get(left) != null)
				if(list.get(right) != null)
					max = list.get(left) >= list.get(right) ? left : right;
				else
					max = list.get(left);
			else
				break;
			
			if(list.get(max) > list.get(top)){
				swap(max,top);
			top = max;
			}else
				break;
		}
				
		
	}
	public void print()
	{
	    System.out.println(print(1,""));
	}

	private String print(int index, String prefix)
	{
	    String outputString = "";

	    outputString = prefix + "|__";

	    if( index < list.size() )
	    {
	        boolean isLeaf = index > list.size() / 2;

	        outputString += list.get(index) + "\n";

	        String _prefix = prefix;

	        if( index%2 == 0 )
	            _prefix += "|  "; // one | and two spaces
	        else
	            _prefix += "   " ; // three spaces

	        if( !isLeaf )
	        {
	            outputString += print( 2*index, _prefix);
	            outputString += print( 2*index + 1, _prefix);
	        }
	    }
	    else
	        outputString += "null\n";

	    return outputString;
	    }
	//Then we have children at i*2 and i*2+1, and each parent can be located at i/2.
	private void swap(int start, int finish)
	{	
		int e1 = list.get(start);
		int e2 = list.get(finish);
		
		list.set(start, e2);
		list.set(finish, e1);
		
	}

	

	public String toString()
	{
		return list.toString();
	}
}