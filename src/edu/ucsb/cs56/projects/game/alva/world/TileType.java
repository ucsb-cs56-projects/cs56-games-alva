package edu.ucsb.cs56.projects.game.alva.world;

import edu.ucsb.cs56.projects.game.alva.Graphics.Texture;

import edu.ucsb.cs56.projects.game.alva.Assets;

public enum TileType {
    STEELX(Assets.redTile, false),
    XPLATFORM(Assets.platformTile, false),
    SWITCH(Assets.Switch1, true),
    BACKGROUND(Assets.BackgroundTile,true);
    
          
    private final Texture t;
    private boolean isPassable;
    /**Determines if a texture object is passable
     * @param t passes object of type Texture 
     * @param pass passes value of type boolean; if false not passable, if true passable
     */
    private TileType(Texture t, boolean pass) {
            this.t = t;
            isPassable = pass;
    }
    /**Gets the texture object
     * @return the texture object
     */
    public Texture getTexture() {
        return t;
    }
    /**gets the value of 'isPassable'; false or true
     * @return the value of 'isPassable'; false or true
     */
    public boolean isPassable() {
    	return isPassable;
    }
}
