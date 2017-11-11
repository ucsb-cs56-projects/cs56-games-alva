package edu.ucsb.cs56.projects.game.alva.commands;

import edu.ucsb.cs56.projects.game.alva.Util.Vector2;
import edu.ucsb.cs56.projects.game.alva.entity.Entity;
/** class that controls the movement command, two instance variables, a reference variable to an Entity, and an int that holds the velocity of the moving */
public class MoveCommand implements Command {
	
	Entity e;
	int dx;
    /** constructor that sets the value of Entity and velocity(dx) based on the passed parameter 
     @param e Entity object now referenced by the referene variable e for MoveCommand object
    @param dx int value that represents the value of velocity in the x direction*/
	public MoveCommand(Entity e, int dx) {
		this.e = e;
		this.dx = dx;
	}
	
	/**
	 * This execute sets the velocity of the entity passed into the main character. Moving the actual character is called in the update method (pending removal of that and adding it here)
	 */
	public void execute() {
		e.getVelocity().setX(dx);
	}
	
	
	
}
