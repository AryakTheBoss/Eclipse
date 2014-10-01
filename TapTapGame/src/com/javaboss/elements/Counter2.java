/**
 * 
 */
package com.javaboss.elements;

/**
 * 
 * Can't you tell this is a timer?
 * 
 * @author UnityBoss
 *
 */
public class Counter2 {
	private int secs = 0;
	private int mins = 0;
	private boolean done = false;
	
	public Counter2(){}
	
	public void setTime(int seconds,int minutes){
		
		secs = seconds;
		mins = minutes;
		
	}
	public void nextCount(){
		
		if(secs == 0 && mins != 0){
			
			secs = 59;
			mins--;
			
		}else if(secs == 0 && mins == 0){
			
            done = true;			
			
		}else{
			
			secs--;
			
		}
		
	}
	public boolean isDone(){
		
		return done;
		
	}
	public String getTime(){
		
		return mins+":"+secs;
		
		
	}
	

}
