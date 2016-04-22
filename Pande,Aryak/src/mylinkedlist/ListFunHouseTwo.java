//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -  
package mylinkedlist;


public class ListFunHouseTwo
{
	private ListNode theList;
	private ListNode tail;
	private ListNode head;
	
	public ListFunHouseTwo()
	{
		theList = null;
		tail =  null;
	}
	
	public void add(Comparable data)
	{
		theList = new ListNode(data,null);
		if(head == null)
			head = theList;
		
		if(tail == null)
			tail = theList;
		tail.setNext(theList);
		tail = theList;
		
		
	}
	
	//this method will return the number of nodes present in theList
	public int nodeCount()
	{
   
		theList = head;
   	int count=1;
   	while(theList.getNext() != null){
   		count++;
   		theList = theList.getNext();
   	}
		
	
   	return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node at the front of the theList.  Once finished, the first node will occur twice.
	public void doubleFirst()
	{
		theList = head;
		theList.setNext(new ListNode(theList.getValue(),theList.getNext()));
				
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast()
	{
		theList = head;
		while(theList.getNext() != null)
	   		theList = theList.getNext();
	   	
	   	theList.setNext(new ListNode(theList.getValue(),null));
		
	}
	
	//method skipEveryOther will remove every other node
	public void skipEveryOther()
	{
		theList = head;
		while(theList != null)
            if(theList.getNext().getNext() != null)
            	theList.setNext(theList.getNext().getNext());

	}

	//this method will set the value of every xth node in the theList
	public void setXthNode(int x, Comparable value)
	{
		theList = head;
		int count=1;
		ListNode temp = theList;
        while(temp != null)
        {
            if(count % x == 0)
                temp.setValue(value);
            temp = temp.getNext();
            count++;
        }

	
	}	

	//this method will remove every xth node in the theList
	public void removeXthNode(int x)
	{
		theList = head;
		int count=1;
		ListNode pr = null;
        ListNode tt = theList;
        while(tt != null)
        {
            if(count % x == 0)
            {
                pr.setNext(tt.getNext());
            }
            pr = tt;
            tt = tt.getNext();
            count++;
        }
	
	}		
	//this method will return a String containing the entire theList
   public String toString()
   {
	   theList = head;
   	String output="";

   	output += (theList.getValue()+" ");
	   while(theList.getNext() != null){
		   theList = theList.getNext();
		   output+=(theList.getValue()+" ");
		 
		   
	   }


   	return output;
   }			
	
}