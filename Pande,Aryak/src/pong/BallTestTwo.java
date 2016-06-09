package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7950451109931544310L;
	private Ball ball;

	public BallTestTwo()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//instantiate a new Ball


		//test the Ball thoroughly
		

		//test all constructors


		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);

		if(!(ball.getX()>=10 && ball.getX()<=550))
		{
			ball.setVx(-ball.getVx());
		}

		if(!(ball.getY()>=10 && ball.getY()<=450))
		{
			ball.setVy(-ball.getVy());
		}
	}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.sleep(19);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}