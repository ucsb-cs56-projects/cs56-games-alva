package edu.ucsb.cs56.projects.game.alva.Graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import edu.ucsb.cs56.projects.game.alva.Element;
/**Enables images to be placed into the window; the images take on the position of specificied element objects
 */
public class Texture {
	
	BufferedImage img;
      /**Passes in BufferedImage object to be an instance variable of Texture object
       * @param img passes in object of type BufferedImage to be an instance variable of Texture object
       */  
        public Texture(BufferedImage img) {
            this.img = img;
        }
        /**Gets the passed in image
	 * @return passed in image is returned 
	 */
        public BufferedImage getImage() {
            return img;
        }
        /**Draws the img at element object's specific location
	 * @param e passes object of type Element; element object's position will determine img location
	 * @param win Graphics2D object that represents the window object for drawing to a GUI
	 */
        public void draw(Element e, Graphics2D win) {
            win.drawImage(img, null, (int) e.getPosition().getX(), (int) e.getPosition().getY());
        }
}
