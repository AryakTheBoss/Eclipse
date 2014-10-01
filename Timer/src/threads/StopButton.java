/**
 * 
 */
package threads;

import javax.swing.JOptionPane;

import timer.Main;

/**
 * @author UnityBoss
 *
 */
public class StopButton implements Runnable {
	
	
	
	@Override
	public void run(){
		//System.out.println("NEW THREAD!");
		for(;;){
			
			try{
				Thread.sleep(5);
				}catch(InterruptedException e){e.printStackTrace();}
			
			if(Main.stopButtonUP.getModel().isPressed() == true && PauseButtonUP.paused == false){
				Main mm = new Main();
				mm.pauseUP(true); 
				JOptionPane.showMessageDialog(null, "Stopped at: "+Main.t.toTime());
				System.exit(0); 
				
			}else if(Main.stopButtonUP.getModel().isPressed() == true && PauseButtonUP.paused == true){
				
				Main.t.setTime(0, 0, 0); 
				Main.displayUP.setText(Main.t.toTime());
				Main.resumeButtonUP.setText("Start"); 
				
			}
			
			
		}
		
	}
	public StopButton(){}
	
	public static void start(){new Thread(new StopButton()).start();}
}
