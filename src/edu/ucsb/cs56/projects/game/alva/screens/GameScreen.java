// GameScreen.java
// by Ray Muhlenkamp
// Screen class that handles the Game screen (world building, assets loading, etc)


package edu.ucsb.cs56.projects.game.alva;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class GameScreen implements Screen {

	private MainComp mc;
	protected BufferedImage back;

        public GameScreen(MainComp MC) {
                this.mc = MC;
        }


	public void update(Graphics2D win) {
		render(win);
	}

	public void render(Graphics2D win) {
	
	       	if(back==null) {
               		back = (BufferedImage)(createImage(mc.getWidth(),mc.getHeight()));
		}

		Graphics2D graphToBack = (Graphics2D) back.createGraphics();

		draw(graphToBack);
                win.drawImage(back, null, 0, 0);
	}


}



