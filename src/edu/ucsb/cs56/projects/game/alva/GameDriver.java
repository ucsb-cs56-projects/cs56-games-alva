package edu.ucsb.cs56.projects.game.alva;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.Character.*;

import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/** non instatiatable class sets up all variables related to the game, has key thread to registered key strokes and released key strokes, sets windows, returns BufferedImages from files
 */

public abstract class GameDriver extends Canvas implements KeyListener, Runnable, MouseListener
{

	protected boolean[] keys;
	protected BufferedImage back;
        protected BufferedImage home;
	protected int timer = 6;
    protected static boolean menu;
    
	/**Set up all variables related to the game, starts the key thread to log key strokes, sets the background color to black 
	 */
	public GameDriver()
	{
		//set up all variables related to the game

		// number of key possibilities
		keys = new boolean[16];
		menu = true;

    	setBackground(Color.BLACK);
		setVisible(true);
	   
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
		setFocusable(true);
		addMouseListener(this);
	}
/**By default paints background
 */
   public void update(Graphics window){
	   paint(window);
   }
	/**Makes value an instance variable of class GameDriver 
	 * @param value passes a value of type int that made into an instance variable of class GameDriver
	 */
   public void setTimer(int value) {
   		timer = value;
   }
   /**Creates a default window
    * @param window Graphics object that represents a window object for drawing to a GUI
    */
   public void paint(Graphics window)
   {
       if(menu == false){
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));
		Graphics2D graphToBack = (Graphics2D) back.createGraphics();

		draw(graphToBack);

		Graphics2D win2D = (Graphics2D) window;
		win2D.drawImage(back, null, 0, 0);

       }
       else{
	   Graphics2D g2d = (Graphics2D) window;
	   g2d.drawImage(Assets.LoadScreen, null, 0,0);
       }
	   
   }
	/**non instantiatable class that draws the elemements in the window
	 * @param win Graphics2D object that represents a window object for drawing to GUI
	 */
	public abstract void draw(Graphics2D win);
/**Ties event with keycode 
 * @param e pass an object of type KeyEvent that is tied with a keycode for registering key strokes
 */
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_W : keys[0]=true; break;
			case KeyEvent.VK_S : keys[1]=true; break;
			case KeyEvent.VK_A : keys[2]=true; break;
			case KeyEvent.VK_D : keys[3]=true; break;
			case KeyEvent.VK_F : keys[4]=true; break;

			case KeyEvent.VK_8 : keys[5]=true; break;
			case KeyEvent.VK_5 : keys[6]=true; break;
			case KeyEvent.VK_4 : keys[7]=true; break;
			case KeyEvent.VK_6 : keys[8]=true; break;
			case KeyEvent.VK_PLUS : keys[9]=true; break;
		case KeyEvent.VK_ENTER : keys[10]=true; menu = false; break;
			case KeyEvent.VK_SPACE : keys[11]=true;break;
			case KeyEvent.VK_UP : keys[12]=true;break;
			case KeyEvent.VK_DOWN : keys[13]=true;break;
			case KeyEvent.VK_LEFT : keys[14]=true;break;
			case KeyEvent.VK_RIGHT : keys[15]=true;break;
		}

	}
	/**Not implemented yet
	 * @param arg0 passes an object of type MouseEvent 
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}
	/**Not implemented yet
	 * @param arg0 passes an object of type MouseEvent
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**Not implemented yet
	 * @param arg0 passes an object of type MouseEvent
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**Not implemented yet
	 * @param arg0 passes an object of type MouseEvent
	 */
	@Override 
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	 /**Not implemented yet
         * @param arg0 passes an object of type MouseEvent
         */

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**Tie event with keycode
	 * @param e passes an object of type KeyEvent that is tied with a keycode when key is released
	 */
	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_W : keys[0]=false; break;
			case KeyEvent.VK_S : keys[1]=false; break;
			case KeyEvent.VK_A : keys[2]=false; break;
			case KeyEvent.VK_D : keys[3]=false; break;
			case KeyEvent.VK_F : keys[4]=false; break;

			case KeyEvent.VK_8 : keys[5]=false; break;
			case KeyEvent.VK_5 : keys[6]=false; break;
			case KeyEvent.VK_4 : keys[7]=false; break;
			case KeyEvent.VK_6 : keys[8]=false; break;
			case KeyEvent.VK_PLUS : keys[9]=false; break;
			case KeyEvent.VK_ENTER : keys[10]=false;break;
			case KeyEvent.VK_SPACE : keys[11]=false;break;
			case KeyEvent.VK_UP : keys[12]=false;break;
			case KeyEvent.VK_DOWN : keys[13]=false;break;
			case KeyEvent.VK_LEFT : keys[14]=false;break;
			case KeyEvent.VK_RIGHT : keys[15]=false;break;
		}
	}
/**Not implemented yet
 * @param e passes object of type KeyEvent
 */
	public void keyTyped(KeyEvent e){}
/**Try Catch block that moves thread into blocked state for timer duration and repaints within that same duration
 */
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(timer);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
   /**Try Catch block to return the BufferedImage containing decode contents of input or NULL otherwise throw IOException
    * @param name passes object of type string that is file name Buffered Image is placed in 
    * @return returns the BufferedImage containing decoded contents of input or NULL else throw IOException
    */

  	public static BufferedImage addImage(String name) {

  		BufferedImage img = null;

  			try {
  				File f = new File(name);
  				System.out.println(f.getAbsolutePath());
				img = ImageIO.read(f);

			} catch (IOException e) {
				System.out.println(e);
		}

  		return img;



  	}


}
