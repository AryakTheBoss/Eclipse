//© A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class - 
//Lab  -
package linkedlist;

import mylinkedlist.HistoNode;

public class HistoList
{
	private ListNode front;

	public HistoList( )
	{
		front = null;
	}


	//ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
	//IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
	public void add(Object obj)
	{
		//ThingCount c = (ThingCount)obj;
		if(front == null)
			front = new ListNode(new ThingCount(obj,1), null);
		
		ListNode temp = front;
		while(temp.getNext() != null){
			
			if(temp.getLetter() == let){
				temp.setLetterCount(temp.getLetterCount() + 1);
				return;
			}
			else
				temp = temp.getNext();
			
		}
		
	}

	//RETURNS THE INDEX POSITION OF LET IN THE LIST
	public int indexOf(Object obj)
	{
		int spot=-1;
		ListNode temp = front;
		int count = 0;
		while(temp.getNext() != null){
			if(temp.getValue().equals(obj))
				return count;
			temp = temp.getNext();
			count++;
		}
		return -1;
		
	}

	//RETURNS A REFERENCE TO THE NODE AT SPOT
	private ListNode nodeAt(int spot)
	{
		
		ListNode temp = front;
		int count = 0;
		while(temp.getNext() != null){
			if(count == spot)
				return temp;
			temp = temp.getNext();
			count++;
		}
		return null;
		
	}

	//RETURNS THE LIST AS A BIG STRING
	public String toString()
	{
		ListNode temp = front;
		String ret = "";
		ThingCount c = (ThingCount)temp.getValue();
		while(temp.getNext() != null){
			c = (ThingCount)temp.getValue();
			ret += c.getThing() + " - " + c.getCount()+"\t";
			temp = temp.getNext();
		}
		ret += c.getThing() + " - " + c.getCount()+"\t"; 
		return ret;
	}
}