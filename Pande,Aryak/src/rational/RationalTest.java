package rational;
import java.util.*;
public class RationalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int n,n2,d,d2;
	

	Scanner s = new Scanner(System.in);
	System.out.println("Enter a numerator between -20 and 20");
	n = Integer.parseInt(s.nextLine());
	System.out.println("Enter a denominator between -20 and 20");
	d = Integer.parseInt(s.nextLine());
	s.close();
	
	if(Math.abs(n)> 20)
		n = 20;
	if(Math.abs(d)> 20)
		d = 20;
	
	Rational r1 = new Rational (n,d);
	
	if (Math.random() < 0.5){
		n2 = (int)(Math.random()*20);}
	else {
		n2 = (int)(Math.random()*-20);}
	
	if (Math.random() < 0.5){
		d2 = (int)(Math.random()*20);}
	else {
		d2 = (int)(Math.random()*-20);}
	
	Rational r2 = new Rational (n2,d2);
	
	Rational rSum, rDiff, rProd, rQuot, rRecip;
	
	System.out.println("First rational number: " + r1);
	System.out.println("Second rational number: " + r2);
	
	if (r1.equals(r2))
		System.out.println("r1 and r2 are equal.");
	else 
		System.out.println("r1 and r2 are NOT equal.");
	
	if (r1.compareTo(r2)< 0)
		System.out.println("r1 is less than r2.");
	else if (r1.compareTo(r2) > 0)
		System.out.println("r1 is greater than r2.");
	else if (r1.compareTo(r2) == 0)
		System.out.println("r1 and r2 are equal.");
	
	rRecip = r1.getReciprocal();
	System.out.println("The reciprocal is r1 is: " + rRecip);
	rSum = r1.add(r2);
	rDiff = r1.subtract(r2);
	rProd = r1.multiply(r2);
	rQuot = r1.divide(r2);
	
	System.out.println("r1 + r2: " + rSum);
	System.out.println("r1 - r2: " + rDiff);
	System.out.println("r1 * r2: " + rProd);
	System.out.println("r1 / r2: " + rQuot);
	
	}
}