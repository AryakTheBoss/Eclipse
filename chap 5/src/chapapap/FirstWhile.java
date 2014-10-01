/**
 * 
 */
package chapapap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author 310843
 *
 */
public class FirstWhile {

	/**
	 * @param args
	 */
	public static long a,b;
static Random r = new Random();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 PrintWriter p = new PrintWriter("test.txt");
		
		b=1000;
	
		
		while(a<b){
			
			a++;
		   p.println("Spam");
			
			
		}
		
		p.close();
		

	}

}
