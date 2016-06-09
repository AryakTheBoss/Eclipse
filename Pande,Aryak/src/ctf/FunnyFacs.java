/**
 * 
 */
package ctf;

/**
 * @author 17ap0497
 *
 */
public class FunnyFacs {

	/**
	 * @param args
	 * Keith has discovered a mysterious piece of paper, containing a mysterious formula:
x^2 + (5/3)x^3 + (23/12)x^4 + (119/60)x^5 ... + (2*[5000!-1]/[5000!])x^5000
//3! -1 / 3
//(3!-1/(3!/2))x^3	4!-1/12)
Keith was curious, and so decided to evaluate the expression for x=0.7893
What number was returned, to the nearest 20 decimal places?
	 */
	public static double sum = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(factorial(5));
		formula(0.7893);
		System.out.println(sum);
	}
	
	public static void formula(double x){
		 long f= 1;
		for(int i=2;i<=5000;i++){
			
			f = factorial(i);
			System.out.println(f+" "+i);
			sum += (2*(f-1)/f);//*(Math.pow(x, i));
			
			
		}
		
		
	}
	
	public static long factorial(int n)
	{
		if (n == 0)
			return 1;
		else
			return n * factorial(n-1);
	}

	
	
}
