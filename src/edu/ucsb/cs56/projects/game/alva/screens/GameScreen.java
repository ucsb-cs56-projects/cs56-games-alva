// GameScreen.java
// by Ray Muhlenkamp
// Screen class that handles the Game screen (world building, assets loading, etc)


package edu.ucsb.cs56.projects.game.alva;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;


public class GameScreen implements Screen {

	private MainComp mc;
	
	protected BufferedImage back;

        public GameScreen(MainComp MC) {
                this.mc = MC;
				mc.createWorld();
				
        }


	public void update(Graphics2D win) {
		mc.c.update(mc.r, mc.w);
		mc.input.handleInput(mc.keys);
		mc.pe.update(mc.dt);
		render(win);


	}

	public void render(Graphics2D win) {
		
		if(back==null) {
			back = (BufferedImage)(mc.createImage(mc.getWidth(),mc.getHeight()));		
		}

		Graphics2D graphToBack = (Graphics2D) back.createGraphics();

		graphToBack.setColor(Color.BLACK);
		graphToBack.clearRect(0,0, mc.getWidth(), mc.getHeight());
		
		graphToBack.translate(mc.c.getX(), mc.c.getY());
		mc.w.render(graphToBack);
		graphToBack.translate(-mc.c.getX(), -mc.c.getY());
		
        win.drawImage(back, null, 0, 0);
		
		

		
	}
	
	public int handleMouse(int mx, int my) {
				System.out.println(mx + " " + my);

		return -2;
	}


}



