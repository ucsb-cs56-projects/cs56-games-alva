package edu.ucsb.cs56.projects.game.alva.commands;

import edu.ucsb.cs56.projects.game.alva.commands.Command;

import edu.ucsb.cs56.projects.game.alva.entity.Robot;
import edu.ucsb.cs56.projects.game.alva.entity.Box;

public class GrabCommand implements Command {
    
    Box b;
    Robot r;
    
    public GrabCommand(Box b) {
        this.b = b;
        r = Robot.getInstance();
    }
    
    @Override
    public void execute() {
        b.getVelocity().setX((r.getVelocity().getX()));
    }
}
