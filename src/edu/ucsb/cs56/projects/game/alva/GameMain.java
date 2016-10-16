package edu.ucsb.cs56.projects.game.alva;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class GameMain {

	/**
	 * Main class, created JFrame
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame j1 = new JFrame();
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		j1.setSize(1280, 720);
		j1.add(new MainComp());
		j1.setVisible(true);
	}

}
