package pm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;

import emai.GoogleMail;

//import timer.PBE;

/** Basic Information
 * @author Aryak
 * @version 7.5
 * 
 * Excellent Documentation :D
 * 
 * Planned: 
 * v3.3 - BUG FIX UPDATE
 * v4.1 - MULTI-USER UPDATE
 * v4.2 - LOGOUT BUTTON
 * v4.3 - Fixes a Logout Bug that may show the previous users passwords.
 * v4.3.2 - Fixes a bug that could crash the program if you pressed cancel in the choose username dialog.
 * v4.3.3 - minor UI tweaks
 * v4.3.7 - fixes a bug that allows security qs and sign up fields to be blank.
 * v4.5 - if you have many passwords, the list will now be scrollable.
 * v4.6 - fixes erase data bug where the user data may not be completely erased.
 * v4.6.2 - UI tweaks
 * v4.7 - fixes the file not found bug below.
 * v5.1 - CHANGEABLE THEME UPDATE!
 * v5.1.1 - it will now save which theme each user picked
 * v5.1.2 - cannot choose the same theme that it is on. and other UI tweaks
 * v5.1.3 - bug fixes 
 * v6.1 - phone number field and able to reset sequrity questions by text message
 * v6.2 - UI tweaks
 * v6.5 - edit account info (username,email,phone,carrier)
 * v6.7 - 2 step verification
 * v6.8 - option to enable password confirmation everytime you press show password.
 * v6.9 - show password lock bugs are fixed
 * v6.10 - bug fixed that could allow someone to bypass your protect showpassword option. also the show password option in the file is now encrypted.
 * v6.11 - backup keys are now encrypted.
 * v7.1 - added more security by generating a new backup key everytime you enable 2-step verification 
 * v7.1.1 - fixed bugs
 * v7.2 - EVEN MORE security by generating a NEW backup code each time you use one.
 * v7.3 - password confirmation for disabling 2-step verification
 * v7.4 - UI tweaks
 * v7.5 - bug fixes
 * v8.0 - now uses RSA-2048
 *  Behold the LEGENDARY JAVASAFE!! Have Fun Remembering your Passwords!
 * 
 *  
 *  
 *  
 *  
 * 
 * */

public class JavaSafe{
public static int INDEX = -1;
public static String LOOKANDFEEL,THEME,US;
public static final String ALLTEL = "@text.wireless.alltel.com";
public static final String ATT = "@txt.att.net";
public static final String CINGULAR = "@cingularme.com";
public static final String BOOST = "@myboostmobile.com";
public static final String CRICKET = "@sms.mycricket.com";
public static final String METRO = "@mymetropcs.com";
public static final String SPRINT = "@messaging.sprintpcs.com";
public static final String SN = "@page.nextel.com";
public static final String STRAIGHT = "@VTEXT.COM";
public static final String TMOBILE = "@tmomail.net";
public static final String USCELL = "@email.uscc.net";
public static final String VERIZON = "@vtext.com";
public static final String VIRGIN = "@vmobl.com";
private static Encryptor e = new Encryptor();
private static String nmd;
private static File userData;
private static File passwords; 
private static File dir; 
private static File securityQ;
private static File dira,dd4;
public static final int KEY = 0;
public static boolean TYPE;
public static boolean NEW = false;
public static JMenuBar menu = new JMenuBar();
public static final int USERNAME = 1;
public static final int PASSWORD = 3;
public static final int EMAIL = 2; //TODO UPP
public static final int LAF = 4;
public static final int PHONE = 5;
public static final int CARRIER = 6;
public static final int CONF = 7;
public static final int BACKUP = 8;
public static final int SHOW = 9;
public static final int COUNT = 10;
public static int CODECOUNT = 0;
public static ArrayList<String> loginData;
public static JScrollPane scrollPane;
public static ArrayList<String> passwordDataBase,securityQs;
public static JList<Object> listOfPasswords;
public static ArrayList<String> names = new ArrayList<String>(),
usernames = new ArrayList<String>(),
pswds = new ArrayList<String>();

//public static String[][] pswds;

public static void main(String[] args)throws Exception{
	
	//System.out.println(Calendar.getInstance().getTime()); 
	
	temp();
	 
	
}

public static void temp()throws Exception{
	
	//System.out.println(e.encrypt("JavaSafeData"));
	Thread.sleep(400); 
	load();
	
}
public static void load()throws Exception{
	
if(System.getProperty("os.name").compareToIgnoreCase("mac os x") == 0){
		
		initLookAndFeel("Nimbus",null);
		
	}else if(System.getProperty("os.name").startsWith("Windows")){
		
		initLookAndFeel("Nimbus",null);
		
	}else{
		
		initLookAndFeel("Metal","DefaultMetal");
		
	}
			
			
	
	
	nmd = e.encrypt("JavaSafeData");
	
	String[] optionsf = new String[] {"New User", "Existing User","Quit"};
	 int opp =  JOptionPane.showOptionDialog(null, "Who Are You?", "Choose", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		        null, optionsf, optionsf[0]);
	 
	 if(opp == 0){
		// String nmd = e.encrypt("JavaSafeData");
		 String input;
		 for(;;){
		 
		 input = JOptionPane.showInputDialog("Pick a New Username for the Account (Ex. Bob)");
		 if(input != null){
			 if(!input.isEmpty()){
		 if(System.getProperty("os.name").compareToIgnoreCase("mac os x") == 0){
			 
			 dira = new File("/Users/"+System.getProperty("user.name")+"/Library/Application Support/"+nmd+"/"+input);
			 if(dira.exists()){
				 
				 JOptionPane.showMessageDialog(null, "That Username is already taken.", "Username Taken", JOptionPane.ERROR_MESSAGE); 
				 continue;
				 
			 }else{
				US = input;
				init(input);	
				Thread.sleep(120);
				start();
				 break;
				 
			 }
		 }else if(System.getProperty("os.name").startsWith("Windows")){
			 
			 dira = new File("C:/Users/"+System.getProperty("user.name")+"/AppData/Roaming/"+nmd+"/"+input);
         if(dira.exists()){
				 
				 JOptionPane.showMessageDialog(null, "That Username is already taken.", "Username Taken", JOptionPane.ERROR_MESSAGE); 
				 continue;
				 
			 }else{
				 
				 US = input;
					init(input);		
					Thread.sleep(120);
					start();
					 break;
			 }
		 }
		 
		 }else{
			 
			 JOptionPane.showMessageDialog(null, "Username Can\'t be empty.", "Empty", JOptionPane.ERROR_MESSAGE);
			 continue;
			 
		 }
		 }else{
			 
			 //reload option dialog
			 temp();
			 return;
		 }
		 }//end loop
		 
	 }else if(opp == 1){
		 
		 //existing user
		 
		 if(System.getProperty("os.name").compareToIgnoreCase("mac os x") == 0){
			 
			 File s = new File("/Users/"+System.getProperty("user.name")+"/Library/Application Support/"+nmd);
			 if(s.exists()){
				 
				 userboot();
				 
			 }else{
				 
				 JOptionPane.showMessageDialog(null, "There are No existing Users!", "No Existing Users", JOptionPane.ERROR_MESSAGE); 
				 temp();
				 
			 }
			 
		 }else if(System.getProperty("os.name").startsWith("Windows")){
			 File ss = new File("C:/Users/"+System.getProperty("user.name")+"/AppData/Roaming/"+nmd);
             if(ss.exists()){
				 
				 userboot();
				 
			 }else{
				 
				 JOptionPane.showMessageDialog(null, "There are No existing Users!", "No Existing Users", JOptionPane.ERROR_MESSAGE); 
				 temp();
				 
			 }
			 
		 }
		 
		
		 
		 
	 }else{
		 
		 System.exit(0);
		 
	 }
	
	
}


public static void init(String username)throws Exception{//TODO init
	
	//String nmd = e.encrypt("JavaSafeData"); 
	if(System.getProperty("os.name").compareToIgnoreCase("mac os x") == 0){
	
		
		userData = new File("/Users/"+System.getProperty("user.name")+"/Library/Application Support/"+nmd+"/"+username+"/user.dat");
		passwords = new File("/Users/"+System.getProperty("user.name")+"/Library/Application Support/"+nmd+"/"+username+"/passwords.db");
		dir = new File("/Users/"+System.getProperty("user.name")+"/Library/Application Support/"+nmd+"/"+username);
		securityQ = new File("/Users/"+System.getProperty("user.name")+"/Library/Application Support/"+nmd+"/"+username+"/SecurityQuestions.dat");
		
 	}else if(System.getProperty("os.name").startsWith("Windows")){ 
		
		userData = new File("C:/Users/"+System.getProperty("user.name")+"/AppData/Roaming/"+nmd+"/"+username+"/user.dat");
		passwords = new File("C:/Users/"+System.getProperty("user.name")+"/AppData/Roaming/"+nmd+"/"+username+"/passwords.db");
		dir = new File("C:/Users/"+System.getProperty("user.name")+"/AppData/Roaming/"+nmd+"/"+username);
		securityQ = new File("C:/Users/"+System.getProperty("user.name")+"/AppData/Roaming/"+nmd+"/"+username+"/SecurityQuestions.dat");
		
	}else{
		
		JOptionPane.showMessageDialog(null, "Your OS is unrecognized! IMPORTANT! READ: Therefore the passwords will be stored in the documents folder with the name \"JavaSafeData\". Currently this program is compatible with ALL OSs but it will be the MOST Secure and effective on Mac OS X and Windows. Linux and Ubuntu will be added in the next update. This could be a bug so please contact the developer.", "OS ERROR!", JOptionPane.ERROR_MESSAGE);
		userData = new File("/Users/"+System.getProperty("user.name")+"/Documents/JavaSafeData/user.dat");
		passwords = new File("/Users/"+System.getProperty("user.name")+"/Documents/JavaSafeData/passwords.db");
		dir = new File("/Users/"+System.getProperty("user.name")+"/Documents/JavaSafeData");
		securityQ = new File("/Users/"+System.getProperty("user.name")+"/Documents/JavaSafeData/SecurityQuestions.dat");
		
	}
	
	
	
}

