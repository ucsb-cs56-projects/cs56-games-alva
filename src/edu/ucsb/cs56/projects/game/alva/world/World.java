package edu.ucsb.cs56.projects.game.alva.world;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import edu.ucsb.cs56.projects.game.alva.Util.Vector2;
import edu.ucsb.cs56.projects.game.alva.entity.Entity;
import edu.ucsb.cs56.projects.game.alva.entity.Robot;

public class World implements Serializable {

    private int width, height;
    ArrayList<Entity> entities;
    Tile[][] tiles;
    Vector2 spawnPoint;
    ArrayList<Switch> switches;
    int timer;
    
    public static final Tile steelX = new Tile(0, 0, TileType.STEELX);
    public static final Tile platform = new Tile(0, 0, TileType.XPLATFORM);

    public World(int width, int height, Vector2 spawnPoint, Vector2 endPoint) {
	this.width = width;
	this.height = height;
	Robot.getInstance().setPosition(spawnPoint);
	entities = new ArrayList<Entity>();
	tiles = new Tile[width][height];
	switches = new ArrayList<Switch>();
	timer = 600000;
    }

    public void render(Graphics2D win) {
	for (int x = 0; x < width; x++) {
	    for (int y = 0; y < height; y++) {
		Tile t = tiles[x][y];
		if(t instanceof Switch) {
		    t.drawIt(win);
		} else if (t != null) {
		    win.drawImage(t.getTileType().getTexture().getImage(), null, x * 100, y * 100);
		}
	    }
	}
	for (Entity e : entities) {
d	    e.update(win);
	}
    }

    public ArrayList<Entity> getEntities() {
	// TODO Auto-generated method stub
	return entities;
    }

    public void addEntity(Entity e) {
	entities.add(e);
    }

    public Tile[][] getTiles() {
	return tiles;
    }

    public void addTile(int x, int y, Tile t) {
	tiles[x][y] = t;
    }

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

    public Vector2 getSpawnPoint() {
	return spawnPoint;
    }

    public void setSpawnPoint(Vector2 spawnPoint) {
	this.spawnPoint = spawnPoint;
    }
	
    public void addSwitch(Switch s, int x, int y) {
	switches.add(s);
	tiles[x][y] = s;
    }

    public ArrayList<Switch> getSwitches() {
	// TODO Auto-generated method stub
	return switches;
    }
	
}
