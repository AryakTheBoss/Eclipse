/**
 * 
 */
package com.anaelectronics.handlers;

import java.io.IOException;

import com.anaelectronics.AlarmClock;
import com.anaelectronics.Globals;
import java.io.File;


import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 * @author ARYAK
 *	This checks when to sound alarm if its set and on
 */
public class AlarmHandler implements Runnable{
	

	private static Thread t = null;
	
	
@Override
public void run() {
	// TODO Auto-generated method stub
	
	Thread thisThread = Thread.currentThread();
	
	while(t == thisThread){
		
		
		if(Globals.hours >= Globals.ahours && Globals.minutes >= Globals.aminutes && Globals.PM == Globals.aPM){
			ring();
			try {
				Thread.sleep(11050);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

public static void start() throws IOException{
	
	t = new Thread(new AlarmHandler());
	t.start();
}
public static void convertTime(){
	
//	if(Globals.ahours >= 12)
//		Globals.aPM = true;
//	else
//		Globals.aPM = false;
	
	if(Globals.ahours != 0)
	Globals.displayedAlarm = "Alarm: "+(Globals.ahours >= 12 ? Globals.ahours-12 : Globals.ahours)+":"+(Globals.aminutes < 10 ? "0"+Globals.aminutes : Globals.aminutes)+"  "+(Globals.aPM ? "PM":"AM");
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
