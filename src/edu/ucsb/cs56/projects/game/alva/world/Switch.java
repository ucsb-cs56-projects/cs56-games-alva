package edu.ucsb.cs56.projects.game.alva.world;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import edu.ucsb.cs56.projects.game.alva.Assets;
/**Enables Tile objects to switch off from being active and inactive so Switch animation is possible
 */
public class Switch extends Tile {

	World w;
	ArrayList<Point> activeTiles;
	ArrayList<Point> inactiveTiles;
	boolean active = true;
	/**Calls Tile constructor to create an instance of rectangle object to set bounds and make TileType.SWITCH an instance variable of class Tile, creates two instances of ArrayList type point that categorizes tiles as active or inactive and makes w an instance variable of Switch Class
	 * @param x Vector2 object x position
	 * @param y Vector2 object y position
	 * @param w passes object of type World to be made into instance variable of Switch Class
	 */	
	public Switch(int x, int y, World w) {
		super(x, y, TileType.SWITCH);
		activeTiles = new ArrayList<Point>();
		inactiveTiles = new ArrayList<Point>();
		this.w = w;
	}
	/**Adds a new instance of tile to activeTile ArrayList
	 * @param x int value of x position of new tile
	 * @param y int value of y position of new tile
	 */
	public void addActiveTile(int x, int y) {
		activeTiles.add(new Point(x, y));
	}
	/**Adds a new instance of tile to inactiveTile ArrayList
	 * @param x int value of x position of new tile
	 * @param y int value of y position of new tile
	 */
	public void addInactiveTile(int x, int y) {
		inactiveTiles.add(new Point(x, y));
	}
	/**Recycles active and inactive tile objects so different animations arepossible
	 */
	public void active() {
		ArrayList<Point> temp = activeTiles;
		activeTiles = inactiveTiles;
		inactiveTiles = temp;
		active = !active;
		update();
	}
	/**Runs enchanced for loop to get inactive and active tiles on instance of World object; background tile objects are inactive Tiles and steelX tile objects are active Tiles 
	 */
	public void update() {
		for(Point p:inactiveTiles) {
			w.getTiles()[(int) p.getX()][(int) p.getY()] = World.background;
		}
		for(Point p:activeTiles) {
			w.getTiles()[(int) p.getX()][(int) p.getY()] = World.steelX;
		}
	}
	/**Overrides the drawIt function to draw the switch animation
	 * @param win Graphics2D object that represents the window object for drawing to a GUI 
	 */
	@Override
	public void drawIt(Graphics2D win) {
		if(active) {
			Assets.Switch1.draw(this, win);
		} else {
			Assets.Switch2.draw(this, win);
		}
	}
}
