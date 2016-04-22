package mylinkedlist;
import static java.lang.System.*;

public class ListFunHouse
{
	//this method will print the entire list on the screen
   public static void print(ListNode list)
   {
	   out.print(list.getValue()+" ");
	   while(list.getNext() != null){
		   list = list.getNext();
		   out.print(list.getValue()+" ");
		 
		   
	   }
   }		
	
	//this method will return the number of nodes present in list
	public static int nodeCount(ListNode list)
	{
   	int count=1;
   	while(list.getNext() != null){
   		count++;
   		list = list.getNext();
   	}
		return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list)
	{
		
		list.setNext(new ListNode(list.getValue(),list.getNext()));
	 	
	 
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list)
	{
   	while(list.getNext() != null)
   		list = list.getNext();
   	
   	list.setNext(new ListNode(list.getValue(),null));
	}
		
	//method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list)
	{
		
		while(list != null)
                if(list.getNext().getNext() != null)
                	list.setNext(list.getNext().getNext());
        
		
	}

	//this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value)
	{
		int count=1;
		ListNode temp = list;
        while(temp != null)
        {
            if(count % x == 0)
                temp.setValue(value);
            temp = temp.getNext();
            count++;
        }
	}	

	//this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x)
	{
		int count=1;
		ListNode pr = null;
        ListNode tt = list;
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
}