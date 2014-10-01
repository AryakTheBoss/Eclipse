package com.javaboss.main;

import java.awt.BorderLayout;


import com.javaboss.elements.Comps;
import com.javaboss.elements.CounterThread;
import javax.swing.*;
public class Game {
	
//sorry but this time the documentation will be very poor because i want to save some time yolo
	private static int retry = 0;
	private static int score = 0;
	private static char gameMode = ' ';
	private static char difficulty = ' ';
	private static char diff = ' ';
	private static int mustGet = 0;
	private static boolean pressed = false;
	
	private static boolean inside = false;
	public Game(){}
	public void setPress(boolean s){pressed = s;}
	public void setIn(boolean s){inside = s;}
	public static void main(String[] args)throws InterruptedException {
		
		System.out.println("Game Started!");
		Comps.graphics.initLookAndFeel();
       JOptionPane.showMessageDialog(null, "Welcome to Tap Tap Alpha!!");
        
        
        
          
		  JLabel tim = new JLabel("Time");
		  JLabel sc = new JLabel("Score");
		  JLabel display=new JLabel("WELCOME TO TAP TAP v1.0.1a!");
		  display.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		 	  
          JButton bestButton = new JButton("View Best Score");
          JButton startButton = new JButton("Play");
          JButton arcade = new JButton("Arcade Mode");
          JButton ta = new JButton("Time Attack Mode");
          JButton easy = new JButton("Easy");
          JButton med = new JButton("Medium");
          JButton hard = new JButton("Hard");
          JButton one = new JButton("15 Seconds");
          JButton two = new JButton("30 Seconds");
          JButton three = new JButton("1 Minute");
          JButton quit = new JButton("Quit");
          JButton pause = new JButton("Pause");
          JButton resume = new JButton("Resume");
          JButton tapButton = new JButton("!!!");
    
          JPanel pane = new JPanel();
          pane.add(bestButton);
          pane.add(startButton);
          pane.add(arcade);
          pane.add(ta);
          pane.add(easy);
          pane.add(med);
          pane.add(hard);
          pane.add(one);
          pane.add(two);
          pane.add(three);
          pane.add(quit);
          pane.add(pause);
          pane.add(resume);
          
          JPanel pane2 = new JPanel();
          
          pane2.add(sc);
          JPanel pane3 = new JPanel();
          pane3.add(tim);
          
          
          
          
    
          JFrame frr = new JFrame("Main Menu");
          
          frr.setLayout(new BorderLayout());        
          frr.add(pane, BorderLayout.SOUTH); 
          frr.add(pane2, BorderLayout.EAST);
          frr.add(pane3,BorderLayout.WEST);
          frr.add(tapButton);
          tapButton.setSize(65, 65);
         tapButton.setLocation(165, 50);
          frr.setSize(400, 200);
          frr.add(display);
          
          arcade.setVisible(false);   
          ta.setVisible(false);
          easy.setVisible(false);
          med.setVisible(false);
          hard.setVisible(false);
          one.setVisible(false);
          two.setVisible(false);
          three.setVisible(false);
          quit.setVisible(false);
          pause.setVisible(false);
          resume.setVisible(false);
          tim.setVisible(false);
          tapButton.setVisible(false);
          sc.setVisible(false);
          frr.setLocationRelativeTo(null);
          frr.setVisible(true);
          
          while(startButton.getModel().isPressed() == false){
        	  
        	  if(bestButton.getModel().isPressed() == true && Comps.highScore.getBestScore() != 0){
        		  
        		  JOptionPane.showMessageDialog(null, "Your High Score: "+Comps.highScore.getBestScore());
        		  
        		  
        	  }else if(bestButton.getModel().isPressed() == true){
        		  
        		  JOptionPane.showMessageDialog(null, "You Never Played the game!");
        		  
        	  }
        	  
          }
          
          Thread.sleep(400);
          
          bestButton.setVisible(false);
          startButton.setVisible(false);
          arcade.setVisible(true);
          ta.setVisible(true);
          display.setText("Pick a Game Mode!");
          frr.setTitle("Pick Mode");
          boolean ex = false;
          while(ex == false){
        	  
        	  if(arcade.getModel().isPressed() == true){
        		  
        		  gameMode = 'A';
        		  ex = true;
        		  
        	  }else if(ta.getModel().isPressed() == true){
        		  
        		  gameMode = 'T';
        		  ex = true;
        	  }else{
        		  
        		  ex = false;
        		  
        	  }
        	   //something new :)
        	  if(arcade.getModel().isRollover() == true){
        		  
        		  
        		  
        		  display.setText("<html>In Arcade mode, you have a certain amount of <br/> time (Depending on what difficulty you pick) to <br/> click the button a certain number of times.</html>");        		  
        		  
        	  }else if(ta.getModel().isRollover() == true){
        		  
        		  display.setText("<html>In Time Attack mode you have different time <br/> limits to pick from and you have to click the <br/> button as many times as you can in that time.</html>");
        		  
        	  }else{
        		  
        		  display.setText("Pick a Difficulty!");
        		  
        	  }
        	  
          }
          Thread.sleep(400);
          
          arcade.setVisible(false);
          ta.setVisible(false);
          boolean a = false;
          
          if(gameMode == 'A'){
        	  
        	  easy.setVisible(true);
        	  med.setVisible(true);
        	  hard.setVisible(true);
        	  display.setText("Pick Difficulty!");
        	  while(a == false){
            	  Thread.sleep(40);
            	  if(easy.getModel().isPressed() == true){
            		  
            		  difficulty = 'E';
            		  a = true;
            		  
            	  }else if(med.getModel().isPressed() == true){
            		  
            		  difficulty = 'M';
            		  a = true;
            		  
            	  }else if(hard.getModel().isPressed() == true){
            		  
            		  difficulty = 'H';
            		  a = true;
            		  
            	  }
            	  
              }
        	  
          }else if(gameMode == 'T'){
        	  
        	  one.setVisible(true);
        	  two.setVisible(true);
        	  three.setVisible(true);
        	  display.setText("Pick Time!");
        	  while(a == false){
            	  Thread.sleep(40);
            	  if(one.getModel().isPressed() == true){
            		  
            		  diff = 'F'; //15 sec
            		  a = true;
            		  
            	  }else if(two.getModel().isPressed() == true){
            		  
            		  diff = 'T'; //30 sec
            		  a = true;
            	  }else if(three.getModel().isPressed() == true){
            		  
            		  diff = 'M'; //1 min
            		  a = true;
            	  }else{
            		  a = false;
            	  }
            	  
            	 
            	  
            	  
              }
        	  
          }
          
          
         Thread.sleep(400);
          
          if(gameMode == 'A' && difficulty == 'E'){
        	  
        	  Comps.timer.setTime(0, 2);
        	  mustGet = 1300;
        	  easy.setVisible(false);
        	  med.setVisible(false);
        	  hard.setVisible(false);
        	  
          }else if(gameMode == 'A' && difficulty == 'M'){
        	  
        	  Comps.timer.setTime(45, 1);
        	  mustGet = 1500;
        	  easy.setVisible(false);
        	  med.setVisible(false);
        	  hard.setVisible(false);
        	  
          }else if(gameMode == 'A' && difficulty == 'H'){
        	  
        	  Comps.timer.setTime(30, 1);
        	  mustGet = 1700;
        	  one.setVisible(false);
        	  two.setVisible(false);
        	  three.setVisible(false);
        	  
          }else if(gameMode == 'T' && diff == 'F'){
        	  
        	  Comps.timer.setTime(15,0);
        	  one.setVisible(false);
        	  two.setVisible(false);
        	  three.setVisible(false);
        	          	  
          }else if(gameMode == 'T' && diff == 'T'){
        	  
        	  Comps.timer.setTime(30, 0); 
        	  one.setVisible(false);
        	  two.setVisible(false);
        	  three.setVisible(false);
        	  
        	  
          }else if(gameMode == 'T' && diff == 'M'){
        	  
        	  Comps.timer.setTime(0, 1);
        	  one.setVisible(false);
        	  two.setVisible(false);
        	  three.setVisible(false);
        	  
        	  
          }
          
         //
          quit.setVisible(true);
          pause.setVisible(true);
          
          display.setVisible(false);
          
          tim.setVisible(true);
          sc.setVisible(true);
          tapButton.setVisible(true);
          tim.setText("Time: "+Comps.timer.getTime());
          if(gameMode == 'A'){
          score = mustGet;
          sc.setText("Taps to go: "+score);
          
          }else if(gameMode == 'T'){
        	  
        	  score = 0;
        	  sc.setText("Score: "+score);
        	 tapButton.addMouseListener(Comps.tl);
        	 CounterThread ct = new CounterThread();
        	 CounterThread.m();
        	  int hs = Comps.highScore.getBestScore();
        	  sc.setText("<html>Score: "+score+"<br/>High Score: "+hs+"</html>");
        	  for(;;){
        		  
        		 Thread.sleep(2);
        		 tim.setText("Time: "+Comps.timer.getTime());
        		 if(pressed == true){
        			 pressed = false;
        			 score++;
        			 sc.setText("<html>Score: "+score+"<br/>High Score: "+hs+"</html>");
        			 
        			 continue;
        		 }
        		 if(Comps.timer.isDone() == true){
        			 
        			 ct.pause();
        			 break;
        			 
        		 }
        		 if(score > Comps.highScore.getBestScore()){
        			 
        			hs = (score+1);
        			 
        		 }
        		 
        		  
        		  
        	  }
        	  System.out.println("Game Done");
        	 
        	  
        	  if(score > Comps.highScore.getBestScore() && Comps.highScore.getBestScore() != -1){
        		  
        		  JOptionPane.showMessageDialog(null, "New High Score!");
        		  Comps.highScore.writeHighScore(score);
        		  
        	  }else{
        		  
        		  Comps.highScore.writeHighScore(Comps.highScore.getBestScore());
        		  
        	  }
        	  
        	  String[] optionsd = new String[] {"Retry", "Restart","Quit"};
        	  int i= JOptionPane.showOptionDialog(null, "Want to Retry?", "Retry?", 
  			        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
  			        null, optionsd, optionsd[0]);
        	  
        	  if(i == JOptionPane.YES_OPTION){
        		  
        		  retry = 1;
        		  
        	  }else if(i == JOptionPane.NO_OPTION){
        		  retry = 2;
        	  }else{
        		  retry = 3;
        	  }
        	  
          }
          
          //k
		
	}//END MAIN

	

}//END CLASS
