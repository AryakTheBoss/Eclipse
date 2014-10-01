/**
 * 
 */
package formval;

/**
 * @author Aryak
 *
 */
import javax.swing.*; 

import java.awt.*;
import java.util.*;
import java.applet.*;

/*

JPanel app=new JPanel();

JFrame thing=new JFrame();
	


app.setSize(400, 400);

  thing.setSize(400, 400);

  
thing.setTitle(Username + "\'s Window");
	  
  
  JLabel lab=new JLabel("   Hello");
  
  
  
  thing.add(lab);
  

  
  
  
  
  
  
  thing.setVisible(true);
  
  
    */


public class FormObject {
	
	public JPanel main = new JPanel();
	public JFrame in = new JFrame();
	
	public FormObject(String AppletTitle){
		
		
			
		main.setSize(600, 600);
		
		 main.setLayout(new GridLayout(4,1));  
		
		in.setSize(600, 600);
		
		in.setTitle(AppletTitle);
		
		
		
	}
	
	
	public void InitializeFields(){
		
		 JLabel FName=new JLabel("First Name");  
		  
		 
		 JLabel LName=new JLabel("Last Name");
		 
		 JLabel Minit = new JLabel("Middle Initial");
		 
		 JTextField fname=new JTextField(12);  
		  
		 
		 JTextField lname=new JTextField(12);  
		 
		 JTextField minit = new JTextField(12);
		  
	
		  
		 main.add(FName);  		  
		 
		 main.add(fname);  		
		 
		 main.add(Minit);
		 
		 main.add(minit);		
		 
		 

		 
		  
		  
		 main.add(LName);  		  
		
		 main.add(lname);  
		
		
		
	}
	
	

}
