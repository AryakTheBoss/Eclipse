package shapes2014;
// FILE: Eyes.java
// A Java applet that draws eyes that follow the mouse when the cursor
// is inside the applet window.  Clicking anywhere will place a new eye
// and launch a new thread for that eye's processing.
// Written by: Grant Macklem (Grant.Macklem@colorado.edu)

import java.applet.Applet;  // Provides the Applet class.
import java.awt.*;          // Provides the Button class, etc.
import java.awt.event.*;    // Provides ActionEvent, ActionListener
import java.text.*;         // Provides DecimalFormat


/**
  * The <code>Eye</code> Java class implements an eye on the screen
  * that looks at the mouse pointer.  Each eye is a separate thread.
  * @author
  *   Grant Macklem (<a href=mailto:macklem@colorado.edu>macklem@colorado.edu</a>)
  **/
class Eye extends Thread
{
    /**
      * Every time the mouse is moved, this is set to the x-coordinate of the mouse.
      **/
    public static int mouseX;
    /**
      * Every time the mouse is moved, this is set to the y-coordinate of the mouse.
      **/
    public static int mouseY;
    private static final int WIDTH     = 50;    // Eye width, in pixels
    private static final int HEIGHT    = 75;    // Eye height, in pixels
    private static final int IRISSIZE  = 30;    // Iris size, in pixels
    private static final int PUPILSIZE = 12;    // Pupil size, in pixels
    private Color irisColor;

    // Radii of the inner ellipse that the iris slides along
    private static final int SMALLXRAD = (WIDTH  - IRISSIZE)/2;
    private static final int SMALLYRAD = (HEIGHT - IRISSIZE)/2;

    private int x, y;                           // Current position of the eye
    private double newx, newy;                  // Position of the iris
    private Graphics g;                         // Graphics context

    /**
    * Constructs a new eye thread.
    * @param x
    *   The x-coordinate of the eye (in pixels) in the current window.
    * @param y
    *   The y-coordinate of the eye (in pixels) in the current window.
    * @param g
    *   The graphics context to which the eye should be drawn.
    **/
    public Eye(int x, int y, Graphics g)
    {
        this.g = g;
        this.x = x;
        this.y = y;
        // Create a random iris color
        irisColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
    }

    private void draw()
    {
        synchronized(g)
        {
            // Erase the old eye
            g.setColor(Color.white);
            g.fillOval(x - WIDTH/2, y - HEIGHT/2, WIDTH, HEIGHT);
            // Draw the iris
            g.setColor(irisColor);
            g.fillOval((int)newx - IRISSIZE/2 + 1, (int)newy - IRISSIZE/2 + 1, IRISSIZE, IRISSIZE);
            // Draw the pupil
            g.setColor(Color.black);
            g.fillOval((int)newx - PUPILSIZE/2 + 1, (int)newy - PUPILSIZE/2 + 1, PUPILSIZE, PUPILSIZE);
            // Draw the eye outline
            g.drawOval(x - WIDTH/2, y - HEIGHT/2, WIDTH, HEIGHT);
        }
    }

    /**
      * Continually calculates where the eye should be and redraws it on the screen
      * until the thread is destroyed.
      **/
    public void run()
    {
        for(;;)
        {
            updateCoordinates();
            draw();
            try
            {
                // Sleep to reduce flicker
                sleep(50);
            }
            catch (InterruptedException e)
            {
		// Continue execution
            }
        }

    }

