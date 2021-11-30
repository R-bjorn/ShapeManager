package shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Rectangle extends AtomicShape{

	protected int x, y, width, height;
	
	public Rectangle(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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
    	Graphics2D g2d = (Graphics2D) g;
    	g2d.drawRect(x,y,width,height);    	
	}
    
    @Override
    public String toString() {
    	return "Rect: " + x + " " + y + " " + width + " " + height;
    }
}
