package edu.ucsb.cs56.projects.game.alva.world;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

import edu.ucsb.cs56.projects.game.alva.Element;
import edu.ucsb.cs56.projects.game.alva.Util.Vector2;

public class Tile extends Element implements Serializable {

    TileType type;

	public Tile(int x, int y, TileType t) {
		super(new Vector2(x * 100, y * 100), 100, 100);
        type = t;
	}
	
	public void drawIt(Graphics2D win) {
		type.getTexture().draw(this, win);
	}
	
	public TileType getTileType() {
		return type;
	}

}
