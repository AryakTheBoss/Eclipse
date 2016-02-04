package pq;

public class LiverTestic {
	
	public static void main(String[] args){
		
		LiverTransplant l = new LiverTransplant();
		l.add(new Patient("Smith",3));

	    l.add(new Patient("Chen",2));

	    l.add(new Patient("Jones",3));

	    l.add(new Patient("Wong",3));

	    l.add(new Patient("Gupta",2));

	    l.add(new Patient("Garcia",1));

	    l.add(new Patient("Brown",3));

	    System.out.println("The list is");

	    System.out.println(l);  

	    while(l.size()>0)

	    {

	            System.out.println("The next patient for the liver transplant is");

	            System.out.println(l.poll());
	    }
		
	}

}
