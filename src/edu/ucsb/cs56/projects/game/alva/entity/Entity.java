package edu.ucsb.cs56.projects.game.alva.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import edu.ucsb.cs56.projects.game.alva.Element;
import edu.ucsb.cs56.projects.game.alva.Util.Vector2;

public abstract class Entity extends Element {
	
	public enum State {
		STATE_AIR,
		STATE_GROUND,
		STATE_WALK_LEFT,
		STATE_WALK_RIGHT
	}
	
	private State state;
	Vector2 velocity;
	
	public Entity(Vector2 position, Vector2 velocity, int width, int height) {
		super(position, width, height);
		this.velocity = velocity;
		state = State.STATE_AIR;
	}
	
	public void move() {
		position.add(velocity);
		getBounds().setLocation((int) position.getX(), (int) position.getY()); 
	}
	
	public void jump() {
		velocity.setY(-6);
		setState(State.STATE_AIR);
	}
	
	public void setVelocity(Vector2 v) {
		velocity = v;
	}
	
	public Vector2 getVelocity() {
		return velocity;
	}
	
	public abstract void drawIt(Graphics2D win);
	
	public void update(Graphics2D win) {
		move();
		drawIt(win);
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State s) {
		state = s;
	}
}
