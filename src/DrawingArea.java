import javax.swing.*;

import shapes.Rectangle;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import shapes.*;

public class DrawingArea extends JLabel {
    Dimension minSize = new Dimension(100, 50);
    private int x1, y1, x2, y2;
   
    public static enum State{
    	Start,
    	Moving,
    	Rectangle,
    	Oval,
    	Triangle
    }
    
    private State state = State.Start;
    
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
	// ArrayList for Backup of all merged shapes 
	private ArrayList<Shape> shapesBackup = new ArrayList<Shape>();
    
    public DrawingArea() {
    	this.setBackground(Color.BLACK);
        setOpaque(true);
    }
    
    public Dimension getMinimumSize() {
        return minSize;
    }

    public Dimension getPreferredSize() {
        return minSize;
    }
    
    public void setMouseDownPosition(int x, int y){
    	x1 = x;
    	y1 = y;
    	//System.out.println(x1 + " " + y1);
    }
    
    public void setMouseUpPosition(int x, int y){
    	x2 = x;
    	y2 = y;
    	//System.out.println(x2 + " " + y2);
    }
    
    public void paint(Graphics g){
    	super.paint(g);

    	if (x1 == 0 && x2 == 0 && y1 == 0 && y2 == 0) return;
    	
    	if (state == State.Moving){
    		for (Shape s: shapes) {
	    		s.move(x1, y1, x2, y2);
	    		s.paint(g);
    		}
    	}
    	else if (state == State.Rectangle) {
        	shapes.add(new Rectangle(x1, y1, x2-x1, y2-y1, Color.BLUE));
    	}
    	else if (state == State.Triangle) {
//    		shapes.add(new Triangle(x1 , y1 , x2-x1 , y2-y1 , y2+y1 , x1+x2+y, Color.RED));
    	}
    	else if (state == State.Oval) {
//    		shape.add(new Oval());
    	}

    	for (Shape s: shapes){
    		s.paint(g);
    	}
    }
    
    public void changeState(State newState) {
    	state = newState;
    }
    
    public State getState() {
    	return state;
    }

    public void mergeAll() {
    	// One compositeShape for all the merged shapes
    	CompositeShape merged = new CompositeShape();
    	for(Shape s : shapes) {
    		shapesBackup.add(s);
    		merged.addShape(s);
    	} 
    	shapes.clear();
    	shapes.add(merged);
    }
    
    public void unmergeAll() {
    	if(shapesBackup.isEmpty()) return;
    	
    	shapes.clear();
    	for(Shape s : shapesBackup) {
    		shapes.add(s);
    	}
    	shapesBackup.clear();
    }
    
    
}