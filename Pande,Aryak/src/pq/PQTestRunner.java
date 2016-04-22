//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -  
package pq;
public class PQTestRunner
{
	public static void main ( String[] args )
	{
		//add test cases
		PQTester pp = new PQTester("one two three four five six seven");
		PQTester pp2 = new PQTester("1 2 3 4 5 one two three four five");
		PQTester pp3 = new PQTester("a p h j e f m c i d k l g n o b");
		
		System.out.println("toString - "+pp);
		System.out.println("getMin - "+pp.getMin());
		System.out.println("getNaturalOrder - "+pp.getNaturalOrder());
		
		System.out.println("toString - "+pp2);
		System.out.println("getMin - "+pp2.getMin());
		System.out.println("getNaturalOrder - "+pp2.getNaturalOrder());
		
		System.out.println("toString - "+pp3);
		System.out.println("getMin - "+pp3.getMin());
		System.out.println("getNaturalOrder - "+pp3.getNaturalOrder());

	}
}