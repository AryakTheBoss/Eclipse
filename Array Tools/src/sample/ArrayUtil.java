package sample;



public class ArrayUtil<E>{
	
	private Object[] op;
	private int currentPos = -1;
	private int size = 0;
	
	public ArrayUtil(){/*System.out.println("Please use the init() method to avoid a NullPointerException");*/}
	
	/**
	 * Adds an item to the array
	 * 
	 * 
	 * @param item - the item of the Type Specified
	 * 
	 **/
	public void add(E item)throws ArrayFullException{
		
		if(currentPos < size){
			
			currentPos++;
			op[currentPos] = item;
			
		}else{
			
			throw new ArrayFullException("Cannot Add Anymore values!");
			
		}
		
		
		
		
		
	}
	
	/**
	 * Gets the object at the index specified
	 * 
	 * 
	 * @param index - The index
	 * @return Object - the value at the index specified
	 * 
	 **/
	
	public Object getValue(int index){
		
		if(index < op.length && index >= 0){
		
		return op[index];
		
		}else{
			
			System.err.println("Index is Invalid! Returning null...");
			
		}
		
		return null;
		
		
	}
	/**
	 * Adds an item to the array at a specific index
	 * 
	 * 
	 * @param item - the item of the Type Specified
	 * @param index - the index of the array in which to insert the value
	 * 
	 **/
	public void add(E item,int index){
		
		if(index < op.length && index >= 0){
			
			op[index] = item;
			
		}else{
			
			System.err.println("Index is Invalid!");
			return;
		}
		
	}
	/**
	 * Removes an item from the array
	 * 
	 * 
	 * @param index - the index
	 * 
	 **/
	public void remove(int index){
		
		if(op[index] != null){
			
			op[index] = null;
			
		}else{
			
			System.err.println("The item at that place is already NULL !!");
			return;
		}
		
	}
	/**
	 * Erases the array and sets it to null requiring you to invoke the init() Method again.
	 * 
	 * 
	 * @param areYouSure - I think the name speaks for itself. use true for yes false for no
	 * 
	 **/
	public void reset(boolean areYouSure){
		
		
		
		if(areYouSure == false){
			
			System.out.println("ok cancel");
			return;
			
		}else{
			System.err.println("Array Deleted! make sure you use the init() method again\n before calling any other methods in this class!");
			op = null;
			
		}
		
		
		
		
	}
	/**
	 * Initializes the array - REQUIRED AFTER reset() METHOD!!
	 * 
	 * 
	 * @param siz - the array size
	 * 
	 **/
	public void init(int siz){
		
		 op = new Object[siz];
		    size = siz;
		
	}
	/**
	 * Converts the array to a String
	 * 
	 * 
	 * @param showNull - again the name says it all. true if you want to see all the ugly nulls
	 *  in the array or false if you don't.
	 * 
	 **/
	public String toSTR(boolean showNull){
		
		String as = "[";
		
		if(showNull == true){
		
		for(int i=0;i<op.length;i++){
			
			as += op[i];
			if(i != op.length-1){
				as += ",";
				}
			
			
		}
		}else{
			
			for(int i=0;i<op.length;i++){
				
				if(op[i] != null){
				
				as += op[i];
				if(i != op.length-1){
				as += ",";
				}
				}
				
			}
			
		}
		as+="]";
		return as;
		
	}
	/**
	 * Checks for the existance of a key
	 * 
	 * 
	 * @param key - the key to be searched for
	 * 
	 **/
	public boolean exists(E key){
		
		for(int i=0;i<op.length;i++){
			
			if(op[i] == key){
				
				return true;
				
			}
			
		}
		
		return false;
	}
	/**
	 * Searches the array for the key and returns the index of the first occurrence of the key. if its not found <code>-1</code> is returned
	 * 
	 * 
	 * @param key - the key to be searched for
	 * @return int - the pos
	 **/
	public int findKey(E key){
		
           for(int i=0;i<op.length;i++){
			
        	   if(op[i] == key){
        		   
        		   return i;
        		   
        	   }
			
           }
           
           return -1;
	}
	/**
	 * checks how many times a key appears in an array if the key is not found it returns zero.
	 * 
	 * @param key - the key to be searched for
	 * @return int - number of times it appeared
	 **/
	public int countKeys(E key){
		int count = 0;
		for(int i=0;i<op.length;i++){
			
     	   if(op[i] == key){
     		   
     		   count++;
     		   
     	   }
			
        }
		return count;
		
	}
	
	

}
