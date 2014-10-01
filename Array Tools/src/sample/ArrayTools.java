package sample;

public class ArrayTools 
{
	//static methods to program standard array operations
	//max , min, sum , avg,  int[], double[]
	//(int[]a, int n)  (double[]a , int n) for each one.
	// no constructor, n = number of elements to use
	
	/**
	 * Calculates the sum of the int array
	 * 
	 * @param int[] a - the array to add
	 * */
	public static int sum(int[] a)
	{
		int sum = 0;
		for(int x = 0; x < a.length;x++)
		{
			sum += a[x];
		}
		
		return sum;
	}
	/**
	 * Calculates the sum of the double array
	 * 
	 * @param double[] a - the array to add
	 * */
	public static double sum(double[] a)
	{
		double sum = 0;
		for(int x = 0; x < a.length;x++)
		{
			sum += a[x];
		}
		return sum;
	}
	/**
	 * Calculates the sum of a portion of the int array
	 * 
	 * @param int[] a - the array to add
	 * @param int n - the index to sum up
	 * */
	public static int sum(int[] a, int n)
	{
		int sum = 0;
		for(int x = 0; x < n;x++)
		{
			sum += a[x];
		}
		
		return sum;
	}
	
	/**
	 * Calculates the sum of a portion of the int array
	 * 
	 * @param double[] a - the array to add
	 * @param int n - the index to sum up
	 * */
	public static double sum(double[] a, int n)
	{
		double sum = 0;
		for(int x = 0; x < n;x++)
		{
			sum += a[x];
		}
		
		return sum;
	}
	/**
	 * Calculates the max value
	 * 
	 * @param int[] a - the array
	 * 	 
	 *  */
	public static int max(int[]a)
	{
		int max = a[0];
		
		for(int x = 0; x < a.length; x++)
		{
			if(a[x] > max)
			{
				max = a[x];
			}
		}
		
		return max;
	}
	/**
	 * Calculates the max value
	 * 
	 * @param double[] a - the array
	 * 	 
	 *  */
	public static double max(double[]a)
	{
		double max = a[0];
		
		for(int x = 0; x < a.length; x++)
		{
			if(a[x] > max)
			{
				max = a[x];
			}
		}
		
		return max;
	}
	/**
	 * Calculates the max value of a potion of array
	 * 
	 * @param int[] a - the array
	 * 	 @param int n - endIndex
	 *  */
	public static int max(int[]a, int n)
	{
		int max = a[0];
		
		for(int x = 0; x < n; x++)
		{
			if(a[x] > max)
			{
				max = a[x];
			}
		}
		
		return max;
	}
	/**
	 * Calculates the max value of a potion of array
	 * 
	 * @param double[] a - the array
	 * 	 @param int n - endIndex
	 *  */
	public static double max(double[]a, int n)
	{
		double max = a[0];
		
		for(int x = 0; x < a.length; x++)
		{
			if(a[x] > max)
			{
				max = a[x];
			}
		}
		
		return max;
	}
	/**
	 * Calculates the min value of  array
	 * 
	 * @param int[] a - the array
	 * 	 
	 *  */
	public static int min(int[]a)
	{
		int min = a[0];
		
		for(int x = 0; x < a.length; x++)
		{
			if(a[x] < min)
			{
				min = a[x];
			}
		}
		
		return min;
	}
	/**
	 * Calculates the min value of  array
	 * 
	 * @param double[] a - the array
	 * 	 
	 *  */
	public static double min(double[]a)
	{
		double min = a[0];
		
		for(int x = 0; x < a.length; x++)
		{
			if(a[x] < min)
			{
				min = a[x];
			}
		}
		
		return min;
	}
	/**
	 * Calculates the min value of portion of  array
	 * 
	 * @param int[] a - the array
	 * 	 @param int n - index
	 *  */
	public static int min(int[]a, int n)
	{
		int min = a[0];
		
		for(int x = 0; x < n; x++)
		{
			if(a[x] < min)
			{
				min = a[x];
			}
		}
		
		return min;
	}
	/**
	 * Calculates the min value of portion of  array
	 * 
	 * @param double[] a - the array
	 * 	 @param int n - index
	 *  */
	public static double min(double[]a, int n)
	{
		double min = a[0];
		
		for(int x = 0; x < n; x++)
		{
			if(a[x] < min)
			{
				min = a[x];
			}
		}
		
		return min;
	}
	/**
	 * Calculates the avg
	 * 
	 * @param int[] a - the array
	 * 	 
	 *  */
	public static double avg(int[]a)
	{
		return sum(a)/ a.length;
	}
	/**
	 * Calculates the avg
	 * 
	 * @param double[] a - the array
	 * 	 
	 *  */
	public static double avg(double[]a)
	{
		return sum(a)/ a.length;
	}
	/**
	 * Calculates the avg of portion of array
	 * 
	 * @param int[] a - the array
	 * 	 @param int n - index
	 *  */
	public static double avg(int[]a, int n)
	{
		return sum(a)/ n;
	}
	/**
	 * Calculates the avg of portion of array
	 * 
	 * @param double[] a - the array
	 * 	 @param int n - index
	 *  */
	public static double avg(double[]a, int n)
	{
		return sum(a)/ n;
	}
	/**
	 * sorts the array
	 * 
	 * @param int[] a - the array
	 * 	 
	 *  */
	public static void sort(int[]a)
	{	int temp;
		boolean isSorted = false;
		
		while(!isSorted)
		{
			isSorted = true;
			
			for(int x = 0; x < a.length - 1; x++)
			{
				if(a[x] > a[x + 1])
				{
					isSorted = false;
					temp = a[x];
					a[x] = a[x + 1];
					a[x +1 ] = temp;
				}	
			}
		}
	}

