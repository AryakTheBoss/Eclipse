/**
 * 
 */
package org.aryakDev.shapes;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author 310843
 *
 */
public class DisneyAryak extends Applet {

	
	/**
	 * 
	 */
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	private static final int WIDTH     = 50;    
    private static final int HEIGHT    = 75;    
    private static final int IRISSIZE  = 0;    
    private static final int PUPILSIZE = 12;    
    private static Color irisColor;

    
    private static final int SMALLXRAD = (WIDTH  - IRISSIZE)/2;
    private static final int SMALLYRAD = (HEIGHT - IRISSIZE)/2;

    private static int x, y;                           // Current position of the eye
    private static double newx, newy; 
    public static int mouseX;
    public static int mouseY;// Position of the iris
    private static Graphics g = Canvas.getCanvas().graphic;         
	static Triangle roof1 = new Triangle(150,120,400,250,"blue",true);
	static Triangle roof2 = new Triangle(100,120,520,300,"blue",true);
	static Triangle roof3 = new Triangle(100,120,640,300,"blue",true);
	static Triangle roof4 = new Triangle(150,120,760,250,"blue",true);
	static Triangle roof5 = new Triangle(350,120,760,250,"blue",true);
	static Triangle roof6 = new Triangle(350,80,300,100,"blue",true);
	static Triangle roof7 = new Triangle(350,80,860,100,"blue",true);

	
	static Square body = new Square(240,480,340,400,"blue",true);
	static Square stripe1 = new Square(10,480,340,420,"white",true);
	static Square stripe2 = new Square(10,480,340,440,"white",true);
	static Square stripe3 = new Square(10,480,340,460,"white",true);
	static Square stripe4 = new Square(10,480,340,480,"white",true);
	static Square stripe5 = new Square(10,480,340,500,"white",true);
	static Square stripe6 = new Square(10,480,340,520,"white",true);
	static Square stripe7 = new Square(10,480,340,540,"white",true);
	static Square stripe8 = new Square(10,480,340,560,"white",true);
	static Square stripe9 = new Square(10,480,340,580,"white",true);
	static Square stripe10 = new Square(10,480,340,600,"white",true);
	static Square stripe11 = new Square(10,480,340,620,"white",true);
	static Square stripe12 = new Square(10,480,340,640,"white",true);
	static Square side1 = new Square(190,80,260,450,"blue",true);
	static Square side2 = new Square(190,80,820,450,"blue",true);
	static Square rail = new Square(10,900,0,20,"black",true);
	static Square mono = new Square(30,20,10,10,"blue",true);
	
	
	static Circle door = new Circle(200,150,490,550,"white",true);
	static Circle mickface = new Circle(400,350,350,"black",true);
	static Circle mickear1 = new Circle(200,260,250,"black",true);
	static Circle mickear2 = new Circle(200,590,220,"black",true);
	static Circle mickeye1 = new Circle(120,60,500,420,"white",true);
	static Circle mickeye2 = new Circle(120,60,600,420,"white",true);
	static Circle blk1 = new Circle(20,520,520,"black",true);
	static Circle blk2 = new Circle(20,620,520,"black",true);
	static Circle fire = new Circle(20,400,400,"yellow",true);
	static Circle part1 = new Circle(20,400,400,"yellow",true);
	static Circle part2 = new Circle(20,400,400,"yellow",true);
	static Circle part3 = new Circle(20,400,400,"yellow",true);
	static Circle part4 = new Circle(20,400,400,"yellow",true);
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		CASTLEON();
		
		
		
		mono.slowMoveHorizontal(900);
		
		
		
		
		
		
		
		String[] colors = {"red","blue","green","yellow"};
		
		Random r = new Random();
		
		
			
//			for(int i=0; i<6000; i++){
//				
//				stripe1.changeColor(colors[r.nextInt(4)]);
//				stripe2.changeColor(colors[r.nextInt(4)]);
//				stripe3.changeColor(colors[r.nextInt(4)]);
//				stripe4.changeColor(colors[r.nextInt(4)]);
//				stripe5.changeColor(colors[r.nextInt(4)]);
//				stripe6.changeColor(colors[r.nextInt(4)]);
//				stripe7.changeColor(colors[r.nextInt(4)]);
//				stripe8.changeColor(colors[r.nextInt(4)]);
//				stripe9.changeColor(colors[r.nextInt(4)]);
//				stripe10.changeColor(colors[r.nextInt(4)]);
//				stripe11.changeColor(colors[r.nextInt(4)]);
//				stripe12.changeColor(colors[r.nextInt(4)]);
//				
//			}
			
			
		
			Thread.sleep(7000);
		
		System.exit(0);


	        	
	        	
	        
	        
	        
		
	}
	
	
	public static void CASTLEON(){
		
		roof1.makeVisible();
		roof2.makeVisible();
		roof3.makeVisible();
		roof4.makeVisible();
		roof6.makeVisible();
		roof7.makeVisible();
		body.makeVisible();
		side1.makeVisible();
		side2.makeVisible();
		stripe1.makeVisible();
		stripe2.makeVisible();
		stripe3.makeVisible();
		stripe4.makeVisible();
		stripe5.makeVisible();
		stripe6.makeVisible();
		stripe7.makeVisible();
		stripe8.makeVisible();
		stripe9.makeVisible();
		stripe10.makeVisible();
		stripe11.makeVisible();
		stripe12.makeVisible();
		door.makeVisible();
		rail.makeVisible();
		mono.makeVisible();
		
		
	}
	public static void CASTLEOFF(){
		
		
		roof1.makeInvisible();
		roof2.makeInvisible();
		roof3.makeInvisible();
		roof4.makeInvisible();
		roof6.makeInvisible();
		roof7.makeInvisible();
		body.makeInvisible();
		side1.makeInvisible();
		side2.makeInvisible();
		stripe1.makeInvisible();
		stripe2.makeInvisible();
		stripe3.makeInvisible();
		stripe4.makeInvisible();
		stripe5.makeInvisible();
		stripe6.makeInvisible();
		stripe7.makeInvisible();
		stripe8.makeInvisible();
		stripe9.makeInvisible();
		stripe10.makeInvisible();
		stripe11.makeInvisible();
		stripe12.makeInvisible();
		door.makeInvisible();
		
	}
	

}
