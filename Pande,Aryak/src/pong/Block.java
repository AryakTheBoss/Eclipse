package pong;
import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color = Color.BLACK;

	public Block()
	{


	}

	//add other Block constructors - x , y , width, height, color
	
	public Block(int x,int y,int width,int height,Color c){
		
		xPos =x;
		yPos = y;
		this.width = width;
		this.height = height;
		color = c;
		
	}
public Block(int width,int height){
		
		
		this.width = width;
		this.height = height;
		xPos = 0;
		yPos = 0;
		
	}
public Block(int x,int y,int width,int height){
		
		xPos =x;
		yPos = y;
		this.width = width;
		this.height = height;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
   //add the other set methods
   

   public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

public void setColor(Color col)
   {
color = col;

   }
public Color getColor(){
	return color;
}

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	      window.fillRect(getX(), getY(), getWidth(), getHeight());

   }
   
	public boolean equals(Object obj)
	{

Block b = (Block)obj;


		return this.xPos == b.getX() && this.yPos == b.getY() && this.width == b.getWidth() && this.height == b.getHeight() && this.color == b.getColor();
	}

	@Override
	public void setPos(int x, int y) {
		// TODO Auto-generated method stub
		xPos = x;
		yPos = y;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		xPos = x;
	}
	

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		yPos = y;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return xPos;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return yPos;
	}   

   //add the other get methods
    
public String toString(){
	
	
	
	return "x: "+xPos+" y: "+yPos+" w: "+width+" h: "+height+" Color: "+color;
	
	
}
   //add a toString() method  - x , y , width, height, color
}