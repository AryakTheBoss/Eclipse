/**
 * 
 */
package main;
import javax.swing.*;

import java.io.*;
import java.util.*;
/**
 * @author Aryak
 *
 */
public class AuthMe { /*NOT A RUNNABLE CLASS*/
	
	//this is the universal class

	private String Password;  //varibles
	private String Username;
	private static String TPH;
	private static String TUH;
	private static String oldPassword, oldUsername;
	private static String xx;
	
	
	public AuthMe(){ //default !!DO NOT USE!!
		
		Password = "default";
		Username = "admin";
		
		
	}//END
	
	public AuthMe(String u, String p){ //Creates a new Account
		
		
		
		writeInformation(u,p);
		
		JOptionPane.showMessageDialog(null, "Success! Your Account Has Been Created!!");
		
		/*Writing to Text file code goes here!!*/
		
	}
	
	
		
	
	
	//mutator(s)
	
	public static void changePassword(String a,String o,String n){ //changes the password
		
		oldPassword = a;
		TPH = o;
		oldUsername = n;
		chgPwd();
		JOptionPane.showMessageDialog(null, "Password Changed! (Remember it!)");
		
		/*Writing to Text file code goes here!!*/
		
		
	}
	
	public void changeUsername(String us){
		
		TUH = us;
		
		JOptionPane.showMessageDialog(null, "Username Changed!");
	}
	
public AuthMe(String j, String l,int i){ //Enterign password
		
		
		
		searchInformation(j,l);
		
		
		
		/*Writing to Text file code goes here!!*/
		
	}
	
	public static void writeInformation(String Us,String Ps){
		
		
		 // The name of the file to open.
        String fileName = "C:\\Reference\\data.txt";
        String line;
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName,true);

            // Always wrap FileWriter in BufferedWriter.
            PrintWriter pp =
                new PrintWriter(fileWriter);
            
          //  Writer output;
           // output = new BufferedWriter(new FileWriter(fileName,true));
            line = Us+" "+Ps;
            //pp.println("\n");
            pp.println(line);
           
pp.close();
                
              
               
               
            // Note that write() does not automatically
            // append a newline character.
                
            

            // Always close files.
           
            
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
		
		
	}
	
	
	public static void chgPwd(){
		
		// The name of the file to open.
        String fileName = "C:\\Reference\\data.txt";
        String line = null;
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            
            FileReader fileReader = 
                    new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = 
                    new BufferedReader(fileReader);


            // Note that write() does not automatically
            // append a newline character.
                while((line = bufferedReader.readLine()) != null) {
                    
                	if (line.contains(oldUsername+" "+oldPassword)){
                		
                		
                		
                		TUH = oldUsername;
                		 bufferedReader.close();
                         bufferedWriter.close();
                		 write();
                         return;
                		
                	}else{
                		
                		TUH = "none";
                		
                	}
                	
                	
                }	
                
          
            if (TUH == "none"){
            	
            	MainProg.oldPasswordMatch(false);
            	
            }
            
           
            

            // Always close files.
            bufferedReader.close();
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
		
		
		
	}
	
	
	public static void searchInformation(String User,String Pass){	
		
		
		String fileName = "C:\\Reference\\data.txt";
		
		File f = new File(fileName);
        
		
		 
         
		
		// The name of the file to open.
        

        // This will reference one line at a time
        
        try {
            // FileReader reads text files in the default encoding.
            
        	 Scanner d = new Scanner(f);
String da;
         do  {
                
            	da = d.nextLine();
            	
            	if (da.matches(User+" "+Pass)){
            		
            		MainProg in=new MainProg(true);
            		d.close();
            		return;
            	}else{
            		
            		MainProg in2=new MainProg(false);
            		d.close();
            		return;
            	} 
            	
            	
            } while(d.hasNextLine());
         
        
         
            // Always close files.
          
        }
        catch(FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Unable to open file '" + fileName + "' make sure you have a folder in your C:\\ called \"Reference\" and a txt file in it named \"data.txt\"","Error",JOptionPane.ERROR_MESSAGE);	
           
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");					
            // Or we could just do this: 
            // ex.printStackTrace();
        }
       
        

	}
		public static void write(){
			try{
			String fileName = "C:\\Reference\\data.txt";
			FileWriter fileWriter =
	                new FileWriter(fileName);

	            // Always wrap FileWriter in BufferedWriter.
	            BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
	            
			 bufferedWriter.write(TUH+" "+TPH);
			bufferedWriter.close();
			}catch(FileNotFoundException ex) {
				String fileName = "C:\\Reference\\data.txt";
				JOptionPane.showMessageDialog(null,"Unable to open file '" + fileName + "' make sure you have a folder in your C:\\ called \"Reference\" and a txt file in it named \"data.txt\"","Error",JOptionPane.ERROR_MESSAGE);	
		           				
	            }
	            catch(IOException ex) {
	            	String fileName = "C:\\Reference\\data.txt";
	                System.out.println(
	                    "Error reading file '" 
	                    + fileName + "'");					
	                // Or we could just do this: 
	                // ex.printStackTrace();
	            }
		
	}}
	

