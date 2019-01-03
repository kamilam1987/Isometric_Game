package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.imageio.*;
import java.io.*;
import java.util.*;

/*
 * This is a God class and is doing way too much. The instance variables cover everything from isometric to 
 * Cartesian drawing and the class has methods for loading images and converting from one coordinate space to
 * another.
 * 
 */
public class GameView extends JPanel implements Runnable {
	/*
	 * private static final long serialVersionUID = 777L; private static final int
	 * DEFAULT_IMAGE_INDEX = 0;
	 * 
	 * // Encapsulate the things that vary... public static final int
	 * DEFAULT_VIEW_SIZE = 1280; private static final int TILE_WIDTH = 128; private
	 * static final int TILE_HEIGHT = 64; private Sprite player;
	 * 
	 * 
	 * // Do we really need two models like this? private int[][] matrix; private
	 * int[][] things;
	 * 
	 * private BufferedImage[] tiles; // Note that all images, including sprites,
	 * have dimensions of 128 x 64. This // make painting much simpler. private
	 * BufferedImage[] objects; // Taller sprites can be created, by using two tiles
	 * (head torso, lower body and // legs) and improve animations private Color[]
	 * cartesian = { Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE,
	 * Color.CYAN, Color.YELLOW, Color.PINK, Color.BLACK }; // This is a 2D
	 * representation
	 * 
	 * private Timer timer; // Controls the repaint interval. private boolean
	 * isIsometric = true; // Toggle between 2D and Isometric (Z key)
	 * 
	 * public GameView(int[][] matrix, int[][] things) throws Exception { //init();
	 * this.matrix = matrix; this.things = things;
	 * 
	 * setBackground(Color.WHITE); setDoubleBuffered(true); // Each image is
	 * buffered twice to avoid tearing / stutter timer = new Timer(100, this); //
	 * calls the actionPerformed() method every 100ms timer.start(); // Start the
	 * timer }
	 * 
	 * 
	 * private void init() throws Exception { tiles =
	 * loadImages("./resources/images/ground", tiles); objects =
	 * loadImages("./resources/images/objects", objects); //player = new
	 * Sprite("Player 1", new Point(0, 0),
	 * loadImages("./resources/images/sprites/default", null)); }
	 * 
	 * 
	 * 
	 * 
	 * // This method breaks the SRP private BufferedImage[] loadImages(String
	 * directory, BufferedImage[] img) throws Exception { File dir = new
	 * File(directory); File[] files = dir.listFiles(); Arrays.sort(files, (s, t) ->
	 * s.getName().compareTo(t.getName()));
	 * 
	 * img = new BufferedImage[files.length]; for (int i = 0; i < files.length; i++)
	 * { img[i] = ImageIO.read(files[i]); } return img; }
	 * 
	 * public void toggleView() { isIsometric = !isIsometric; this.repaint(); }
	 * 
	 * public void actionPerformed(ActionEvent e) { // This is called each time the
	 * timer reaches zero this.repaint(); }
	 * 
	 * public void paintComponent(Graphics g) { // This method needs to execute
	 * quickly... super.paintComponent(g); Graphics2D g2 = (Graphics2D) g; int
	 * imageIndex = -1, x1 = 0, y1 = 0; Point point;
	 * 
	 * for (int row = 0; row < matrix.length; row++) { for (int col = 0; col <
	 * matrix[row].length; col++) { imageIndex = matrix[row][col];
	 * 
	 * if (imageIndex >= 0 && imageIndex < tiles.length) { // Paint the ground tiles
	 * if (isIsometric) { x1 = getIsoX(col, row); y1 = getIsoY(col, row);
	 * 
	 * g2.drawImage(tiles[DEFAULT_IMAGE_INDEX], x1, y1, null); if (imageIndex >
	 * DEFAULT_IMAGE_INDEX) { g2.drawImage(tiles[imageIndex], x1, y1, null); } }
	 * else { x1 = col * TILE_WIDTH; y1 = row * TILE_HEIGHT; if (imageIndex <
	 * cartesian.length) { g2.setColor(cartesian[imageIndex]); } else {
	 * g2.setColor(Color.WHITE); }
	 * 
	 * g2.fillRect(x1, y1, TILE_WIDTH, TILE_WIDTH); } // Paint the object or things
	 * on the ground
	 * 
	 * imageIndex = things[row][col]; g2.drawImage(objects[imageIndex], x1, y1,
	 * null); } } }
	 * 
	 * // Paint the player on the ground //point =
	 * getIso(player.getPosition().getX(), player.getPosition().getY());
	 * //g2.drawImage(player.getImage(), point.getX(), point.getY(), null); }
	 * 
	 * // This method breaks the SRP private int getIsoX(int x, int y) { int rshift
	 * = (DEFAULT_VIEW_SIZE / 2) - (TILE_WIDTH / 2) + (x - y); // Pan camera to the
	 * right return (x - y) * (TILE_WIDTH / 2) + rshift; }
	 * 
	 * // This method breaks the SRP private int getIsoY(int x, int y) { return (x +
	 * y) * (TILE_HEIGHT / 2); }
	 * 
	 * // This method breaks the SRP private Point getIso(int x, int y) { return new
	 * Point(getIsoX(x, y), getIsoY(x, y)); // Could be more efficient... }
	 */

	// Added a new part =========================================================//

	/**
	 * 
	 */
	private GameWindow gameWindow; // gameWindow object
	private static final long serialVersionUID = 777L;
	private Thread thread; // Thread
	private boolean running = false; // set to false at the start
	public int width, height;
	public String title;
	private BufferStrategy bs;
	private Graphics g;

	// Constructor
	public GameView(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		// Initialize gameWindow in GameView constructor

	}

	private void init() {
		gameWindow = new GameWindow(title, width, height);
		// testImage = ImageLoader.loadImage("/images/sprites/default/sheet.png");
		Assets.init();

	}

	int x = 0;

	// Calls many times
	private void tick() {
		x += 1;

	}

	private void render() {
		// source:
		// https://docs.oracle.com/javase/9/docs/api/java/awt/image/BufferStrategy.html
		bs = gameWindow.getCanvas().getBufferStrategy();
		// BufferStrategy - tells computer how to draw things on the screen
		if (bs == null) {
			gameWindow.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		// Clear
		g.clearRect(0, 0, width, height);
		// Draw
		// Graphics2D g2d = (Graphics2D) g;
		// AffineTransform at = AffineTransform.getShearInstance(1, 0);
		// g2d.transform(at);
		g.drawImage(Assets.grass, x, 10, null);

		// End drawing
		bs.show();
		g.dispose();

	}

	public void run() {
		init();
		
		//Runs in the same speed at every computer
		int fps = 60;//Frames per sec, amount of time that tick and render method runs
		double timePerTick = 1000000000 / fps;//(NanoTime) Max amount of time allow to have to run tick and render method to achieve 60 frame/sec
		double delta = 0;//Amount time before call tick and render method
		long now;//Current time of a coputer
		long lastTime = System.nanoTime();// Current time in nano sec
		long timer = 0;
		int tick = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;//Amount of time to call tick and render method
			timer += now - lastTime;//Adds the amount of time that is passed since code above last ran
			lastTime = now;//current time
			//Check if tick and render methods needs to be call
			if(delta >= 1) {
				tick();
				render();
				tick++;
				delta--;
			}
			if(timer >= 1000000000) {
				System.out.println("Tick and frames"+ tick);//Amount of tick
				tick = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}

	// Starts a thread
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	// Stops a thread
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}