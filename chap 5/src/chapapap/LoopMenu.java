/**
 * 
 */
package chapapap;

import java.text.DecimalFormat;
/**
 * @author 310843
 *
 */
import java.util.*;
public class LoopMenu {

	/**
	 * @param args
	 */
	 
	static Scanner k = new Scanner(System.in);
	static DecimalFormat money = new DecimalFormat("$0.0#");
	//static DecimalFormat percent = new DecimalFormat("");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int c;
		System.out.println("Welcome to");
		
		c= menu();
		
		while(c!=7){
			
			switch (c){
			
			case 1:
				//2 
				System.out.println("prob 1");
				
				Hi();
				break;
			case 2:
				//4
				System.out.println("prob 2");
				break;
			case 3:
				//5
				System.out.println("prob 3");
				break;
			case 4:
				prob7();
				break;
			case 5:
				
				break;
			case 6:
				
				break;
				
				default:
					System.out.println("Bad input");
			
			
			
			
			
			}
			
			System.out.println();
			c=menu();
		}
		

	} //degree symbol is: \u00B0

	public static int menu(){
		
		int choice;
		
		System.out.println("1. print shit");
		System.out.println("2. print hi");
		System.out.println("3. Commision");
		System.out.println("4. discount");
		System.out.println("5. intrest");
		System.out.println("6. circles");
		System.out.println("7. quit");
		
		choice = k.nextInt();
		
		return choice;
		
		
		
		
	}
	
	public static void Hi(){
		
		System.out.println("*\n*\n*\n*\n*\n*");
		
		
		
	}
	
	public static void prob7(){
		
		System.out.println("pick a start list price");
		int start = k.nextInt();
		
		System.out.println("pick end list price");
		int end = k.nextInt();
		
		System.out.println("pick an increment");
		int inc = k.nextInt();
		
		System.out.println("what is the discount");
		double discount = k.nextDouble();
		
		double current;
		double newp;
		
		current = start;
		
		System.out.println("------------------------------------------------------------------------------");
															
		while(current <= end){
			
			System.out.println(money.format(current));
		
			newp = current*discount;
			
			
			
			System.out.print("\t\t\t\t\t\t\t\t"+money.format(current - newp));
			
			System.out.println();
			
			current += inc;
			
			
			
		}
		
	}
	
}
