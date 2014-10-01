package shapes2014;

import javax.swing.JOptionPane;


public class ShapeTester {

	/**
	 * @author 310843
	 * 3/11/14
	 * 
	 */
	public static void main(String[] args)throws InterruptedException {
		// draw and move a box with default constructor
		Square floor = new Square(100,700,0,600,"red",true);
	    Circle ball = new Circle(20,20,0,0,"black",true);
		ball.makeVisible();
		floor.makeVisible();
		Thread.sleep(1000);
		JOptionPane.showMessageDialog(null, "CLICK TO START BALL!");
		//first drop
		
		while(ball.getY() < 580){
			
			ball.moveHorizontal(3);
			ball.moveVertical(20);
			
		}
		//first bounce
		
		while(ball.getY() > 310){
			
			ball.moveHorizontal(3);
			ball.moveVertical(-20);
			
			
		}
		//falling back
		while(ball.getY() < 580){
			
			ball.moveHorizontal(5);
			ball.moveVertical(20);
			
		}
		//bounce 2
        while(ball.getY() > 395){
			
			ball.moveHorizontal(3);
			ball.moveVertical(-20);
			
			
		}
        
        while(ball.getY() < 580){
        	
        	ball.moveHorizontal(3);
			ball.moveVertical(20);
        	
        }
        
        while(ball.getY() > 450){
        	
        	ball.moveHorizontal(3);
			ball.moveVertical(-20);
        	
        }
		
		Thread.sleep(2500);
		System.exit(0);
	}
}

