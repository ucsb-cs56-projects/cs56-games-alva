package edu.ucsb.cs56.projects.game.alva;

import java.awt.image.BufferedImage;

import edu.ucsb.cs56.projects.game.alva.Graphics.Animation;
import edu.ucsb.cs56.projects.game.alva.Graphics.Texture;

public class Assets {
    
    public static Texture redTile;
    public static Texture platformTile;
    public static Texture robot;
    public static Texture robot_left;
    public static Texture box;
    public static Animation robotAnim;
    public static Animation robotAnim_left;
    private static BufferedImage robotSpriteSheet = GameDriver.addImage("src/assets/Spread Sheet Final.png");
    private static BufferedImage robotleftSpriteSheet = GameDriver.addImage("assets/Robot/Left/Moving/RobotMovingLeft.png");
    public static Texture Switch1;
    public static Texture Switch2;
    
    public static void loadAssets() {
    	Switch1 = new Texture(GameDriver.addImage("src/assets/Switch.png"));
    	Switch2 = new Texture(GameDriver.addImage("src/assets/Switch2.png"));
        redTile = new Texture(GameDriver.addImage("src/assets/Steel X.png"));
        platformTile = new Texture(GameDriver.addImage("src/assets/Steel X Platform.png"));
        robot = new Texture(GameDriver.addImage("src/assets/Robot.png"));
	robot_left = new Texture(GameDriver.addImage("assets/Robot/Left/Moving/robotmovingframe1.png"));
        box = new Texture(GameDriver.addImage("src/assets/Moveable box.png"));
        robotAnim = new Animation(20);
        for(int i = 0; i < 280; i += 70) {
        	robotAnim.addFrame(new Texture(robotSpriteSheet.getSubimage(i, 0, 70, 103)));
        }
	robotAnim_left = new Animation(20);
	int j;
	int k;
        for( k = 0; k < 206; k += 103){
	    for(j = 0; j < 140; j += 70){
		robotAnim_left.addFrame(new Texture(robotleftSpriteSheet.getSubimage(j,k,70,103)));
	    }
	}
    }
    
}
