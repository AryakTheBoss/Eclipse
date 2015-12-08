package bets;

import java.util.Scanner;

public class OpRunner {
	private static ArithmeticOPS a;
	public static void main(String[] args) {
		
	
		Scanner s = new Scanner(System.in);
		System.out.println("Enter yor string expression pls");
		String input = s.nextLine();
		a = new ArithmeticOPS(input);
		System.out.println(a);
	
		
		
		
	}
	
	
	
}
