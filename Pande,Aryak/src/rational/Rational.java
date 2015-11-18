/**
 * 
 */
package rational;

import java.math.*;

/**
 * @author 17ap0497
 *
 */

public class Rational implements Comparable{
	
	private int num;
	private int den;
	
	public Rational(int numerator,int denominator){
		
		num = numerator;
		den = denominator;
		if(den == 0)
			den = 1;
		if(den < 0 && num < 0){
			den = Math.abs(den);
			num = Math.abs(num);
		}
		else if(den < 0 || num < 0){
			den = Math.abs(den);
			num = -(Math.abs(num));	
		}
		this.reduce();
	}
	
	private static int gcd(int a, int b) {
	    BigInteger b1 = BigInteger.valueOf(a);
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.intValue();
	}
	
	public int getNumerator(){
		
		return num;
		
	}
	
	public int getDenominator(){
		
		return den;
		
	}
	
	public Rational getReciprocal(){
		
		return new Rational(den, num);
		
	}
	
	public Rational add(Rational rat2){
		
		Rational r = new Rational((num*rat2.getDenominator())+(rat2.getNumerator()*den),(den*rat2.getDenominator()));
	r.reduce();
		return r;
		
	}
	
	public Rational subtract(Rational rat2){
		
		Rational r = new Rational((num*rat2.getDenominator())-(rat2.getNumerator()*den),(den*rat2.getDenominator()));
		r.reduce();
			return r;
		
	}
	public Rational multiply(Rational rat2){
		
		Rational r = new Rational(num*rat2.getNumerator(),den*rat2.getDenominator());
		r.reduce();
		return r;
		
	}
	public Rational divide(Rational rat2){
	
		Rational r = multiply(rat2.getReciprocal());
		r.reduce();
	return r;
	
	}
	public void reduce(){
		
		int temp = gcd(num,den);
		num/=temp;
		den/=temp;		
	}
	
	public boolean equals(Object obj){
		Rational r = (Rational)obj;
		return (num==r.getNumerator() && den==r.getDenominator());
		
	}

	@Override
	public int compareTo(Object obj) {
		Rational r = (Rational)obj;
		double one = num/den;
		double two = r.getNumerator()/r.getDenominator();
		if(one < two)
			return -1;
		else if (one == two)
			return 0;
		else 
			return 1;
		
	}
	public String toString(){		
		return num + "/" + den;
	}

}
