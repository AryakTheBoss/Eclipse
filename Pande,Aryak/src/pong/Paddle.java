package pong;
import java.awt.Graphics;

public class Paddle extends Block {
	private int v; // Velocity

	public Paddle() {
		this(10, 10);
	}
	public Paddle(int x, int y) {
		this(x, y, 5);
	}
	public Paddle(int x, int y, int v) {
		super(x, y);
		this.v=v;
	}

	// add the other Paddle constructors

	public void moveUpAndDraw(Graphics g) {

	}

	public void moveDownAndDraw(Graphics g) {

	}

	// add get methods

	// add a toString() method
}