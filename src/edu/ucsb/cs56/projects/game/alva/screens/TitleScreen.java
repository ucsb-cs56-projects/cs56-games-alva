// TitleScreen.java 
// by Ray Muhlenkamp CS56 W18
// Screen class that displays Alva title screen


package edu.ucsb.cs56.projects.game.alva;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class TitleScreen implements Screen 
{

	private MainComp mc;

	public TitleScreen(MainComp MC) {
		this.mc = MC;
	}

	public void update(Graphics2D win) { 
		mc.input.handleInput(mc.keys);
		win.translate(mc.c.getX(), mc.c.getY());
		render(win);
		win.translate(-mc.c.getX(), -mc.c.getY());	}

	public void render(Graphics2D win) {
        	win.drawImage(Assets.LoadScreen, null, 0,0);
	}
	
	public int handleMouse(int mx, int my) {
		return -2;
	}



}
