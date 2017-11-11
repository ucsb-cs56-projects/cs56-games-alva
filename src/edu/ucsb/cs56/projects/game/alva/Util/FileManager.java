package edu.ucsb.cs56.projects.game.alva.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import edu.ucsb.cs56.projects.game.alva.world.World;
import edu.ucsb.cs56.projects.game.alva.entity.Box;
import edu.ucsb.cs56.projects.game.alva.world.Switch;
/** class that creates the levels of the game through the use of the text file corresponding to every level */
public class FileManager {
	
	private final int wallTile = 1;
	private final int floorTile = 2;
	private final int box = 3;
        private final int Switch = 4;
        private final int Back = 5;
    /** method that takes reads file that is passed as a parameter, and creates the level based on the file's level 
     @param f File object that is read to build the world. First and last lines of the file are specifications for the Window and Camera objects. All intermediate lines are specifications on world layout.
    @return World object that is created based on the file passed as the parameter*/
	public World loadWorld(File f) {
		World w = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String line = null;
			int counter = 0;
			while((line = reader.readLine()) != null) {
				if(counter == 0) {
					String[] tokens = line.split(",");
					Vector2 temp = new Vector2(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
					Vector2 temp2 = new Vector2(Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]));
					w = new World(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), temp, temp2);
					counter++;
					continue;
				}
				
				if(counter > w.getHeight()) {
					String[] tokens = line.split("-");
					for(int i = 0; i < tokens.length; i++) {
						Switch s = w.getSwitches().get(counter - w.getHeight() - 1);
						String[] active = tokens[1].split(":");
						for(int j = 0; j < active.length; j++) {
							String[] tile = active[j].split(",");
							s.addActiveTile(Integer.parseInt(tile[0]), Integer.parseInt(tile[1]) - 1);
						}
						String[] inactive = tokens[2].split(":");
						for(int j = 0; j < inactive.length; j++) {
							String[] tile = inactive[j].split(",");
							s.addInactiveTile(Integer.parseInt(tile[0]), Integer.parseInt(tile[1]) - 1);
						}
						s.update();
					}
					continue;
				}
				String[] tokens = line.split(":");
				for(int i = 0; i < tokens.length; i++) {
					int type = Integer.parseInt(tokens[i]);
					switch(type) {
					case wallTile:
					    //w.addTile(i, counter - 1, World.steelX);
					    //w.addTile(i, counter-1, World.background);
					    w.addTile(i, counter - 1, World.steelX);
					    break;
					case floorTile:
					    w.addTile(i, counter-1, World.background);
					    w.addTile(i, counter - 1, World.platform);
					    break;
					case box:
					    w.addEntity(new Box(new Vector2(i * 100, (counter - 1) * 100)));
					    w.addTile(i, counter-1, World.background);
					    break;
					case Switch:
					    w.addTile(i, counter-1, World.background);
					    w.addSwitch(new Switch(i, (counter - 1), w), i, (counter - 1));
					    break;
					case Back: w.addTile(i, counter-1, World.background);break;
					}
				}
				
				counter++;
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return w;
	}

}
