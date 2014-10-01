/**
 * 
 */
package com.mp3.thread;

import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import com.mp3.elements.Globals;
import com.mp3.main.Player;

/**
 * @author UnityBoss
 *
 */
public class MusicPlay implements Runnable {
	private static Thread tt;
	
	@Override
	public void run(){
		System.out.println("music thread");
		for(;;){
			try {
				Thread.sleep(5);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			
			if(Globals.paused == false && Globals.currentSong != null){
				System.out.println("trying to play");
				try {
					
					Player.startMP3();
					
				} catch (FileNotFoundException | JavaLayerException e) {
					
					e.printStackTrace();
				}
				
			}
			
			
		}
		
		
	}
	
	public static void start(){
		
		tt = new Thread(new MusicPlay());
		tt.start();
		
	}
	
	public static void pause() throws InterruptedException{
		
		tt.wait();
		
		
	}
	public static void res(){
		
		tt.notify();
		
	}

}