	/**
	 * sorts the array
	 * 
	 * @param double[] a - the array
	 * 	 
	 *  */
	public static void bubbleSort(double[]a)
	{
		double temp;
		
		for(int x =0; x < a.length - 1; x ++)
		{
			for(int y = 0; y < a.length - 1 - x; y++)
			{
				if(a[y] > a[y + 1])
				{
					temp = a[y];
					a[y] = a[y + 1];
					a[y + 1] = temp;
				}	
			}
		}
	}
	
	public static void bubbleSort(int[]a, int n)
	{
		int temp;
		
		for(int x =0; x < n - 1 ; x ++)
		{
			for(int y = 0; y < n - 1 -x ; y++)
			{
				if(a[y] > a[y + 1])
				{
					temp = a[y];
					a[y] = a[y + 1];
					a[y +1 ] = temp;
				}	
			}
		}
	}
	
	public static void bubbleSort(double[]a, int n)
	{
		double temp;
		
		for(int x =0; x < n - 1 ; x ++)
		{
			for(int y = 0; y < n - 1 ; y++)
			{
				if(a[y] > a[y + 1])
				{
					temp = a[y];
					a[y] = a[y + 1];
					a[y +1 ] = temp;
				}	
			}
		}
	}
	/**
	 * sorts the array
	 * 
	 * @param String[] a - the array
	 * 	 
	 *  */
	public static void bubbleSort(String[]a)
	{
		String temp;
		for(int x = 0; x < a.length - 1; x ++)
		{
			for(int y = 0; y < a.length - 1; y++)
			{
				if(a[y].compareTo(a[y+1])>0)
				{
					temp = a[y];
					a[y] = a[y + 1];
					a[y +1 ] = temp;
				}
			}
		}
	}
	/**
	 * sorts the portion of array
	 * 
	 * @param String[] a - the array
	 * 	 @param int n - index
	 *  */
	public static void bubbleSort(String[]a, int n)
	{
		String temp;
		
		for(int x =0; x < n - 1; x ++)
		{
			for(int y = 0; y < n - 1; y++)
			{
				if(a[y].compareTo(a[y+1])>0)
				{
					temp = a[y];
					a[y] = a[y + 1];
					a[y+1 ] = temp;
				}
			}
		}
	}
	
