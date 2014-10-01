/**
 * 
 */
package auto;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

/**
 * @author UnityBoss
 *
 */
public class Automator {

	/**
	 * @param args
	 */
	public static Font fon = null;//,fon2 = null;
	  
	  public static GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
	  private static String LOOKANDFEEL = "";
	  private static String THEME = "";
	  private static int world,section;
	  private static String sectionS,worldS;
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		initLookAndFeel("Nimbus",null);
		
		String[] options = new String[] {"Final Boss", "World 1", "World 2","World 3"};
		  int opp =  JOptionPane.showOptionDialog(null, "What World?", "World?", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		        null, options, options[0]);
				
		world = opp;
		
		
		if(world == 0){ //can add more worlds if you choose
			String fileContents = "";
			File fNBOSS = new File("Levels/FINAL BOSS (Bowser)/FNBOS.txt");
			Scanner read = new Scanner(fNBOSS);
			while(read.hasNext()){
				
				fileContents += read.nextLine()+"\n";
				
			}
			read.close();
			StringSelection stringSelection = new StringSelection (fileContents);
			Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
			clpbrd.setContents (stringSelection, null);
			JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
			
		}else if(world == 1){
			
			String[] optionss = new String[] {"Castle", "World 1-1", "World 1-2","World 1-3","World 1-4"};
			  int opps =  JOptionPane.showOptionDialog(null, "What Section?", "Section?", 
			        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
			        null, optionss, optionss[0]);
			
			
			section = opps;
			
			
			if(section == 0){
				
				String fileContents = "";
				File cASTLE = new File("Levels/World 1/World 1 Castle.txt");
				Scanner read = new Scanner(cASTLE);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 1){
				
				String fileContents = "";
				File w1 = new File("Levels/World 1/World 1-1.txt");
				Scanner read = new Scanner(w1);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 2){
				
				String fileContents = "";
				File w2 = new File("Levels/World 1/World 1-2.txt");
				Scanner read = new Scanner(w2);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 3){
				
				String fileContents = "";
				File w3 = new File("Levels/World 1/World 1-3.txt");
				Scanner read = new Scanner(w3);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 4){
				
				String fileContents = "";
				File w4 = new File("Levels/World 1/World 1-4.txt");
				Scanner read = new Scanner(w4);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}
		}else if(world == 2){
			
			String[] optionss = new String[] {"Castle", "World 2-1", "World 2-2","World 2-3","World 2-4"};
			  int opps =  JOptionPane.showOptionDialog(null, "What Section?", "Section?", 
			        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
			        null, optionss, optionss[0]);
			
			
			section = opps;		
			
			
			
			if(section == 0){
				
				String fileContents = "";
				File cASTLE = new File("Levels/World 2/World 2 Castle.txt");
				Scanner read = new Scanner(cASTLE);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 1){
				
				String fileContents = "";
				File w1 = new File("Levels/World 2/World 2-1.txt");
				Scanner read = new Scanner(w1);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 2){
				
				String fileContents = "";
				File w2 = new File("Levels/World 2/World 2-2.txt");
				Scanner read = new Scanner(w2);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 3){
				
				String fileContents = "";
				File w3 = new File("Levels/World 2/World 2-3.txt");
				Scanner read = new Scanner(w3);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 4){
				
				String fileContents = "";
				File w4 = new File("Levels/World 2/World 2-4.txt");
				Scanner read = new Scanner(w4);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}
			
		}else if(world == 3){
			
			String[] optionss = new String[] {"Castle", "World 3-1", "World 3-2","World 3-3","World 3-4"};
			  int opps =  JOptionPane.showOptionDialog(null, "What Section?", "Section?", 
			        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
			        null, optionss, optionss[0]);
			
			
			section = opps;	
			
			
			
			
			
			if(section == 0){
				
				String fileContents = "";
				File cASTLE = new File("Levels/World 3/World 3 Castle.txt");
				Scanner read = new Scanner(cASTLE);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 1){
				
				String fileContents = "";
				File w1 = new File("Levels/World 3/World 3-1.txt");
				Scanner read = new Scanner(w1);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 2){
				
				String fileContents = "";
				File w2 = new File("Levels/World 3/World 3-2.txt");
				Scanner read = new Scanner(w2);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 3){
				
				String fileContents = "";
				File w3 = new File("Levels/World 3/World 3-3.txt");
				Scanner read = new Scanner(w3);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}else if(section == 4){
				
				String fileContents = "";
				File w4 = new File("Levels/World 3/World 3-4.txt");
				Scanner read = new Scanner(w4);
				while(read.hasNext()){
					
					fileContents += read.nextLine()+"\n";
					
				}
				read.close();
				StringSelection stringSelection = new StringSelection (fileContents);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents (stringSelection, null);
				JOptionPane.showMessageDialog(null,"Copied to Clipboard! May Paste into the game!");
				
			}
			
		}
		
	}
	private static void initLookAndFeel(String LaF,String theme) {
    	LOOKANDFEEL = LaF;
    	THEME = theme;
	        String lookAndFeel = null;
	        
	        
					
				  fon = new Font("Arial", Font.PLAIN, 16);
				
	       
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
	            } 
	            
	            else {
	                System.err.println("Unexpected value of LOOKANDFEEL specified: "
	                                   + LOOKANDFEEL);
	                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
	            }

	            try {
	            	
	            	
	                UIManager.setLookAndFeel(lookAndFeel);
	                
	                // If L&F = "Metal", set the theme
	                
	                if (LOOKANDFEEL.equals("Metal")) {
	                  if (THEME.equals("DefaultMetal"))
	                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
	                  else if (THEME.equals("Ocean"))
	                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
	                  //dooku
	                     
	                     
	                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
	                }	
	                	
	                	
	                  
	                
	            } 
	            
	            catch (ClassNotFoundException e) {
	                System.err.println("Couldn't find class for specified look and feel:"
	                                   + lookAndFeel);
	                System.err.println("Did you include the L&F library in the class path?");
	                System.err.println("Using the default look and feel.");
	            } 
	            
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
	    }

}
