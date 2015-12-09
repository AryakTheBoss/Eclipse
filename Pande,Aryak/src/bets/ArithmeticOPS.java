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

		while (!nums.empty()) {
			int num = Integer.parseInt(nums.remove(0));
			String sign = nums.remove(0);
			int x = 0;
			while (!ops.isEmpty()) {
				String op = ops.remove(0);
				if (op.equals("*")) {
					
				} else if (op.equals("/")) {

				} else if (op.equals("+")) {

				} else if (op.equals("-")) {

				}

			}

		}

	}

	private String runNumbers(String num1, String num2, String op) {
		int num1i = Integer.parseInt(num1);
		int num2i = Integer.parseInt(num2);
		if (op == "^")
			return Math.pow(num1i, num2i) + "";
		else if (op == "*")
			return (num1i * num2i) + "";
		else if (op == "/")
			return (num1i / num2i) + "";
		else if (op == "+")
			return (num1i + num2i) + "";
		else if (op == "-")
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

}
