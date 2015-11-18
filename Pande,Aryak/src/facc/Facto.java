/**
 * 
 */
package facc;

/**
 * @author 17ap0497
 *
 */
public class Facto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(loop(7));
		System.out.println(recur(7));
		System.out.println(fib(7));

	}

	public static int loop(int num){
		
		int total = 1;
		for(int i=num;i>0;i--){
			
			total *= i;
			
		}
		return total;
		
	}
	public static long recur(int num){
		
		if(num == 1)
			return 1;
		
		return num * recur(num-1);
		
		
	}
	public static long fib(int n) {
        if (n <= 1) 
        	return n;
        else 
        	return fib(n-1) + fib(n-2);
    }
	public static String rev(String toRev){
		
		if(toRev.length == 1)
			return toRev;
		
		return toRev.substring(toRev.length-1,toRev.length) + rev();
		
	}
}
