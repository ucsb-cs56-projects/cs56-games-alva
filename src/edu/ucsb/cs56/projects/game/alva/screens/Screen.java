// Screen.java
// by Ray Muhlenkamp CS56 W18
// Interface for abstract screen creation

package edu.ucsb.cs56.projects.game.alva;

import java.awt.Graphics2D;


public interface Screen 
{

	public void update(Graphics2D win);

	public void render(Graphics2D win);

}
