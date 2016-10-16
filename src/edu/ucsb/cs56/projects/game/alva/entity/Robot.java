package edu.ucsb.cs56.projects.game.alva.entity;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import edu.ucsb.cs56.projects.game.alva.Graphics.Animation;
import edu.ucsb.cs56.projects.game.alva.Util.Vector2;
import edu.ucsb.cs56.projects.game.alva.Assets;

public class Robot extends Entity {
	
    private static Robot r;
    private boolean isGrabbing;
  
    private Robot() {
        super(new Vector2(200, 400), new Vector2(0, 0), 65, 100);
        isGrabbing = false;
    }
    
    public static Robot getInstance() {
        if(r == null) {
            r = new Robot();
        } 
        return r;
    }
    
    public void setGrabbing(boolean grabbing) {
        isGrabbing = grabbing;
    }
    
    @Override
    public void drawIt(Graphics2D win) {
        Assets.robotAnim.animate(this, win);
    }

    public boolean isGrabbing() {
        return isGrabbing;
    }
    
}
