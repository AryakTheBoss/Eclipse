package mylinkedlist;

public class ListNode implements Linkable
{
	private Comparable listNodeValue = null;
	private ListNode nextListNode = null;
	

	public ListNode()
	{
		listNodeValue = null;
		nextListNode = null;
		
	}

	public ListNode(Comparable value, ListNode next)
	{
		listNodeValue=value;
		nextListNode=next;
	}

	public Comparable getValue()
	{
		return listNodeValue;
	}

	public ListNode getNext()
	{
		
	   return nextListNode;
	}
	
	public void setValue(Comparable value)
	{
		listNodeValue = value;
	}
	public boolean hasNext(){
		return nextListNode != null;
	}
	
	public void setNext(Linkable next)
	{
		nextListNode = (ListNode)next;
	}
	public void setLast(Linkable next)
	{
		nextListNode = (ListNode)next;
	}
}