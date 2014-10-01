package org.aryakDev.shapes;

import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael K??lling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Circle
{
    private int L,W;
   private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Create a new circle at default position with default color.
     */
    public Circle()
    {
        L = 30;
        W = 30;
        xPosition = 20;
        yPosition = 60;
        color = "blue";
        isVisible = false;
    }
    public Circle (int dia,int xp,int yp,String colo,boolean isvis){
    	
    	L = dia;
    	W = dia;
    	xPosition = xp;
    	yPosition = yp;
    	color = colo;
    	isVisible = isvis;
    	
    }
     public Circle (int ll,int ww,int xp,int yp,String colo,boolean isvis){
    	
    	L = ll;
    	W = ww;
    	xPosition = xp;
    	yPosition = yp;
    	color = colo;
    	isVisible = isvis;
    	
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move the circle a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the circle horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the circle vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the circle vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newDiameter)
    {
        erase();
        L = newDiameter;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /*
     * Draw the circle with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition, 
                    W, L));
            canvas.wait(10);
        }
    }

    /*
     * Erase the circle on screen.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    public int getY(){
    	
    	return yPosition;
    	
    }
    
    public int getX(){
    	
    	return xPosition;
    	
    }
    
    public void setX(int newX){
    	
    	erase();
    	xPosition = newX;
    	draw();
    	
    	
    }
    public void setY(int newY){
    	
    	erase();
    	yPosition = newY;
    	draw();
    	
    }
}
