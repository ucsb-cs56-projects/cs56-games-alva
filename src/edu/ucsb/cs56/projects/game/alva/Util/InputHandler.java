package edu.ucsb.cs56.projects.game.alva.Util;

import edu.ucsb.cs56.projects.game.alva.GameDriver;
import edu.ucsb.cs56.projects.game.alva.world.Switch;
import edu.ucsb.cs56.projects.game.alva.world.World;
import edu.ucsb.cs56.projects.game.alva.commands.Command;
import edu.ucsb.cs56.projects.game.alva.commands.GrabCommand;
import edu.ucsb.cs56.projects.game.alva.commands.JumpCommand;
import edu.ucsb.cs56.projects.game.alva.commands.MoveCommand;
import edu.ucsb.cs56.projects.game.alva.commands.SwitchCommand;
import edu.ucsb.cs56.projects.game.alva.entity.Box;
import edu.ucsb.cs56.projects.game.alva.entity.Entity;
import edu.ucsb.cs56.projects.game.alva.entity.Entity.State;
import edu.ucsb.cs56.projects.game.alva.entity.Robot;
/** class that explains how to manage the different inputs */
public class InputHandler {
    GameDriver gd;
	boolean holdingJump;
	Command moveLeft, moveRight, jump, standStill;
	Robot r;
	World w;
	boolean spacePressed;
	int timer;
    int clearTimer;
	int delay;
    /** constructor that sets the value of all variables, and sets value of Robot and World object to the appropriate passed parameter 
     @param e Robot object that the reference variable r is set to for InputHandler object
    @param w World object that the reference variable w is set to for InputHandler object 
   @param g GameDriver object that the reference variable gd is set to for InputHandler object 
   */
    public InputHandler(Robot e, World w, GameDriver g) {
	gd = g; 
		holdingJump = false;
		moveLeft = new MoveCommand(e, -2);
		moveRight = new MoveCommand(e, 2);
		jump = new JumpCommand(e);
		standStill = new MoveCommand(e, 0);
		this.r = e;
		this.w = w;
		timer = 0;
        clearTimer = 0;
		delay = 20;
	}

	/**
	 * Meant to handle the input to control this fucker
	 * 
	 * @param keys
	 *            The actual keys
	 */
	public void handleInput(boolean[] keys) {
        System.out.println(r.getFinished() + ", " + clearTimer);
	    

	    if (r.getBounds().intersects(w.getFinish().getBounds())){
            r.setFinished(true);
            standStill.execute();
            clearTimer++;
            if (clearTimer > 500){
                r.setFinished(false);
                clearTimer = -1;
                gd.menu = 2;
            }
            return;
	    } else {
            r.setFinished(false);
        }
		if (keys[0]) {
			if (r.getState() == State.STATE_GROUND && !holdingJump) {
				jump.execute();
				r.holdingJump = true;
				holdingJump = true;
			}
		} else {
		    r.holdingJump = false;
			holdingJump = false;
		}

		if (keys[2]) {
		    r.isleft = true;
			moveLeft.execute();
		} else if (keys[3]) {
		    r.isleft = false;
			moveRight.execute();
		} else {
			standStill.execute();
		}

		

		if (keys[4]) {
		        
			Robot r = Robot.getInstance();
			for (Entity ent : w.getEntities()) {
				if (ent instanceof Box) {
					Box b = (Box) ent;
					if (r.getPosition().getY() + r.getHeight() >= b
							.getPosition().getY()
							&& r.getPosition().getY() <= b.getPosition().getY() + 100) {
						if (r.getPosition().getX() + r.getWidth() + 10 > b
								.getPosition().getX()) {
							new GrabCommand(b).execute();
							r.setGrabbing(true);
                            r.setGrabbingOnLeft(r.getPosition().getX() < b.getPosition().getX());
						}
					}
				}
			}
		} else {
			Robot.getInstance().setGrabbing(false);
		}
		
		if(keys[11]) {
			for(Switch s:w.getSwitches()) {
				if(r.getBounds().intersects(s.getBounds()) && timer > delay) {
					new SwitchCommand(r, s).execute();
					System.out.println("Sending switch command");
                    r.setSwitching(true);
					timer = 0;
				}
			}
		}
		if(keys[5]) {
		    gd.i = 0; gd.menu = 3;
		}
		if(keys[12]) {
		    gd.i = 1; gd.menu = 3;
		}
		if(keys[13]){
		    gd.i = 2; gd.menu = 3;
		}
		if(keys[14]){
		    gd.i = 3; gd.menu = 3;
		}
		if(keys[15]){
		    gd.i = 4; gd.menu = 3;
		}
		timer++;
        if (timer == 80){
            r.setSwitching(false);
        }
	}

}
