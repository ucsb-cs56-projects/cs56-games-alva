package edu.ucsb.cs56.projects.game.alva.commands;

import edu.ucsb.cs56.projects.game.alva.world.Switch;
import edu.ucsb.cs56.projects.game.alva.entity.Robot;

public class SwitchCommand implements Command {
	
	Switch s;
	Robot r;
	public SwitchCommand(Robot e, Switch s) {
		this.r = e;
		this.s = s;
	}
	
	@Override
	public void execute() {
		s.active();
	}

}
