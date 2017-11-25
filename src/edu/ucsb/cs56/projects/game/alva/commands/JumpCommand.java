package edu.ucsb.cs56.projects.game.alva.commands;

import edu.ucsb.cs56.projects.game.alva.entity.Entity;
/** class that controls the Robot's ability to jump. The only instance variable is a reference to an Entity object (Robot extends Entity) */
public class JumpCommand implements Command {
	
	Entity e;
    /** constructor that sets the entity object to the passed parameter
     @param e Entity object that is set to the value of the reference variable e for the object */
	public JumpCommand(Entity e) {
		this.e = e;
	}
    /** overriden command which executes the Entity's jump() method */
	@Override
	public void execute() {
		e.jump();
	}
	
	

}
