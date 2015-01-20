/**
 * 
 */
package chapapap;

/**
 * @author 310843
 *
 */
import java.util.Arrays;

/**
 * 
 * @author 91040037
 *
 * @param <E> Type of elements in this collection
 */
/**
 * My version of the ArrayList class
 * @author 177172
 *
 * @param <E>
 */
/**
 * @author Matt Lu
 * @date 11/22/14
 * @param <E>
 */

public class MyArrayList<E>
{
	private Object[] a;
	private int size;

	/**
	 * Default constructor
	 */
	public MyArrayList()
	{
		this(10);
	}

	/**
	 * Constructor with user-defined initial capacity
	 * @param initialCapacity
	 */
	public MyArrayList(int initialCapacity) 
	{
		if (initialCapacity <= 0) // Replace this with the correct condition
			throw new IllegalArgumentException("Initial capacity must exceed zero");
		else
		{
			a = new Object[initialCapacity];
			size = 0;
		}
	}

	/**
	 * Returns the size
	 * @return size of array
	 */
	public int size()
	{
		return this.size;
	}

	/**
	 * Returns the object at user-defined index
	 * @param index
	 * @return object at index
	 */
	public E get(int index)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index must be greater than zero and less than the size of the list");

		return (E) a[index];

	}

	/**
	 * Sets object at user-defined index as user-defined element
	 * 
	 * @param index
	 * @param element
	 * @return element previously at user-defined index
	 */
	public E set(int index, E element)
	{
		if (index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException("Index must be greater than zero and less than the size of the list");
		} 
		else {
			Object valueHolder = a[index];
			a[index] = element;
			return (E) valueHolder;
		}
	}

	/**
	 * Tells user whether or not the user-defined element is present in the arrayList
	 * 
	 * @param elem
	 * @return true or false for if element is user-defined present or not
	 */
	public boolean contains(Object elem)
	{
		boolean contains = false;
		int counter = 0;
		while(counter < this.size)
		{
			if(a[counter].equals(elem))
				contains = true;
			counter ++;
		}
		return contains;
	}

	/**
	 * Decreases size of array
	 */
	public void trimToSize()
	{
		Object[] b = new Object[this.size];
		for(int x = 0; x < this.size; x++)
		{
			b[x] = a[x];
		}
		a = b;
	}

	/**
	 * Adds user-defined element to end of array
	 * @param elem
	 */
	public void add(E elem)
	{
		int previousSize = this.size;
		if(this.size == a.length && a.length > 0)
			a = cloneArray(a.length * 2);
		else
			a = cloneArray(a.length +1);
		a[previousSize] = elem;
		size++;
	}

	/**
	 * Adds user-defined element to user-defined index, moves following elements back
	 * @param index
	 * @param element
	 */
	public void add(int index, E element)
	{
		if (index > this.size || index < 0)
			throw new IndexOutOfBoundsException("The index must be greater than zero and less than the size of the list");
		if(this.size >= a.length)
			a = cloneArray(a.length * 2);

		Object[] b = cloneArray(a.length + 1);
		b[index] = element;
		for(int x = index ; x < a.length; x++)
		{
			b[x + 1] = a[x];
		}
		a = b;	
		size++;
	}

	/**
	 * Removes element at user-defined index, moves following elements forward. 
	 * @param index
	 * @return
	 */
	public E remove(int index)
	{
		if (index < 0 || index >= this.size){
			throw new IndexOutOfBoundsException("The index must be greater than zero and less than the size of the list");	
		}
		else{
			Object valueHolder = a[index];
			Object[] b = cloneArray(a.length);
			for(int x = index ; x < this.size -1; x++)
			{
				b[x] = a[x +1];
			}
			a = b;
			size --;
			return (E)valueHolder;
		}
	}

	/**
	 * Removes all instances of user-defined element, moving all following and remaining elements forward. 
	 * @param elem
	 * @return
	 */
	public boolean remove(Object elem)
	{
		boolean isIncluded = false;
		for(int x = 0; x < this.size; x++)
		{
			if(elem.equals(a[x]))
			{
				remove(x);
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a copy of the array of specified length
	 * @param newArrayLength
	 * @return
	 */
	private Object[] cloneArray(int newArrayLength)
	{
		if(newArrayLength < a.length)
			throw new IllegalArgumentException("You must enter a length greater than or equivalent to that of the shortest array's length");
		int counter = 0;
		Object[] b = new Object[newArrayLength];
		while(counter < a.length)	//creates an Object[] b containing all values of a no indexes of a left out
		{
			b[counter] = a[counter];
			counter ++;
		}
		return b;
	}
}

//ITALY OR BUST!