package edu.ucsb.cs56.projects.game.alva.entity;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import edu.ucsb.cs56.projects.game.alva.Graphics.Animation;
import edu.ucsb.cs56.projects.game.alva.Util.Vector2;
import edu.ucsb.cs56.projects.game.alva.Assets;
/**Creates an instance of robot, and draws the robot facing left or right depening on direction it's moving, and sets and gets values for robot and box interaction
 */
public class Robot extends Entity {
	
    private static Robot r;
    private boolean isGrabbing;
    public boolean isleft;
 /**Calls on Parent Class Entity constructor to create an instance of rectangle object, sets the objects's initial position, velocity, width, and height, and sets initial boolean value for 'isGrabbing'
  */ 
    private Robot() {
        super(new Vector2(200, 400), new Vector2(0, 0), 65, 100);
        isGrabbing = false;
    }
    /**Creates an instance of robot
     */
    public static Robot getInstance() {
        if(r == null) {
            r = new Robot();
        } 
        return r;
    }
    /**Sets "isGrabbing" to boolean value passed in as argument
     * @param grabbing pass in value of type boolean to set value of isGrabbing
     */
    public void setGrabbing(boolean grabbing) {
        isGrabbing = grabbing;
    }
    /**Override the inheried drawIt function to draw robot instance facing left or right depending on direction its moving
     * @param win Graphics2D object that represents the window object for drawing a GUI
     */
    @Override
    public void drawIt(Graphics2D win) {
	if(isleft){
	    Assets.robotAnim_left.animate(this, win);
	}
	else{
	    Assets.robotAnim.animate(this, win);
	}
    }
/**Gets the value of isGrabbing
 * @return the boolean value isGrabbing is currently set to
 */
    public boolean isGrabbing() {
        return isGrabbing;
    }
    
}
