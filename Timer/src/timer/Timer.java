/**
 * 
 */
package timer;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
/**
 * Complete Blind program that has meaningful names. you need to the logic in another class.
 * 
 * @author UnityBoss
 *
 */
import javax.swing.*;
public class Timer {
	private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
	private int secs = 0,mins = 0,hours = 0;
	private boolean UoD;
	
	public Timer(){}
	
	public int getS(){
		return secs;
	}
	public int getM(){
		return mins;
	}
	public int getH(){
		return hours;
	}
	
	
	public void setTime(int seconds,int minutes,int hours){		
		secs = seconds;
		mins = minutes;
		this.hours = hours;
	}
	public void setType(boolean uod){	
		UoD = uod;
	}
	public void nextUp() throws InterruptedException{
			
		 if(UoD == true){
			
			if(secs > 58){
				
				mins++;
				secs = 0;
				
			}else if(mins > 58){
				
				hours++;
				mins = 0;
				
			}else{
				
				secs++;
				
				
			}
			}else{
				
				JOptionPane.showMessageDialog(null, "Incorrect Method!");
				System.exit(0);
				
			}
		}
	
	public void nextDown() throws InterruptedException{
		
       if(UoD == false){
			
    	   if(secs == 0 && mins != 0){
    		   
    		   mins--;
    		   secs = 59;
    		   
    	   }else if (secs == 0 && mins == 0){
    		   hours--;
    		   mins = 59;
    		   secs = 59;
    	   
       }else if(mins == 0 && hours != 0){
    		   
    		   hours--;
    		   mins = 59;
    		   
    	//   }else if(mins == 0 && hours == 0){
    		   
    		//mins = 0;
    		//hours = 0;
    		
    		   
    		   
    	   }else if(hours == 0 && mins == 0 && secs == 0){
    		   
    		  
    		   
    		   playSound("Alarm.wav"); 
    		   
    		   System.exit(0);
    		  
    	   }else{
    		   
    		   secs--;
    		  
    		   
    	   }
			
			}else{
				
				JOptionPane.showMessageDialog(null, "Incorrect Method!");
				System.exit(0);
				
			}
		
	}
		
		
	
	public String toTime(){
		
		String hs,ms,ss;
		
		if(hours < 10){
			
			hs = "0"+String.valueOf(hours);
			
		}else{	
			
			hs = String.valueOf(hours);
			
		}
		if(mins < 10){
			
			ms = "0"+String.valueOf(mins);
			
		}else{
			ms = String.valueOf(mins);
		}
		if(secs < 10){
			
			ss = "0"+String.valueOf(secs); 
			
		}else{
			ss = String.valueOf(secs);
		}
		
		String tim = null;
		
		if(hours == 0){
			
			tim = ms+":"+ss;
			
		}else if(mins == 0){
			
			tim = ss;
			
		}else if(hours != 0){
			
			tim = hs+":"+ms+":"+ss;
			
		}
		if(mins == 0 && hours == 0 && secs < 10){
			ss = "0"+String.valueOf(secs);
			tim = ":"+ss;
		}else if(mins == 0 && hours == 0 && secs > 10){
			
			ss = String.valueOf(secs);
			tim = ":"+ss;
			
		}
		if(hours == 0 && mins == 0 && secs == 10){
			
			tim = ":10";
			
		}
		
		
		
		return tim;
		
	}
	
    public boolean isCountUp(){
		
		return UoD;
		
		
	}	
    
    public void playSound(String filename){
    	
    	String strFilename = filename;

        try {
            soundFile = new File(strFilename);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

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