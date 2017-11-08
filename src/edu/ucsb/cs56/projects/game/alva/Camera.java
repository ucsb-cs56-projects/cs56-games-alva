package edu.ucsb.cs56.projects.game.alva;

import edu.ucsb.cs56.projects.game.alva.world.World;
import edu.ucsb.cs56.projects.game.alva.entity.Entity;
/** Class to control the camera, which follows the Robot object as it moves 
 */
public class Camera {
	
	private double x, y;
    /** lone constructor of the Camera class, parameters are equal to the reference variables in the class */
	public Camera(double x, double y) {
		this.x = x;
		this.y = y;
	}
    /** returns the value of X */
	public double getX() {
		return x;
	}
    /** sets the value of the x variable to the value of the parameter */
	public void setX(double x) {
		this.x = x;
	}
    /** returns the value of the y variable */
	public double getY() {
		return y;
	}
    /** sets the value of the y variable to the value of the passed parameter */
	public void setY(double y) {
		this.y = y;
	}
    /** sets the value of the x coordinate based on the position of the Entity object
     * @param main Entity object that determines the location we are updating x and y to
     * @param w World object that has no noticeable affect on the function */
	public void update(Entity main, World w) {
		setX(-main.getPosition().getX() + (1280 / 2));
        if(main.getPosition().getY() < 700) {
        	 setY(-main.getPosition().getY() + (720 / 2));
        }
	}
	

}
