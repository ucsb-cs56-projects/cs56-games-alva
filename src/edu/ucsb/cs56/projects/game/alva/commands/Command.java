package edu.ucsb.cs56.projects.game.alva.commands;
/** Interface that declares the execute() method, for all implementing classes to define */
public interface Command {
	
    /**
	 * This class is meant to take commands from the user to execute what happens to the main character 
	 * This could also be used for the AI of entities as well
	 */
	
	public void execute();

}
