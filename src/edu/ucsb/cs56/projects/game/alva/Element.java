package edu.ucsb.cs56.projects.game.alva;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import edu.ucsb.cs56.projects.game.alva.Util.Vector2;
/** Class that represents an object that has a defined location and size
 */
public abstract class Element {
	
	protected int width, height;
	protected Vector2 position;
	protected Rectangle bounds;
    /** Constructor which sets the value of an element position, width, and height based on the passed values, as well as creating the bounds object given the other three values 
 * @param width this represents how wide the Element object's bounds will be  
 * @param height this represent how tall the Element object's bounds will be  
 * @param position a Vector2 object that represents the location (top left corner) of the Element object*/
	public Element(Vector2 position, int width, int height) {
		this.position = position;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) position.getX(), (int) position.getY(), width, height);
	}
    /** abstract class that draws the elements in the window 
     @param win Graphics2D object that represents the window object for drawing to a GUI
    */ 
	public abstract void drawIt(Graphics2D win);
    /** returns the value of the width variable 
     @return value of the instance variable width
    */
	public int getWidth() {
		return width;
	}
    /** sets the value of the width variable to the passed parameter value 
     @param width int value which the width variable for an Element object will be set to
    */
	public void setWidth(int width) {
		this.width = width;
	}
    /** returns the value of the height variable 
     @return value of the instance variable height
    */
	public int getHeight() {
		return height;
	}
    /** sets the value of the height variable to the passed parameter value 
     @param height int value which the height variable for an Element object will be set to
    */ 
	public void setHeight(int height) {
		this.height = height;
	}
    /** returns the value of the position variable 
     @return value of the instance variable position
    */
	public Vector2 getPosition() {
		return position;
	}
    /** sets the value of the position variable to the passed parameter value 
     @param position Vector2 object that the position reference variable will be set to for an Element object.
    */
	public void setPosition(Vector2 position) {
		this.position = position;
	}
    /** returns the value of the bounds variable 
     @return Rectangle object which is constructed by from the instance variable values position, height, and width
    */
	public Rectangle getBounds() {
		return bounds;
	}
}
