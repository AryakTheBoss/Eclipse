/**
 * 
 */
package authsrc;
import java.awt.*;

import java.io.*;
import java.applet.*;
import javax.security.auth.login.*;
/**
 * @author Aryak
 *
 */
public class Dingo {

    public static void main(String[] args){
    	
    	
    	

    	
    	    

    	        // The name of the file to open.
    	        String fileName = "C:\\Reference\\story.txt";

    	        // This will reference one line at a time
    	        String line = null;

    	        try {
    	            // FileReader reads text files in the default encoding.
    	            FileReader fileReader = 
    	                new FileReader(fileName);

    	            // Always wrap FileReader in BufferedReader.
    	            BufferedReader bufferedReader = 
    	                new BufferedReader(fileReader);

    	            while((line = bufferedReader.readLine()) != null) {
    	                System.out.println(line);
    	            }	

    	            // Always close files.hhhh
    	            bufferedReader.close();			
    	        }
    	        catch(FileNotFoundException ex) {
    	            System.out.println(
    	                "Unable to open file '" + 
    	                fileName + "'");				
    	        }
    	        catch(IOException ex) {
    	            System.out.println(
    	                "Error reading file '" 
    	                + fileName + "'");					
    	            // Or we could just do this: 
    	            // ex.printStackTrace();
    	        }
    	    }
    	
    	
    	
    	
    }
	

