/**
 * 
 */
package spam;

//import java.awt.Dimension;
import java.awt.GridLayout;
//import java.util.Scanner;



import javax.mail.MessagingException;
//import javax.mail.internet.AddressException;
import javax.swing.*;

/**
 * @author Aryak
 *
 */
public class Spammer {

	/**
	 * @param args
	 */
	
	public static String uid,pw,StoreUID,StoreMessage,StoreEmail,StoreSubject,StorePhone;
	
	
	 
	
	
	public static void start(){
		
		
		     
				//Universal();
				UTextMessage();
				
		
		
	}
	
	public static void UTextMessage(){
		
		JOptionPane.showMessageDialog(null, "This App will use your email to Send a text message. It requires an internet connection and knowledge of the individual's phone provider(i.e. Verizon, AT&T etc.)\n im not stealing any account credentials TRUST ME. I actually don't really know what i get out of hacking peoples accounts,\n i say its pointless. So, Please login to gmail in the next window.");
		
		JPanel pane=new JPanel(); 
		 
		   
		 pane.setLayout(new GridLayout(4,1));  
		  
		  
		 JLabel namea=new JLabel("Username");  
		  
		 
		 JLabel pass=new JLabel("Password");  
		 
		 		  
		 
		 JTextField username=new JTextField(12);  
		  
		 
		 JPasswordField password=new JPasswordField(12);  
		 
		 if(StoreUID != null){
			 
			 username.setText(StoreUID);
			 
		 }
		  
		  
		 pane.add(namea);  
		  
		 
		 pane.add(username);  
		  
		  
		 pane.add(pass);  
		  
		
		 pane.add(password); 
		 
		 boolean B = false;
		 do{
		
		 int j=JOptionPane.showConfirmDialog(null,pane,"Login To Your GMAIL",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		 if(j == JOptionPane.OK_OPTION){
			 
			 if(username.getText().isEmpty() || new String(password.getPassword()).isEmpty()){
				 
				 JOptionPane.showMessageDialog(null, "Username or Password cannot be Empty!", "Error!", JOptionPane.ERROR_MESSAGE);
				//StoreUID = username.getText();
				 B = true;
				 
			 }else{
			 
			 uid = username.getText();
			 pw = new String(password.getPassword());
			 B = false;
			 }
		 }else{
			 
			 System.exit(0);
			 
		 }
		 
		 }while(B == true);
		 
		 //------------------------\\
		
		JPanel panel=new JPanel(); 
		 
		   
		 panel.setLayout(new GridLayout(4,1));  
		  
		  
		 JLabel name=new JLabel("Target Phone #");  
		  
		 
		 JLabel name1=new JLabel("Message");  
		 
		 JLabel numnam=new JLabel("Number of Times to send Message");  
		 		  
		 
		 JTextField email=new JTextField();  //12
		  
		 
		 JTextArea message=new JTextArea();  
		 
		 JTextField num = new JTextField(); //12
		  
          if(StorePhone != null){
			 
			 email.setText(StorePhone);
			 
		 }
		
		 
		 
		 if(StoreMessage != null){
			 
			 message.setText(StoreMessage);
			 
		 }
		
		 
		 panel.add(name);  
		  
		 
		 panel.add(email);  
		 
		 panel.add(numnam);
		 
		 panel.add(num);
		  
		  
		 panel.add(name1);  
		  
		 
		
		 panel.add(message);  
		 
		 boolean M = false;
		 int a;
		 do{
		 
		  a=JOptionPane.showConfirmDialog(null,panel,"Send Text",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		  
		  if(a == JOptionPane.OK_OPTION){
			  
			  if(email.getText().isEmpty() || message.getText().isEmpty() || email.getText().length() != 10){
				  
				  JOptionPane.showMessageDialog(null, "Phone # must be 10 digits and/or Message cant be empty", "Error!", JOptionPane.ERROR_MESSAGE);
				  StorePhone = email.getText();
				  StoreMessage = message.getText();
				  
				  M = true;
			  
			  
			  
		  }else{
				  
				  M = false;
				  
			  }
			  
		  }
		  
		 }while(M == true);
		 
		if(a == JOptionPane.OK_OPTION){
			
			 String[] options = new String[] {"AT&T", "VERIZON", "T-MOBILE","SPRINT","EXIT"};
			  int opp =  JOptionPane.showOptionDialog(null, "What is The Person's Phone Provider?", "Carrier Settings", 
			        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
			        null, options, options[0]);				
					
					if(opp == 0){  //at&t
						
						Google g = new Google(1);
						int i = -1;
						
						SpamATT(g,i,email,message,num);
						
					}else if(opp == 1){ //verizon
						
						Google g = new Google(1);
						int i = -1;
						
						SpamVerizon(g,i,email,message,num);
						
						
						
					}else if(opp == 2){ //tmobile
						
                          Google g = new Google(1);
                          int i = -1;
                          
						SpamTMobile(g,i,email,message,num);
						
						
					}else if(opp == 3){ //sprint
						
                         Google g = new Google(1);
						
						int i = -1;
						
						SpamSprint(g,i,email,message,num);
						
						
					}else{
						
						System.exit(0);
						
					}
					
		
		 

		//s.close();
		}else{
			
			System.exit(0);
			
		}
		
		start();
	}
	
	
	
		
		
	
	
	public static void Universal(){
		
		JPanel pane=new JPanel(); 
		 
		   
		 pane.setLayout(new GridLayout(4,1));  
		  
		  
		 JLabel namea=new JLabel("Username");  
		  
		 
		 JLabel pass=new JLabel("Password");  
		 
		 		  
		 
		 JTextField username=new JTextField(12);  
		  
		 
		 JPasswordField password=new JPasswordField(12);  
		 
		 if(StoreUID != null){
			 
			 username.setText(StoreUID);
			 
		 }
 
		  
		 pane.add(namea);  
		  
		 
		 pane.add(username);  
		  
		  
		 pane.add(pass);  
		  
		
		 pane.add(password); 
		 boolean B = false;
		 do{
		
		 int j=JOptionPane.showConfirmDialog(null,pane,"Login To Your GMAIL",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		 if(j == JOptionPane.OK_OPTION){
			 
			 if(username.getText().isEmpty() || new String(password.getPassword()).isEmpty()){
				 
				 JOptionPane.showMessageDialog(null, "Username or Password cannot be Empty!", "Error!", JOptionPane.ERROR_MESSAGE);
				
				 B = true;
				 
			 }else{
			 
			 uid = username.getText();
			 pw = new String(password.getPassword());
			 B = false;
			 }
		 }else{
			 
			 System.exit(0);
			 
		 }
		 
		 }while(B == true);
		 //------------------------\\
		
		JPanel panel=new JPanel(); 
		 
		   
		 panel.setLayout(new GridLayout(4,1));  
		  
		  
		 JLabel name=new JLabel("Email Address to Send Message");  
		  
		 
		 JLabel name1=new JLabel("Message");  
		 
		 JLabel sub=new JLabel("Subject");  
		 		  
		 
		 JTextField email=new JTextField();  //12
		  
		 
		 JTextArea message=new JTextArea();  
		 
		 JTextField subject = new JTextField(); //12
		  
		 if(StoreEmail != null){
			 
			 email.setText(StoreEmail);
			 
		 }
		
		 if(StoreSubject != null){
			 
			 subject.setText(StoreSubject);
			 
		 }
		 
		 if(StoreMessage != null){
			 
			 message.setText(StoreMessage);
			 
		 }
		 
		 panel.add(name);  
		  
		 
		 panel.add(email);  
		 
		 panel.add(sub);
		 
		 panel.add(subject);
		  
		  
		 panel.add(name1);  
		  
		 
		
		 panel.add(message);  
		 boolean M = false;
		 do{
		 
		 int a=JOptionPane.showConfirmDialog(null,panel,"Send Email",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		 
		 
		 
		 
		
		if(a == JOptionPane.OK_OPTION){
			
			if(!(email.getText().isEmpty()) && email.getText().indexOf("@") != -1){
				M = false;
				Google g = new Google(0);
				
				try {
					g.Send(uid, pw, email.getText(), subject.getText(), message.getText());
				} catch (MessagingException e) {
					
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Something Went Wrong! Maybe Your Password? Remember: you MUST have an internet connection! [ and make sure it doesn't Suck :P ]", "Oops!", JOptionPane.ERROR_MESSAGE);
					StoreUID = username.getText();
					StoreEmail = email.getText();
					StoreSubject = subject.getText();
					StoreMessage = message.getText();
					g.setFrame(false);
					
					return;
				}
				
			}else{
				
				 JOptionPane.showMessageDialog(null, "Email cannot be Empty! also must be valid", "Error!", JOptionPane.ERROR_MESSAGE);
				// StoreUID = username.getText();
					StoreEmail = email.getText();
					StoreSubject = subject.getText();
					StoreMessage = message.getText();
				M = true;
				
			}
		
		
		 

		//s.close();
		}else if(a == JOptionPane.CANCEL_OPTION){
			
			System.out.println("Bye!");
			System.exit(0);
		}
		 }while(M == true);
		
		
	}
		
		
	public static void SpamATT(Google g, int i,JTextField email, JTextArea message, JTextField num){
		
		while(Integer.parseInt(num.getText()) >= i){
		
			try {
				g.Send(uid, pw, email.getText()+"@mms.att.net", "", message.getText());
			} catch (MessagingException e) {
				
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Something Went Wrong! Maybe Your Password? Remember: you MUST have an internet connection! [ and make sure it doesn't Suck :P ]", "Oops!", JOptionPane.ERROR_MESSAGE);
				
				g.setFrame(false);
				
				return;
			}
			
			i++;
			g.update(i);
			
		}
		
		System.exit(0);
		
		
	}
	
	
	public static void SpamVerizon(Google g, int i,JTextField email, JTextArea message, JTextField num){
		
		while(Integer.parseInt(num.getText()) >= i){
			
			try {
				g.Send(uid, pw, email.getText()+"@vtext.net", "", message.getText());
			} catch (MessagingException e) {
				
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Something Went Wrong! Maybe Your Password? Remember: you MUST have an internet connection! [ and make sure it doesn't Suck :P ]", "Oops!", JOptionPane.ERROR_MESSAGE);
				
				g.setFrame(false);
				
				return;
			}
			
			i++;
			g.update(i);
			
		}
		
		System.exit(0);
		
		
		
	}
	
	public static void SpamTMobile(Google g, int i,JTextField email, JTextArea message, JTextField num){
		
		while(Integer.parseInt(num.getText()) >= i){
		
		try {
			g.Send(uid, pw, email.getText()+"@tmomail.net", "", message.getText());
		} catch (MessagingException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Something Went Wrong! Maybe Your Password? Remember: you MUST have an internet connection! [ and make sure it doesn't Suck :P ]", "Oops!", JOptionPane.ERROR_MESSAGE);
			
			g.setFrame(false);
			
			return;
		}
		
		
	}
	}
    public static void SpamSprint(Google g, int i,JTextField email, JTextArea message, JTextField num){
		
		while(Integer.parseInt(num.getText()) >= i){
		
			try {
				g.Send(uid, pw, email.getText()+"@messaging.sprintpcs.com", "", message.getText());
			} catch (MessagingException e) {
				
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Something Went Wrong! Maybe Your Password? Remember: you MUST have an internet connection! [ and make sure it doesn't Suck :P ]", "Oops!", JOptionPane.ERROR_MESSAGE);
				
				g.setFrame(false);
				
				return;
			}
		
		
	}
	}
	

}
