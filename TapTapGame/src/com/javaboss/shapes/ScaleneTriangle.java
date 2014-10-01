package com.javaboss.shapes;

import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael K?lling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class ScaleneTriangle
{
    private int x1,x2,x3,y1,y2,y3;
  
  
    private String color;
    private boolean isVisible;

    /**
     * Create a new triangle at default position with default color.
     */
    
    
     // parameters for any 3 pairs of x,y ,size, color, location
    public ScaleneTriangle(int x1,int y1,int x2,int y2, int x3,int y3,String c, boolean vis)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.x3=x3;
        this.y3=y3;
        color = c;
        isVisible = vis;
    }
   
    

    /**
     * Make this triangle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Make this triangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move the triangle a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the triangle a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the triangle a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the triangle a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the triangle horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        x1 += distance;
        x2 += distance;
        x3 += distance;
        draw();
    }

    /**
     * Move the triangle vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        y1 += distance;
        y2 += distance;
        y3 += distance;
        draw();
    }

    /**
     * Slowly move the triangle horizontally by 'distance' pixels.
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
            x1 += delta;
            x2 += delta;
            x3 += delta;
            draw();
        }
    }

    /**
     * Slowly move the triangle vertically by 'distance' pixels.
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
            y1 += delta;
            y2 += delta;
            y3 += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
 /*   public void changeSize(int newHeight, int newWidth)
    {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }*/

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
     * Draw the triangle with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { x1, x2 ,x3 };
            int[] ypoints = { y1,y2,y3 };
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }

    /*
     * Erase the triangle on screen.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
