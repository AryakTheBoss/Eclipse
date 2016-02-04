package pq;

public class Patient implements Comparable<Patient>{

	private String aname;
	private int condition;
	
	public Patient(String name, int condition){
		
		aname = name;
		this.condition = condition;
		
	}

	@Override
	public int compareTo(Patient arg0) {
		// TODO Auto-generated method stub
	if(arg0.getCondition() < this.condition)
		return 1;
	else if(arg0.getCondition() > this.condition)
		return -1;
	else if(arg0.getCondition() == this.condition)
		return 0;
	
	throw new IllegalStateException("Get Rekt");
	}

	public String getName() {
		return aname;
	}

	public void setName(String aname) {
		this.aname = aname;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}
	@Override
	public String toString(){
		
		return aname+" "+condition;
		
	}

}
