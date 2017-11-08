package edu.ucsb.cs56.projects.game.alva.commands;

import edu.ucsb.cs56.projects.game.alva.world.Switch;
import edu.ucsb.cs56.projects.game.alva.entity.Robot;
/** class that controls the command that flips the switch object, with one reference variable to a Switch object, and another to a Robot object */
public class SwitchCommand implements Command {
    
	Switch s;
	Robot r;
    /** constructor that sets both Switch and Robot reference variables based on passed parameter */
	public SwitchCommand(Robot e, Switch s) {
		this.r = e;
		this.s = s;
	}
    /** overloaded method that activates the flipping of the switch */ 
	@Override
	public void execute() {
		s.active();
	}

}
