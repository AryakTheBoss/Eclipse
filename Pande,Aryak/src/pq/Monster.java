package pq;

public class Monster implements Comparable<Monster>{
	
	private int height;
	private int weight;
	private int age;
	
	public Monster(){
		
	}

	   public Monster(int ht, int wt, int age)  {
		   height = ht;
		   weight = wt;
		   this.age = age;
	   }

	   public void setWeight(int wt){
		   weight = wt;
	   }

	   public void setHeight( int ht) {
		   height = ht;
	   }

	   public void setAge( int age) {
		   this.age = age;
	   }

	   public Object clone(){
		   return new Monster(height,weight,age);
	   }

	   public int getWeight()  {
		   return weight;
	   }
	   public int getHeight()  {
		   return height;
	   }

	   public int getAge()  {
		   return age;
	   }

	   public boolean equals( Object o ){
		   
		   if(o instanceof Monster){
			  if(this.compareTo((Monster)o) == 0)
				  return true;
				  
		   }
		   return false;
	   }

	    
//h,w,a
	   public int compareTo( Monster rhs ){
		   
		   if(rhs.getHeight() < this.height){
			   return 1;
		   }else if(rhs.getHeight() > this.height){
			   return -1;
		   }else if(rhs.getHeight() == this.height){
			   
			   if(rhs.getWeight() < this.weight)
				   return 1;
			   else if(rhs.getWeight() > this.weight)
				   return -1;
			   else if(rhs.getWeight() == this.weight){
				   
				   if(rhs.getAge() < this.age)
					   return 1;
				   else if(rhs.getAge() > this.age)
					   return -1;
				   else if(rhs.getAge() == this.age)
					   return 0;
				   
			   }
			   
			   
		   }
		   throw new IllegalStateException("Ya fucked up");
		   
	   }

	       

	   public String toString(){
		   return height+" "+weight+" "+age;
	   }

}
