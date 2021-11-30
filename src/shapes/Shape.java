package shapes;
/**
 * 
 */


import java.awt.Graphics;
/**
 * @author rbjorn
 *
 */
public abstract class Shape {

	// Move the object
	public abstract void move(int buttonDownX, int buttonDownY, int newx, int newy);	
	// Change coordinates of the object -- used by move() 
	protected abstract void changeCoords(int buttonDownX, int buttonDownY, int newx, int newy);
	// Paint the shape
	public abstract void paint(Graphics g);
	// Log the name of the shape and it's coordinates
	public abstract String toString();

}
