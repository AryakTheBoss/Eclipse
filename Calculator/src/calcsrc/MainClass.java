/**
 * 
 */
package calcsrc;

import javax.swing.JOptionPane;

import java.util.Scanner;

/**
 * @author Aryak
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		intro();
		
	    int Operator;     //declare varibles
	    
	    @SuppressWarnings("resource")
		Scanner keyboard=new Scanner(System.in);
	    
	    int Answer,Input,Input2;
	    String InputCh;
	    
	    
		
		System.out.println("Please Enter a Value (Decimals will NOT Work)");
		Input=keyboard.nextInt();
		InputCh=keyboard.next();
		System.out.println(InputCh);
		
		
		System.out.println("Now Enter an Operator (enter 1 for *, 2 for - , 3 for + , 4 for / , and 5 for %)");
		
		Operator=keyboard.nextInt();
		
if(Operator >= 6){
			
			
			JOptionPane.showMessageDialog(null, "OOPS! LOOKS LIKE YOU HAVE ENTERED A LARGER OPERATOR VALUE THAN WHATS GIVEN! [Program will Terminate]");
			
			System.exit(0);
			
		}
		
		System.out.println("Ok Now give me another Number (Again Decimals will NOT work)");
		
		Input2=keyboard.nextInt();
		
		
		
		if(Operator == 1){
			
			Answer=Input*Input2;
			
			System.out.println(Input + " * " + Input2 + " = " + Answer);
			
			
		}
		
		if(Operator == 2){
			
			Answer=Input-Input2;
			
			System.out.println(Input + " - " + Input2 + " = " + Answer);
			
			
		}
		
		if(Operator == 3){
			
			Answer=Input+Input2;
			
			System.out.println(Input + " + " + Input2 + " = " + Answer);
			
		}
		
		if(Operator == 4){
			
			Answer=Input/Input2;
			
			System.out.println(Input + " / " + Input2 + " = " + Answer);
			
		}
		
		
		if(Operator == 5){
			
			Answer=Input%Input2;
			
			System.out.println(Input + " % [Mod] " + Input2 + " = " + Answer);
		}
		
		
		
		
		
	}

	public static void intro(){
		
		
		JOptionPane.showMessageDialog(null, "Welcome! To use this claculator please open this jar with CMD by using this list of commands: \n\n cd (location of file [ex: C:/Users/(name)/Desktop])\n then type: java -jar (name of file).jar");
		
		
		
	}
	
	
}
