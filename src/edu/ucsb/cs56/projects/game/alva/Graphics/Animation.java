package edu.ucsb.cs56.projects.game.alva.Graphics;

import edu.ucsb.cs56.projects.game.alva.entity.Entity;
import edu.ucsb.cs56.projects.game.alva.entity.Entity.State;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Animation {
    
    ArrayList<Texture> textureList;
    static int position;
    static int timer;
    static int delay;
    
    public Animation(int delay) {
        textureList = new ArrayList<Texture>();
        position = 0;
        timer = 0;
        this.delay = delay;
    }
    
    public Animation(ArrayList<Texture> textures, int delay) {
        textureList = textures;
        position = 0;
        this.delay = delay;
    }
    
    public void addFrame(Texture t) {
        textureList.add(t);
    }
    
    public void addFrame(Texture t, int pos) {
        textureList.add(pos, t);
    }
    
    public ArrayList<Texture> getFrames() {
        return textureList;
    }
    
    public void animate(Entity e, Graphics2D win) {
        if(Math.abs(e.getVelocity().getX()) > 0) {
            timer++;
            if(timer > delay) {
                timer = 0;
                position++;
                position = position % textureList.size();
            }
        } else {
            timer = 0;
            position = 0;
        }
        textureList.get(position).draw(e, win);
    }
    
}
