package pong;
import java.awt.Component;
import javax.swing.JFrame;

public class TheGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4292147302593238909L;
	private static final int WIDTH=800;
	private static final int HEIGHT=600;

	public TheGame() {
		super("PONG");
		setSize(WIDTH, HEIGHT);

		Pong game=new Pong();
//107
		((Component)game).setFocusable(true);
		getContentPane().add(game);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		TheGame run=new TheGame();
	}
}