package edu.ucsb.cs56.projects.game.alva.Graphics;

import edu.ucsb.cs56.projects.game.alva.entity.Entity;
import edu.ucsb.cs56.projects.game.alva.entity.Entity.State;
import java.awt.Graphics2D;
import java.util.ArrayList;
/**Enables movement from Entity objects and appends texture objects for frame behavior
 */
public class Animation {
    
    ArrayList<Texture> textureList;
    static int position;
    static int timer;
    static int delay;
/**Creates an instance of ArrayList of type Texture, sets inital position and timer to zero, and sets the initial delay of Animation object
 * @param delay passes value of type int to set initial delay of Animation object
 */    
    public Animation(int delay) {
        textureList = new ArrayList<Texture>();
        position = 0;
        timer = 0;
        this.delay = delay;
    }
    /**Creates a frame for Texture objects to be copied into textureList ArrayList
     * @param textures passes ArrayList object that is type Texture to copy Texture objects into textureList 
     * @param delay passes value of type int to set initial delay of Animation object
     */
    public Animation(ArrayList<Texture> textures, int delay) {
        textureList = textures;
        position = 0;
        this.delay = delay;
    }
    /**Adds texture objects into textureList
     * @param t passes object of type Texture that will be appended to textureList
     */
    public void addFrame(Texture t) {
        textureList.add(t);
    }
    /**Adds texture object into specific index in textureList
     * @param t passes object of type Texture that will be appended to textureList
     * @param pos the specific index passed in objects will be placed in within the textureList ArrayList object
     */
    public void addFrame(Texture t, int pos) {
        textureList.add(pos, t);
    }
    /**Gets the textureList ArrayList for further usage
     * @return textureList ArrayList with texture objects appended or empty
     */
    public ArrayList<Texture> getFrames() {
        return textureList;
    }
    /**Enables Entity objects or objects that extend Entity class to move
     * @param e passes object of type Entity for so objects can move; can pass objects that extend Entity 
     * @param win Graphics2D object that represents the window object for drawing to a GUI
     */
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
    
    /**Enables Entity objects or objects that extend Entity class to move. Used for animations when standing still.
     * @param e passes object of type Entity for so objects can move; can pass objects that extend Entity 
     * @param win Graphics2D object that represents the window object for drawing to a GUI
     */
    public void animateStill(Entity e, Graphics2D win) {
        timer++;
        if(timer > delay) {
            timer = 0;
            position++;
            position = position % textureList.size();
        }
        textureList.get(position).draw(e, win);
    }
    
}
