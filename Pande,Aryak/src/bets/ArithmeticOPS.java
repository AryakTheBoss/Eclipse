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
public class ArithmeticOPS {

	private Stack<String> ops = new Stack<String>();
	private Stack<String> nums = new Stack<String>();
	private static final String orderOfOps = "^*/+-";
	private int result = 0;

	private String input;

	Vector<String> queue = new Vector<String>();

	public ArithmeticOPS(String arg) {
		ops = null;
		nums = null;
		input = arg;
		splitInput();
		calculate();
	}

	private void calculate() {
		
		while (!nums.empty()) {
			int num = Integer.parseInt(nums.remove(0));
			String sign = nums.remove(0);
			int x = 0;
			while(!ops.isEmpty()) {
				if(ops.size() > 1 && orderOfOps.indexOf(ops.get(0)) > orderOfOps.indexOf(ops.get(1))) {
					nums.add(x, runNumbers(nums.remove(x),nums.remove(x),ops.remove(x + 1)));
					x = 0;
				}
				else if (ops.size() == 1) {
					nums.add(x, runNumbers(nums.remove(x),nums.remove(x),ops.remove(x + 1)));
				} {
					
				}
			}
			

		}

	}
	
	private String runNumbers(String num1, String num2, String op) {
		int num1i = Integer.parseInt(num1);
		int num2i = Integer.parseInt(num2);
		if(op == "^")
			return Math.pow(num1i, num2i)+"";
		else if(op == "*")
			return (num1i*num2i)+"";
		else if(op == "/")
			return (num1i/num2i)+"";
		else if(op == "+")
			return (num1i+num2i)+"";
		else if(op == "-")
			return (num1i-num2i)+"";
		
		return "Some shit went down";
	}

	private void splitInput() {
		Scanner s = new Scanner(input);
		while (s.hasNext()) {
			String hey = s.next();
			if (hey.matches("-?\\d+(\\.\\d+)?")) {
				nums.push(hey);
			} else
				ops.push(hey);
		}

	}

}