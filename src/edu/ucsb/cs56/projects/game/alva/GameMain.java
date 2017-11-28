package edu.ucsb.cs56.projects.game.alva;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;
import edu.ucsb.cs56.projects.game.alva.Util.Vector2;
import edu.ucsb.cs56.projects.game.alva.world.World;

/**Creates JFrame object and creates instances of MainComp objects
 */
public class GameMain {

	/**
	 * Main class, created JFrame
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		JFrame j1 = new JFrame();
		MainComp m = new MainComp();
		//m.w = new World(20,8, new Vector2(200,600), new Vector2(1600,400));
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		j1.setSize(1280, 720);
		j1.add(m);
		j1.setVisible(true);
	}

}
