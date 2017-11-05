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

    @Override
    public void draw(Graphics2D win) {
	update();
	win.translate(c.getX(), c.getY());
	render(win);
	win.translate(-c.getX(), -c.getY());
    }

    public void createMenu() {

    }

    public void createGameOverScreen() {

    }

    public void update() {
	c.update(r, w);
	input.handleInput(keys);
	pe.update(dt);
    }

    public void render(Graphics2D win) {
	win.setColor(Color.BLACK);
	win.fill(clear);
	w.render(win);
    }

    public void loadWorldFile(File f) {

    }

}
