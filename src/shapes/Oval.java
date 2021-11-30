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
public class Oval extends AtomicShape {

	protected int x, y, width, height;
	
	
	public Oval() {
		
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
    	return "Oval: " + x + " " + y + " " + width + " " + height;
    }

}
