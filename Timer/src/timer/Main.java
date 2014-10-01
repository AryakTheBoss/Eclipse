/**
 * 
 */
package timer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.File;


import javax.swing.*;
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

import threads.*;



/**
 * 
 * 
 * @version v3.1
 * @author JavaBoss (Aryak)
 *
 */
public class Main { 

	/**
	 * This is the Main class
	 * 
	 * The class can provide pretty cool ui for setting, pausing starting and stopping the timer.
	 * The next update might have some more "Bliss" lol
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */
	public static Timer t = new Timer();
	private static String LOOKANDFEEL = null;
	private static String THEME = null;
	public static JButton stopButtonUP; 
	public static  JButton resumeButtonUP;
    public static JButton pauseButtonUP; 
   public static JButton stopButton; 
    public static JButton resumeButton; 
   public static JButton pauseButton; 
  public static JLabel displayUP;
  public static Font fon = null,fon2 = null;
  
  public static JButton showTime;
  
  
  public static GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
  
   
    // private static boolean stopUPPressed = false;
    // private static boolean resumeUPPressed = false;
     private static boolean pauseUPPressed = false;
    // private static boolean cancelPressed = false;
     private static boolean pausePressed = false;
    // private static boolean resumePressed = false;
     
    public Main(){}
    //public void stopUP(boolean flag){stopUPPressed = flag;}
   // public void resumeUP(boolean flag){resumeUPPressed = flag;}
    public void pauseUP(boolean flag){pauseUPPressed = flag;}
   // public void cancel(boolean flag){cancelPressed = flag;}
    public void pause(boolean flag){pausePressed = flag;}
   // public void resume(boolean flag){resumePressed = flag;}
    
    
	
	
	public static void main(String[] args) throws InterruptedException {
		
		boolean k = false;
		
		int c = JOptionPane.showConfirmDialog(null, "Want to use a Custom Font?", "CUSTOM FONT?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		
		if(c == JOptionPane.YES_OPTION){
			do{
				
				String x = JOptionPane.showInputDialog(null, "Enter the font file's location (Ex. /Documents/files/yourfont.ttf) or just \"yourfont.ttf\" if the ttf file is right next to the jar or press CANCEL to use default.");
				
				
				
				if(x != null){
				File test = new File(x);
				if(test.exists()){		
					initLookAndFeel("Nimbus","Ocean",x,24f); //initialize the graphics (the L&F)
				    k = true;
				}else{
					JOptionPane.showMessageDialog(null, "File Doesn't exist Try Again");
					k = false;
				}
				}else{
					k = false;
				}
				}while(k == false);
			welcome();
		}else{
			
			initLookAndFeel("Acryl",null,"bumpitup.ttf",24f);
			welcome();
		}
		
		
			  
			  
			
		}
	
	public static void welcome() throws InterruptedException{
		//System.out.println(System.getProperties().values().toString());
		//loading();
		JOptionPane.showMessageDialog(null, "Welcome to the Java Timer! (Did you like the loading screen? :P)");
		JPanel panel=new JPanel(); 
		 
		
		   
		 panel.setLayout(new GridLayout(4,1));  
		  
		  
		 JLabel username=new JLabel("Choose:");  
		  
		 
		  
		  JComboBox<String> choi = new JComboBox<String>();
		  
		  choi.addItem("Select One");
		  choi.addItem("Count Down");
		  choi.addItem("Count Up");
		  panel.add(username);
		  panel.add(choi);
		  boolean none = false;
		 
		  do{
		  int xx = JOptionPane.showConfirmDialog(null,panel,"Pick One",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		  
		    String s = String.valueOf(choi.getSelectedItem()); 
		    if(xx == JOptionPane.CANCEL_OPTION){
		    	
		    	JOptionPane.showMessageDialog(null, "Bye!");
		    	System.exit(0);
		    	
		    }else{
		    if(s.equals("Select One")){
		    	
		    	JOptionPane.showMessageDialog(null, "You Didn't Select an Option!");
		    	none = true;
		    	
		    	
		    }else{
		    	
		    	if(s.equals("Count Down")){
		    		
		    		t.setType(false);
		    		none = false;
		    		
		    	}else{
		    		
		    		t.setType(true);
		    		none = false;
		    	}
		    	
		    }
		    
		    }
			
		  }while(none == true);
		  
		  
		
			
			  if(t.isCountUp() == true){
				  
				  stopWatch();
				  
			  }else{ 
				  
				     
				  countDown();
				  
			  }
		
		
	}

	
	public static void stopWatch() throws InterruptedException{ //stopwatch
		
		
		
          JFrame frame=new JFrame();		
		  frame.setSize(400, 200);		
		  frame.setTitle("TIMER");			  
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   displayUP=new JLabel("Press Start");
		  displayUP.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		  displayUP.setFont(fon); 
		  frame.add(displayUP);		  
       
          JButton startButtonUP = new JButton("Start");
         stopButtonUP = new JButton("Stop");
         resumeButtonUP = new JButton("Resume");
         pauseButtonUP = new JButton("Pause");
          
        
          JPanel pane = new JPanel();
          pane.add(stopButtonUP);
          pane.add(startButtonUP);
          pane.add(resumeButtonUP);
          pane.add(pauseButtonUP);
          resumeButtonUP.setVisible(false);
          pauseButtonUP.setVisible(false);
          JFrame frr = new JFrame("TIMER");
          frr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frr.setLayout(new BorderLayout());        
          frr.add(pane, BorderLayout.SOUTH);        
          frr.setSize(400, 200);
          frr.add(displayUP);
          stopButtonUP.setVisible(false);          
          frr.setLocationRelativeTo(null);
          frr.setVisible(true);
          boolean c = false;
          while(c == false){
          if(startButtonUP.getModel().isPressed() == true){       	  
        	  c = true;
        	  startButtonUP.setVisible(false);
        	  stopButtonUP.setVisible(true);
        	  pauseButtonUP.setVisible(true);
          }
          }
          PauseButtonUP.start();
          StopButton.start();
//          DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
//          
//          Date dateobj = new Date();
//          System.out.println(df.format(dateobj));
		for(;;){ //infinite loop until stopped by user
			
			while(pauseUPPressed == true){Thread.sleep(5);}
					
			
			
			t.nextUp();
			
			
			Thread.sleep(1000);
			  
		    displayUP.setText(t.toTime());  
		
			
	}

	}
	public static void countDown() throws InterruptedException{ //ringing timer!!
		
		
		JPanel panel=new JPanel();  
		 
		   
		 panel.setLayout(new GridLayout(4,1));  
		  
		  
		 JLabel username=new JLabel("Seconds");  
		  
		 
		 JLabel password=new JLabel("Minutes");  
		 
		 JLabel hoursL = new JLabel("Hours");		  
		 
		  
		  JComboBox<Integer> sec = new JComboBox<Integer>();
		  JComboBox<Integer> min = new JComboBox<Integer>();
		  JComboBox<Integer> hrs = new JComboBox<Integer>();	  
		 
		  
		  for(int i=0;i<60;i++){ //for loops add items to the j combo boxes so people can't put ridcoulous values
			  
			  sec.addItem(i);
			  Thread.sleep(3);
			  
		  }
         for(int i=0;i<60;i++){
			  
			  min.addItem(i);
			  Thread.sleep(3);
			  
		  }
         for(int i=0;i<24;i++){
			  
			  hrs.addItem(i);
			  Thread.sleep(3);
			  
		  }				  
		  
		 panel.add(username);  
		  
		 
		 panel.add(sec);  
		  
		  
		 panel.add(password);  
		  
		
		 panel.add(min);  
		 
		 panel.add(hoursL);
		 
		 panel.add(hrs);
		 boolean zero = false;
		 //END
		 int xx = 0;
		 do{
		 
		 xx = JOptionPane.showConfirmDialog(null,panel,"Attention!",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		if(xx == JOptionPane.OK_OPTION){
			
			
			
			String s = String.valueOf(sec.getSelectedItem()); //also can be : String x = sec.getSelectedItem().toString();
			String m = String.valueOf(min.getSelectedItem());
			String h = String.valueOf(hrs.getSelectedItem());
			
			int si = Integer.parseInt(s);
			int mi = Integer.parseInt(m);
			int hi = Integer.parseInt(h);
			
			if(si == 0 && mi == 0 && hi == 0){
				
				JOptionPane.showMessageDialog(null, "Time cannot be set to 0 Try Again!");
				zero = true;
			}else{
			
			t.setTime(si, mi, hi);
			zero = false;
			System.out.println("Timer set to "+hi+":"+mi+":"+si); //debug
			
			}
	   
			
		}else{
			
			JOptionPane.showMessageDialog(null, "Bye!");
			System.exit(0);
			
		}
		 }while(zero == true);
		
		 /**END OF TIMER SET UI**/
		 int barMax = ((((t.getH()*60)+(t.getM()))*60)+t.getS()); //convert the time set into seconds for the JProgressBar
		 System.out.println(barMax);
		 PBE bar = new PBE(barMax,fon);
		 JFrame frame=new JFrame();		
		  frame.setSize(400, 200);		
		  frame.setTitle("TIMER");			  
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  JLabel display=new JLabel("Press Start");
		  display.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		
		  	  
         
         JButton startButton = new JButton("Start");
       stopButton  = new JButton("Cancel");
        resumeButton = new JButton("Resume");
        pauseButton = new JButton("Pause");
         
         JPanel pane = new JPanel();
         pane.add(stopButton);
         pane.add(startButton);
         pane.add(resumeButton);
         pane.add(pauseButton);
         resumeButton.setVisible(false);
         pauseButton.setVisible(false);
         JFrame frr = new JFrame("TIMER");
         frr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frr.setLayout(new BorderLayout());        
         frr.add(pane, BorderLayout.SOUTH);        
         frr.setSize(400, 200);
         frr.add(bar);
        
         stopButton.setVisible(false);          
         frr.setLocationRelativeTo(null);
         frr.setVisible(true);
         boolean c = false;
         do{
         if(startButton.getModel().isPressed() == true){       	  
       	  c = true;
       	  startButton.setVisible(false);
       	  stopButton.setVisible(true);
       	  pauseButton.setVisible(true);
         }
         }while(c == false);
		
		  int val = 0;
		  bar.updateBar(val,display.getText());
		  
		  CancelButton.start();
		  PauseButton.start();
		  display.setText(t.toTime()); 
		  Thread.sleep(105); 
		for(;;){ //infinite loop until stopped by user
			
			
			
			while(pausePressed == true){Thread.sleep(5);}
			
			
			
			
			if(t.getH() == 0 && t.getM() == 0 && t.getS() == 0){
				pauseButton.setVisible(false);
				stopButton.setVisible(false);
				for(int j=0;j<101;j++){
				
				bar.updateBar(barMax, "TIMER DONE!!");
				bar.setVisible(false);
				Thread.sleep(100);
				bar.setVisible(true);
				t.playSound("Alarm.wav"); 
				}
				System.exit(0);
			}
			
			
			t.nextDown();
			
			   
			  display.setText(t.toTime()); 
			  val++;
			  bar.updateBar(val,display.getText());
			  
			  Thread.sleep(1000);
		
			
	}
		
	}
    private static void initLookAndFeel(String LaF,String theme,String font,float fontsize) {
    	LOOKANDFEEL = LaF;
    	THEME = theme;
	        String lookAndFeel = null;
	        
	        try {
				  fon = Font.createFont(Font.TRUETYPE_FONT, new File(font)).deriveFont(fontsize);
				  genv.registerFont(fon);
				} catch (Exception e) {
					System.err.println("Can't load Font Using Default font....");
				  fon = new Font("Arial", Font.PLAIN, 16);
				}
	        
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
    
    public static void loading() throws InterruptedException{
    	
    	JFrame l = new JFrame();
		  fon2 = new Font("Arial", Font.PLAIN, 16);
    	PBE bar = new PBE(250,fon2);
    	      l.setSize(400, 160);		
		  l.setTitle("Loading...");			  
		  l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		  JLabel displayy=new JLabel("Press Start");
//		  displayy.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		 l.add(bar);
		 l.setVisible(true);
		 for(int g=0;g<=1;g++){
			 
			if(g == 0) {
			 
		 for(int i=0;i<=50;i++){
		 bar.updateBar(i, "Loading Resources...");
		 if(i == 23 || i == 34 || i == 42){
		 Thread.sleep(1500);
		 i+=7;
		 }else{
			 Thread.sleep(400);
		 }
		 }
		 bar.updateBar(50, "Mounting Objects...");
		 Thread.sleep(1000); 
		 for(int i=50;i<=100;i++){
			 bar.updateBar(i, "Mounting Objects...");
			 if(i == 58 || i == 66 || i == 88 || i == 64 || i == 55 || i == 77){
			 Thread.sleep(1500);
			 i+=7;
			 }else{
				 Thread.sleep(400);
			 }
			 }
		   
		 bar.updateBar(100, "Starting delay.exe ..."); 
		 for(int i=100;i<=250;i++){
			 bar.updateBar(i, "Starting delay.exe ...");
			 if(i == 110 || i == 105 || i == 133 || i == 166 || i > 170){
			 Thread.sleep(1700);
			 i+=14;
			 if(i > 250){
				 i = 250;
			 }
			 }else{
				 Thread.sleep(400);
			 }
			 }
		 bar.updateBar(250, "FINALLY DONE! Launching...");
		 Thread.sleep(1500);
			}else{
				
				bar.updateBar(0, "JK! Not Quite done yet...");
				Thread.sleep(1500); 
				bar.updateBar(0, "Starting open.exe ....");
				Thread.sleep(1000);
				int percent;
				double percen;
				for(int d=0;d<=250;d++){
					percen = (d/250)*100;
					percent = (int)percen;
					bar.updateBar(d, "Starting open.exe ...."+"("+percent+"%"+")"); 
					Thread.sleep(800);
					
					
				}
				
			}
		 }
		 
		
		 
		 l.setVisible(false);
		 
    	
    }
	
	
	
	}
