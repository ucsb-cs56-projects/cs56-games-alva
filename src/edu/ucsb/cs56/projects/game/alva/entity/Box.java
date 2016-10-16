package edu.ucsb.cs56.projects.game.alva.entity;

import edu.ucsb.cs56.projects.game.alva.Util.Vector2;

import edu.ucsb.cs56.projects.game.alva.entity.Entity;
import edu.ucsb.cs56.projects.game.alva.entity.Robot;
import edu.ucsb.cs56.projects.game.alva.Assets;
import java.awt.Graphics2D;

public class Box extends Entity {

    boolean isGrabbed = false;
    Robot r;
    
    public Box(Vector2 position) {
        super(position, new Vector2(0, 0), 100, 100);
        r = Robot.getInstance();
    }
    
    public void setGrabbed(boolean grab) {
        this.isGrabbed = grab;
    }
    
    @Override
    public void drawIt(Graphics2D win) {
        Assets.box.draw(this, win);
    }
    
    @Override
    public void update(Graphics2D win) {
        if(!r.isGrabbing()) {
            getVelocity().setX(0);
        }
        super.update(win);
    }
    
}
