/**
 * 
 */
package bs;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import email.*;

/**
 * @author UnityBoss
 *
 */
public class AboutListener implements ActionListener{
	
	private static String[] options = {"Send Feedback","Close"};
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		int u = JOptionPane.showOptionDialog(null, "Battleship v3.5b\nMade by: DatJavaMaster(AryakTheBoss)\nIf you want to contribute to the development,\nPlease send me feedback by pressing that button. (NOTE: Internet Connection Required!!)", "About", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);    
		
		if(u == 0){
			
			try {
				if(Boolean.parseBoolean(Battleship.en.decrypt(Battleship.udata.get(16))) == true) {
					
					JOptionPane.showMessageDialog(null, "Sorry! You have already sent an email! (No Spam :3)","ERROR!" ,JOptionPane.ERROR_MESSAGE );
					
				}else{
					
						showFeedbackWindow();
					
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		
		
	}
	
	private static void showFeedbackWindow() throws Exception{
		
		/*JPanel panel=new JPanel(); 
		 
		   
		 panel.setLayout(new GridLayout(3,1));  
		 // panel.setSize(400, 400);
		  
	//	JLabel username=new JLabel("Phone Number: (ex. 5554443333)");  
		  
		 JLabel email=new JLabel("Your Email:");
		 
		 JLabel car = new JLabel("Rating:");
		 
		 JLabel password=new JLabel("Feedback:");  
		 
		 //JLabel passwordconf = new JLabel("Confirm Password:");		  
		 
		// JTextField textField=new JTextField(12);  
		 JTextField emailt=new JTextField(12); 
		 JComboBox<String> carrier = new JComboBox<String>();
		 JTextArea passwordField=new JTextArea();  
		// JPasswordField conf = new JPasswordField(12);
		 //passwordField.setText("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		 passwordField.setMaximumSize(new Dimension(50,100));
		 passwordField.setPreferredSize(new Dimension(10,50));
		 carrier.addItem("Select One");
		 carrier.addItem("EPIC");
		 carrier.addItem("Excellent");
		 carrier.addItem("Cool");
		 carrier.addItem("Good");
		 carrier.addItem("Great");
		 carrier.addItem("Pretty Good");
		 carrier.addItem("Pretty bad");
		 carrier.addItem("Bad");
		 carrier.addItem("Very Bad D:");
		 
		  
		//panel.add(username);  
		  
		 
		//panel.add(textField);  
		
		panel.add(car);
		
		panel.add(carrier);
		  
		 panel.add(email);
		 
		 panel.add(emailt);
		  
		 panel.add(password);  
		  
		
		 panel.add(passwordField); 
		 
		// panel.add(passwordconf);
		 
		// panel.add(conf);
		
		 int x;
		 for(;;){
		 x = JOptionPane.showConfirmDialog(null,panel,"Send",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE); 
		 
		 if(x == JOptionPane.OK_OPTION){
			 
			 if(emailt.getText().isEmpty() || carrier.getSelectedItem().equals("Select One") || passwordField.getText().isEmpty()){  
				 
				 JOptionPane.showMessageDialog(null, "You must fill in All fields!", "ERROR!", JOptionPane.ERROR_MESSAGE);  
				 continue;
			 }else{
				 GoogleMail gm = new GoogleMail(0);
				 try {
					gm.Send("java.safe.dev@gmail.com", "javabossizzmeh123", "pandeary12@gmail.com", carrier.getSelectedItem().toString(), "FROM: "+emailt.getText()+"\nCOMMENTS:\n\n"+passwordField.getText());
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				 
				 Battleship.udata.set(16, Battleship.en.encrypt(""+true));
				 try {
					Battleship.write(Battleship.udata, Battleship.userData);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				 
				 break;
				 
			 }
			 
		 }else{
			 
			 break;
			 
		 }
				 
		 
		 
		 }
		
		
	}*/
	
	}

}
