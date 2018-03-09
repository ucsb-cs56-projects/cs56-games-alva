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
		render(win);	
	}

	public void render(Graphics2D win) {
        	win.drawImage(Assets.LoadScreen, null, 0,0);
	}



}
