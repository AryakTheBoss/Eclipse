/**
 * 
 */
package shapes2014;

/**
 * @author 310843
 *
 */
public class HitBall {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		Square paddle1 = new Square(80,10,310,310,"green",true);
		Square paddle2 = new Square(80,10,370,310,"green",true);
		Circle ball = new Circle(10,320,330,"black",true);
		
		paddle1.makeVisible();
		paddle2.makeVisible();
		ball.makeVisible();
		
		for(;;){
		
		while(ball.getX() < 355){
			
			ball.slowMoveHorizontal(20);
			
		}
		
		paddle2.slowMoveHorizontal(-5);
		Thread.sleep(200);
		paddle2.slowMoveHorizontal(5);
		
        while(ball.getX() > 320){
        	
			ball.slowMoveHorizontal(-20);
			
			
		}
        
        paddle1.slowMoveHorizontal(5);
        Thread.sleep(200);
        paddle1.slowMoveHorizontal(-5);
		
		}
	}

}
