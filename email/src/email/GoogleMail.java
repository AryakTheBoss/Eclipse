/**
 * 
 */
package email;

/**
 * @author Aryak
 *
 */

//import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

import com.sun.mail.smtp.SMTPTransport;

public class GoogleMail {

	/**
	 * @param args
	 */
	 public static PBE bar = new PBE();
	 public static int percent = 0;
	 public static boolean boo;
	 public static String ee;
	 public static JFrame frame;

	public GoogleMail(int type) {
		
		if(type == 0){
			
			frame = new JFrame("Email Sender");	
			
		}else{
			
			frame = new JFrame("Text Sender");
			
		}
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setContentPane(bar);
	   frame.pack();
	   frame.setSize(500, 200);
	   
	    frame.setVisible(true);
		
    }
	
	public void setFrame(boolean on){
		
		frame.setVisible(on);
		
	}

    /**
     * Send email using GMail SMTP server.
     *
     * @param username GMail username
     * @param password GMail password
     * @param recipientEmail TO recipient
     * @param title title of the message
     * @param message message to be sent
     * @throws AddressException if the email address parse failed
     * @throws MessagingException if the connection is dead or not in the connected state or if the message is not a MimeMessage
     */
    public void Send(final String username, final String password, String recipientEmail, String title, String message) throws AddressException, MessagingException {
        GoogleMail.Send(username, password, recipientEmail, "", title, message);
       
    }

    /**
     * Send email using GMail SMTP server.
     *
     * @param username GMail username
     * @param password GMail password
     * @param recipientEmail TO recipient
     * @param ccEmail CC recipient. Can be empty if there is no CC recipient
     * @param title title of the message
     * @param message message to be sent
     * @throws AddressException if the email address parse failed
     * @throws MessagingException if the connection is dead or not in the connected state or if the message is not a MimeMessage
     */
    public static void Send(final String username, final String password, String recipientEmail, String ccEmail, String title, String message) throws AddressException, MessagingException {
    	// Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");     
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

        
        /*
        If set to false, the QUIT command is sent and the connection is immediately closed. If set 
        to true (the default), causes the transport to wait for the response to the QUIT command.

        ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
                http://forum.java.sun.com/thread.jspa?threadID=5205249
                smtpsend.java - demo program from javamail
        */
        props.put("mail.smtps.quitwait", "false"); //end sec 1
        
        frame.setName("Getting Ready...");
        bar.updateBar(0,"Adding Properties to Secure HTTPS...");
        
        try {
			java.lang.Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
       

        Session session = Session.getInstance(props, null);

        // -- Create a new message --
        final MimeMessage msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(username)); //deleted:  + " @gmail.com "
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));
        
        //sec 2
        frame.setName("Initializing...");
        bar.updateBar(0,"Establishing Secure Connection...");
        try {
			java.lang.Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
      
        if (ccEmail.length() > 0) {
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
        }

        msg.setSubject(title);
        msg.setText(message, "utf-8");
        msg.setSentDate(new Date());

        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");
//sec 3
        frame.setName("Initializing...");
        bar.updateBar(0,"Logging in...");
        try {
			java.lang.Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        frame.setName("Logged In!");
       
       
        t.connect("smtp.gmail.com", username, password);
        t.sendMessage(msg, msg.getAllRecipients());
        
        bar.updateBar(0,"Ok!");
        try {
			java.lang.Thread.sleep(600);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        
        //sec 4
        frame.setName("Sending...");
        bar.updateBar(0,"Loading...");
        t.close();
        for(int i=0; i<=100; i++){
        bar.updateBar(i, Integer.toString(i)+"%");
        try {
			java.lang.Thread.sleep(100);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        }
        try {
			java.lang.Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        frame.setName("Succsess!!");
        bar.updateBar(100, "Sent!");
        try {
			java.lang.Thread.sleep(1500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        System.exit(0);
        
    }
	
}
