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

    private TitleScreen tScreen;
	private LevelSelectScreen lsScreen;
    protected Rectangle clear;
    protected InputHandler input;
    private String[] levelfiles;
    double start;
    double accumulator = 0;
    double dt = 0.006;
    World w;
    protected PhysicsEngine pe;
    Robot r;
    Camera c;
    int levelState;
    FileManager fManager;

/**Instatiates all Assets and animations, sets the measurement for time, instantiates a Camera object that starts at the origin, creates an instance of robot object, sets the level, creates a FileManager object, creates a File object of 'src/assests/World1.txt', instantiates World object and addes Entity objects to it,instantiates InputHandler objects and a PhysicsEngine object, creates a rectangle object; sets the playing board and gets everything ready and instantiated.
 */
    public MainComp() {
		tScreen = new TitleScreen(this);
		lsScreen = new LevelSelectScreen(this);
		changeScreen(1);
		levelfiles = new String[]{"src/assets/World1.txt","src/assets/World2.txt","src/assets/World3.txt","src/assets/World4.txt","src/assets/World5.txt"};;
		Assets.loadAssets();
		start = System.currentTimeMillis();
		c = new Camera(0, 0);
		r = Robot.getInstance();
		levelState = 1;
		fManager = new FileManager();
		this.createWorld();
		//File f = new File(levelfiles[i]);
		//w = fManager.loadWorld(f);
		//w.addEntity(r);
		//input = new InputHandler(r, w, this);
		//pe = new PhysicsEngine(w);
		clear = new Rectangle(-500, -500, w.getWidth() * 100 + 1000, w.getHeight() * 100 + 1000);
    }


	/**
	 *  Changes the Screen object that MainComp is currently using to display the GUI
	 *  @param newScreen Screen object that designates what Screen to now draw to the GUI
	 */
 
	public void changeScreen(int newScreen){
		if (newScreen == 1) {
			currentScreen = tScreen;
		}
		else if (newScreen == 2) {
			currentScreen = lsScreen;
		}
		else if (newScreen == 3) {
			currentScreen = new GameScreen(this);
		}
	}
	
/**Overrides the draw function to call the update function of the current Screen GUI 
 * @param win Graphics2D object that represents the window object for drawing a GUI
 */
    @Override
    public void draw(Graphics2D win) {
		currentScreen.update(win);
    }
	
/**Not implemented yet
 */
 
    public void createWorld() {
		w = null;
		File f = new File(levelfiles[i]);
		w = fManager.loadWorld(f);
		w.addEntity(r);
		input = new InputHandler(r, w, this);
		pe = new PhysicsEngine(w);
    }
	

/**Not implmented yet
 * @param f passes object of type File
 */
    public void loadWorldFile(File f) {

    }


	

	
	
}
