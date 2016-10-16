package edu.ucsb.cs56.projects.game.alva;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import edu.ucsb.cs56.projects.game.alva.Util.Vector2;

public abstract class Element {
	
	protected int width, height;
	protected Vector2 position;
	protected Rectangle bounds;
	
	public Element(Vector2 position, int width, int height) {
		this.position = position;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) position.getX(), (int) position.getY(), width, height);
	}
	
	public abstract void drawIt(Graphics2D win);

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Rectangle getBounds() {
		return bounds;
	}
}
