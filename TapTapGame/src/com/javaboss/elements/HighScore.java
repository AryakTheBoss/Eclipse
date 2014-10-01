/**
 * 
 */
package com.javaboss.elements;

import java.io.*;
import java.util.Scanner;

/**
 * A class that will log the user's best score
 * 
 * @author UnityBoss
 *
 */

public class HighScore {
	
	private File scoreFile;
	private PrintWriter write;
	private Scanner read;
	private int bestScore = -1;
	
	public HighScore(String f){scoreFile=new File(f); init();}
	
	private void init(){
		

		
		try{
		read = new Scanner(scoreFile);
		if(read.hasNext()){
		bestScore = Integer.parseInt(read.nextLine(),2);
		}
		read.close();
		write = new PrintWriter(scoreFile);
		write.println(bestScore);
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
		  
		}
	}
	
	public void writeHighScore(int score){
		
		 
		
		write.println(Integer.toBinaryString(score));
		write.close();
	}
	public void writeHighScore(String score){
		
		 
		
		
		write.println(Integer.toBinaryString(Integer.parseInt(score)));
		write.close();
		
	}
	
	
	public int getBestScore(){
		
		return bestScore;
		
		
	}
	public void writeDefaultScore(){
		
		write.println(Integer.toBinaryString(bestScore));
		
		
	}
	
	
	

}
