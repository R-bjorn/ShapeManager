/**
 * 
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author ravid
 *
 */
public class Triangle extends AtomicShape {
	// Variables
	private Color color;

	protected int x, y, side1X, side1Y, side2X, side2Y, side3X, side3Y, width, height;
	
	// Constructor
	public Triangle(int x, int y, int side1X, int side1Y, int side2X, int side2Y,int side3X, int side3Y, Color color) {
		this.x = x; this.y = y;
		this.side1X = side1X; this.side1Y = side1Y;
		this.side2X = side1X; this.side2Y = side2Y;
		this.side3X = side1X; this.side3Y = side3Y;
		this.color = color;
	}

	@Override
    public void move(int buttonDownX, int buttonDownY, int newx, int newy) {
    	if (buttonDownX >= this.x && buttonDownX <= this.x + this.width)
    	{
    		if (buttonDownY >= this.y && buttonDownY <= this.y + this.height)
        	{
    			changeCoords(buttonDownX, buttonDownY, newx, newy);
        	}
    	}
    }
	
	@Override   
    protected void changeCoords(int buttonDownX, int buttonDownY, int newx, int newy) {
		int deltaX = this.x - buttonDownX;
    	int deltaY = this.y - buttonDownY;
    	this.x = newx + deltaX;
    	this.y = newy + deltaY;
    }
    

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Triangle: " + x + " " + y + " " + width + " " + height;
	}

}
