/**
 * 
 */
package com.anaelectronics.handlers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import com.anaelectronics.AlarmClock;
import com.anaelectronics.Globals;
import com.anaelectronics.listeners.AlarmSetListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * @author ARYAK
 *	This checks when to sound alarm if its set and on
 */
public class AlarmHandler implements Runnable{
	

	private static Thread t = null;
	private static Thread g = null;
	public static JButton snooze = new JButton("SNOOZE");
	private static JButton redButton = new JButton("R");
	private static JButton greenButton = new JButton("G");
	private static JButton blueButton = new JButton("B");
	private static JButton orangeButton = new JButton("O");
	private static JPanel colorButtons = new JPanel();
	private static JPanel label = new JPanel();
	private static Random r = new Random();
	private static String labels = "";
	private static SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
	private static Calendar cal = Calendar.getInstance();
	private static JLabel combos = new JLabel("Generating...");
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
    redButton.addActionListener(new ColorButtonListener());
    greenButton.addActionListener(new ColorButtonListener());
    blueButton.addActionListener(new ColorButtonListener());
    orangeButton.addActionListener(new ColorButtonListener());
    dialog.setLayout(new BorderLayout());
    dialog.add(colorButtons, BorderLayout.SOUTH);
    snooze.setEnabled(!Globals.snoozed);
    snooze.addActionListener(new SnoozeListener());
    dialog.add(snooze, BorderLayout.NORTH);
    label.add(combos, BorderLayout.CENTER);
   // snooze.addActionListener(new SnoozeListener());
    dialog.add(label);
    
    clearButtonQueue();
    generateSequence();
    displayCombos();
 
	Thread thisThread = Thread.currentThread();
	
	while(t == thisThread){
		
		if(Calendar.getInstance().get(Calendar.HOUR) == AlarmSetListener.cal.get(Calendar.HOUR) && Calendar.getInstance().get(Calendar.MINUTE) == AlarmSetListener.cal.get(Calendar.MINUTE) && Calendar.getInstance().get(Calendar.AM_PM) == AlarmSetListener.cal.get(Calendar.AM_PM)){//TODO
			//System.out.println("RING! Hours: "+Globals.hours+" Alarm hrs: "+Globals.ahours);
			g = t;
			while(g == thisThread){
			dialog.setVisible(true); //User can't close dialog due to the Loop
			AlarmClock.alarmOn.setEnabled(false);
			if(buttonPresses.isEmpty()){
				off();
				g=null;
		//	snooze.setEnabled(true);
			}
			}
		}
		//Manage when to ring alarm
		//Display the button punch dialog or snooze once
		//call dialog.setVisible(true);
		//730 729
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	dialog.dispose();
	AlarmClock.alarmOn.setEnabled(true);
	
}
private static void displayCombos(){
	
Iterator<Character> i = buttonPresses.iterator();
labels = "Press in this Order: ";
while(i.hasNext()){
	labels += i.next()+" ";
}
    
    combos.setText(labels);
}
private class SnoozeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Re-Implement 
		
		snooze.setEnabled(false);
	g = null;
		AlarmSetListener.cal.set(Calendar.MINUTE, AlarmSetListener.cal.get(Calendar.MINUTE)+5);
		Globals.displayedAlarm = AlarmSetListener.sdf.format(AlarmSetListener.cal.getTime());
		dialog.dispose();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		AlarmClock.alarmOn.setEnabled(true);
	}
	
	
	
	
}
private class ColorButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Find source and deal with it accordingly and poll from the queue
		
		if(e.getSource() == redButton){
			if(buttonPresses.peek() == 'R')
				buttonPresses.poll();
		}
		if(e.getSource() == blueButton){
			if(buttonPresses.peek() == 'B')
				buttonPresses.poll();
		}
		if(e.getSource() == greenButton){
			if(buttonPresses.peek() == 'G')
				buttonPresses.poll();
		}
		if(e.getSource() == orangeButton){
			if(buttonPresses.peek() == 'O')
				buttonPresses.poll();
		}
		displayCombos();
		
	}
	
	
	
	
}

public static void generateSequence(){
	
	for(int i=0;i<6;i++){
		
		buttonPresses.add(buttons[r.nextInt(buttons.length)]);
		
	}
	//System.out.println(buttonPresses);
}

public static void start() throws IOException{
	
	t = new Thread(new AlarmHandler());
	t.start();
	g=t;
}
public static void clearButtonQueue(){
	buttonPresses.clear();
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
