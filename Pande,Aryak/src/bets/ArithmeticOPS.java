/**
 * 
 */
package bets;

import java.io.Serializable;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * @author 17ap0497
 *
 */
public class ArithmeticOPS{
	
	private Stack<String> ops;
	private Stack<String> nums;
	
	private String input;
	
	
	Vector<String> queue = new Vector<String>();
	
	public ArithmeticOPS(String arg){
		ops = null;
		nums = null;
		input = arg;
		splitInput();
		
	}
	
	
	
	private void splitInput() {
		Scanner s = new Scanner(input);
		while(s.hasNext()) {
			
		}
		
	}



	public int parseExp(String expression){
		
		expression.split("[1-9]");
		return 0;
		
	}


}