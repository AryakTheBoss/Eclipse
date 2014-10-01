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
public class CancelButton implements Runnable {
	
	@Override
	public void run(){
		
           for(;;){
			
			try{
				Thread.sleep(5);
				}catch(InterruptedException e){e.printStackTrace();}
			
			if(Main.stopButton.getModel().isPressed() == true){
			
				Main m = new Main();
				
			m.pause(true);
				
				JOptionPane.showMessageDialog(null, "Stopped");
				System.exit(0); 
				
				
				
			}
				
				
				
			
			
			
		}
		
	}
    public CancelButton(){}
	
	public static void start(){new Thread(new CancelButton()).start();}

}
