import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

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
    
    private ArrayList<Rectangle> shapes = new ArrayList<Rectangle>();
    
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
    		for (Rectangle s: shapes) {
	    		s.move(x1, y1, x2, y2);
	    		s.paint(g);
    		}
    	}
    	else if (state == State.Rectangle) {
        	shapes.add(new Rectangle(x1, y1, x2-x1, y2-y1, Color.BLUE));
    	}

    	for (Rectangle s: shapes){
    		s.paint(g);
    	}
    }
    
    public void changeState(State newState) {
    	state = newState;
    }
    
    public State getState() {
    	return state;
    }
}