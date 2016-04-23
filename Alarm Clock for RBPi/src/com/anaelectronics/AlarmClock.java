/**
 * 
 */
package com.anaelectronics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author ARYAK
 *	Main class which will handle displaying it and will recive commands
 */
public class AlarmClock {
	private static JLabel clockDisplay = null;
	public static JFrame window = new JFrame("Clock");
	public static JPanel clock = new JPanel();
	public static Font fon = null;
	public static void openUI() throws FontFormatException, IOException{
		
		 window = new JFrame("Clock");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
       // window.add(buttons, BorderLayout.SOUTH);        
        window.setSize(320, 240);
       
        
         clock = new JPanel();
         clockDisplay = new JLabel("Downloading...");
         fon = Font.createFont(Font.TRUETYPE_FONT, new File("/Users/ARYAK/Downloads/ds_digital/DS-DIGII.TTF")).deriveFont(45);
         //WTF? Doesnt Work? Check online
         clockDisplay.setFont(fon);
        clock.add(clockDisplay);
        
        window.setLayout(new BorderLayout());        
        window.add(clock);
        clock.setLocation(160, 120);
        
        window.setVisible(true);
        
        
	}
	public static void updateDisplay(){
		
		
		clockDisplay.setText(Globals.displayedTime);
		
		
	}
	

}
