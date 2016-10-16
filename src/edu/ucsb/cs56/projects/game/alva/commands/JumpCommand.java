package edu.ucsb.cs56.projects.game.alva.commands;

import edu.ucsb.cs56.projects.game.alva.entity.Entity;

public class JumpCommand implements Command {
	
	Entity e;
	
	public JumpCommand(Entity e) {
		this.e = e;
	}
	
	@Override
	public void execute() {
		e.jump();
	}
	
	

}
