//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -   
//Lab  -
package linkedlist;
public class ThingCount implements Comparable
{
	private int count;
	private Object thing;
	
	public ThingCount()
	{
	}
	
	public ThingCount(Object thang, int cnt)
	{
		this.thing = thang;
		this.count = cnt;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount(int cnt)
	{
		count = cnt;
	}

	public void setThing(Object obj)
	{
		thing = obj;
	}	
	
	public Object getThing()
	{
		return thing;
	}
	
	public boolean equals(Object obj)
	{
		ThingCount other = (ThingCount)obj;
		return other.getCount() == this.getCount();
	}
	
	public int compareTo(Object obj)
	{
		ThingCount other = (ThingCount)obj;
		if(other.getCount() > this.getCount())
			return 1;
		else if(other.getCount() < this.getCount())
			return -1;
		else
			return 0;
		
		
	}
	
	public String toString()
	{
		return ""+ getThing() + " - " + getCount();
	}
}