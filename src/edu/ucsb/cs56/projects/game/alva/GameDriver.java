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


public abstract class GameDriver extends Canvas implements KeyListener, Runnable, MouseListener
{

	protected boolean[] keys;
	protected BufferedImage back;
	protected int timer = 6;

	public GameDriver()
	{
		//set up all variables related to the game

		// number of key possibilities
		keys = new boolean[16];


    	setBackground(Color.BLACK);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
		setFocusable(true);
		addMouseListener(this);
	}

   public void update(Graphics window){
	   paint(window);
   }

   public void setTimer(int value) {
   		timer = value;
   }
   
   public void paint(Graphics window)
   {
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));
		Graphics2D graphToBack = (Graphics2D) back.createGraphics();

		draw(graphToBack);

		Graphics2D win2D = (Graphics2D) window;
		win2D.drawImage(back, null, 0, 0);

	}

	public abstract void draw(Graphics2D win);

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
			case KeyEvent.VK_ENTER : keys[10]=true;break;
			case KeyEvent.VK_SPACE : keys[11]=true;break;
			case KeyEvent.VK_UP : keys[12]=true;break;
			case KeyEvent.VK_DOWN : keys[13]=true;break;
			case KeyEvent.VK_LEFT : keys[14]=true;break;
			case KeyEvent.VK_RIGHT : keys[15]=true;break;
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

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

	public void keyTyped(KeyEvent e){}

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
