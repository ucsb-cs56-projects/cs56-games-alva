package edu.ucsb.cs56.projects.game.alva;

import edu.ucsb.cs56.projects.game.alva.world.World;
import edu.ucsb.cs56.projects.game.alva.entity.Entity;
/** Class to control the camera, which follows the Robot object as it moves. This ensures the robot is always at the center of the screen 
 */
public class Camera {
	
	private double x, y;
    /** lone constructor of the Camera class, parameters are equal to the reference variables in the class
     * @param x double value which will be the new x coordinate for the camera
     * @param y double value which will be the new y coordinate for the camera
     */
	public Camera(double x, double y) {
		this.x = x;
		this.y = y;
	}
    /** returns the x coordinate value for the camera object.  
     @return value that represents the instance variable x*/
	public double getX() {
		return x;
	}
    /** sets the value of the x variable to the value of the parameter 
     * @param x double value which the new x coordinate will be set to 
     */
	public void setX(double x) {
		this.x = x;
	}
    /** returns the y coordinate value for the camera object 
     @return value that represents the instance variable y
    */
	public double getY() {
		return y;
	}
    /** sets the value of the y variable to the value of the parameter 
     @param y double value which the new y coodinate value will be set to*/
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
