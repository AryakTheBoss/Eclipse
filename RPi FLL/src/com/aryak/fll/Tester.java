/**
 * 
 */
package com.aryak.fll;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * @author ARYAK
 *
 */
public class Tester {

	/**
	 * @param args
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void main(String[] args) throws AddressException, MessagingException {
		// TODO Auto-generated method stub

		System.out.println("Version 1.0");
		System.out.println("Sending....");
		TextMessage.Send("Car Temperature is above safe levels");
		System.out.println("Sent!");
	}

}
