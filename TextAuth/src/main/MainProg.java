/**
 * 
 */
package main;
import java.awt.GridLayout;

import email.*;

import javax.swing.*;
/**
 * @author Aryak
 *
 */
public class MainProg {

	/**
	 * @param args
	 */
	private static boolean yes;
	
	public MainProg(boolean right){
		
		yes = right;
		
		System.out.println(yes);
	}
	
	public static void oldPasswordMatch(boolean xtra){
		
		if (xtra == false){
			
			//stuff
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String[] options = new String[] {"New", "Login", "Exit"};
		  int opp =  JOptionPane.showOptionDialog(null, "Pick an Option", "Epic System", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		        null, options, options[0]);
		
		  System.out.println(opp);
		
	}
	
	public static void login(){
		
		
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
		
		 int a=JOptionPane.showConfirmDialog(null,panel,"Login",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);  
		 
		 if (a == JOptionPane.OK_OPTION){
			 
			String str = textField.getText();
			String pswd = new String(passwordField.getPassword());
			 
			 AuthMe ff=new AuthMe(str,pswd,3);
			 
			 if (yes == true){
				 
				 JOptionPane.showMessageDialog(null, "Welcome"+str+"!");
				 userWindow();
			 }else{
				 JOptionPane.showMessageDialog(null,"Invalid Username or Password","Error!",JOptionPane.ERROR_MESSAGE);
				 
			 }
		 }
		
		
		
		
		
	}

	public static void newUser(){
		
		JPanel panel=new JPanel(); 
		 
		   
		 panel.setLayout(new GridLayout(4,1));  
		  
		  
		 JLabel username=new JLabel("Your new Username");  
		  
		 
		 JLabel password=new JLabel("Create a Password");  
		 
		 		  
		 
		 JTextField textField=new JTextField(12);  
		  
		 
		 JPasswordField passwordField=new JPasswordField(12);  
		  
		  
		 panel.add(username);  
		  
		 
		 panel.add(textField);  
		  
		  
		 panel.add(password);  
		  
		
		 panel.add(passwordField); 
		
		 int a=JOptionPane.showConfirmDialog(null,panel,"Create new Account",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);  
		 
		 if (a == JOptionPane.OK_OPTION){
			 
				String str = textField.getText();
				String pswd = new String(passwordField.getPassword());
				 
				 AuthMe ff=new AuthMe(str,pswd);
				 
				 
		
		
	}
	
	}
	
	public static void userWindow(){
		//new,login,exit
		String[] options = new String[] {"Chg Pw", "Logout", "Exit"};
		  int opp =  JOptionPane.showOptionDialog(null, "Pick an Option", "Epic System", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		        null, options, options[0]);
		
		switch (opp){
		
		case 1:
			
			login();
			break;
			
		case 2:
			System.exit(0);
		
			break;
			
		case 3:
			changePw();
			
			break;
		
		default:
			changePw();
		
		}
		
	}
	
	public static void changePw(){
		
		JPanel panel2=new JPanel(); 
		 
		   
		 panel2.setLayout(new GridLayout(4,1));  
		  
		  
		 JLabel username=new JLabel("Your Username");  
		  
		 
		 JLabel password=new JLabel("Old Password");  
		 JLabel newpswd=new JLabel("New Password");
		 
		 		  
		 
		 JTextField textField=new JTextField(12);  
		  
		 
		 JPasswordField passwordField=new JPasswordField(12);  
		 JPasswordField passwordField2=new JPasswordField(12);
		  
		  
		 panel2.add(username);  
		  
		 
		 panel2.add(textField);  
		  
		  
		 panel2.add(password);  
		  
		
		 panel2.add(passwordField); 
		 
		 panel2.add(newpswd);
		 
		 panel2.add(passwordField2);
		
		 int a=JOptionPane.showConfirmDialog(null,panel2,"Change PW",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);  
		 
		 if (a == JOptionPane.OK_OPTION){
			 
				String str = textField.getText();
				String pswd = new String(passwordField.getPassword());
				String pswd2 = new String(passwordField2.getPassword());
				 //oldpw,newpw,usrnm
				 AuthMe.changePassword(pswd,pswd2,str);
				 
				 
		
		
	}
		
		
	}
	
	public static void ForgotPassword(){
		
		
		
		
		
	}
	
}

