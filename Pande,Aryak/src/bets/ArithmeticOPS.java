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
			int num = Integer.parseInt(nums.get(0));
			nums.remove(0);

		}

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