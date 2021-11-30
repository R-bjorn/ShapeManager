/**
 * 
 */
package shapes;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author ravid
 *
 */
public class CompositeShape extends Shape{
	
	ArrayList<Shape> shapeList;
	
	public CompositeShape() {
		shapeList = new ArrayList<Shape>();
	}
	
	// Get all the children shapes from list 
	public ArrayList<Shape> getAllChildren(){
		ArrayList<Shape> clone = new ArrayList<Shape>(shapeList); 
		return clone;
	}
	// To add shapes to the list
	public void addShape(Shape newShape) {
		shapeList.add(newShape);
	}
	
//	Overridden Methods	
	// Move the object
	@Override
	public void move(int buttonDownX, int buttonDownY, int newx, int newy) 
	{
		for(Shape shape : shapeList) {
			shape.move(buttonDownX, buttonDownY, newx, newy);
		}
	}
//	Do we need this method to overridden in composite as it is used by move()?
	// Change coordinates of the object -- used by move()
	@Override
	protected void changeCoords(int buttonDownX, int buttonDownY, int newx, int newy)
	{
		for(Shape shape : shapeList) {
			shape.changeCoords(buttonDownX, buttonDownY, newx, newy);
		}
	}
	// Paint the shape
	@Override
	public void paint(Graphics g) 
	{
		for(Shape shape : shapeList) {
			shape.paint(g);
		}
	}
	// Log the name of the shape and it's coordinates
	@Override
	public String toString()
	{
		String shapes = "";
		for(Shape shape : shapeList) {
			shapes += "\t" + shape.toString() + "\n";
		}
		return "Composite: {\n" + shapes + "}";				
	}
}
