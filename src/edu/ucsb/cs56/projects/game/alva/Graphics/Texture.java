package edu.ucsb.cs56.projects.game.alva.Graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import edu.ucsb.cs56.projects.game.alva.Element;

public class Texture {
	
	BufferedImage img;
        
        public Texture(BufferedImage img) {
            this.img = img;
        }
        
        public BufferedImage getImage() {
            return img;
        }
        
        public void draw(Element e, Graphics2D win) {
            win.drawImage(img, null, (int) e.getPosition().getX(), (int) e.getPosition().getY());
        }
}
