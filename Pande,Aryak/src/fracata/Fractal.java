package fracata;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JFrame;

import fracata.Fractal.Corner;

public class Fractal
{
	
	public enum Corner { LeftTop, RightTop, RightBottom, LeftBottom}
	
		public static void main(String args[])
		{
				GfxApp gfx = new GfxApp();
				gfx.setSize(1000,750);
				gfx.addWindowListener(new WindowAdapter() {
					
					public void windowClosing(WindowEvent e) {
						
						System.exit(0);
					}
					
				});
				gfx.show();
				
		}
}
class GfxApp extends JFrame
{
	public static Random r = new Random();
	public static Color[] ca = {Color.BLUE,Color.CYAN,Color.DARK_GRAY,Color.GRAY,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED};
		public void paint(Graphics g)
		{
			int windowWidth = 1024; 
			int windowHeight = 786; 
			int w = windowWidth / 4;
			int h = windowHeight / 4;

			int x = (windowWidth - w) / 2;
			int y = (windowHeight - h) / 2;
			this.setBackground(Color.black);
			g.fillRect(x, y, w, h);
			
			drawChildRect(g, x - w / 2, y - h / 2, w / 2, h / 2, Corner.LeftTop);
			drawChildRect(g, x + w, y - h / 2, w / 2, h / 2, Corner.RightTop);
			drawChildRect(g, x + w, y + h, w / 2, h / 2, Corner.RightBottom);
			drawChildRect(g, x - w / 2, y + h, w / 2, h / 2, Corner.LeftBottom);
				
		}
		public void drawChildRect(Graphics g, int x, int y, int w, int h, Corner pc){
			g.setColor(ca[r.nextInt(ca.length)]);
			if(w >= 1){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				g.fillRect(x, y, w, h);
				
				if(pc.equals(Corner.LeftTop)){
					drawChildRect(g, x - w / 2, y - h / 2, w / 2, h / 2, Corner.LeftTop);
					drawChildRect(g, x + w, y - h / 2, w / 2, h / 2, Corner.RightTop);
					drawChildRect(g, x - w / 2, y + h, w / 2, h / 2, Corner.LeftBottom);
				}else if(pc.equals(Corner.RightTop)){
					
				
					drawChildRect(g, x - w / 2, y - h / 2, w / 2, h / 2, Corner.LeftTop);
					drawChildRect(g, x + w, y - h / 2, w / 2, h / 2, Corner.RightTop);
					drawChildRect(g, x + w, y + h, w / 2, h / 2, Corner.RightBottom);
				}else if(pc.equals(Corner.RightBottom)){
					
				
					drawChildRect(g, x + w, y - h / 2, w / 2, h / 2, Corner.RightTop);
					drawChildRect(g, x + w, y + h, w / 2, h / 2, Corner.RightBottom);
					drawChildRect(g, x - w / 2, y + h, w / 2, h / 2, Corner.LeftBottom);
				}else if(pc.equals(Corner.LeftBottom)){
					
				
					drawChildRect(g, x - w / 2, y - h / 2, w / 2, h / 2, Corner.LeftTop);
					drawChildRect(g, x + w, y + h, w / 2, h / 2, Corner.RightBottom);
					drawChildRect(g, x - w / 2, y + h, w / 2, h / 2, Corner.LeftBottom);
				}
					
			
		}
			}
			
		
		
}