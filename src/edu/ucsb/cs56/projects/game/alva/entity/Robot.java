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
    public boolean holdingJump;
    private boolean isGrabbing;
    private boolean isSwitching;
    public boolean isleft;
    private boolean grabbingOnLeft;
    private boolean isFinished;
 /**Calls on Parent Class Entity constructor to create an instance of rectangle object, sets the objects's initial position, velocity, width, and height, and sets initial boolean value for 'isGrabbing'
  */ 
    private Robot() {
        super(new Vector2(200, 400), new Vector2(0, 0), 65, 100);
        isGrabbing = false;
        isSwitching = false;
        grabbingOnLeft = false;
        isFinished = false;
    }
    /**Creates an instance of robot
     * @return an instance of robot
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

    /**Sets "isSwitching" to boolean value passed in as argument
     * @param switching pass in value of type boolean to set value of isSwitching
     */
    public void setSwitching(boolean switching){
	isSwitching = switching;
    }
    
    /**Sets "grabbingOnLeft" to boolean value passed in as argument
     * @param side pass in value of type boolean to set value of grabbingOnLeft
     */
    public void setGrabbingOnLeft(boolean side){
        grabbingOnLeft = side;
    }
    
    /**Sets "isFinished" to boolean value passed in as argument
     * @param finished pass in value of type boolean to set value of isFinished
     */
    public void setFinished(boolean finished){
        isFinished = finished;
    }
    
    public boolean getFinished(){
        return isFinished;
    }


    /**Override the inheried drawIt function to draw robot instance facing left or right depending on direction its moving
     * @param win Graphics2D object that represents the window object for drawing a GUI
     */
    @Override
    public void drawIt(Graphics2D win) {
    if (isGrabbing && !isFinished){
        if (grabbingOnLeft){
            Assets.rGrab.animate(this, win);
        }
        else{
            Assets.lGrab.animate(this, win);
        }
    }
	else if(isleft){
        if (isFinished){
            Assets.lFinish.animateStill(this, win);
        }
	    else if(this.velocity.getY() < 0){
		Assets.jleft.animate(this,win);
	    }
        else if(this.velocity.getY() > 0){
            Assets.fleft.animate(this,win);
        }
        
        else if (isSwitching){
            Assets.lSwitch.animateStill(this,win);
        }
        else{
            Assets.robotAnim_left.animate(this, win);
            }
	}
	else{
        if (isFinished){
            Assets.rFinish.animateStill(this, win);
        }
	    else if(this.velocity.getY() < 0){
		Assets.jright.animate(this,win);
	    }
        else if(this.velocity.getY() > 0){
            Assets.fright.animate(this,win);
        }
        
       else if (isSwitching){
	    Assets.rSwitch.animateStill(this,win);
	}
	    else{
	    Assets.robotAnim.animate(this, win);
	    }
	}
    }
/**Gets the value of isGrabbing
 * @return the boolean value isGrabbing is currently set to
 */
       public boolean isGrabbing() {
        return isGrabbing;
    }
    
}
