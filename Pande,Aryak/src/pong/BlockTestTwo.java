package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

import javax.swing.JFrame;

public class BlockTestTwo extends Canvas
{
	public BlockTestTwo()
	{
		setBackground(Color.WHITE);
	}

	public void paint(Graphics window)
	{
		Block one = new Block();
		one.draw(window);

		Block two = new Block(50,50,30,30);
		two.draw(window);

		Block three = new Block(350,350,15,15,Color.RED);
		three.draw(window);

		//two.draw(window, Color.white);

		Block four = new Block(450,50,20,60, Color.GREEN);
		four.draw(window);
		
		//add more test cases			
	}
	public static void main(String[] args){
		
		BlockTestTwo btt = new BlockTestTwo();
	
		JFrame frmMain = new JFrame();
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setSize(400, 400);
        
        Canvas cnvs = new Canvas();
        cnvs.setSize(400, 400);

        frmMain.add(btt);
        frmMain.setVisible(true);

       // Graphics g = cnvs.getGraphics();
		
      //  btt.paint(g);
		
	//btt.paint();

	}
}