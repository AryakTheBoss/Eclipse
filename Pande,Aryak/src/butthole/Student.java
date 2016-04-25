/**
 * 
 */
package butthole;

/**
 * @author 17ap0497
 *
 */
public class Student implements Comparable<Student>{
	
	private String first,last,id,name;
	
	public Student(String firstn,String lastn,String id){
		
		this.name = lastn+" "+firstn;
		first = firstn;
		last = lastn;
		this.id = id;
		
	}
	
	public int hashCode(){
		
		final int HASH_MULTIPLIER = 29;
		int h1 = name.hashCode();
		int h2 = new Integer(id).hashCode();
		return HASH_MULTIPLIER * h1 + h2;
		
	}
	public boolean equals(Object other){
		
		if(other == null)
			return false;
		if(getClass() != other.getClass())
			return false;
		return (id == ((Student) other).getId() && name.equals(((Student)other).getName()));
		
		
	}
	public String getId(){
		
		return this.id;
		
	}
	public String getName(){
		
		return this.name;
		
	}
public String getFirst(){
		
		return this.first;
		
	}
public String getLast(){
	
	return this.last;
	
}
	
	public String toString(){
		
		return name + " " + id;
		
	}

	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		return this.last.compareTo(arg0.getLast());
	}

	

}
