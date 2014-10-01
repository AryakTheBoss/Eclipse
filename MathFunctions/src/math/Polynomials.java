package math;


import java.util.ArrayList;
import java.util.Scanner;

public class Polynomials {
    public static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		System.out.println("Enter the two Binomials: (MUST USE x as the varible and must look something like this: x+2");
		System.out.println("Enter the first Binomial:"); //x-7
		String bi1 = s.nextLine();
		System.out.println("Enter the second Binomial:");
		String bi2 = s.nextLine();
		
		ArrayList<String> terms1 = new ArrayList<String>();
		terms1.add("x");
		if(bi1.charAt(1) == '+'){
		terms1.add("+"+Character.toString(bi1.charAt(2))); 
		}else if(bi1.charAt(1) == '-'){
			
			terms1.add("-"+Character.toString(bi1.charAt(2))); 
			
		}
		ArrayList<String> terms2 = new ArrayList<String>();
		terms2.add("x");
		if(bi2.charAt(1) == '+'){
		terms2.add("+"+Character.toString(bi2.charAt(2))); 
		}else if(bi2.charAt(1) == '-'){
			
			terms2.add("-"+Character.toString(bi2.charAt(2))); 
			
		}
		//x+2 x-7
		String ax = "x^2";
		ax += terms2.get(1)+"x"; 
		ax += terms1.get(1)+"x";
		ax += Integer.parseInt(terms1.get(1))*Integer.parseInt(terms2.get(1));
		System.out.println(ax);
	}
	
	public static ArrayList<Integer> getFactors(int nInput) 
	{ 

	int nNumberToFactor = nInput; 
	int nCurrentUpper = nInput; 
	int i; 

	ArrayList<Integer> factors = new ArrayList<Integer>(); 
	factors.add(1); 

	for (i = 2; i < nCurrentUpper; i++) 
	{ 
	if ((nNumberToFactor % i) == 0) 
	{
	
	nCurrentUpper = nNumberToFactor / i; 
	factors.add(i);

	if (nCurrentUpper != i) 
	factors.add(nCurrentUpper); 
	} 
	}
	 factors.add(nInput);
	return factors;
	}

}
