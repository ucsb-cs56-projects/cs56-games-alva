package edu.ucsb.cs56.projects.game.alva;

import edu.ucsb.cs56.projects.game.alva.world.World;
import edu.ucsb.cs56.projects.game.alva.entity.Entity;

public class Camera {
	
	private double x, y;
	
	public Camera(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void update(Entity main, World w) {
		setX(-main.getPosition().getX() + (1280 / 2));
        if(main.getPosition().getY() < 700) {
        	 setY(-main.getPosition().getY() + (720 / 2));
        }
	}
	

}
