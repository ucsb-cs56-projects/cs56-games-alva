package edu.ucsb.cs56.projects.game.alva.world;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

import edu.ucsb.cs56.projects.game.alva.Element;
import edu.ucsb.cs56.projects.game.alva.Util.Vector2;
/**Enables textures to drawn on the window through Tile objects 
 */
public class Tile extends Element implements Serializable {

    TileType type;
	/**Uses the Element class constructor to create an instance of rectangle object to set bounds and make t an instance variable of Tile Class
	 * @param x Vector2 object x position
	 * @param y Vector2 object y position
	 * @param t passes object of type TileType to be made into instance variable of Tile Class 
	 */
	public Tile(int x, int y, TileType t) {
		super(new Vector2(x * 100, y * 100), 100, 100);
        type = t;
	}
	/**Draw specific texture object on window
	 * @param win Graphics2D object that represents the window object for drawing to a GUI
	 */
	public void drawIt(Graphics2D win) {
		type.getTexture().draw(this, win);
	}
	/**Gets the specific Tile Type 
	 * @return the specific Tile Type
	 */
	public TileType getTileType() {
		return type;
	}

}
