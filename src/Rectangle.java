import java.awt.Color;
import java.awt.Graphics;

public class Rectangle{

	private Color color;

	protected int x, y, width, height;
	
	protected Rectangle(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
    
    public void move(int buttonDownX, int buttonDownY, int newx, int newy) {
    	if (buttonDownX >= this.x && buttonDownX <= this.x + this.width)
    	{
    		if (buttonDownY >= this.y && buttonDownY <= this.y + this.height)
        	{
    			changeCoords(buttonDownX, buttonDownY, newx, newy);
        	}
    	}
    }
    
    protected void changeCoords(int buttonDownX, int buttonDownY, int newx, int newy) {
		int deltaX = this.x - buttonDownX;
    	int deltaY = this.y - buttonDownY;
    	this.x = newx + deltaX;
    	this.y = newy + deltaY;
    }
    
    public void paint(Graphics g){
    	g.setColor(color);
    	g.drawRect(x, y, width, height);
    }
    
    @Override
    public String toString() {
    	return "Rect: " + x + " " + y + " " + width + " " + height;
    }
}
