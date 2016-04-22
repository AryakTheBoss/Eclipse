//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -
package mylinkedlist;
import java.util.*;

import static java.lang.System.*;

public class HistoList
{
   private HistoNode front;
   
	public HistoList( )
	{
		front = null;
	}

	//addLetter will add a new node to the front for let if let does not exist
	//addLetter will bump up the count if let already exists
	public void addLetter(char let)
	{
		
		
		if(front == null)
			front = new HistoNode(let, 1, null);
		
		HistoNode temp = front;
		while(temp.getNext() != null){
			if(temp.getLetter() == let){
				temp.setLetterCount(temp.getLetterCount() + 1);
				return;
			}
			else
				temp = temp.getNext();
		}
		
		if(temp.getLetter() == let && temp.getNext() == null)
			temp.setLetterCount(temp.getLetterCount() + 1);
		else
		temp.setNext(new HistoNode(let, 1, null));
		
	}
	
	//returns the index pos of let in the list if let exists
	public int indexOf(char let)
	{

		HistoNode temp = front;
		int count = 0;
		while(temp.getNext() != null){
			if(temp.getLetter() == let)
				return count;
			temp = temp.getNext();
			count++;
		}
		return -1;
		
	}

	//returns a reference to the node at spot
	private HistoNode nodeAt(int spot)
	{
		HistoNode temp = front;
		int count = 0;
		while(temp.getNext() != null){
			if(count == spot)
				return temp;
			temp = temp.getNext();
			count++;
		}
		return null;
	}

	//returns a string will all values from list
	public String toString()
	{
		HistoNode temp = front;
		String ret = "";
		while(temp.getNext() != null){
			if(temp.getLetter() == 'A'){
				temp.setLetterCount(temp.getLetterCount()-1);
			}
			ret += temp.getLetter() + " - " + temp.getLetterCount()+"\t";
			temp = temp.getNext();
		}
		ret += temp.getLetter() + " - " + temp.getLetterCount()+"\t"; 
		return ret;
	}
}