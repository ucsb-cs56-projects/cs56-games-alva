package edu.ucsb.cs56.projects.game.alva.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import edu.ucsb.cs56.projects.game.alva.Element;
import edu.ucsb.cs56.projects.game.alva.Util.Vector2;
/**Class that cannot be instantiated and inherits from Element class; sets the values for the jump and move of the Entity object
 */
public abstract class Entity extends Element {
	/**Declares 'four' state variables of primitive type
	 */
	public enum State {
		STATE_AIR,
		STATE_GROUND,
		STATE_WALK_LEFT,
		STATE_WALK_RIGHT
	}
	
	private State state;
	Vector2 velocity;
	/**Calls the constructor of the parent class (Element) and creates a reference to a rectangle object, sets the Entity Object's velocity, sets the state as the primitive value of STATE_AIR; gets everything ready for further usage
	 * @param position pass in object of type Vector2 to set initial position of Entity object
	 * @param velocity pass in object of type Vector2 to set initial velocity of Entity object
	 * @param width pass in value of type int to set initial width of Entityobject
	 * @param height pass in value of type int to set initial height of Entity object
	 */
	public Entity(Vector2 position, Vector2 velocity, int width, int height) {
		super(position, width, height);
		this.velocity = velocity;
		state = State.STATE_AIR;
	}
	/**Enables Entity object to move by 'updating' position and bounds
	 */
	public void move() {
		position.add(velocity);
		getBounds().setLocation((int) position.getX(), (int) position.getY()); 
	}
	
	/**Enables Entity object to jump by setting vertical velocity of jump and setting state as the primitive value of STATE_AIR
	 */
	public void jump() {
		velocity.setY(-6);
		setState(State.STATE_AIR);
	}
	
	/**Sets velocity of Entity object
	 * @param v pass in object of type Vector2 to set velocity of Entity object
	 */
	public void setVelocity(Vector2 v) {
		velocity = v;
	}
	
	/**Gets the velocity of Entity object
	 * @return the velocity of Entity object
	 */
	public Vector2 getVelocity() {
		return velocity;
	}
	
	/**Inherited function from Element Parent class; non instantiatable class that draws the elements in the window
	 * @param win Graphics2D object that represents the window object for drawing to a GUI
	 */
	public abstract void drawIt(Graphics2D win);
	
	/**Updates the Elements in the window when movement is detected
	 * @param win Graphics2D object that represents the window object for drawing to a GUI
	 */
	public void update(Graphics2D win) {
		move();
		drawIt(win);
	}
	
	/**Gets the state in the form of a primitive value (STATE_AIR, STATE_GROUND, ...) 
	 * @return the state (STATE_AIR, STATE_GROUND, ...)
	 */
	public State getState() {
		return state;
	}
	
	/**Sets the state in the form of a primtive value (STATE_AIR, STATE_GROUND, ...)
	 * @param s one of 4 states of primitive type (STATE_AIR, STATE_GROUND, ...)
	 */
	public void setState(State s) {
		state = s;
	}
}
