package pong;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Pong extends Canvas implements KeyListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4876617302605606971L;
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;

	public Pong() {
		// set up all variables related to the game

		keys=new boolean[4];

		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); // starts the key thread to log key strokes
	}

	public void update(Graphics window) {
		
		paint(window);
	}

	public void paint(Graphics window) {
		// set up the double buffering to make the game animation nice and
		// smooth
		Graphics2D twoDGraph=(Graphics2D)window;

		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
		if(back==null) back=(BufferedImage)(createImage(getWidth(), getHeight()));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack=back.createGraphics();

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);

		// see if ball hits left wall or right wall
		if(!(ball.getX()>=10&&ball.getX()<=780)) {
			ball.setVx(0);
			ball.setVy(0);
		}

		// see if the ball hits the top or bottom wall

		// see if the ball hits the left paddle

		// see if the ball hits the right paddle

		// see if the paddles need to be moved

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		switch(Character.toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0]=true;
			break;
		case 'Z':
			keys[1]=true;
			break;
		case 'I':
			keys[2]=true;
			break;
		case 'M':
			keys[3]=true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(Character.toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0]=false;
			break;
		case 'Z':
			keys[1]=false;
			break;
		case 'I':
			keys[2]=false;
			break;
		case 'M':
			keys[3]=false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void run() {
		try {
			while(true) {
				Thread.currentThread().sleep(8);
				repaint();
			}
		} catch(Exception e) {
		}
	}
}