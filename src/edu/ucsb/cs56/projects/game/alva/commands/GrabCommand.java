package edu.ucsb.cs56.projects.game.alva.commands;

import edu.ucsb.cs56.projects.game.alva.commands.Command;

import edu.ucsb.cs56.projects.game.alva.entity.Robot;
import edu.ucsb.cs56.projects.game.alva.entity.Box;
/** class that defines the grab command, which a robot can do when near a box */
public class GrabCommand implements Command {
    
    Box b;
    Robot r;
    /** constructor that takes parameter and sets it to the box variable b. Also, Robot variable r is set to an instance of Robot 
     @param b Box object that the Box reference variable will be set to*/
    public GrabCommand(Box b) {
        this.b = b;
        r = Robot.getInstance();
    }
    /** overriden execute method from Command class to get the box to move */
    @Override
    public void execute() {
        b.getVelocity().setX((r.getVelocity().getX()));
    }
}
