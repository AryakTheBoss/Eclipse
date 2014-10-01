/**
 * 
 */
package authsrc;

import javax.swing.*; 

import com.sun.jmx.snmp.Timestamp;

import java.awt.*;
import java.util.*;
import java.applet.*;




/**
 * @author Aryak
 *
 */
@SuppressWarnings("unused")
public class Userxpassx{

	/**
	 * @param args
	 */
	//declare global variables
	public static int pwdCorrect = 1;
	public static int pwdFalse = 2;
	public static int pwdCancel = 3;
	public static int pwdStatus;
	public static int attempts = 10;
	public static final String Password = "wwp";
	public static final String Username = "south";
	public static final int Delay = 10;
	public static long Time;
	public static int Timeint;
	public static int Tim;
	public static long Time2;
	public static String input;
	public static boolean bool = false;
	private static Object obj;
	private static Graphics comp;
	public static int prog = 100;
			
			public static void StopSeq(){
		
		System.out.println("Stopping...");
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.util.Date date= new java.util.Date();
		 System.out.println(new Timestamp(date.getTime()).toString());
		
		//prog();
	}
	
	
		public static void alt(){
			
			
			JPanel app=new JPanel();
					
	        JFrame thing=new JFrame();
			
		
			
			
			
			app.setSize(400, 400);
			
			  thing.setSize(400, 400);
			
			  
			thing.setTitle(Username + "\'s Window");
				  
			  
			  JLabel lab=new JLabel("   Hello");
			  
			  
			  
			  thing.add(lab);
			  
			  
			  
			  
			  
			  
			  
			  
			  thing.setVisible(true);
			  
			  
			  
			  
			 
			  
              

			  
			  
			
			
		  
		  
		  
		  			 	   
	   
	  
	  
	}
	

	
	public static void prog(){
// Declaring variables
		
		
		
		
		
	  do {
		  
	    pwdStatus = pswd();
		  
		 if (pwdStatus == pwdCorrect)
		 {
			 JOptionPane.showMessageDialog(null,"Welcome!","Master Key",JOptionPane.INFORMATION_MESSAGE); 
			
			   alt();
			  return;
			   
		 }else if(pwdStatus == pwdFalse){
			 attempts--;
			// JOptionPane.showMessageDialog(null,"You are not The person im looking for." ,"Unauthorized Error!",JOptionPane.ERROR_MESSAGE);
			 JOptionPane.showMessageDialog(null,"Wrong! You have " + attempts + " attempts Left" ,"Unauthorized Error!",JOptionPane.WARNING_MESSAGE);
		 }else if (pwdStatus == pwdCancel){
			 
			// JOptionPane.showInternalMessageDialog(null, null);
			System.exit(0);
			
		 }
	  }while (attempts > 0 || Delay == 11);
	  
	  if(Delay == 11){
		  
		  //JOptionPane.showInternalMessageDialog(null, " ");
		  return;
	  }
		 
	  JOptionPane.showMessageDialog(null,"Sorry You are Having Trouble :(","Unauthorized Error!",JOptionPane.ERROR_MESSAGE);
		 
		 }
	
		
	
		
	 
		public static int pswd() {
			JPanel panel=new JPanel(); 
			 
			   
			 panel.setLayout(new GridLayout(1,4));  
			  
			  
			 JLabel username=new JLabel("Username");  
			  
			 
			 JLabel password=new JLabel("Password");  
			 
			 		  
			 
			 JTextField textField=new JTextField(12);  
			  
			 
			 JPasswordField passwordField=new JPasswordField(12);  
			  
			  
			 panel.add(username);  
			  
			 
			 panel.add(textField);  
			  
			  
			 panel.add(password);  
			  
			
			 panel.add(passwordField);  
			
			int pwstat=0;
			
			int a=JOptionPane.showConfirmDialog(null,panel,"Attention!",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);  
			  
			 
			 if(a==JOptionPane.OK_OPTION)  
			 {  
			  if(textField.getText().equals(Username)&&new String(passwordField.getPassword()).equals(Password))  
			  {  
			   
			   
			 pwstat=1;
				
			  }  
			  else  
			  { 
				  pwstat=2;
			   
			  }  
			 }  
			  
			 
			 else if(a==JOptionPane.CANCEL_OPTION || textField.getText().equals("stop"))  
			 {  
			  JOptionPane.showMessageDialog(null,"Bye!");  
			  pwstat=3;
			  
			  //System.exit(0);
			 }
			//only works if i return a value here
			 
			 return pwstat;
			 
			 
		}
		
		
	}