	public static void start() throws Exception { //TODO start
		
		if(dir.exists()){
			
			
			userboot();
			
		}else{
			
			dir.mkdirs();
		
			userData.createNewFile();
			passwords.createNewFile();
			securityQ.createNewFile();
			newuser();
		}

	}
	private static void initLookAndFeel(String LaF,String theme) { //TODO LaF
    	LOOKANDFEEL = LaF;
    	THEME = theme;
	        String lookAndFeel = null;
	        
	        
	        if (LOOKANDFEEL != null) {
	            if (LOOKANDFEEL.equals("Metal")) {
	                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
	              //  an alternative way to set the Metal L&F is to replace the 
	              // previous line with:
	              // lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
	                
	            }
	            
	            else if (LOOKANDFEEL.equals("System")) {
	                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
	            } 
	            
	            else if (LOOKANDFEEL.equals("Motif")) {
	                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	            } 
	            
	            else if (LOOKANDFEEL.equals("Nimbus")) { 
	                lookAndFeel = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	try {
		            	
		            	
		                UIManager.setLookAndFeel(lookAndFeel);
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	                
	            }else if(LOOKANDFEEL.equals("Acryl")){ 
	            	
	           
	            	try {
		            	
		            	
		                UIManager.setLookAndFeel(new AcrylLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }else if(LOOKANDFEEL.equals("Aero")){
	            	
	try {
		            	
		            	
		                UIManager.setLookAndFeel(new AeroLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		               
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }else if(LOOKANDFEEL.equals("Aluminium")){
	            	
	try {
		            	
		            	
		                UIManager.setLookAndFeel(new AluminiumLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }else if(LOOKANDFEEL.equals("Bernstein")){
	            	
	try {
		            	
		            	
		                UIManager.setLookAndFeel(new BernsteinLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }else if(LOOKANDFEEL.equals("Fast")){
	            	
	try {
		            	
		            	
		                UIManager.setLookAndFeel(new FastLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }else if(LOOKANDFEEL.equals("HiFi")){
	            	
	try {
		            	
		            	
		                UIManager.setLookAndFeel(new HiFiLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }else if(LOOKANDFEEL.equals("McWin")){
	            	
	try {
		            	
		            	
		                UIManager.setLookAndFeel(new McWinLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }else if(LOOKANDFEEL.equals("Mint")){
	            	
	try {
		            	
		            	
		                UIManager.setLookAndFeel(new MintLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }else if(LOOKANDFEEL.equals("Noire")){
	            	
	try {
		            	
		            	
		                UIManager.setLookAndFeel(new NoireLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }else if(LOOKANDFEEL.equals("Smart")){
	            	
	try {
		            	
		            	
		                UIManager.setLookAndFeel(new SmartLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }else if(LOOKANDFEEL.equals("Luna")){
	            	
	try {
		            	
		            	
		                UIManager.setLookAndFeel(new LunaLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }else if(LOOKANDFEEL.equals("Texture")){
	            	
	try {
		            	
		            	
		                UIManager.setLookAndFeel(new TextureLookAndFeel());
		                
		                // If L&F = "Metal", set the theme
		                
		                if (LOOKANDFEEL.equals("Metal")) {
		                  if (THEME.equals("DefaultMetal"))
		                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		                  else if (THEME.equals("Ocean"))
		                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		                  
		                     
		                     
		                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		                }	
		                	
		                	
		                  
		                
		            } 
		            
		          /*  catch (ClassNotFoundException e) {
		                System.err.println("Couldn't find class for specified look and feel:"
		                                   + lookAndFeel);
		                System.err.println("Did you include the L&F library in the class path?");
		                System.err.println("Using the default look and feel.");
		            } */
		            
		            catch (UnsupportedLookAndFeelException e) {
		                System.err.println("Can't use the specified look and feel ("
		                                   + lookAndFeel
		                                   + ") on this platform.");
		                System.err.println("Using the default look and feel.");
		            } 
		            
		            catch (Exception e) {
		                System.err.println("Couldn't get specified look and feel ("
		                                   + lookAndFeel
		                                   + "), for some reason.");
		                System.err.println("Using the default look and feel.");
		                e.printStackTrace();
		            }
	            	
	            }
	            
	            else {
	                System.err.println("Unexpected value of LOOKANDFEEL specified: "
	                                   + LOOKANDFEEL);
	                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
	            }

	            
	        }
	    }
public static void userboot() throws HeadlessException, Exception{//TODO userboot
	
	JPanel pl=new JPanel();  
	 
	   
	 pl.setLayout(new GridLayout(2,1));  
	  
	  
	 JLabel username=new JLabel("Username");   
	  
	 
	 JLabel password=new JLabel("Password");  
	 
	 		  
	 
	 JTextField textField=new JTextField(12);  
	  
	 
	 JPasswordField passwordField=new JPasswordField(12);  
	  
	  
	 pl.add(username);  
	  
	 
	 pl.add(textField);  
	  
	  
	 pl.add(password);  
	  
	
	 pl.add(passwordField);  
	 int c;
	 int count = 0;
	 String[] optionsd = new String[] {"Forgot Password", "OK"};
	 String[] optionsf = new String[] {"Forgot Answers","OK"};
	 for(;;){
		 count++;   
		 
	c =  JOptionPane.showConfirmDialog(null,pl,"Login",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
	
	if(c == JOptionPane.OK_OPTION){
	if(System.getProperty("os.name").compareToIgnoreCase("mac os x") == 0){
		
		dd4 = new File("/Users/"+System.getProperty("user.name")+"/Library/Application Support/"+nmd+"/"+textField.getText());
		if(dd4.exists()){
			
			init(textField.getText());
			
		}else{
			
			JOptionPane.showMessageDialog(null, "That Username does not exist.", "Unknown User", JOptionPane.ERROR_MESSAGE); 
			continue;
		}
		
		
	}else if(System.getProperty("os.name").startsWith("Windows")){
		
		dd4 = new File("C:/Users/"+System.getProperty("user.name")+"/AppData/Roaming/"+nmd+"/"+textField.getText());
        if(dd4.exists()){
			
			init(textField.getText());
			
		}else{
			
			JOptionPane.showMessageDialog(null, "That Username does not exist.", "Unknown User", JOptionPane.ERROR_MESSAGE); 
			continue;
		}
	}
	}else{
		
		 load();
		 return;
		
	}
	
	securityQs = read(securityQ);
	loginData = read(userData);
	CODECOUNT = Integer.parseInt(loginData.get(COUNT)); 
	if(c == JOptionPane.CANCEL_OPTION){
		
		JOptionPane.showMessageDialog(null, "BYE");
		System.exit(0); 
	}else if(c == JOptionPane.OK_OPTION){
		
		if(textField.getText().matches(loginData.get(USERNAME)) && new String(passwordField.getPassword()).matches(e.decrypt(loginData.get(PASSWORD)))){ 
			
			if(e.decrypt(loginData.get(CONF)).matches("true")){  
				
				String[] array = new String[]{"Continue","Phone is Unavailable"};
				
				int xp = JOptionPane.showOptionDialog(null, "Your Account Has 2-Step Verification Enabled.", "2-Step Verification", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, array, array[0]); 
				
				if(xp == 0){
					
					String cc,code; //TODO FINISH
					int d1,d2,d3,d4,d5,d6;
					Random ri = new Random();
					d1 = ri.nextInt(10);
					d2 = ri.nextInt(10);
					d3 = ri.nextInt(10);
					d4 = ri.nextInt(10);
					d5 = ri.nextInt(10);
					d6 = ri.nextInt(10);
					code = String.valueOf(d1)+String.valueOf(d2)+String.valueOf(d3)+String.valueOf(d4)+String.valueOf(d5)+String.valueOf(d6);
					GoogleMail gm = new GoogleMail(0);
					
					cc = "";
					
					if(e.decrypt(loginData.get(CARRIER)).matches("Alltel Wireless")){
						
						cc = ALLTEL;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("AT&T")){
						
						cc = ATT;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("Cingular")){
						
						cc = CINGULAR;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("Boost Mobile")){
						
						cc = BOOST;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("Cricket")){
						
						cc = CRICKET;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("Metro PCS")){
						
						cc = METRO;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("Sprint")){
						
						cc = SPRINT;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("Sprint (Nextel)")){
						
						cc = SN;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("Straight Talk")){
						
						cc = STRAIGHT;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("T-Mobile")){
						
						cc = TMOBILE;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("U.S. Cellular")){
						
						cc = USCELL;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("Verizon")){
						
						cc = VERIZON;
						
					}else if(e.decrypt(loginData.get(CARRIER)).matches("Virgin Mobile")){
						
						cc = VIRGIN;
						
					}
					JOptionPane.showMessageDialog(null, "Please be Patient this may take a while depending on your internet connection. click ok to continue.", "Please Wait", JOptionPane.WARNING_MESSAGE); 
					gm.Send("java.safe.dev@gmail.com", "javabossizzmeh123", e.decrypt(loginData.get(PHONE))+cc, "", "Your Secret Code is: "+code); 
					int repeats = 0;
					for(;;){
						repeats++;
						String i = JOptionPane.showInputDialog(null, "Please enter the 6 Digit Code You got on your phone:", "2-Step Verification", JOptionPane.QUESTION_MESSAGE); 
						
						if(i.matches(code)){
							
							JOptionPane.showMessageDialog(null, "Logged in!");
							break;
							
						}else{
							
							JOptionPane.showMessageDialog(null, "Invalid Code!", "Invalid!", JOptionPane.ERROR_MESSAGE);  
							//continue;
						}
						if(repeats >= 3){
							
							JOptionPane.showMessageDialog(null, "Sorry You are having trouble. Try Again Later.", "Invalid!", JOptionPane.ERROR_MESSAGE);  
							System.exit(0);
							
						}
						
					}
				}else{
					
					int a = JOptionPane.showConfirmDialog(null, "Do you have the Backup code that was Given to you?", "Backup Code", JOptionPane.YES_NO_OPTION);  
					
					if(a == JOptionPane.YES_OPTION){
						int iop = 0;
						for(;;){
							iop++;
						String kk = JOptionPane.showInputDialog("Great! please enter or paste the backup code:"); //TODO BACKUP
						
						if(e.decrypt(kk).matches(e.decrypt(loginData.get(BACKUP)))){
							
							JOptionPane.showMessageDialog(null, "Backup Code Confirmed. A New backup code is now on your desktop. \nThe one you entered just now is now INVALID.\nNext time you dont have accsess to your phone, you must use the new code.");
							
							File f = new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+loginData.get(USERNAME)+"s BACKUP CODE"+"("+CODECOUNT+")"+".txt");  
							
							if(f.exists()){
								
								f.delete();
								Thread.sleep(100);
								CODECOUNT++;
								f = new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+loginData.get(USERNAME)+"s BACKUP CODE"+"("+CODECOUNT+")"+".txt");
								f.createNewFile();
							}else{
								
								CODECOUNT++;
								f = new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+loginData.get(USERNAME)+"s BACKUP CODE"+"("+CODECOUNT+")"+".txt");
								f.createNewFile();
								
							
							}
							
							loginData.set(BACKUP, e.encrypt(newBackupCode())); 
							write(loginData,userData);
							
							PrintWriter pww = new PrintWriter(f);
							pww.println(loginData.get(BACKUP));
							pww.println("\nPLEASE CLOSE THIS FILE AFTER COPYING THE CODE! \nNOTE: On Mac, press CMD+C to COPY and then in the java app DO CTRL-V");
							pww.close();
							
							break;
						}else{
							
							JOptionPane.showMessageDialog(null, "Invalid Code!", "Invalid!", JOptionPane.ERROR_MESSAGE);
							
						}
						
						if(iop >= 3){
							
							JOptionPane.showMessageDialog(null, "Sorry You are having trouble. Try Again Later.", "Invalid!", JOptionPane.ERROR_MESSAGE);  
							System.exit(0);
							
						}
						
						
						}
						
					}else{
						
						JOptionPane.showMessageDialog(null, "Oops. Well due to security reasons, you wont be able to access your account until your phone is available.", "Sorry!", JOptionPane.ERROR_MESSAGE);  
						System.exit(0);
					}
					
					
				}
				
				
				//JOptionPane.showMessageDialog(null, "Your Account has 2-Step Verification Enabled.", title, messageType);
				
				
			}else{
				
				JOptionPane.showMessageDialog(null, "Logged in!");
				
			}
			
			
			
			break;
		}else{
			if(count >= 4){
			
			int ttyl = JOptionPane.showOptionDialog(null, "Invalid! Press Forgot Password if you have forgotten it!", "ERROR!", 
			        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
			        null, optionsd, optionsd[0]);
			if(ttyl == 0){
				
				JPanel secqs = new JPanel();
				//open security qs and the email
				secqs.setLayout(new GridLayout(3,1)); 
				JLabel s1 = new JLabel(e.decrypt(securityQs.get(0))+"?"); 
				 JLabel s2 = new JLabel(e.decrypt(securityQs.get(2))+"?");
				 JLabel s3 = new JLabel(e.decrypt(securityQs.get(4))+"?"); 
				
				 
				
				 JPasswordField ans1 = new JPasswordField(12);
				
				 JPasswordField ans2 = new JPasswordField(12);
				
				 JPasswordField ans3 = new JPasswordField(12);
				 
				 secqs.add(s1);
				
				 secqs.add(ans1);
				 secqs.add(s2);
				
				 secqs.add(ans2);
				 secqs.add(s3);
				
				 secqs.add(ans3);
				 int d1,d2,d3,d4,d5,d6;
				 String code;
				 String cc;
				 for(;;){
				int exp=  JOptionPane.showConfirmDialog(null,secqs,"Verify Your Identity",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				 
				if(exp == JOptionPane.CANCEL_OPTION){
					
					//continue;
					break;
					
				}else{
					 
					if(e.decrypt(securityQs.get(1)).matches(new String(ans1.getPassword())) && e.decrypt(securityQs.get(3)).matches(new String(ans2.getPassword())) && e.decrypt(securityQs.get(5)).matches(new String(ans3.getPassword()))){
						
						JOptionPane.showMessageDialog(null, "Your Secret Questions have been Confirmed! An Email will be sent to you with your login Details!"); 
						GoogleMail gm = new GoogleMail(0);			
						gm.Send("java.safe.dev@gmail.com", "javabossizzmeh123", e.decrypt(loginData.get(EMAIL)), "Your JavaSafe Credentials", "Hello, \n\n Your login details are as follows: \n\n Username: "+loginData.get(USERNAME)+"\nPassword: "+e.decrypt(loginData.get(PASSWORD)));  
						JOptionPane.showMessageDialog(null, "Email Sent!"); 
						
						System.exit(0);
						
					}else{
						
						int ttyk = JOptionPane.showOptionDialog(null, "The Answers you Provided are Invalid!", "Error!", 
						        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
						        null, optionsf, optionsf[0]);
						
						if(ttyk == 0){
							
							
							if(loginData.get(CARRIER).matches("Not Shown")){
								JOptionPane.showMessageDialog(null, "You said your carrier is not shown so we cant help you :(", "No Carrier", JOptionPane.ERROR_MESSAGE);
								break;
							}
							JOptionPane.showMessageDialog(null, "If you have forgotten Both your password and your sequrity Qs then you can verfiy your identity by text message.\n i hope you put your REAL phone number in the signup field :P", "Phone", JOptionPane.WARNING_MESSAGE);
							Random ri = new Random();
							d1 = ri.nextInt(10);
							d2 = ri.nextInt(10);
							d3 = ri.nextInt(10);
							d4 = ri.nextInt(10);
							d5 = ri.nextInt(10);
							d6 = ri.nextInt(10);
							code = String.valueOf(d1)+String.valueOf(d2)+String.valueOf(d3)+String.valueOf(d4)+String.valueOf(d5)+String.valueOf(d6);
							GoogleMail gm = new GoogleMail(0);
							
							cc = "";
							
							if(e.decrypt(loginData.get(CARRIER)).matches("Alltel Wireless")){
								
								cc = ALLTEL;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("AT&T")){
								
								cc = ATT;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("Cingular")){
								
								cc = CINGULAR;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("Boost Mobile")){
								
								cc = BOOST;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("Cricket")){
								
								cc = CRICKET;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("Metro PCS")){
								
								cc = METRO;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("Sprint")){
								
								cc = SPRINT;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("Sprint (Nextel)")){
								
								cc = SN;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("Straight Talk")){
								
								cc = STRAIGHT;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("T-Mobile")){
								
								cc = TMOBILE;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("U.S. Cellular")){
								
								cc = USCELL;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("Verizon")){
								
								cc = VERIZON;
								
							}else if(e.decrypt(loginData.get(CARRIER)).matches("Virgin Mobile")){
								
								cc = VIRGIN;
								
							}
							JOptionPane.showMessageDialog(null, "Please be Patient this may take a while depending on your internet connection. click ok to continue.", "Please Wait", JOptionPane.WARNING_MESSAGE); 
							gm.Send("java.safe.dev@gmail.com", "javabossizzmeh123", e.decrypt(loginData.get(PHONE))+cc, "", "Your Secret Code is: "+code); 
							for(;;){
							String rply = JOptionPane.showInputDialog("Please Enter the code you got on your phone:");
							
							if(rply.matches(code)){
								
								JOptionPane.showMessageDialog(null, "OK! Identity Verified. Here is your Account Info:\n\nUsername: "+loginData.get(USERNAME)+"\nPassword: "+e.decrypt(loginData.get(PASSWORD))+"\nSecret Answer 1: "+e.decrypt(securityQs.get(1))+"\nSecret Answer 2: "+e.decrypt(securityQs.get(3))+"\nSecret Answer 3: "+e.decrypt(securityQs.get(5)));           
								System.exit(0); 
							}else if(rply.isEmpty()){
							System.exit(0); 
							}else{
								
								JOptionPane.showMessageDialog(null, "Wrong Secret Code!", "Error!", JOptionPane.ERROR_MESSAGE); 
								continue;
							}
							}
							//TODO send TEXT
							
						}else{
							
							continue;
							
						}
						
												
					}
					
					
				}
				 
			}

				
			}else{
				
				continue;
				
			}
			}else{
				//JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				//playSound(errorSound); 
				int tty = JOptionPane.showOptionDialog(null, "Invalid Username or Password!", "ERROR!", 
				        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
				        null, optionsd, optionsd[0]);
				
				if(tty == 0){
					
					JPanel secqs = new JPanel();
					//open security qs and the email
					secqs.setLayout(new GridLayout(3,1)); 
					JLabel s1 = new JLabel(e.decrypt(securityQs.get(0))+"?"); 
					 JLabel s2 = new JLabel(e.decrypt(securityQs.get(2))+"?");
					 JLabel s3 = new JLabel(e.decrypt(securityQs.get(4))+"?"); 
					// JLabel a1 = new JLabel("Answer Question I:");
					// JLabel a2 = new JLabel("Answer Question II:");
					// JLabel a3 = new JLabel("Answer Question III:");
					 
					// JTextField ques1 = new JTextField(12);
					 JPasswordField ans1 = new JPasswordField(12);
					 //JTextField ques2 = new JTextField(12);
					 JPasswordField ans2 = new JPasswordField(12);
					// JTextField ques3 = new JTextField(12);
					 JPasswordField ans3 = new JPasswordField(12);
					 
					 secqs.add(s1);
					// secqs.add(ques1);
					// secqs.add(a1);
					 secqs.add(ans1);
					 secqs.add(s2);
					// secqs.add(ques2);
					// secqs.add(a2);
					 secqs.add(ans2);
					 secqs.add(s3);
					// secqs.add(ques3);
					// secqs.add(a3);
					 secqs.add(ans3);
					 int d1,d2,d3,d4,d5,d6;
					 String code;
					 String cc;
					for(;;){ 
					int exp=  JOptionPane.showConfirmDialog(null,secqs,"Verify Your Identity",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
					 
					if(exp == JOptionPane.CANCEL_OPTION){
						
						//continue;
						break;
						
					}else{
						
						if(e.decrypt(securityQs.get(1)).matches(new String(ans1.getPassword())) && e.decrypt(securityQs.get(3)).matches(new String(ans2.getPassword())) && e.decrypt(securityQs.get(5)).matches(new String(ans3.getPassword()))){
							
							JOptionPane.showMessageDialog(null, "Your Secret Questions have been Confirmed! An Email will be sent to you with your login Details!"); 
							GoogleMail gm = new GoogleMail(0);			
							gm.Send("java.safe.dev@gmail.com", "javabossizzmeh123", e.decrypt(loginData.get(EMAIL)), "Your JavaSafe Credentials", "Hello, \n\n Your login details are as follows: \n\n Username: "+loginData.get(USERNAME)+"\nPassword: "+e.decrypt(loginData.get(PASSWORD)));  
							JOptionPane.showMessageDialog(null, "Email Sent!"); 
							
							System.exit(0);
							
						}else{
							
							int ttyk = JOptionPane.showOptionDialog(null, "The Answers you Provided are Invalid!", "Error!", 
							        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
							        null, optionsf, optionsf[0]);
							if(ttyk == 0){
								
								
								if(loginData.get(CARRIER).matches("Not Shown")){
									JOptionPane.showMessageDialog(null, "You said your carrier is not shown so we cant help you :(", "No Carrier", JOptionPane.ERROR_MESSAGE);
									break;
								}
								JOptionPane.showMessageDialog(null, "If you have forgotten Both your password and your sequrity Qs then you can verfiy your identity by text message.\n i hope you put your REAL phone number in the signup field :P", "Phone", JOptionPane.WARNING_MESSAGE);
								Random ri = new Random();
								d1 = ri.nextInt(10);
								d2 = ri.nextInt(10);
								d3 = ri.nextInt(10);
								d4 = ri.nextInt(10);
								d5 = ri.nextInt(10);
								d6 = ri.nextInt(10);
								code = String.valueOf(d1)+String.valueOf(d2)+String.valueOf(d3)+String.valueOf(d4)+String.valueOf(d5)+String.valueOf(d6);
								GoogleMail gm = new GoogleMail(0);
								
								cc = "";
								
								if(e.decrypt(loginData.get(CARRIER)).matches("Alltel Wireless")){
									
									cc = ALLTEL;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("AT&T")){
									
									cc = ATT;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("Cingular")){
									
									cc = CINGULAR;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("Boost Mobile")){
									
									cc = BOOST;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("Cricket")){
									
									cc = CRICKET;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("Metro PCS")){
									
									cc = METRO;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("Sprint")){
									
									cc = SPRINT;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("Sprint (Nextel)")){
									
									cc = SN;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("Straight Talk")){
									
									cc = STRAIGHT;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("T-Mobile")){
									
									cc = TMOBILE;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("U.S. Cellular")){
									
									cc = USCELL;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("Verizon")){
									
									cc = VERIZON;
									
								}else if(e.decrypt(loginData.get(CARRIER)).matches("Virgin Mobile")){
									
									cc = VIRGIN;
									
								}
								JOptionPane.showMessageDialog(null, "Please be Patient this may take a while depending on your internet connection. click ok to continue.", "Please Wait", JOptionPane.WARNING_MESSAGE); 

								gm.Send("java.safe.dev@gmail.com", "javabossizzmeh123", e.decrypt(loginData.get(PHONE))+cc, "", "Your Secret Code is: "+code); 
								for(;;){
								String rply = JOptionPane.showInputDialog("Please Enter the code you got on your phone:");
								
								if(rply.matches(code)){
									
									JOptionPane.showMessageDialog(null, "OK! Identity Verified. Here is your Account Info: (You might want to write it down)\n\nUsername: "+loginData.get(USERNAME)+"\nPassword: "+e.decrypt(loginData.get(PASSWORD))+"\nSecret Answer 1: "+e.decrypt(securityQs.get(1))+"\nSecret Answer 2: "+e.decrypt(securityQs.get(3))+"\nSecret Answer 3: "+e.decrypt(securityQs.get(5)));           
									System.exit(0); 
								}else if(rply.isEmpty()){
									System.exit(0); 
								}else{
									
									JOptionPane.showMessageDialog(null, "Wrong Secret Code!", "Error!", JOptionPane.ERROR_MESSAGE); 
									continue;
								}
								}
								//TODO send TEXT
								
							}else{
								
								continue;
								
							}
							
						}
						
					}
					 
				}

					
				}else{
					
					continue;
					
				}
				
			}
			
		}
		
	}
	
	 }
	 initLookAndFeel(loginData.get(LAF),null);
	 passwordDataBase = read(passwords);
	 String[] options = new String[] {"SECURE", "NORMAL"}; //button mode strings
	 if(NEW == false){
	 JOptionPane.showMessageDialog(null,"Your Theme is Initialized.", "Theme", JOptionPane.INFORMATION_MESSAGE);
	 }
	 for(;;){
	  int opp =  JOptionPane.showOptionDialog(null, "Would you like to boot into Secure Mode or Normal Mode? \nSecure Mode is when your passwords are always encrypted unless you choose to decrypt them to view them.\nNormal Mode is an insecure mode where you passwords are autmatically decrypted. if you press view or edit, they will be visible.\n(THE FILE WHERE THE PASSWORDS ARE STORED WILL ALWAYS BE ENCRYPTED)", "Choose Mode", 
	        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
	        null, options, options[0]);	
	  if(opp == 0){
		  TYPE = true;
		  UI();
		  
		  break;
	  }else{
		  
		 int i= JOptionPane.showConfirmDialog(null, "WARNING! This mode may reveal your passwords to people standing behind you! Are you Sure?", "WARNING!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		  if(i == JOptionPane.NO_OPTION){
			 continue;
		  }else{
			  TYPE = false;
			  UI();
			  
			  break;
		  }
		  
	  }
	 }
	 
	
}



public static void newuser() throws Exception{//TODO newuser
	NEW = true;
	JPanel panel=new JPanel(); 
	 
	   
	 panel.setLayout(new GridLayout(5,1));  
	  
	  
	JLabel username=new JLabel("Phone Number: (ex. 5554443333)");  
	  
	 JLabel email=new JLabel("Your Email:");
	 
	 JLabel car = new JLabel("Your Phone Carrier: (Used to send a text)");
	 
	 JLabel password=new JLabel("Pick a Strong Password:");  
	 
	 JLabel passwordconf = new JLabel("Confirm Password:");		  
	 
	 JTextField textField=new JTextField(12);  
	 JTextField emailt=new JTextField(12); 
	 JComboBox<String> carrier = new JComboBox<String>();
	 JPasswordField passwordField=new JPasswordField(12);  
	 JPasswordField conf = new JPasswordField(12);
	 
	 carrier.addItem("Select One");
	 carrier.addItem("Alltel Wireless");
	 carrier.addItem("AT&T");
	 carrier.addItem("Cingular");
	 carrier.addItem("Boost Mobile");
	 carrier.addItem("Cricket");
	 carrier.addItem("Metro PCS");
	 carrier.addItem("Sprint");
	 carrier.addItem("Sprint (Nextel)");
	 carrier.addItem("Straight Talk");
	 carrier.addItem("T-Mobile");
	 carrier.addItem("U.S. Cellular");
	 carrier.addItem("Verizon");
	 carrier.addItem("Virgin Mobile");
	 carrier.addItem("Not Shown");
	  
	panel.add(username);  
	  
	 
	panel.add(textField);  
	
	panel.add(car);
	
	panel.add(carrier);
	  
	 panel.add(email);
	 
	 panel.add(emailt);
	  
	 panel.add(password);  
	  
	
	 panel.add(passwordField); 
	 
	 panel.add(passwordconf);
	 
	 panel.add(conf);
	 
	 int x;
	 
	 for(;;){
	 
	  x = JOptionPane.showConfirmDialog(null,panel,"Sign Up",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);  
	  
	  if(x == JOptionPane.CANCEL_OPTION){
		  
		  JOptionPane.showMessageDialog(null, "Bye"); 
		  userData.delete();
		  passwords.delete();
		  securityQ.delete();
		  dir.delete();
		  
		  System.exit(0); 
	  }else{ //TODO security qs and signup can be empty fields.
		  
		  if(emailt.getText().isEmpty() || new String(passwordField.getPassword()).isEmpty() || new String(conf.getPassword()).isEmpty() || textField.getText().isEmpty() || carrier.getSelectedItem().toString().matches("Select One")){ 
			  
			  JOptionPane.showMessageDialog(null, "Fields Cannot be Empty!", "ERROR!", JOptionPane.ERROR_MESSAGE);
			  continue;
		  }
		  
		  if(new String(passwordField.getPassword()).matches(new String(conf.getPassword()))){
			  
			 // e.setPassword(new String(passwordField.getPassword()));
			  break;
			  
		  }else{
			  
			  JOptionPane.showMessageDialog(null, "Passwords Don\'t match", "ERROR!", JOptionPane.ERROR_MESSAGE); 
			  
		  }
		  
	  }
	  
	 }
	 if(carrier.getSelectedItem().toString().matches("Not Shown")){
	 JOptionPane.showMessageDialog(null, "Sorry your carrier isn\'t supported yet. but if you drop me an email to java.safe.dev@gmail.com ill try to add the carrier :) \n Please note that at the moment we cant reset your security q's if you forget them becuase of this.", "Unsupported Carrier :(", JOptionPane.WARNING_MESSAGE);
	 }
	 JOptionPane.showMessageDialog(null, "You will now create some secret questions and answers\n to verify your identity if you ever forget your password.", "WARNING!", JOptionPane.WARNING_MESSAGE);
	 JPanel secqs = new JPanel();
	 secqs.setLayout(new GridLayout(3,1));  
	 JLabel s1 = new JLabel("Enter Secret Question Number I:");
	 JLabel s2 = new JLabel("Enter Secret Question Number II:");
	 JLabel s3 = new JLabel("Enter Secret Question Number III:");
	 JLabel a1 = new JLabel("Answer Question I:");
	 JLabel a2 = new JLabel("Answer Question II:");
	 JLabel a3 = new JLabel("Answer Question III:");
	 
	 JTextField ques1 = new JTextField(12);
	 JPasswordField ans1 = new JPasswordField(12);
	 JTextField ques2 = new JTextField(12);
	 JPasswordField ans2 = new JPasswordField(12);
	 JTextField ques3 = new JTextField(12);
	 JPasswordField ans3 = new JPasswordField(12);
	 
	 secqs.add(s1);
	 secqs.add(ques1);
	 secqs.add(a1);
	 secqs.add(ans1);
	 secqs.add(s2);
	 secqs.add(ques2);
	 secqs.add(a2);
	 secqs.add(ans2);
	 secqs.add(s3);
	 secqs.add(ques3);
	 secqs.add(a3);
	 secqs.add(ans3);
	 int op;
	 for(;;){
	 op = JOptionPane.showConfirmDialog(null,secqs,"Security Questions",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);  
	 if(ques1.getText().isEmpty() || ques2.getText().isEmpty() || ques3.getText().isEmpty() || new String(ans1.getPassword()).isEmpty() || new String(ans2.getPassword()).isEmpty() || new String(ans3.getPassword()).isEmpty()){
		 
		 JOptionPane.showMessageDialog(null, "Fields Can\'t be Empty!", "Fields Empty", JOptionPane.ERROR_MESSAGE); 
		 continue;
	 }
	 if(op == JOptionPane.CANCEL_OPTION){
		  
		  JOptionPane.showMessageDialog(null, "Bye"); 
		  userData.delete();
		  passwords.delete();
		  securityQ.delete();
		  dir.delete();		 
		  System.exit(0); 
		  
	  }else{
		 
	 PrintWriter write = new PrintWriter(userData);
	 PrintWriter wr = new PrintWriter(passwords);
	 PrintWriter wrr = new PrintWriter(securityQ);
	 Random r = new Random();
	double jj =  r.nextDouble();
	 wrr.println(e.encrypt(ques1.getText()));  
	 wrr.println(e.encrypt(new String(ans1.getPassword())));
	 wrr.println(e.encrypt(ques2.getText()));  
	 wrr.println(e.encrypt(new String(ans2.getPassword())));
	 wrr.println(e.encrypt(ques3.getText()));  
	 wrr.println(e.encrypt(new String(ans3.getPassword())));
	 wrr.println(e.encrypt(Double.toString(jj)));
	 write.println(e.encrypt(Double.toString(jj)));  
	 wr.println(e.encrypt(Double.toString(jj))); 
	 write.println(US);
	 write.println(e.encrypt(emailt.getText()));
	 write.println(e.encrypt(new String(passwordField.getPassword())));
	 write.println("Aluminium");
	 write.println(e.encrypt(textField.getText())); //phone number 
	 write.println(e.encrypt(carrier.getSelectedItem().toString())); //carrier
	 write.println(e.encrypt("false"));
	 write.println(e.encrypt(newBackupCode())); 
	 write.println(e.encrypt("false")); 
	 write.println(0);
	 write.close();
	 wrr.close();
	 wr.close(); //TODO new user write to file
	loginData = read(userData);
	securityQs = read(securityQ);
	start();
	
	break;
	
	  }
	 
}
}
	public static ArrayList<String> read(File f) throws FileNotFoundException{
		
		ArrayList<String> al = new ArrayList<String>();
		Scanner s = new Scanner(f);
		while(s.hasNext()){
			al.add(s.nextLine());
		}
		s.close();
		return al;
		
		
	}
	public static void write(ArrayList<String> al,File f) throws FileNotFoundException{
		
		
		PrintWriter pw = new PrintWriter(f);
		
		for(int u=0;u<al.size();u++){
			
			pw.println(al.get(u)); 
			
		}
		pw.close();
		
		
		
	}
	
	public static void UI() throws Exception{ //TODO UI
		
	    if(e.decrypt(passwordDataBase.get(0)).matches(e.decrypt(loginData.get(KEY))) == false || e.decrypt(passwordDataBase.get(0)).matches(e.decrypt(securityQs.get(6))) == false){
	    	
	    
	    	userData.delete(); 
	    	passwords.delete();
	    	dir.delete();
	    	JOptionPane.showMessageDialog(null, "Sorry, Your Data files are Invalid! Files were Deleted!", "ERROR!", JOptionPane.ERROR_MESSAGE);  
	    	System.exit(0);
	    	
	    	
	    }
	    String title = "";
	    if(TYPE == true){
	    	
	    	title = "Password Vault (AES-128 Encryption)";
	    	
	    }else{
	    	
	    	title = "Password Vault (AES-128 Encryption)(UNSAFE MODE)";
	    	
	    }
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame(title);
		JButton changePassword = new JButton("Change Login Password");
		JButton addNew = new JButton("Add New Password");
		JButton editAcc = new JButton("Account Settings");
		JButton edit = new JButton("Edit");
		JButton check = new JButton("View");
		JButton delete = new JButton("Delete");
		JButton exit = new JButton("Quit");
		JButton swich = new JButton("Switch Mode");
		JButton chgTheme = new JButton("Change Theme");
		JButton erase = new JButton("Erase All Data");
		JButton logout = new JButton("Logout");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(screenSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jl = new JLabel("Your Password List: ");
		frame.add(jl); 
		
		
		 listOfPasswords = new JList<Object>();
		
		jl.setLabelFor(listOfPasswords); 
		
		
		
		
		
		JPanel pane = new JPanel();
        pane.add(changePassword);
        pane.add(logout);
        pane.add(addNew);
        pane.add(editAcc);
        pane.add(edit);
        pane.add(check);
        pane.add(delete);
        pane.add(exit);
        pane.add(chgTheme);
        pane.add(swich);
        pane.add(erase);
        if(passwordDataBase.isEmpty() == false){
        	
        	for(int t=1;t<passwordDataBase.size();){
        		
        		names.add(passwordDataBase.get(t));
        		t++;
        		usernames.add(passwordDataBase.get(t));
        		t++;
        		pswds.add(passwordDataBase.get(t)); 
        		t++;
        		
        	}
        
        	listOfPasswords.setListData(names.toArray());
        	
        }
/*        else{
        	Object[] o = {"--","--"};
       listOfPasswords.setListData(o);
       	
        }*/
        frame.add(new JScrollPane(listOfPasswords));
        frame.add(pane, BorderLayout.SOUTH); 
		//delete.setEnabled(false); 
		//edit.setEnabled(false);
        //frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon-128.png")); 
        //frame.setIconImage(Toolkit.getDefaultToolkit().getImage("red_lock.png"));
        		frame.setVisible(true); 
		
		listOfPasswords.addListSelectionListener(new ListSelectionListener() {
  			@Override
          public void valueChanged(ListSelectionEvent e) {
	
	if (!e.getValueIsAdjusting()) {
	      for(int i=0;i<names.size();i++){
	    	  try {
				Thread.sleep(25);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
	    	  if(listOfPasswords.getSelectedValue() != null){
		if(listOfPasswords.getSelectedValue().toString().matches(names.get(i))){
			INDEX = i;
		}
	    	  }
	      }
	    }
}
});
		if(NEW == true){
			
			JOptionPane.showMessageDialog(null, "Default Theme is Initialized. Dont like it? Click Change Theme to change it!");
			NEW = false;
		}
		for(;;){
		for(;;){ //TODO Main Loop
			
			
		//	System.out.println(INDEX);
			if(INDEX == -1){
				
				edit.setEnabled(false); 
				delete.setEnabled(false); 
				check.setEnabled(false); 
				
			}else{
				
				edit.setEnabled(true); 
				delete.setEnabled(true); 
				check.setEnabled(true); 
				
			}
			if(exit.getModel().isPressed() == true){
				System.exit(0);
			}
			if(editAcc.getModel().isPressed() == true){
				
				editAcc.getModel().setPressed(false);
				
				JPanel panel=new JPanel(); 
				 
				   
				 panel.setLayout(new GridLayout(7,1));  
				  
				 // JLabel usn = new JLabel("Username: ");
				JLabel username=new JLabel("Phone Number: ");  
				  
				 JLabel email=new JLabel("Your Email: ");
				 
				 JLabel car = new JLabel("Your Phone Carrier: ");
				 //TODO modifying any settings requires password confirmation...
					  
				 //JTextField usernam = new JTextField(12);
				 JTextField textField=new JTextField(12);  
				 JTextField emailt=new JTextField(12); 
				 JComboBox<String> carrier = new JComboBox<String>();
				JCheckBox jb = new JCheckBox("2 Step Verification (Extra Text-Message Verification EVERY time you login)");
				JCheckBox jb2 = new JCheckBox("Protect Show Password Button");
				//JToggleButton jb2 = new JToggleButton("Protect Show Password Button");
				//JToggleButton ts = new JToggleButton("TEST");
				
				 carrier.addItem("Select One");
				 carrier.addItem("Alltel Wireless");
				 carrier.addItem("AT&T");
				 carrier.addItem("Cingular");
				 carrier.addItem("Boost Mobile");
				 carrier.addItem("Cricket");
				 carrier.addItem("Metro PCS");
				 carrier.addItem("Sprint");
				 carrier.addItem("Sprint (Nextel)");
				 carrier.addItem("Straight Talk");
				 carrier.addItem("T-Mobile");
				 carrier.addItem("U.S. Cellular");
				 carrier.addItem("Verizon");
				 carrier.addItem("Virgin Mobile");
				 carrier.addItem("Not Shown");
				  
				 //panel.add(usn);
				 
				 //panel.add(usernam);
				 
				panel.add(username);  
				  
				 
				panel.add(textField);  
				
				panel.add(car);
				
				panel.add(carrier);
				  
				 panel.add(email);
				 
				 panel.add(emailt);
				  
				 panel.add(jb);
				 panel.add(jb2);
				// usernam.setText(loginData.get(USERNAME));
				 textField.setText(e.decrypt(loginData.get(PHONE)));  
				 carrier.setSelectedItem(e.decrypt(loginData.get(CARRIER)));  
				 emailt.setText(e.decrypt(loginData.get(EMAIL)));
				 jb.setSelected(Boolean.parseBoolean(e.decrypt(loginData.get(CONF)))); 
				 jb2.setSelected(Boolean.parseBoolean(e.decrypt(loginData.get(SHOW))));  
				 int x;
				 for(;;){
					 if(e.decrypt(loginData.get(CARRIER)).matches("Not Shown")){
						 
						 jb.setSelected(false);
						 jb.setEnabled(false);  
						 
					 }
					 if(TYPE == false){
						 
						 jb2.setSelected(false); 
						 jb2.setEnabled(false);
						 
						 
					 }
				 x = JOptionPane.showConfirmDialog(null,panel,"Edit Account",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
				 
				 if(x == JOptionPane.CANCEL_OPTION){
					 
					 break;
					 
				 }else{
					 
					 if(e.decrypt(loginData.get(PHONE)).matches(textField.getText()) && e.decrypt(loginData.get(CARRIER)).matches(carrier.getSelectedItem().toString()) && e.decrypt(loginData.get(EMAIL)).matches(emailt.getText()) && e.decrypt(loginData.get(CONF)).matches(String.valueOf(jb.isSelected())) && e.decrypt(loginData.get(SHOW)).matches(String.valueOf(jb2.isSelected()))){  
						 
						 
						 break;
						 
					 }
					 
					//loginData.set(USERNAME, usernam.getText()); 
					loginData.set(PHONE, e.encrypt(textField.getText())); 
					loginData.set(CARRIER, e.encrypt(carrier.getSelectedItem().toString()));
					loginData.set(EMAIL, e.encrypt(emailt.getText()));
					
					if(e.decrypt(loginData.get(CONF)).matches("true") && jb.isSelected() == false){
						
						JPanel pan = new JPanel();
						
						pan.setLayout(new GridLayout(2,1));
						
						JLabel pswd = new JLabel("Please Confirm Your Password: ");
						JPasswordField jpf = new JPasswordField(12);
						 
						pan.add(pswd);
						pan.add(jpf);
						
						int yy = JOptionPane.showConfirmDialog(null,pan,"Confirm Password",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
						
						if(yy == JOptionPane.CANCEL_OPTION){
							
							loginData.set(CONF, e.encrypt("true"));
							
						}else{
							
							if(new String(jpf.getPassword()).matches(e.decrypt(loginData.get(PASSWORD)))){
								
								loginData.set(CONF, e.encrypt("false"));  
								File gh = new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+loginData.get(USERNAME)+"s BACKUP CODE"+"("+CODECOUNT+")"+".txt");
								gh.delete();
							}
							
						}
						
						
					}else if(e.decrypt(loginData.get(CONF)).matches("false") && jb.isSelected() == true){  
						
						loginData.set(CONF, e.encrypt("true"));
						
					}
					
					
					
					if(e.decrypt(loginData.get(SHOW)).matches("true") && jb2.isSelected() == false && TYPE == true){ 
					JPanel pan = new JPanel();
					
					pan.setLayout(new GridLayout(2,1));
					
					JLabel pswd = new JLabel("Please Confirm Your Password: ");
					JPasswordField jpf = new JPasswordField(12);
					
					pan.add(pswd);
					pan.add(jpf);
					
					int yy = JOptionPane.showConfirmDialog(null,pan,"Confirm Password",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
					
					if(yy == JOptionPane.CANCEL_OPTION){
						
						continue;
						
					}else{
						
						if(new String(jpf.getPassword()).matches(e.decrypt(loginData.get(PASSWORD)))){
							
							loginData.set(SHOW, e.encrypt("false"));
							
						}else{
							
						JOptionPane.showMessageDialog(null, "Invalid Password!", "Invalid!", JOptionPane.ERROR_MESSAGE);  	
							continue;
						}
						
					}
					}else if(e.decrypt(loginData.get(SHOW)).matches("false") && jb2.isSelected() == true && TYPE == true){
						
						loginData.set(SHOW, e.encrypt("true"));
					}
					write(loginData,userData);
					if(jb.isSelected() == true){
						
						JOptionPane.showMessageDialog(null, "WARNING! You will now be asked a security code sent to your phone by text message \neverytime you want to login to your account.\nIf you dont have access to your phone, you can use a backup code which will be placed in a txt file on your desktop.\nPlease move it to a secure place! Because if you lose it, your passwords stored in the database will be lost!", "Warning!", JOptionPane.WARNING_MESSAGE); 
						File bak = new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+loginData.get(USERNAME)+"s BACKUP CODE"+"("+CODECOUNT+")"+".txt");
						
						
						if(bak.exists()){
							
							bak.delete();
							Thread.sleep(100);
							CODECOUNT++;
							bak = new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+loginData.get(USERNAME)+"s BACKUP CODE"+"("+CODECOUNT+")"+".txt");
							bak.createNewFile();
							
						}else{
							//FIXME this function may not work at times due to timing
							CODECOUNT++;
							bak = new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+loginData.get(USERNAME)+"s BACKUP CODE"+"("+CODECOUNT+")"+".txt");
							bak.createNewFile();
							
						
						}
						
						
						loginData.set(BACKUP, e.encrypt(newBackupCode()));
						loginData.set(COUNT, String.valueOf(CODECOUNT));
						write(loginData,userData);
						PrintWriter pp = new PrintWriter(bak);
						pp.println(loginData.get(BACKUP));
						pp.println("\nPLEASE CLOSE THIS FILE AFTER COPYING THE CODE! \nNOTE: On Mac, press CMD+C to COPY and then in the java app DO CTRL-V");
						pp.close();
						JOptionPane.showMessageDialog(null, "Done! Please Move it to a secure Location ASAP! (I recommend a Cloud Drive like Google Drive or MEGA)");
						
					}
					break;
				 }
				 
				 }
				
			}
			if(chgTheme.getModel().isPressed() == true){//TODO THEME
				
				chgTheme.getModel().setPressed(false);
				String[] optionsd = new String[] {"Acryl", "Aero","Aluminium","Bernstein","Fast","HiFi","Nimbus","McWin","Mint","Noire","Smart","Luna","Texture","Cancel"};
	        	  int ii= JOptionPane.showOptionDialog(null, "Which Theme Would you like?", "Choose Theme", 
	  			        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
	  			        null, optionsd, optionsd[0]);
	        	  if(ii == 13){ 
	        		  
	        		  if(loginData.get(LAF).matches(optionsd[ii])){
	 	        		 
		        		  JOptionPane.showMessageDialog(null, "Cannot Re-init same Theme.", "Duplicate Theme", JOptionPane.ERROR_MESSAGE);
		        		  
		        	  }
	        		  continue;
	        		  
	        	  }else if(ii == 0){
	        		  
	        		  frame.setVisible(false); 
	        		  initLookAndFeel(optionsd[0],null);
	        		  loginData.set(LAF, optionsd[0]);
	        		  
	        	  }else if(ii == 1){
	        		  
	        		  frame.setVisible(false); 
	        		  initLookAndFeel(optionsd[1],null);
	        		  loginData.set(LAF, optionsd[1]);
	        		  
	        	  }else if(ii == 2){
	        		  
	        		  frame.setVisible(false);
	        		  initLookAndFeel(optionsd[2],null);
	        		  loginData.set(LAF, optionsd[2]);
	        		  
	        	  }else if(ii == 3){
	        		  
	        		  frame.setVisible(false);
	        		  initLookAndFeel(optionsd[3],null);
	        		  loginData.set(LAF, optionsd[3]);
	        		  
	        	  }else if(ii == 4){
	        		  
	        		  frame.setVisible(false);
	        		  initLookAndFeel(optionsd[4],null);
	        		  loginData.set(LAF, optionsd[4]);
	        		  
	        	  }else if(ii == 5){
	        		  
	        		  frame.setVisible(false);
	        		  initLookAndFeel(optionsd[5],null);
	        		  loginData.set(LAF, optionsd[5]);
	        		  
	        	  }else if(ii == 6){
	        		  
	        		  frame.setVisible(false);
	        		  initLookAndFeel(optionsd[6],null);
	        		  loginData.set(LAF, optionsd[6]);
	        		  
	        	  }else if(ii == 7){
	        		  
	        		  frame.setVisible(false);
	        		  initLookAndFeel(optionsd[7],null);
	        		  loginData.set(LAF, optionsd[7]);
	        		  
	        	  }else if(ii == 8){
	        		  
	        		  frame.setVisible(false);
	        		  initLookAndFeel(optionsd[8],null);
	        		  loginData.set(LAF, optionsd[8]);
	        		  
	        	  }else if(ii == 9){
	        		  
	        		  frame.setVisible(false);
	        		  initLookAndFeel(optionsd[9],null);
	        		  loginData.set(LAF, optionsd[9]);
	        		  
	        	  }else if(ii == 10){
	        		  
	        		  frame.setVisible(false);
	        		  initLookAndFeel(optionsd[10],null);
	        		  loginData.set(LAF, optionsd[10]);
	        		  
	        	  }else if(ii == 11){
	        		  
	        		  frame.setVisible(false);
	        		  initLookAndFeel(optionsd[11],null);
	        		  loginData.set(LAF, optionsd[11]);
	        		  
	        	  }else if(ii == 12){
	        		  
	        		  frame.setVisible(false);
	        		  initLookAndFeel(optionsd[12],null);
	        		  loginData.set(LAF, optionsd[12]);
	        		  
	        	  }
	        	  
	        	  Thread.sleep(100); 
	        	 frame.dispose();
	        	 write(loginData,userData);
	         names.clear();
	         usernames.clear();
	         pswds.clear();
	        	 uu();
	        	 return;
	        	  
				
			}
			if(logout.getModel().isPressed() == true){
				logout.getModel().setPressed(false); 
				int y = JOptionPane.showConfirmDialog(null, "WARNING! You are about to log out of the System.", "Logout", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if(y == JOptionPane.OK_OPTION){
					
					logout.getModel().setPressed(false);
					
					frame.dispose();
					
					makeNull();
					load();
					return;
					
				}else{
					
					continue;
					
				}
				
				
			}
			if(erase.getModel().isPressed() == true){
				//TODO confirm pass
				erase.getModel().setPressed(false);
				 
					
					JPanel pan = new JPanel();
					
					pan.setLayout(new GridLayout(2,1));
					
					JLabel pswd = new JLabel("Please Confirm Your Password: ");
					JPasswordField jpf = new JPasswordField(12);
					
					pan.add(pswd);
					pan.add(jpf);
					
					int yy = JOptionPane.showConfirmDialog(null,pan,"Confirm Password",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
					
					if(yy == JOptionPane.CANCEL_OPTION){
						
						continue;
						
					}else{
						
						if(!new String(jpf.getPassword()).matches(e.decrypt(loginData.get(PASSWORD)))){
							
							JOptionPane.showMessageDialog(null, "Wrong Password", "Error!", JOptionPane.ERROR_MESSAGE);  
							continue;
						}
						
					}
					
				
				
				
				
				int yuiop = JOptionPane.showConfirmDialog(null, "WARNING! \n\n You are about to delete ALL OF YOUR SAVED PASSWORDS FROM THE SYSTEM! (This INCLUDES your login details!) \n\n is this what you want?", "!!!Erase Data!!!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if(yuiop == JOptionPane.NO_OPTION){
					
					continue;
					
				}else{
					frame.dispose();
					userData.delete();
					passwords.delete();
					securityQ.delete();
					Thread.sleep(100);
					dir.delete();
					JOptionPane.showMessageDialog(null, "Data Erase Complete! Quitting.");
					
					System.exit(0); 
					
				}
				
				
			}
			if(edit.getModel().isPressed() == true && INDEX != -1){
				
				edit.getModel().setPressed(false);
				JPanel panel1=new JPanel(); 
				 
				   
				 panel1.setLayout(new GridLayout(3,1));  
				 
				  
				 JLabel username1=new JLabel("Account Name:"); 
				 
				 JLabel user1 = new JLabel("Username or Email:");
				  
				 
				 JLabel password1=new JLabel("Password:");  
				 
				 		  
				 
				 JTextField textField1=new JTextField(12);  
				  JTextField usrnm1 = new JTextField(12);
				 if(TYPE == true){
				 JPasswordField passwordField1=new JPasswordField(12);
				 textField1.setText(names.get(INDEX)); 
					usrnm1.setText(usernames.get(INDEX));
					passwordField1.setText(e.decrypt(pswds.get(INDEX))); 
					panel1.add(username1);  
					  
					 
					 panel1.add(textField1);  
					 
					 panel1.add(user1);
					 
					 panel1.add(usrnm1);
					  
					  
					 panel1.add(password1);  
					  
					
					 panel1.add(passwordField1); 
				 
				 
				  
				  
				 
				 int k;
				
				 for(;;){
				 k = JOptionPane.showConfirmDialog(null,panel1,"Edit"+names.get(INDEX),JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				 
				 if(k == JOptionPane.CANCEL_OPTION){
					 
					 break;
					 
				 }else{
					 
					 if(textField1.getText().matches(names.get(INDEX)) && usrnm1.getText().matches(usernames.get(INDEX)) && new String(passwordField1.getPassword()).matches(e.decrypt(pswds.get(INDEX)))){
						 
						 break;
						 
					 }
					 
					 names.set(INDEX, textField1.getText()); 
					 usernames.set(INDEX, usrnm1.getText());
					 pswds.set(INDEX, e.encrypt(new String(passwordField1.getPassword()))); 
					 NUPtoPDB(); //TODO edit
					 write(passwordDataBase,passwords); 
						refreshList();
						Thread.sleep(20);
						if(listOfPasswords != null){
						listOfPasswords.setListData(
								names.toArray());
						}
						break;
				 }
				 
				 
			}
			}else{
				JTextField passwordField1=new JTextField(12);
				 textField1.setText(names.get(INDEX)); 
					usrnm1.setText(usernames.get(INDEX));
					passwordField1.setText(e.decrypt(pswds.get(INDEX))); 
					panel1.add(username1);  
					  
					 
					 panel1.add(textField1);  
					 
					 panel1.add(user1);
					 
					 panel1.add(usrnm1);
					  
					  
					 panel1.add(password1);  
					  
					
					 panel1.add(passwordField1); 
				 
				
				  
				  
				 
				 int k;
				 boolean q = false;
				 do{
				 k = JOptionPane.showConfirmDialog(null,panel1,"Edit"+names.get(INDEX),JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				 
				 if(k == JOptionPane.CANCEL_OPTION){
					 
					 break;
					 
				 }else{
					 
					 names.set(INDEX, textField1.getText()); 
					 usernames.set(INDEX, usrnm1.getText());
					 pswds.set(INDEX, e.encrypt(passwordField1.getText())); 
					 NUPtoPDB();
					 write(passwordDataBase,passwords); 
						refreshList();
						Thread.sleep(20);
						if(listOfPasswords != null){
						listOfPasswords.setListData(
								names.toArray());
						}
						q = true;
				 
				 }
				 
				 
			}while(q == false);
			}
			}else if(edit.getModel().isPressed() == true && INDEX == -1){//
				edit.getModel().setPressed(false);
				JOptionPane.showMessageDialog(null, "Nothing is Selected", "ERROR!", JOptionPane.ERROR_MESSAGE);  
				
			}
			
			if(delete.getModel().isPressed() == true && INDEX != -1){
				
				delete.getModel().setPressed(false);
				int y = JOptionPane.showConfirmDialog(null, "Are You Sure? The Account \""+names.get(INDEX)+"\" will be Lost forever!", "WARNING!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(y == JOptionPane.NO_OPTION){
					continue;
				}else{
					//System.out.println(INDEX);
				names.remove(INDEX);
				usernames.remove(INDEX);
				pswds.remove(INDEX);
				NUPtoPDB();
				write(passwordDataBase,passwords); 
				refreshList();
				Thread.sleep(20);
				if(listOfPasswords != null){
				listOfPasswords.setListData(
						names.toArray());
				}else{
					System.out.println("LIST was null");
					System.exit(0); 
				}
				INDEX = -1;
				}
			}else if(delete.getModel().isPressed() == true && INDEX == -1){
				
				delete.getModel().setPressed(false);
				JOptionPane.showMessageDialog(null, "Nothing is Selected!", "ERROR!", JOptionPane.ERROR_MESSAGE);  
				
			}
			
			 if(changePassword.getModel().isPressed() == true){
				 
				 changePassword.getModel().setPressed(false);
				 JPanel pp = new JPanel();
				 pp.setLayout(new GridLayout(3,1));
				 
				 JLabel pswdl = new JLabel("Old Password: ");
				 JLabel pswdl2 = new JLabel("New Password: ");
				 JLabel pswdcl = new JLabel("Confirm Password: ");
				 JPasswordField oldPswd = new JPasswordField(12);
				 JPasswordField newPswd = new JPasswordField(12);
				 JPasswordField confPswd = new JPasswordField(12);
				 pp.add(pswdl);
				 pp.add(oldPswd);
				 pp.add(pswdl2);
				 pp.add(newPswd);
				 pp.add(pswdcl);
				 pp.add(confPswd);
				 int klj;
				 boolean bnm = false;
				 do{
				 klj = JOptionPane.showConfirmDialog(null,pp,"Change Login",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				 
				 if(klj == JOptionPane.CANCEL_OPTION){
					 
					 break;		 
					 
				 }else{
					 
					 if(new String(oldPswd.getPassword()).matches(e.decrypt(loginData.get(PASSWORD))) && new String(newPswd.getPassword()).matches(new String(confPswd.getPassword()))){ 
						 //check for password confirmation
						 loginData.set(PASSWORD, e.encrypt(new String(newPswd.getPassword()))); //update the logs
						 write(loginData,userData);
						 bnm = true;
						 JOptionPane.showMessageDialog(null, "Password Has Been Changed! (Remember it!)");
					 }else{
						
						 JOptionPane.showMessageDialog(null, "Invalid Information! (Passwords Don\'t Match or Incorrect Old Password", "ERROR!", JOptionPane.ERROR_MESSAGE); 
						 
					 }
					 
				 }
				 
				 }while(bnm == false);
			 }
			
			if(addNew.getModel().isPressed() == true){
				
				addNew.getModel().setPressed(false); 
				JPanel panel=new JPanel(); 
				 
				   
				 panel.setLayout(new GridLayout(3,1));  
				  
				  
				 JLabel username=new JLabel("Name (ex. Facebook):"); 
				 
				 JLabel user = new JLabel("Username or Email:");
				  
				 
				 JLabel password=new JLabel("Password (Encrypted with AES):");  
				 
				 if(TYPE == true){
				 
				 JTextField textField=new JTextField(12); 
				  JTextField usrnm = new JTextField(12);   
				 
				 JPasswordField passwordField=new JPasswordField(12);  
				
				  
				 panel.add(username);  
				  
				 
				 panel.add(textField);  
				 
				 panel.add(user);
				 
				 panel.add(usrnm);
				  
				  
				 panel.add(password);  
				  
				
				 panel.add(passwordField); 
				 
				 int a; 
				 boolean kk = false;
				 do{
				 a = JOptionPane.showConfirmDialog(null,panel,"Add New",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
				 
				 if(a == JOptionPane.CANCEL_OPTION){
					 
					 break;
					 
				 }else{
					 
					 if(textField.getText() != "" && usrnm.getText() != "" && new String(passwordField.getPassword()).matches("") == false){ 
					 
					 passwordDataBase.add(textField.getText());
					 passwordDataBase.add(usrnm.getText()); 
					 passwordDataBase.add(e.encrypt(new String(passwordField.getPassword())));
					 write(passwordDataBase,passwords); 
					 names.add(textField.getText());
					 usernames.add(usrnm.getText());
					 pswds.add(e.encrypt(new String(passwordField.getPassword())));
					 refreshList();
					 Thread.sleep(20);
				     listOfPasswords.setListData(
				    		 names.toArray()); 
					 kk = true;
					 }else{
						 
						 JOptionPane.showMessageDialog(null, "Fields Cannot Be Empty!", "ERROR!", JOptionPane.ERROR_MESSAGE); 
						 kk = false;
						 //klop
					 }
				 }
			}while(kk == false);
				 }else{
					 JTextField textField=new JTextField(12);  
					  JTextField usrnm = new JTextField(12);   
					 
					 JTextField passwordField=new JTextField(12);  
					
					  
					 panel.add(username);  
					  
					 
					 panel.add(textField);  
					 
					 panel.add(user);
					 
					 panel.add(usrnm);
					  
					  
					 panel.add(password);  
					  
					
					 panel.add(passwordField); 
					 
					 int a; 
					 boolean kk = false;
					 do{
					 a = JOptionPane.showConfirmDialog(null,panel,"Add New",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
					 
					 if(a == JOptionPane.CANCEL_OPTION){
						 
						 break;
						 
					 }else{
						 
						 if(textField.getText() != "" && usrnm.getText() != "" && passwordField.getText().matches("") == false){ 
						 
						 passwordDataBase.add(textField.getText());
						 passwordDataBase.add(usrnm.getText()); 
						 passwordDataBase.add(e.encrypt(passwordField.getText()));
						 write(passwordDataBase,passwords); 
						 names.add(textField.getText());
						 usernames.add(usrnm.getText());
						 pswds.add(e.encrypt(passwordField.getText()));
						 refreshList();
						 Thread.sleep(20);
					     listOfPasswords.setListData(
					    		 names.toArray()); 
						 kk = true;
						 }else{
							 
							 JOptionPane.showMessageDialog(null, "Fields Cannot Be Empty!", "ERROR!", JOptionPane.ERROR_MESSAGE); 
							 kk = false;
							 
						 }
					 }
				}while(kk == false);
					 
				 }
			}
			
			if(check.getModel().isPressed() == true && INDEX != -1){
				
				check.getModel().setPressed(false);
				if(TYPE == true){
				JFrame checkFrame = new JFrame("Account Information");
				checkFrame.setSize(500,210);
				JPanel buttonPane = new JPanel();
				JButton decrypt = new JButton("Show Password");
				JButton ok = new JButton("OK");
				buttonPane.add(decrypt);
				buttonPane.add(ok);
				checkFrame.add(buttonPane, BorderLayout.SOUTH); 
				
				int jc = e.decrypt(pswds.get(INDEX)).length();
				
				String ps = "";
				for(int s=1;s<=jc;s++){
					ps+="*";
				}
				
				JLabel display = new JLabel("<html>Account Name: "+names.get(INDEX)+"<br/>Username or Email: "+usernames.get(INDEX)+"<br/>Password: "+ps+"<br/>If you would like to see the Password, press \"Show Password\".</html>"); 
				display.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
				checkFrame.add(display); 
				checkFrame.setVisible(true); 
				for(;;){
					Thread.sleep(25);
					if(ok.getModel().isPressed() == true){
						
						ok.getModel().setPressed(false);
						checkFrame.setVisible(false); 
						break;
					}
					if(decrypt.getModel().isPressed() == true){
						int v =0;
						decrypt.getModel().setPressed(false); 
						
						if(e.decrypt(loginData.get(SHOW)).matches("true")){
						
						JPanel pan = new JPanel();
						
						pan.setLayout(new GridLayout(2,1));
						
						JLabel pswd = new JLabel("Please Confirm Your Password: ");
						JPasswordField jpf = new JPasswordField(12);
						
						pan.add(pswd);
						pan.add(jpf);
						
						int yy = JOptionPane.showConfirmDialog(null,pan,"Confirm Password",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
						
						if(yy == JOptionPane.CANCEL_OPTION){
							
							continue;
							
						}else{
							
							if(new String(jpf.getPassword()).matches(e.decrypt(loginData.get(PASSWORD)))){
								
							 v = JOptionPane.showConfirmDialog(null, "Do you still want to see the Password?", "WARNING!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); 
								
							}else{
								
							JOptionPane.showMessageDialog(null, "Invalid Password!", "Invalid!", JOptionPane.ERROR_MESSAGE);  	
								continue;
							}
							
						}
						
						
						}
						
						if(v == JOptionPane.NO_OPTION){
							
							continue;
							
						}else{
							//JOptionPane.showMessageDialog(null, "For Saftey, the dialog with the password shown will self destruct in 10 seconds.", "Notice", JOptionPane.WARNING_MESSAGE); 
							display.setText("<html>Account Name: "+names.get(INDEX)+"<br/>Username or Email: "+usernames.get(INDEX)+"<br/>Password: "+e.decrypt(pswds.get(INDEX))+"</html>"); 
							//Thread.sleep(10000);
							decrypt.setEnabled(false); 
							for(int co = 10000;co>=0;co--){
								Thread.sleep(1);
								
								if(ok.getModel().isPressed()==true){
									ok.getModel().setPressed(false);
									break;
									
								}
							if(co <= 7000){
							display.setText("<html>Account Name: "+names.get(INDEX)+"<br/>Username or Email: "+usernames.get(INDEX)+"<br/>Password: "+e.decrypt(pswds.get(INDEX))+"<br/>Self Destruct in: "+co/1000+"s"+"</html>");
							}
							}
							display.setText("SELF DESTRUCT!");
							
							checkFrame.dispose();
							Thread.sleep(10);
							break;
							
						}
					}
					
				}
				}else{ // normal mode
					
					JFrame checkFrame = new JFrame("Account Information");
					checkFrame.setSize(500,210);
					JPanel buttonPane = new JPanel();
					
					JButton ok = new JButton("OK");
					
					buttonPane.add(ok);
					checkFrame.add(buttonPane, BorderLayout.SOUTH); 
					
					
					
					JLabel display = new JLabel("<html>Account Name: "+names.get(INDEX)+"<br/>Username or Email: "+usernames.get(INDEX)+"<br/>Password: "+e.decrypt(pswds.get(INDEX))+"<br/>Click OK when Finished</html>"); 
					display.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
					checkFrame.add(display); 
					checkFrame.setVisible(true); 
					for(;;){
						Thread.sleep(25);
						if(ok.getModel().isPressed() == true){
							
							ok.getModel().setPressed(false);
							checkFrame.dispose();
							break;
						}
						
						
					}
					
				}
				
			}else if(INDEX == -1 && check.getModel().isPressed() == true){
				check.getModel().setPressed(false);
				JOptionPane.showMessageDialog(null, "Nothing is Selected!");
				System.out.println(INDEX);
			}
			if(swich.getModel().isPressed() == true){
				//TODO confirm pass
				
				
				
				
				String mod;
				swich.getModel().setPressed(false);
				
                   if(e.decrypt(loginData.get(SHOW)).matches("true") && TYPE == true){  
					
					JPanel pan = new JPanel();
					
					pan.setLayout(new GridLayout(2,1));
					
					JLabel pswd = new JLabel("Please Confirm Your Password: ");
					JPasswordField jpf = new JPasswordField(12);
					
					pan.add(pswd);
					pan.add(jpf);
					
					int yy = JOptionPane.showConfirmDialog(null,pan,"Confirm Password",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
					
					if(yy == JOptionPane.CANCEL_OPTION){
						
						continue;
						
					}else{
						
						if(!new String(jpf.getPassword()).matches(e.decrypt(loginData.get(PASSWORD)))){
							
							JOptionPane.showMessageDialog(null, "Wrong Password", "Error!", JOptionPane.ERROR_MESSAGE);  
							continue;
						}
						
					}
					
				}
				
				if(TYPE == true){
					mod = "NORMAL";
					frame.setTitle("Password Vault (AES-128 Encryption)(UNSAFE MODE)");
				}else{
					mod = "SECURE";
					frame.setTitle("Password Vault (AES-128 Encryption)");
				}
				JOptionPane.showMessageDialog(null, "Switching to "+mod+" mode"); 
				
				TYPE = !TYPE;
			
				break;
			}
			
			
			
			
		
		}
	     
		}
		
		
	}
	
	public static void refreshList()throws Exception{
		names.clear();
		usernames.clear();
		pswds.clear();
		for(int t=1;t<passwordDataBase.size();){
    		
    		names.add(passwordDataBase.get(t));
    		t++;
    		usernames.add(passwordDataBase.get(t));
    		t++;
    		pswds.add(passwordDataBase.get(t)); 
    		t++;
    		
    	}
	
		
	}
	public static void NUPtoPDB(){
		
		passwordDataBase.clear();
		passwordDataBase.add(loginData.get(0)); 
		for(int i=0;i<names.size();i++){
			
			passwordDataBase.add(names.get(i));
			passwordDataBase.add(usernames.get(i));
			passwordDataBase.add(pswds.get(i));
			
			
		}
		
		
	}
	




	public static void makeNull(){
		
		userData = null;
		 passwords = null; 
		dir = null; 
		securityQ = null;
		dira = null;
		dd4 = null; 
		passwordDataBase = null;
		loginData = null;
		securityQs = null;
		listOfPasswords = null;
		usernames.clear();
		pswds.clear();
		names.clear();
		
	}
	public static void uu()throws Exception{
		
		Thread.sleep(250);
		UI();
		
	}
	public static String newBackupCode() throws Exception{
		
		 String code;
		  int d1,d2,d3,d4,d5,d6,d7,d8,d9;
		  Random ri = new Random();
			d1 = ri.nextInt(10);
			d2 = ri.nextInt(10);
			d3 = ri.nextInt(10);
			d4 = ri.nextInt(10);
			d5 = ri.nextInt(10);
			d6 = ri.nextInt(10);
			d7 = ri.nextInt(10);
			d8 = ri.nextInt(10);
			d9 = ri.nextInt(10);
			code = String.valueOf(d1)+String.valueOf(d2)+String.valueOf(d3)+String.valueOf(d4)+String.valueOf(d5)+String.valueOf(d6)+String.valueOf(d7)+String.valueOf(d8)+String.valueOf(d9);
		return code;
	}
	
}