	/**
	 * sorts the array
	 * 
	 * @param int[] a - the array
	 * 	 
	 *  */
	public static void bubbleSort(int[]a)
	{
		int temp;
		
		for(int x =0; x < a.length - 1; x ++)
		{
			for(int y = 0; y < a.length - 1; y++)
			{
				if(a[y] > a[y + 1])
				{
					temp = a[y];
					a[y] = a[y + 1];
					a[y +1 ] = temp;
				}	
			}
		}
	}
	/**
	 * checks for equality
	 * 
	 * @param int[] a - array
	 * 	 @param int[] b - other array
	 *  */
	public static boolean equals(int[] a, int[]b)
	{
		if(a.length != b.length)
		{
			return false;
		}
		
		for(int x = 0 ; x < a.length; x++)
		{
			if(a[x] != b[x])
			{
				return false;
			}
		}
		
		return true;
	}
	/**
	 * checks for equality
	 * 
	 * @param double[] a - array
	 * 	 @param double[] b - other array
	 *  */
	public static boolean equals(double[] a, double[]b)
	{
		if(a.length != b.length)
		{
			return false;
		}
		
		for(int x = 0 ; x < a.length; x++)
		{
			if(a[x] != b[x])
			{
				return false;
			}
		}
		
		return true;
	}
	/**
	 * checks for equality
	 * 
	 * @param String[] a - array
	 * 	 @param String[] b - other array
	 *  */
	public static boolean equals(String[] a, String[]b)
	{
		if(a.length != b.length)
		{
			return false;
		}
		
		for(int x = 0 ; x < a.length; x++)
		{
			if(!(a[x].equalsIgnoreCase(b[x])))
			{
				return false;
			}
		}
		
		return true;
	}
	/**
	 * inserts value into array
	 * 
	 * @param String[] a - array
	 * 	 @param String value - ?
	 * @param int n - index
	 *  */
	public static void insert(String[]a, String value, int n)
	{
		a[n] = value;
	
		String temp;
		
		for(int x = n - 1 ; x >= 0; x--)
		{
			if(a[x].compareTo(a[x + 1]) < 0 )
			{
				temp = a[x];
				a[x] = a[x + 1];
				a[x + 1] = temp; 
			}
		}
		// up to you to think about how to handle n
	}
	
	public static void insert(int []a, int value, int n)
	{
		a[n] = value;	
		int temp;
			while (a[n]< a[n-1] && n>0 )
			{
				temp = a[n];
				a[n] = a[n - 1];
				a[n - 1] = temp; 
				n--;
			}
		}
		// up to you to think about how to handle n

	/**
	 *Searches the array for the key when not sorted
	 * 
	 * @param int[] a - array
	 * 	 @param int key - key
	 * @param int n - portion of array
	 *  */	
	public static int lSearch(int []a,int key, int n){
		for(int x=0;x<n;x++){
			if (a[x]==key)
				{
					return x;    // or loc=x; 
				}
		}
		return -1;
	}
	/**
	 * Searches aray for string
	 * 
	 * 
	 *  */
public static int lSearch(String []a,String key, int n){
		for(int x=0;x<n;x++){
			if (a[x].equalsIgnoreCase(key))
				{
					return x;    // or loc=x; 
				}
		}
		return -1;
	}
/**
 * Binary search
 * 
 * 
 *  */
public static int binSearch(int []a,int key, int n){
// use google to find the binary search algorithm or code 
// pre cond array must be sorted
    int low = 0;
    int high = n-1;
    int mid;

    while( low <= high )
    {
        mid = ( low + high ) / 2;

        if( a[ mid ] < key )
            low = mid + 1;
        else if( a[ mid ]>key )
            high = mid - 1;
        else
            return mid;
    }

    return  -1;

}
/**
 * Binary search
 * STrings
 * 
 *  */
public static int binSearch(String []a,String key, int n){
	// use google to find the binary search algorithm or code 
	// pre cond array must be sorted search order is log base 2 N
	    int low = 0;
	    int high = n-1;
	    int mid;

	    while( low <= high )
	    {
	        mid = ( low + high ) / 2;
	        if( a[ mid ].compareToIgnoreCase(key )<0 )
	            low = mid + 1;
	        else if( a[ mid ].compareToIgnoreCase(key )>0)
	            high = mid - 1;
	        else
	            return mid;
	    }
	    return  -1;

	}
/**
 * removes value from array
 * 
 * @param int[] a - array
 * 	 @param int value - value
 * @param int n - idk
 *  */
	public static void remove(int [] a, int value, int n)
	{		boolean removed = false;
		
		for(int x = 0 ; x < n ; x++)
		{
			if(a[x] == value)
			{
				removed = true;
			}
			
			if(removed)
			{
				a[x] = a[x + 1];
			}
		}
	}
	/**
	 * remove
	 * 
	 * 
	 *  */
	public static void remove(double [] a, double value, int n)
	{
		boolean removed = false;
		
		for(int x = 0 ; x < n ; x++)
		{
			if(a[x] == value)
			{
				removed = true;
			}
			
			if(removed)
			{
				a[x] = a[x + 1];
			}
		}
	}
	/**
	 * remove
	 * 
	 * 
	 *  */
	public static void remove(String[] a, String value, int n)
	{
		boolean removed = false;
		
		for(int x = 0 ; x < n ; x++)
		{
			if(a[x].equals(value))
			{
				removed = true;
			}
			
			if(removed)
			{
				a[x] = a[x + 1];
			}
		}
	}
	
	
}