    private void updateCoordinates()
    {

        if (mouseX == x)
        {   // mouse is vertical above eye center
            newx = mouseX;

            if (Math.abs(y - mouseY) >= SMALLYRAD)
            {   // Pointer is outside the eye
                if ( (y - mouseY) > 0 )
                    newy = y - SMALLYRAD;
                else
                    newy = y + SMALLYRAD;
            }
            else // pointer is in the eye
                newy = mouseY;
            return;
        }

        // Find intersection point of line to mouse with eye ellipse
        double slope = (double)(mouseY - y) / (double)(mouseX - x);
        double numerator = SMALLXRAD * SMALLXRAD * SMALLYRAD * SMALLYRAD;
        double denominator = SMALLYRAD * SMALLYRAD + slope * slope * SMALLXRAD * SMALLXRAD;
        newx = Math.sqrt(numerator / denominator);
        newy = slope * newx;

        // Choose appropriate intersection point
        if (mouseX < x)
            newx = -Math.abs(newx);
        else
            newx = Math.abs(newx);

        if (mouseY < y)
            newy = -Math.abs(newy);
        else
            newy = Math.abs(newy);

        newx += x;
        newy += y;

        if ( (double)(mouseX - x)*(mouseX - x) / (SMALLXRAD * SMALLXRAD) + (double)(mouseY - y)*(mouseY - y) / (SMALLYRAD * SMALLYRAD) < 1 )
        {   // Mouse is inside of the eye
            newx = mouseX;
            newy = mouseY;
        }
    }
}


/**
  * The <code>Eyes</code> Java applet implements eyes on the screen
  * that follow the mouse pointer.  Each eye is a separate thread.
  * There can be a maximum of 50 eyes on the screen.
  * @author
  *   Grant Macklem (<a href=mailto:macklem@colorado.edu>macklem@colorado.edu</a>)
  **/
public class Eyeball extends Applet
{
    // Most comments are for double buffering, which does not help too much
    // on my system since the buffers can swap before all threads have
    // drawn their eye.
    static final int NUM_EYES = 50; // Number of threads
    Eye[] eyes = new Eye[NUM_EYES]; // Array of Eyes
    int count = -1;                 // Count of eyes
    int width, height;              // Height and width of applet
    //Image myOffScreenImage;         // Second drawing buffer
    //Graphics myOffScreenGraphics;   // Second graphics context

    /**
    * Initializes the applet by loading sizes and starting two eye threads.
    **/
    public void init( )
    {
        addMouseMotionListener( new MouseMotionListener( ) {
            public void mouseDragged(MouseEvent e) {}
            public void mouseMoved(MouseEvent e) {
                Eye.mouseX = e.getX();
                Eye.mouseY = e.getY();
                repaint();
            }
        } );
    }

    /**
    * (Re)starts all the eye threads after initializing or having been suspended.
    * Start is called once the applet has been placed on the screen.
    * It is recalled whenever the browser goes elsewhere and later comes
    * back to this applet.
    **/
    public void start()
    {
	if (count == -1)
	{ // Nothing has been placed on the screen yet
	    width = getSize().width;    // Width of the applet
	    height = getSize().height;  // Height of the applet
	    //myOffScreenImage = createImage(width, height);
	    //myOffScreenGraphics = myOffScreenImage.getGraphics();
	    final Graphics g = getGraphics( );
	    //eyes[++count] = new Eye(width/4,   height/2, myOffScreenGraphics);
	    eyes[++count] = new Eye(width/4,   height/2, g);
	    eyes[count].start();
	    //eyes[++count] = new Eye(3*width/4, height/2, myOffScreenGraphics);
            eyes[++count] = new Eye(3*width/4, height/2, g);
	    eyes[count].start();	    
	    addMouseListener( new MouseListener ( ) {
		public void mouseClicked(MouseEvent e) {
		    if ((count+1) >= NUM_EYES)
			return;
		    //eyes[++count] = new Eye(e.getX(), e.getY(), myOffScreenGraphics);
		    eyes[++count] = new Eye(e.getX(), e.getY(), g);
		    eyes[count].start();
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	    } );
	}
	else
	{
	    for (int i = 0; i < count; i++)
		eyes[i].resume();
	}
	repaint();
    }

    /**
    * Pauses all the eye threads after minimizing the applet.
    **/
    public void stop()
    {
        for (int i = 0; i < count; i++)
            eyes[i].suspend();
    }

    /**
    * Destroys all the eye threads when the applet is exiting..
    **/
    public void destroy()
    {
        for (int i = 0; i < count; i++)
            eyes[i].stop();
    }

    /**
     * Redraws a border around the applet.
     **/
    public void update(Graphics g)
    {
	g.drawRect(0,0,width-1,height-1);
        //paint(myOffScreenGraphics);       // Draws on the db
        // draws the double buffer onto applet
        //g.drawImage(myOffScreenImage,0,0,this);
    }
}