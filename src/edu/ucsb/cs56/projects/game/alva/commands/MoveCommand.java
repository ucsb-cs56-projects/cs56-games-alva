package edu.ucsb.cs56.projects.game.alva.commands;

import edu.ucsb.cs56.projects.game.alva.Util.Vector2;
import edu.ucsb.cs56.projects.game.alva.entity.Entity;

public class MoveCommand implements Command {
	
	Entity e;
	int dx;
	
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
