/**
 * 
 */
package com.mp3.main;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import javax.swing.*;

import com.mp3.elements.Comps;
import com.mp3.elements.Globals;
import com.mp3.thread.*;

/**
 * @author UnityBoss
 * MAC VERSION
 */

public class Player {

	/**
	 * @param args
	 */
	private static final int BUFFER_SIZE = 128000;
    private static File soundFile1;
    public static boolean jkl = false;
    private static AudioInputStream audioStream;
    private static AudioFormat audioFormat;
    private static SourceDataLine sourceLine;
    public static int pausedOnFrame = 0;
    private static FileInputStream fis;
    public static AdvancedPlayer player = null;
    public static AdvancedPlayer pp = null;
   public static JButton playP;      
   public static JButton skipF;
   public static JButton skipB;
	public static void main(String[] args) throws FileNotFoundException, JavaLayerException, InterruptedException {  
		
		Comps.graphics.initLookAndFeel();
		
		JOptionPane.showMessageDialog(null, "Welcome! Place all the Music you want the player to play in a folder on the desktop called \"MP3\". ");
		
        JFrame window = new JFrame("MP3 Player");
        
        
        
        
        JComboBox<String> music = new JComboBox<String>();
        
        music.addItem(null);
        
        for(int i=0;i<Globals.mp3Files.length;i++){
        	
        	music.addItem(Globals.mp3Files[i].getName());
        	
        }
        playP = new JButton("▶");
        skipF = new JButton("▶|");
        skipB = new JButton("|⫷");
        
        JPanel buttons = new JPanel();
        buttons.add(skipB);        
        buttons.add(playP);
        buttons.add(skipF);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());        
        window.add(buttons, BorderLayout.SOUTH);        
        window.setSize(400, 200);
        
        
        JPanel musicChooser = new JPanel();
        musicChooser.add(music);
        window.add(musicChooser);
        window.setVisible(true);
        PausePlay.start();
        MusicPlay.start();
        MusicPause.start();
        for(;;){
        	Thread.sleep(10);
        	if(music.getSelectedItem() != null){
        		
        		Globals.currentSong = Globals.mp3Files[music.getSelectedIndex()-1];
        		fis = new FileInputStream(Globals.currentSong);	
        		player = new AdvancedPlayer(fis);
        		
        	}
        	
        	
        }
        
	}
	
public static void startWAV(File soundFile){
    	
    	
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
        while (nBytesRead != -1) { //possibly pauseable in this loop... checks if the sound is done playing.
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
public static void startMP3() throws FileNotFoundException, JavaLayerException{ 
	
	
	jkl = false;
		
	
	player.setPlayBackListener(new PlaybackListener() {
	    @Override
	    public void playbackFinished(PlaybackEvent event) {
	        pausedOnFrame = event.getFrame();
	    }
	});
	System.out.println("Starting MUSIC");
	jkl = true;
	
	player.play();
	
	
	
}
public static void play() throws JavaLayerException{}
public static void pause(){player.stop();}


}
