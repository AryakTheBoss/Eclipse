/**
 * 
 */
package dingyfart;

/**
 * @author 17ap0497
 *
 */





import java.util.Arrays;
import java.util.Iterator;

public class CircularArrayQueue
{

private int head, tail, theSize;
private Object[] elements; 




public CircularArrayQueue (int initialCapacity)
{
  head = tail = theSize = 0;
  elements = ( (Object[])(new Object[initialCapacity]) );
}


public void add (Object element)
{
  if (size() == elements.length) 
     expandCapacity();

  elements[tail] = element;

  tail = (tail+1) % elements.length;

  theSize++;
}


public Object remove() throws IllegalStateException
{
  if (isEmpty())
     throw new IllegalStateException ("queue");

  Object result = elements[head];
  elements[head] = null;

  head = (head+1) % elements.length;

  theSize--;

  return result;
}


public Object first() throws IllegalStateException
{
  if (isEmpty())
     throw new IllegalStateException ("queue"); 

  return elements[head];
}


public boolean isEmpty()
{
  return (theSize == 0);
}


public int size()
{
  return theSize;
}



public String toString()
{
/*String result = "";
int scan = 0;

while(scan < theSize)
{
 if(elements[scan]!=null)
 {
   result += elements[scan].toString()+"\n";
 }
scan++;
}

return result;*/

return Arrays.toString(elements);

}


public void expandCapacity()
{
Object[] larger = (Object[])(new Object[elements.length *2]);   

for(int scan=0; scan < theSize; scan++)
{
  larger[scan] = elements[head];
  head=(head+1) % elements.length;
}

head = 0;
tail = theSize;
elements = larger;
}
}

