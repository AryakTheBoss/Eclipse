/**
 * 
 */
package email;

import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * @author Aryak
 *
 */
public class Sender {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Scanner s = new Scanner(System.in);
		
		System.out.println("Test Started!");
		
		 GoogleMail g = new GoogleMail();
		
		try {
			g.Send("dingosnsn", "dingoman123", "kiran.email@gmail.com", "Java", "This is a Test EMAIL SENT BY JAVA");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error!");
		}

		//s.close();
		
	}

}
