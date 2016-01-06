/**
 * 
 */
package dingyfart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;



/**
 * @author 17ap0497
 *
 */
public class GetRekt {
	
	public static void main(String args[])
	{
			GfxApp gfx = new GfxApp();
			gfx.setSize(1000,750);
			gfx.addWindowListener(new WindowAdapter() {
				
				public void windowClosing(WindowEvent e) {
					
					System.exit(0);
				}
				
			});
			
			gfx.setVisible(true);
			
			
	}

}
class Point{
	
	private int x;
	private int y;
	
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String toString(){
		
		return "<"+x+","+y+">";
		
	}
	
}
class GfxApp extends JFrame
{
	private static Random r = new Random();
	private static Point endPt;
	private static Queue<Point> lel = new LinkedList<Point>();
	private static Queue<Point> lelB = new LinkedList<Point>();
	public static Color[] ca = {Color.BLUE,Color.CYAN,Color.DARK_GRAY,Color.GRAY,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED};
		public void paint(Graphics g)
		{
			
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.cyan);
			lel.offer(new Point(0,0));
			for(int i=0;i<10;i++){
				lel.offer(randomPoint());
			}
			Iterator<Point> l = lel.iterator();
			while(l.hasNext()){
				lelB.offer(l.next());
			}
			
			Stack<Point> s = new Stack<Point>();  //create a stack

		    //while the queue is not empty
		    while(!lelB.isEmpty())
		    {  //add the elements of the queue onto a stack
		       s.push(lelB.poll());
		    } 

		    //while the stack is not empty
		    while(!s.isEmpty())
		    { //add the elements in the stack back to the queue
		      lelB.offer(s.pop());
		    }
			
			System.out.println(lel);
			System.out.println(lelB);
			Iterator<Point> ll = lel.iterator();
			drawLine(g,ll.next(),storePrevEndPt(ll));
			while(ll.hasNext()){
				
				try {
					Thread.sleep(165);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				drawLine(g,endPt,storePrevEndPt(ll));
				
				
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.setColor(Color.black);
			drawLine(g,lel.poll(),storePrevEndPt(ll));
			while(!lel.isEmpty()){
				
				try {
					Thread.sleep(165);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				drawLine(g,endPt,storePrevEndPt(ll));
				
			}
		}
		
			public void drawLine(Graphics g, Point start,Point end){
				
				g.drawLine(start.getX(), start.getY(), end.getX(), end.getY()); 
				
			}
			public void drawLineConnected(Graphics g, Point end){
				
				
				
			}
			public Point storePrevEndPt(Iterator<Point> rekt){
				
				endPt = rekt.next();
				return endPt;
				
			}
		public Point randomPoint(){
			
			return new Point(r.nextInt(this.getWidth()),r.nextInt(this.getHeight()));
			
		}
		
}
