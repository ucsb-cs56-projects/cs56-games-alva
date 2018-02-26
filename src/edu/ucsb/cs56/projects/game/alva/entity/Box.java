package edu.ucsb.cs56.projects.game.alva.entity;

import edu.ucsb.cs56.projects.game.alva.Util.Vector2;

import edu.ucsb.cs56.projects.game.alva.entity.Entity;
import edu.ucsb.cs56.projects.game.alva.entity.Robot;
import edu.ucsb.cs56.projects.game.alva.Assets;
import java.awt.Graphics2D;

/**Creates an instance of a box object and enables interaction between an instance of a robot and an instance of a box 
 */
public class Box extends Entity {

    boolean isGrabbed = false;
    Robot r;
    
    /**Calls the Entity Class constructor to set values and creates a reference to a rectangle object, and creates a reference to a Robot object
     * @param position pass in object of type Vector2 to set initial position of Box object
     */
    public Box(Vector2 position) {
        super(position, new Vector2(0, 0), 100, 100);
        r = Robot.getInstance();
    }
    
    /**Sets the value of isGrabbed instance variable for Box object
     * @param grab pass in value of type boolean to set value of isGrabbed instance variable for Box object
     */
    public void setGrabbed(boolean grab) {
        this.isGrabbed = grab;
    }
    
    /**Override the inherited drawIt function to draw box object
     * @param win Graphics2D object that represents the window object for drawing to a GUI
     */
    @Override
    public void drawIt(Graphics2D win) {
        Assets.box.draw(this, win);
    }
    
    /**Override the inherited update function to stop robot instance if not grabbing and call Entity class update function to update elements 
     * @param win Graphics2D object that represents the window object for drawing to a GUI
     */
    @Override
    public void update(Graphics2D win) {
        if(!r.isGrabbing()) {
            getVelocity().setX(0);
        }
        super.update(win);
    }
    
}
