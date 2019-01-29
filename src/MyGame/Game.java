package MyGame;
import graphics.Screen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import Entity.Entity;
import Entity.PlayerWizardProjectile;
import Entity.Mob.Player;
import Input.Keyboard;
import Input.Mouse;
import Level.Level;
import Level.TileCoordinates;
import Menu.Launcher;

import java.util.Scanner;

/**
 * @author John
 * @version 1.0
 *
 */
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private static int width = 600;
	private static int height = width / 16 * 9;
	public static int scale = 3;
	private String title = "Rambo";

	private Thread thread;
	private boolean running = false;
	public static boolean updating = true;
	
	public JFrame frame;
	private Screen screen;

	private Level level;
    private Keyboard key;
	Player player;
	private int time = 0;
	private SoundsEffect effect = new SoundsEffect();
	
	static int interval;
	static Timer timer;
      String soundtrack = "res/sounds/RedAlert.wav";

    File myfile = new File("myscore.txt");
	public File myscore;
	private static int TOP_SCORE;
	
	private BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB); //1
											
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData(); //2
	

	public Game() {
		loadTopScore();
		key = new Keyboard();
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		frame = new JFrame();
		level = Level.spawn;
		screen = new Screen(width, height);
		TileCoordinates player_level1 = new TileCoordinates(15 , 20); // * 16
		player = new Player(player_level1.x(), player_level1.y(), key); // defines the rendering range according to the player movements
		level.add(player);; // to initialize level in Entity class
		
		myscore = new File("myscore.txt");
		
	
		addKeyListener(key);

		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		setFocusable(true);
		
	}
	
	public static int getwidth(){
		return width * scale;
	}
	
	public static int getheight(){
		return height * scale;
	}
	

	public synchronized void start() {
		sound(soundtrack);
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void loadTopScore() {
		try {
			Scanner in = new Scanner(myfile);
			TOP_SCORE = in.nextInt();
            System.out.println(TOP_SCORE);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
	}
	
	public void saveScore(){
		try {
	
			PrintWriter pw = new PrintWriter(myscore);
			if(Entity.score > TOP_SCORE) pw.print(Entity.score);
			else pw.print(TOP_SCORE);
			
			
			pw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}


	public void sound(String path){
        if(updating){
		try {
	
			InputStream in = new FileInputStream(path);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
	    	}
        }
	
}
	


	
	public void run() {

		long lastTime = System.nanoTime();
		long timeOnFirstLoopEntry = System.currentTimeMillis();
        final double ns = 1000000000.0;
        double delta = 0;
		int frames = 0;
		int updates = 0;

		requestFocus();
		while (running) {

			long now = System.nanoTime(); 
            delta = delta + (now - lastTime) / ns * 60;
			lastTime = now; 

			while (delta >= 1) { 

				update(); 
				updates++;
				delta--; 

			}

			render();
			frames++;

			if (System.currentTimeMillis() - timeOnFirstLoopEntry > 1000) { 
				timeOnFirstLoopEntry = timeOnFirstLoopEntry + 1000; 
				frame.setTitle(title + " | " + updates + " ups," + frames
						+ " fps");

				updates = 0;
				frames = 0;

			}

		}

	}

	public void over(){
		updating = false;
	}
	public void update() {
		if(updating) {
			key.update();
            level.update();
		}
	}

	public void render() {
	 
		BufferStrategy bs = getBufferStrategy(); // Returns a graphics context
													// for the drawing buffer
		if (bs == null) {
			createBufferStrategy(3); // This method attempts to create the best
										// strategy available with the number of
										// buffers supplied
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.blue);
		g.setFont(new Font("Verdana", 0, 25));
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null); // must be before g.dispose();
	//	g.drawRect(0, 0, width, height);
	    // For efficiency, programmers should call dispose when
		// finished using a Graphics object only if it was created directly from
		// a component or another Graphics object.
		
		g.drawString("Score: " + PlayerWizardProjectile.score, 30, 30);
		g.setColor(Color.cyan);
		g.drawString("Mobs: " + PlayerWizardProjectile.mobs, 200, 30);
		g.setColor(Color.MAGENTA);
		g.drawString("Hyena: " + PlayerWizardProjectile.hyena, 400, 30);
		g.setColor(Color.ORANGE);
		g.drawString("Tanks: " + PlayerWizardProjectile.tanks, 600, 30);
		g.setColor(Color.RED);
		g.drawString("Health: " + PlayerWizardProjectile.health, 780, 30);
		g.setColor(Color.pink);
		g.drawString("Top Score: " + TOP_SCORE, 1000, 30);
		g.setColor(Color.GREEN);
		g.drawString("Time Left: " + StopWatch.interval, 20, getheight() - 40);
		g.setColor(Color.RED);
		
		  if((player.getX()) > 310 * 16){
			 
		//		g.drawString("Helicopter sound",  width / 2 + 100, height / 2 + 100);
			//	  effect.Helicopter();
		
		  }
		  
		  
		  if(player.getX() > 250 * 16){
				
				if(time < 250) time++;
			    
				if(time < 250){
					g.setFont(new Font("Verdana", 0, 35));
				g.drawString("Press 2 to switch weapon and destroy Tanks!!", (width / 2) - 50 , height / 2 - 50);
				}
				
			}
		
	    if((PlayerWizardProjectile.score >= PlayerWizardProjectile.upgrade)){
            if(time < 2) time++;
		    
			if(time < 2){

        	  effect.upgrade();

		    }
	    }
	    if(PlayerWizardProjectile.upgraded || key.two) {
	        if(time < 100) time++;
		    
	   			if(time < 99){
			g.setFont(new Font("Verdana", 0, 45));
			g.drawString("Rocket is Loaded!",  width / 2 + 100, height / 2 + 100);
		}
	    }
	    
		
		if(PlayerWizardProjectile.score >= PlayerWizardProjectile.upgrade){
			
			if(time < 100) time++;
		    
			if(time < 70){
			
				g.setFont(new Font("Verdana", 0, 45));
			g.drawString("Rocket Upgraded!",  width / 2 + 100, height / 2 + 100);
			}
			
		}
		
	   
		
		if(PlayerWizardProjectile.health <= 0 || StopWatch.interval < 1) {
			g.setFont(new Font("Verdana", 0, 40));
			g.drawString("Game Over!", width / 2 + 60, height / 2 + 100);
            
		    over(); 
            if(time < 2) time++;
		    
			if(time < 2){
		 
			}
			
		}
	    if((player.getX()) >> 4 > level.width - 30){
	    	g.setFont(new Font("Verdana", 0, 40));
	    	g.drawString("Level Completed",  width / 2 + 60, height / 2 + 100);
	    	saveScore();
	    	over();
	    
					effect.missionCompleted();

	    	
	    	
	    }
	    
	    
		g.fillOval(Mouse.getX(), Mouse.getY() + 25, 7, 7);
	    g.dispose();
    	bs.show(); // Makes the next available buffer visible

		screen.clear();

	      int xScroll = player.getX() - Screen.width / 3;
		  int yScroll = player.getY() - Screen.height / 3;
		
	//	System.out.println("X: " +player.getX());
	//	System.out.println("XScroll: " +xScroll);
		  

		    level.render(xScroll, yScroll, screen);
		 //   screen.renderPlayer(22 * 16, 15 * 16, Sprite.tank);
		  //  screen.rendersheet(20, 54, SpriteSheet.side_tank_destroyed_anim, false);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];

		}

	}
	

	public static void main(String[] agrs) {
        new Launcher(); // runs the constructor

	}

}
