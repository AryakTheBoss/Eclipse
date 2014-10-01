/**
 * 
 */
package com.mp3.thread;

import javazoom.jl.decoder.JavaLayerException;

import com.mp3.elements.Globals;
import com.mp3.main.Player;

/**
 * @author UnityBoss
 *
 */
public class MusicPause implements Runnable{
	public static boolean ready = false;
	@Override
	public void run(){
		
		for(;;){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		   if(Globals.paused == true & Globals.currentSong != null & Player.player != null && Player.jkl == true){
			   System.out.println("jrgritbghwurthrthwrhwykhktjhktyjhket");
			   ready = true;
			Player.player.close();
			try {
				MusicPlay.pause();
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
		
			   try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		   }else if(Globals.paused == false & ready == true){
			   ready = false;
			   
				MusicPlay.res();
			
		   
			   
			   
			   
		   }
			
		}
		
	}
	
	public static void start(){
		
		new Thread(new MusicPause()).start();
		
	}

}
