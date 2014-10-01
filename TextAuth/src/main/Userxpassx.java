/**
 * 
 */
package main;

import javax.mail.MessagingException;
import javax.swing.*; 

import java.awt.*;
import java.util.*;
import java.applet.*;

import email.*;


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
	public static final int pwdCorrect = 1;
	public static final int pwdFalse = 2;
	public static final int pwdCancel = 3;
	public static final int pwdForgot = 4;
	public static int pwdStatus;
	public static int attempts = 10;
	public static String Password;
	public static String Username;
	public static String EMAIL;
	public static String PN;	
	public static int Delay = 10;
	public static long Time;
	public static int Timeint;
	public static int Tim;
	public static long Time2;
	public static String input;
	public static boolean bool = false;
	private static Object obj;
	private static Graphics comp;
	public static int prog = 100;
	public static GoogleMail gmail = new GoogleMail();
			
			public static void StopSeq(){
		
		System.out.println("Stopping...");
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		prog();
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
		
		
		JPanel panel=new JPanel(); 
		 
		   
		 panel.setLayout(new GridLayout(4,1));  
		  
		  
		 JLabel username=new JLabel("Username (You are making new account)");  
		  
		 
		 JLabel password=new JLabel("Password");  
		 
		 JLabel email=new JLabel("EMail (Will be used to recover password)");  
		 
		 JLabel ph= new JLabel("Phone #");  
		 		  
		 
		 JTextField usrnm=new JTextField(12);  
		 
		 JTextField emai=new JTextField(12);  
		 JTextField phone=new JTextField(12);  
		  
		 
		 JPasswordField passwordField=new JPasswordField(12);  
		  
		  
		 panel.add(username);  
		  
		 
		 panel.add(usrnm);  
		  
		  
		 panel.add(password);  
		  
		
		 panel.add(passwordField);  
		 
		 panel.add(email);
		 
		 panel.add(emai);
		 
		 panel.add(ph);
		 
		 panel.add(phone);
		
		int pwstat=0;
		
		int a=JOptionPane.showConfirmDialog(null,panel,"Create Account",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);  
		  
		if(a==JOptionPane.OK_OPTION &&new String(passwordField.getPassword()).equals(null) && usrnm.getText().equals(null) && emai.getText().equals(null) && phone.getText().equals(null)){
			
			
			Username = usrnm.getText();
			
			Password = new String(passwordField.getPassword());
			
			EMAIL = emai.getText();
			
			PN = phone.getText();			
			
		}
		
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
			 
			   
			 panel.setLayout(new GridLayout(4,1));  
			  
			  
			 JLabel username=new JLabel("Username");  
			  
			 
			 JLabel password=new JLabel("Password");  
			 
			 		  
			 
			 JTextField textField=new JTextField(12);  
			  
			 
			 JPasswordField passwordField=new JPasswordField(12);  
			  
			  
			 panel.add(username);  
			  
			 
			 panel.add(textField);  
			  
			  
			 panel.add(password);  
			  
			
			 panel.add(passwordField);  
			
			int pwstat=0;
			
			int a=JOptionPane.showConfirmDialog(null,panel,"Attention!",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);  
			  
			 
			 if(a==JOptionPane.YES_OPTION)  
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
			  
			 
			 else if(a==JOptionPane.CANCEL_OPTION)  
			 {  
			  JOptionPane.showMessageDialog(null,"Bye!");  
			  pwstat=3;
			  
			  //System.exit(0);
			 }else if(a==JOptionPane.NO_OPTION){
				 
				String str = JOptionPane.showInputDialog(null, "Enter Your email");
				 boolean s = str.equals(Username);
				 if(!s){
					 
					 
					 try {
							gmail.Send("dingosnsn", "dingoman123", EMAIL, "Password Recovery", "Hello, \n\n Your Password is: "+Password);
						} catch (MessagingException e) {
							
							e.printStackTrace();
							System.err.println("Error!");
						}
					 
					 
				 }else{
					 
					 
					 JOptionPane.showMessageDialog(null, "Incorrect Username");
					 
					 
				 }
				 
			 }
			//only works if i return a value here
			 
			 return pwstat;
			 
			 
		}
		
		
	}








