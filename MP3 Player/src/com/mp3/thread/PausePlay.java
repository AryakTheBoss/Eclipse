/**
 * 
 */
package com.mp3.thread;

import com.mp3.elements.Globals;
/**
 * @author UnityBoss
 *
 */
import com.mp3.main.Player;
public class PausePlay implements Runnable{
	
	
	
	@Override
	public void run(){
		System.out.println("New thread");
		for(;;){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} 
			if(Player.playP.getModel().isPressed() == true && Globals.paused == false){
				System.out.println("paused");
				Globals.paused = true;
				try{Thread.sleep(2);}catch(InterruptedException e){e.printStackTrace();}
				Player.playP.getModel().setPressed(false); 
			}
			if(Player.playP.getModel().isPressed() == true && Globals.paused == true){
				System.out.println("unpause");
				Globals.paused = false;
				try{Thread.sleep(2);}catch(InterruptedException e){e.printStackTrace();}
				Player.playP.getModel().setPressed(false);
				
			}
			if(Globals.paused == true){
				
				Player.playP.setText("▶"); 
				
			}else{
				
				Player.playP.setText("||"); 
				
			}
			
			
		}
		
	}
	
	public static void start(){
		
		new Thread(new PausePlay()).start();
		
	}

}
