package shit;
public class NumberTester
{
	public static void main(String[] args)
	{
		Integer one = new Integer(45);
		System.out.println(one.hashCode());
		
		Integer two = new Integer(107);
		System.out.println(two.hashCode());
		
		Integer three = new Integer(213);
		System.out.println(three.hashCode());				
	}
}