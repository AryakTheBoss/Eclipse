package butthole;

import java.util.Hashtable;

public class PhoneEntry implements Comparable<PhoneEntry>{
	
	private String name;
	private String numba;
	
	public PhoneEntry(String name, String number){
		
		this.name = name;
		numba = number;
		
		
	}
	
	public String getName(){
		return name;
	}
	public String getNumber(){
		return numba;
	}
	
	public int hashCode() { 

		return name.charAt(0);

		}
	
	public String toString(){
		
		return name+" "+numba;
		
	}
	public void setNumber(String numba){
		
		this.numba = numba;
	}

	@Override
	public int compareTo(PhoneEntry arg0) {
		// TODO Auto-generated method stub
		return this.name.compareTo(arg0.getName());
	}

}
