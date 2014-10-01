package threads;

import timer.Main;

public class PauseButton implements Runnable {
	
	
	private Main m = new Main();
	private boolean bo = false;
	
	@Override
	public void run(){
		
         for(;;){
			
			try{
			Thread.sleep(5);
			}catch(InterruptedException e){e.printStackTrace();}
			if(Main.pauseButton.getModel().isPressed() == true){
				
				m.pause(true);
				Main.pauseButton.setVisible(false);
				Main.resumeButton.setVisible(true);				
				Main.stopButton.setEnabled(false);
				
				while(bo == false){
				if(Main.resumeButton.getModel().isPressed() == true){
					
					m.pause(false);
					
					
					Main.pauseButton.setVisible(true);
					
					Main.resumeButton.setVisible(false);
					
					Main.stopButton.setEnabled(true);
					bo = true;
					
				}
				}
				bo = false;
				
			}
			
			
		
			
		}
		
		
	}
	public PauseButton(){}
	
	public static void start(){new Thread(new PauseButton()).start();}

}
