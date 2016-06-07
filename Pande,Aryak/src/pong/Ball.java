package pong;
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block {
	private int vX, vY; // Velocity: x, y

	public Ball() {
		this(200, 200);
	}
	public Ball(Block block) {
		this(block, 3, 1);
	}
	public Ball(int x, int y) {
		this(new Block(x, y));
	}
	public Ball(Block block, int vX, int vY) {
		super(block.getX(), block.getY(), block.getWidth(), block.getHeight(), block.getColor());
		this.vX=vX;
		this.vY=vY;
	}
	public Ball(int x, int y, int w, int h) {
		this(new Block(x, y, w, h));
	}
	public Ball(int x, int y, int w, int h, Color c) {
		this(new Block(x, y, w, h, c));
	}
	public Ball(int x, int y, int w, int h, Color c, int vX, int vY) {
		this(new Block(x, y, w, h, c), vX, vY);
	}

	@Override
	public boolean equals(Object obj) {
		Ball b=(Ball)obj;
		return super.equals(b)&&vX==b.getVx()&&vY==b.getVy();
	}
	public int getVx() {
		return vX;
	}
	public int getVy() {
		return vY;
	}
	public void moveAndDraw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		setX(getX()+vX);
		setY(getY()+vY);
		g.setColor(getColor());
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	public void setVx(int vX) {
		this.vX=vX;
	}
	public void setVy(int vY) {
		this.vY=vY;
	}
	@Override
	public String toString() {
		return String.format("%s %d %d", super.toString(), vX, vY);
	}
}