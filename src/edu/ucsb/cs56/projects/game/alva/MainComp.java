package edu.ucsb.cs56.projects.game.alva;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;

import edu.ucsb.cs56.projects.game.alva.Util.FileManager;
import edu.ucsb.cs56.projects.game.alva.Util.InputHandler;
import edu.ucsb.cs56.projects.game.alva.Util.PhysicsEngine;
import edu.ucsb.cs56.projects.game.alva.Util.Vector2;
import edu.ucsb.cs56.projects.game.alva.world.World;
import edu.ucsb.cs56.projects.game.alva.entity.Robot;
/**Sets the playing board and gets everything ready and instatiated, updates the screen/window for registered key inputs
 */
public class MainComp extends GameDriver {
    /**
     * Various fields Clear: clear the screen for drawing InputHandler: handled
     * input for main character
     */
    private Rectangle clear;
    private InputHandler input;
    double start;
    double accumulator = 0;
    double dt = 0.006;
    World w;
    private PhysicsEngine pe;
    Robot r;
    Camera c;
    int levelState;
    FileManager fManager;
/**Instatiates all Assets and animations, sets the measurement for time, instantiates a Camera object that starts at the origin, creates an instance of robot object, sets the level, creates a FileManager object, creates a File object of 'src/assests/World1.txt', instantiates World object and addes Entity objects to it,instantiates InputHandler objects and a PhysicsEngine object, creates a rectangle object; sets the playing board and gets everything ready and instantiated.
 */
    public MainComp() {
        Assets.loadAssets();
	start = System.currentTimeMillis();
	c = new Camera(0, 0);
	r = Robot.getInstance();
	levelState = 1;
	fManager = new FileManager();
	File f = new File("src/assets/World1.txt");
	w = fManager.loadWorld(f);
	w.addEntity(r);
	input = new InputHandler(r, w);
	pe = new PhysicsEngine(w);
	clear = new Rectangle(-500, -500, w.getWidth() * 100 + 1000, w.getHeight() * 100 + 1000);
    }
/**Overrides the draw function to update window object after each registered input 
 * @param win Graphics2D object that represents the window object for drawing a GUI
 */
    @Override
    public void draw(Graphics2D win) {
	update();
	win.translate(c.getX(), c.getY());
	render(win);
	win.translate(-c.getX(), -c.getY());
    }
/**Not implemented yet
 */
    public void createMenu() {
	
	

    }
/**Not implemented yet
 */
    public void createGameOverScreen() {

    }
/** Registered input key, Camera object and PhysicEngine object adjust  
 */
    public void update() {
	c.update(r, w);
	input.handleInput(keys);
	pe.update(dt);
    }
/**Sets the color of the window object to 'black'
 * @param win Graphics 2D object that represents the window object for drawing a GUI
 */
    public void render(Graphics2D win) {
	win.setColor(Color.BLACK);
	win.fill(clear);
	w.render(win);
    }
/**Not implmented yet
 * @param f passes object of type File
 */
    public void loadWorldFile(File f) {

    }

}
