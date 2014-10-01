/**
 * 
 */
package threads;

/**
 * @author UnityBoss
 *
 */
import timer.Main;

public class PauseButtonUP implements Runnable {
	
	public static boolean paused = false;
	private Main m = new Main();
	private boolean bo = false;
	@Override
	public void run(){
		//System.out.println("NEW THREAD!");
		for(;;){
			
			try{
			Thread.sleep(5);
			}catch(InterruptedException e){e.printStackTrace();}
			if(Main.pauseButtonUP.getModel().isPressed() == true){
				
				m.pauseUP(true);
				Main.pauseButtonUP.setVisible(false);
				Main.resumeButtonUP.setVisible(true);				
				Main.stopButtonUP.setText("Reset");
				paused = true;
				while(bo == false){
				if(Main.resumeButtonUP.getModel().isPressed() == true){
					
					m.pauseUP(false);
					paused = false;
					
					Main.pauseButtonUP.setVisible(true);
					Main.resumeButtonUP.setText("Resume");
					Main.resumeButtonUP.setVisible(false);
					
					Main.stopButtonUP.setText("Stop");
					bo = true;
					
				}
				}
				bo = false;
				
			}
			
			
		
			
		}
		
	}
	
	public PauseButtonUP(){}
	
	
    
	public static void start(){new Thread(new PauseButtonUP()).start();}

}
