// LevelSelectScreen.java
// by Ray Muhlenkamp CS56 W18
// Screen class that handles Level Select

package edu.ucsb.cs56.projects.game.alva;

import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;



public class LevelSelectScreen implements Screen {


	private MainComp mc;
	protected BufferedImage back;


        public LevelSelectScreen(MainComp MC) {
                this.mc = MC;
        }


	public void update(Graphics2D win) {
		render(win);
	}

	public void render(Graphics2D win) {

           back = (BufferedImage) createImage(mc.getWidth(), mc.getHeight());
           Graphics2D graphToBack = (Graphics2D) back.createGraphics();

           mc.setBackground(Color.black);

           Font f1 = new Font("arial", Font.BOLD, 50);
           graphToBack.setFont(f1);
           graphToBack.fill3DRect(0,0,1280,720,false);
           graphToBack.setColor(Color.red);
           graphToBack.drawString("Select a Stage:", 1280/2 - 250, 100);

           //drawing boxes for level selection
           graphToBack.drawRect(140, 200, 200, 100);
           graphToBack.drawRect(140, 400, 200, 100);
           graphToBack.drawRect(540, 200, 200, 100);
           graphToBack.drawRect(540, 400, 200, 100);
           graphToBack.drawRect(940, 200, 200, 100);
           graphToBack.drawRect(940, 400, 200, 100);

           //drawing Strings within boxes
           Font f2 = new Font("arial", Font.BOLD, 47);
           graphToBack.setFont(f2);
           graphToBack.drawString("Stage 1", 140, 270);
           graphToBack.drawString("Stage 4", 140, 470);
           graphToBack.drawString("Stage 2", 540, 270);
           graphToBack.drawString("Stage 5", 540, 470);
           graphToBack.drawString("Stage 3", 940, 270);

           graphToBack.setFont(f1);
           graphToBack.drawString("  Quit", 940, 470);

           win.drawImage(back, 0, 0, this);


	}



}
