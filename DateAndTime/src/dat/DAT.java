package dat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
public class DAT {

	private static JFrame frame = new JFrame();
	private static DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
	private static Date d = new Date();
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		frame.setSize(400, 200);		
		  frame.setTitle("TIMER");			  
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  JLabel display=new JLabel("Starting....");
		  display.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		 
		  frame.add(display);		  
		Thread.sleep(3000);
		display.setText("AAA");
		int year = 0;
		int month = 0;
		int day = 0;
		int ampm = 0;
		int h = 0;
		int m = 0;
		int s = 0;
		int dayofweek = 0;
		for(;;){
			
		
		
		
		}
		
		
	}

}
