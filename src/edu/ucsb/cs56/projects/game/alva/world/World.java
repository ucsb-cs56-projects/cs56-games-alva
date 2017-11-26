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
import edu.ucsb.cs56.projects.game.alva.Assets;
/**Creates a multidimensional array that Tile objects are positioned in  
 */
public class World implements Serializable {

    private int width, height;
    ArrayList<Entity> entities;
    Tile[][] tiles;
    Vector2 spawnPoint;
    ArrayList<Switch> switches;
    int timer;
    Assets a;
    
    public static final Tile steelX = new Tile(0, 0, TileType.STEELX);
    public static final Tile platform = new Tile(0, 0, TileType.XPLATFORM);
    public static final Tile background = new Tile(0, 0, TileType.BACKGROUND);
    /**Makes width and height instance variables of class World, creates an instance of robot object at a specific position, instantiates an Entity ArrayList object, a Switch ArrayList object, a two dimensional array Tile object set initially with int values width and height, and set initial value for timer
     * @param width passes value of type int, and made into instance variable of class World, and used to specify value for 2 dimensional array Tile object
     * @param height passes value of type int, and made into instance variable of class World, and used to specify value for 2 dimensional array Tile object
     * @param spawnPoint passes object of type Vector2 to get position of where to spawn instance of robot object
     * @param endPoint passes object of type Vector2 'could be used for create a finish line/objective for the game' 
     */
    public World(int width, int height, Vector2 spawnPoint, Vector2 endPoint) {
	this.width = width;
	this.height = height;
	a.loadAssets();
	Robot.getInstance().setPosition(spawnPoint);
	entities = new ArrayList<Entity>();
	tiles = new Tile[width][height];
	switches = new ArrayList<Switch>();
	timer = 600000;
    }
/**Puts specific images on the window object based of Tile object
 * @param win Graphics2D object that represents the window object for drawing to a GUI
 */
    public void render(Graphics2D win) {
	for (int x = 0; x < width; x++) {
	    for (int y = 0; y < height; y++) {
		Tile t = tiles[x][y];
		if(t instanceof Switch) {
		    win.drawImage(background.getTileType().getTexture().getImage(), null, x * 100, y * 100);
		    t.drawIt(win);
		} else if (t != null) {
		    win.drawImage(t.getTileType().getTexture().getImage(), null, x * 100, y * 100);
		}
	    }
	}
	for (Entity e : entities) {
	    e.update(win);
	}

    }
/**Gets ArrayList of type Entity referred to as entities
 * @return the ArrayList of type Entity 'entities'
 */
    public ArrayList<Entity> getEntities() {
	// TODO Auto-generated method stub
	return entities;
    }
/**Appends an entity object to ArrayList of type Entity 'entities'
 * @param e passes an object of type Entity to be appended to ArrayList of type Entity 'entities'
 */
    public void addEntity(Entity e) {
	entities.add(e);
    }
/**Gets two dimensional array of type Tile referred to as tiles
 * @return the two dimensional array of type Tile 'tiles'
 */
    public Tile[][] getTiles() {
	return tiles;
    }
/**Adds tile object to a specific position in the two dimensional array of type Tile 'tiles'
 * @param x the row position of the multidimensional array
 * @param y the column position of the multidimensional array
 * @param t passing object of type Tile to be stored in specified position in two dimensional array of type Tile 'tiles'
 */
    public void addTile(int x, int y, Tile t) {
	tiles[x][y] = t;
    }
/**Gets the width of the World object
 * @return the width of the World object
 */
    public int getWidth() {
	return width;
    }
/**Sets the width of the World object
 * @param width passes in a value of type int that is used to set the width of the World object
 */
    public void setWidth(int width) {
	this.width = width;
    }
/**Gets the height of the World object
 * @return the height of the World object
 */
    public int getHeight() {
	return height;
    }
/**Sets the height of the World object
 * @param height passes in a value of type int that is used to set the height ofthe World object
 */
    public void setHeight(int height) {
	this.height = height;
    }
/**Gets the starting position of the Vector2 object
 * @return the starting position of the Vector2 object
 */
    public Vector2 getSpawnPoint() {
	return spawnPoint;
    }
/**Sets the starting point of the World object
 * @param spawnPoint passes in an object of type Vector2 used to set the starting point of the World object
 */
    public void setSpawnPoint(Vector2 spawnPoint) {
	this.spawnPoint = spawnPoint;
    }
/**adds instances of switch objects and positions them in the 2 dimensional array object
 * @param s instance of switch object
 * @param x passes a value of type int used for row positioning in multidimensional array 
 * @param y passes a value of type int used for column positioning in multidimensioanl array 
 */	
    public void addSwitch(Switch s, int x, int y) {
	switches.add(s);
	tiles[x][y] = s;
    }
/**Gets ArrayList object of type Switch 'switches'
 * @return ArrayList object of type Switch 'switches'
 */
    public ArrayList<Switch> getSwitches() {
	// TODO Auto-generated method stub
	return switches;
    }
	
}
