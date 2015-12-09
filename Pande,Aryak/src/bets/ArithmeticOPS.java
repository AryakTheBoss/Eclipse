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
		input = arg;
		splitInput();
		calculate();
	}

	private void calculate() {
			int x = 0;
			while (!ops.isEmpty()) {
				System.out.println(x);
				String op = ops.get(x);
				if (op.equals("^")) {
					nums.add(x, runNumbers(nums.remove(x),nums.remove(x), ops.remove(x)));
					x = 0;
				} else if (op.equals("*")) {
					if(ops.indexOf("^") < 0) {
						nums.add(x, runNumbers(nums.remove(x),nums.remove(x), ops.remove(x)));
						x = 0;
					}
					else {
						x++;
					}
				} else if (op.equals("/")) {
					if(ops.indexOf("^") < 0) {
						nums.add(x, runNumbers(nums.remove(x),nums.remove(x), ops.remove(x)));
						x = 0;}
					else {
						x++;
					}
				} else if (op.equals("+")) {
					if(!(ops.contains("^") || ops.contains("*")|| ops.contains("/"))) {
						nums.add(x, runNumbers(nums.remove(x),nums.remove(x), ops.remove(x)));
						x = 0;
					}
					else {
						x++;
					}
				} else if (op.equals("-")) {
					if(!(ops.contains("^") || ops.contains("*")|| ops.contains("/"))) {
						nums.add(x, runNumbers(nums.remove(x),nums.remove(x), ops.remove(x)));
						x = 0;}
					else {
						x++;
					}
				}

			

		}

	}

	private String runNumbers(String num1, String num2, String op) {
		int num1i = Integer.parseInt(num1);
		int num2i = Integer.parseInt(num2);
		if (op.equals("^"))
			return Math.pow(num1i, num2i) + "";
		else if (op.equals("*"))
			return (num1i * num2i) + "";
		else if (op.equals("/"))
			return (num1i / num2i) + "";
		else if (op.equals("+"))
			return (num1i + num2i) + "";
		else if (op.equals("-"))
			return (num1i - num2i) + "";

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

	@Override
	public String toString() {
		return nums.pop();
	}

}
