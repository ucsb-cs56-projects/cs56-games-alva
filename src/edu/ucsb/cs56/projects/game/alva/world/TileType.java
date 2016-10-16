package edu.ucsb.cs56.projects.game.alva.world;

import edu.ucsb.cs56.projects.game.alva.Graphics.Texture;

import edu.ucsb.cs56.projects.game.alva.Assets;

public enum TileType {
    STEELX(Assets.redTile, false),
    XPLATFORM(Assets.platformTile, false),
    SWITCH(Assets.Switch1, true);
          
    private final Texture t;
    private boolean isPassable;
    private TileType(Texture t, boolean pass) {
            this.t = t;
            isPassable = pass;
    }
    
    public Texture getTexture() {
        return t;
    }
    public boolean isPassable() {
    	return isPassable;
    }
}
