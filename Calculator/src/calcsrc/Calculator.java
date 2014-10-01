/**
 * 
 */
package calcsrc;

/**
 * @author Aryak
 *
 */
import java.util.Scanner;


public class Calculator {

	/**
	 * @param args
	 */
	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Type Five Numbers pressing enter after each");
		
		int val1,val2,val3,val4,val5;
		
		  val1 = s.nextInt();		  
		  val2 = s.nextInt();
		  val3 = s.nextInt();
		  val4 = s.nextInt();
		  val5 = s.nextInt();
		  
		  System.out.println("Choose Operator (1 = add , 2 = - , 3 = * 4 = /)");
		
		int op = 0;
		
		int ans = 0;
		
		double ansdiv = 0;
		
	   op = s.nextInt();
		
	   if(op == 1){
		   
		   ans = Addition(val1,val2,val3,val4,val5);
		   
	   }else if (op == 2){
		   
		 ans =  Subtraction(val1,val2,val3,val4,val5);
		   
		   
	   }else if (op == 3){
		   
		  ans = Multi(val1,val2,val3,val4,val5);
		   
	   }else{
		   
		   ansdiv = Division(val1,val2,val3,val4,val5);
		   
	   }
	   
	   
	   System.out.println("Answer is: "+ans+"(If Applicble for division)"+ansdiv);

	}
	
	
	
 public static int Addition(int val1,int val2,int val3, int val4, int val5){
	 
	return val1+val2+val3+val4+val5;
	 
 }
 
 public static int Subtraction(int val1,int val2,int val3, int val4, int val5){
	 
	 return val1-val2-val3-val4-val5;
	 
	 
 }
 
 public static int Multi(int val1,int val2,int val3, int val4, int val5){
	 
	 return val1*val2*val3*val4*val5;
 }
 
 public static double Division(int val1,int val2,int val3, int val4, int val5){
	 
	 return val1/val2/val3/val4/val5;
	 
 }//% NOT INCLUDED BECAUSE IM LAZY
 
}
