/**
 * 
 */
package calcsrc;

import java.util.Scanner;

import javax.swing.JOptionPane;



/**
 * @author Aryak
 *
 */
public class AdvCalc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
intro(); 

	}


		
	   
		
		

	public static void intro(){
		
		
		JOptionPane.showMessageDialog(null, "Welcome! Open this Jar With CMD If you Havent already");
		
		Prog();
		
	}
	
public static void alt(){
		
		
		Prog();
		
	}
	
	public static void Prog(){
		
		 @SuppressWarnings("unused")
			int Operator;     //declare varibles
		    
		    @SuppressWarnings("resource")
			Scanner keyboard=new Scanner(System.in);
		    
		    int Answer,Input,Input2;
		    String InputCh;
		    
		    
			
			System.out.println("Please Enter The First value [You can Get a Chance Next Window that opens in which you can stop this loop]");
			
			Input=keyboard.nextInt();
			
			
			
			System.out.println("Please Enter An Operator [You can Also Close This App by typing the word : stop (+,-,*,/,%)");		
			
			InputCh=keyboard.next();
			
if(InputCh.contains("stop")){
				
				System.out.println("Stopping...");
				System.exit(0);
			}
			
			System.out.println("Please Enter The Second value");
			
			Input2=keyboard.nextInt();
			
			if(InputCh.contains("*")){
				
				Answer = Input*Input2;
				
				System.out.println(Input + " * " + Input2 + " = " + Answer);
				alt();
			}
			
	if(InputCh.contains("+")){
				
				Answer = Input+Input2;
				
				System.out.println(Input + " + " + Input2 + " = " + Answer);
				
				alt();
				
			}
			
	if(InputCh.contains("-")){
		
		Answer = Input-Input2;
		
		System.out.println(Input + " - " + Input2 + " = " + Answer);
		alt();
	}
	if(InputCh.contains("/")){
		
		Answer = Input/Input2;
		
		System.out.println(Input + " / " + Input2 + " = " + Answer);
		alt();
	}

	if(InputCh.contains("%")){
		
		Answer = Input%Input2;
		
		System.out.println(Input + " % " + Input2 + " = " + Answer);
		alt();
	}


		
		
		
	}
	
	
	
}

