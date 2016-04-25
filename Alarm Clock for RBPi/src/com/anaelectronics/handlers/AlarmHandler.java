/**
 * 
 */
package com.anaelectronics.handlers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import com.anaelectronics.AlarmClock;
import com.anaelectronics.Globals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;


import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author ARYAK
 *	This checks when to sound alarm if its set and on
 */
public class AlarmHandler implements Runnable{
	

	private static Thread t = null;
	private static JButton snooze = new JButton("SNOOZE");
	private static JButton redButton = new JButton("R");
	private static JButton greenButton = new JButton("G");
	private static JButton blueButton = new JButton("B");
	private static JButton orangeButton = new JButton("O");
	private static JPanel colorButtons = new JPanel();
	public static JFrame dialog = new JFrame("ALARM");
	private static final char[] buttons = {'R','G','B','O'};
	private static Queue<Character> buttonPresses = new LinkedList<Character>();
	
@Override
public void run() {
	// TODO Auto-generated method stub
	
	colorButtons.add(redButton);
	colorButtons.add(greenButton);
	colorButtons.add(blueButton);
	colorButtons.add(orangeButton);
	dialog.setSize(250, 140); 
	dialog.setResizable(false);
	Dimension dim = new Dimension(320,240);
    dialog.setLocation(dim.width/2-dialog.getSize().width/2, dim.height/2-dialog.getSize().height/2);
    dialog.setAutoRequestFocus(true);
    redButton.setPreferredSize(new Dimension(50,50));
    greenButton.setPreferredSize(new Dimension(50,50));
    blueButton.setPreferredSize(new Dimension(50,50));
    orangeButton.setPreferredSize(new Dimension(50,50));
    redButton.setForeground(Color.RED);   
    redButton.setBackground(Color.RED); 
    redButton.setOpaque(true);
    greenButton.setForeground(Color.GREEN);
    greenButton.setBackground(Color.GREEN); 
    greenButton.setOpaque(true);
    blueButton.setForeground(Color.BLUE);
    blueButton.setBackground(Color.BLUE); 
    blueButton.setOpaque(true);
    orangeButton.setForeground(Color.ORANGE);
    orangeButton.setBackground(Color.ORANGE); 
    orangeButton.setOpaque(true);
    dialog.setLayout(new BorderLayout());
    dialog.add(colorButtons, BorderLayout.SOUTH);
    snooze.setEnabled(!Globals.snoozed);
    dialog.add(snooze, BorderLayout.NORTH);
    
    dialog.setVisible(true);
	Thread thisThread = Thread.currentThread();
	
	while(t == thisThread){
		
		
		//Manage when to ring alarm
		//Display the button punch dialog or snooze once
		//call dialog.setVisible(true);
		
	}
	dialog.dispose();
	
}

public static void start() throws IOException{
	
	t = new Thread(new AlarmHandler());
	t.start();
}
public static void clearButtonQueue(){
	buttonPresses.clear();
}
public static void convertTime(){ //converts the military time into standard AM/PM time
	

	//System.out.println(Globals.ahours);
	if(Globals.ahours != 0)
	Globals.displayedAlarm = "Alarm: "+(Globals.ahours > 12 ? Globals.ahours-12 : Globals.ahours)+":"+(Globals.aminutes < 10 ? "0"+Globals.aminutes : Globals.aminutes)+"  "+(Globals.aPM ? "PM":"AM");
	else
		Globals.displayedAlarm = "Alarm: "+(12)+":"+(Globals.aminutes < 10 ? "0"+Globals.aminutes : Globals.aminutes)+"  "+(Globals.aPM ? "PM":"AM");
}

public static void snooze(){
	Globals.snoozed = true;
}
public static void stopAlarm(){
	Globals.snoozed = false;
}
public static void off(){
	
	t = null;
	
}
public static void ring(){
	
	 final int BUFFER_SIZE = 128000;
     File soundFile = new File("/Users/ARYAK/Downloads/ALARM.wav");
     AudioInputStream audioStream = null;
     AudioFormat audioFormat = null;
     SourceDataLine sourceLine = null;

   // String strFilename = filename;

   

    try {
        audioStream = AudioSystem.getAudioInputStream(soundFile);
    } catch (Exception e){
        e.printStackTrace();
        System.exit(1);
    }

    audioFormat = audioStream.getFormat();

    DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
    try {
        sourceLine = (SourceDataLine) AudioSystem.getLine(info);
        sourceLine.open(audioFormat);
    } catch (LineUnavailableException e) {
        e.printStackTrace();
        System.exit(1);
    } catch (Exception e) {
        e.printStackTrace();
        System.exit(1);
    }

    sourceLine.start();

    int nBytesRead = 0;
    byte[] abData = new byte[BUFFER_SIZE];
    while (nBytesRead != -1) {
        try {
            nBytesRead = audioStream.read(abData, 0, abData.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (nBytesRead >= 0) {
            @SuppressWarnings("unused")
            int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
        }
    }

    sourceLine.drain();
    sourceLine.close();
}

}
