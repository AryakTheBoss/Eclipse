/**
 * 
 */
package com.anaelectronics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 * @author ARYAK
 *	Main class which will handle displaying it and will recive commands
 */
public class AlarmClock {
	private static JLabel clockDisplay = null;
	private static JFrame window = new JFrame("Clock");
	private static JPanel clock = new JPanel();
	private static JButton setAlarm = new JButton("Set Alarm");
	private static JToggleButton alarmOn = new JToggleButton(Globals.alarmSymbol);
	private static JLabel alarmSetFor = new JLabel("Alarm: 12:00 AM");
	private static JPanel statusBar = new JPanel();
	public static void openUI() throws FontFormatException, IOException{
		
		 window = new JFrame("Clock");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
       // window.add(buttons, BorderLayout.SOUTH);        
        window.setSize(320, 240);
       
        
         clock = new JPanel();
         clockDisplay = new JLabel("Downloading...");
         try {
             GraphicsEnvironment ge = 
                 GraphicsEnvironment.getLocalGraphicsEnvironment();	//Change path below to "DS-DIGII.TTF" when testing on the Pi
             ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("/Users/ARYAK/Downloads/ds_digital/DS-DIGII.TTF")));
           //  System.out.println(Arrays.toString(ge.getAvailableFontFamilyNames()));
        } catch (IOException|FontFormatException e) {
             e.printStackTrace();
        }
         
         clockDisplay.setFont(new Font("DS-Digital", Font.PLAIN, 100)); 
         clockDisplay.setForeground(Color.RED);
         //clockDisplay.setBackground(Color.BLACK);
        clock.add(clockDisplay,SwingConstants.CENTER);
        
        window.setLayout(new BorderLayout());        
        window.add(clock, BorderLayout.SOUTH);
        //clockDisplay.setLocation(160, 120);
        clock.setBackground(Color.BLACK);
        window.getContentPane().setBackground( Color.BLACK );
        window.setVisible(true);
        
        
	}
	public static void updateDisplay(){
		
		
		clockDisplay.setText(Globals.displayedTime);
		
		
	}
	

}
