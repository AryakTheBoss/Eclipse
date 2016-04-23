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


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import com.anaelectronics.handlers.AlarmHandler;
import com.anaelectronics.listeners.AlarmButtonListener;
import com.anaelectronics.listeners.AlarmSetListener;

/**
 * @author ARYAK
 *	Main class which will handle displaying it and will recive commands
 */
public class AlarmClock {
	private static JLabel clockDisplay = null;
	private static JFrame window = new JFrame("Clock");
	private static JPanel clock = new JPanel();
	public static JButton setAlarm = new JButton("Set");
	public static JToggleButton alarmOn = new JToggleButton("On");
	private static JLabel alarmSetFor = new JLabel("Alarm: "+Globals.displayedAlarm);
	private static JPanel statusBar = new JPanel();
	public static void openUI() throws FontFormatException, IOException{
		
		 window = new JFrame("Clock");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
               
        window.setSize(320, 240); //Fullscreen on our little touch screen we will buy (2" 320x240)
       window.setResizable(false);
       
         clock = new JPanel();
         clockDisplay = new JLabel("null");
         //Add the custom Digital Clock font to the Environment
         try {
             GraphicsEnvironment ge = 
                 GraphicsEnvironment.getLocalGraphicsEnvironment();	//Change path below to "DS-DIGII.TTF" when testing on the Pi
             ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("/Users/ARYAK/Downloads/ds_digital/DS-DIGII.TTF")));
           
        } catch (IOException|FontFormatException e) {
             e.printStackTrace();
        }
         
         clockDisplay.setFont(new Font("DS-Digital", Font.PLAIN, 90)); 
         clockDisplay.setForeground(Color.RED);
         
        clock.add(clockDisplay,SwingConstants.CENTER);
        
        window.setLayout(new BorderLayout());        
        window.add(clock, BorderLayout.SOUTH);
       
        clock.setBackground(Color.BLACK);
        window.getContentPane().setBackground( Color.BLACK );
        alarmSetFor.setFont(new Font("DS-Digital",Font.PLAIN,25));
        alarmSetFor.setForeground(Color.RED);
        statusBar.setBackground(Color.BLACK);
        statusBar.add(setAlarm, BorderLayout.EAST);
        statusBar.add(alarmSetFor, BorderLayout.CENTER);
        statusBar.add(alarmOn, BorderLayout.WEST);
        alarmOn.addActionListener(new AlarmButtonListener());
        setAlarm.addActionListener(new AlarmSetListener());
        window.add(statusBar, BorderLayout.NORTH);
        AlarmHandler.convertTime();
        window.setVisible(true);
        
        
	}
	
	public static synchronized void updateDisplay(){
		
		
		clockDisplay.setText(Globals.displayedTime);
		
		
	}
	public static synchronized void updateAlarm(){
		
		alarmSetFor.setText(Globals.displayedAlarm);
		
	}
	

}
