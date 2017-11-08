package edu.ucsb.cs56.projects.game.alva.Util;

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

	boolean holdingJump;
	Command moveLeft, moveRight, jump, standStill;
	Robot r;
	World w;
	boolean spacePressed;
	int timer;
	int delay;
    /** constructor that sets the value of all variables, and sets value of Robot and World object to the appropriate passed parameter */
	public InputHandler(Robot e, World w) {
		holdingJump = false;
		moveLeft = new MoveCommand(e, -2);
		moveRight = new MoveCommand(e, 2);
		jump = new JumpCommand(e);
		standStill = new MoveCommand(e, 0);
		this.r = e;
		this.w = w;
		timer = 0;
		delay = 20;
	}

	/**
	 * Meant to handle the input to control this fucker
	 * 
	 * @param keys
	 *            The actual keys
	 */
	public void handleInput(boolean[] keys) {

		if (keys[0]) {
			if (r.getState() == State.STATE_GROUND && !holdingJump) {
				jump.execute();
				holdingJump = true;
			}
		} else {
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
					timer = 0;
				}
			}
		}
		timer++;
	}

}
