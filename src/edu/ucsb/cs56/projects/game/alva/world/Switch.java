package edu.ucsb.cs56.projects.game.alva.world;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import edu.ucsb.cs56.projects.game.alva.Assets;

public class Switch extends Tile {

	World w;
	ArrayList<Point> activeTiles;
	ArrayList<Point> inactiveTiles;
	boolean active = true;
	
	public Switch(int x, int y, World w) {
		super(x, y, TileType.SWITCH);
		activeTiles = new ArrayList<Point>();
		inactiveTiles = new ArrayList<Point>();
		this.w = w;
	}
	
	public void addActiveTile(int x, int y) {
		activeTiles.add(new Point(x, y));
	}
	
	public void addInactiveTile(int x, int y) {
		inactiveTiles.add(new Point(x, y));
	}
	
	public void active() {
		ArrayList<Point> temp = activeTiles;
		activeTiles = inactiveTiles;
		inactiveTiles = temp;
		active = !active;
		update();
	}
	
	public void update() {
		for(Point p:inactiveTiles) {
			w.getTiles()[(int) p.getX()][(int) p.getY()] = null;
		}
		for(Point p:activeTiles) {
			w.getTiles()[(int) p.getX()][(int) p.getY()] = World.steelX;
		}
	}
	
	@Override
	public void drawIt(Graphics2D win) {
		if(active) {
			Assets.Switch1.draw(this, win);
		} else {
			Assets.Switch2.draw(this, win);
		}
	}
}
