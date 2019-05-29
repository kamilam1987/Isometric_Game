package ie.gmit.sw.view;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;

import ie.gmit.sw.Handler;
import ie.gmit.sw.camera.Camera;
import ie.gmit.sw.listener.KeyboardInput;
import ie.gmit.sw.listener.MouseInput;
import ie.gmit.sw.state.GameState;
import ie.gmit.sw.state.MenuState;
import ie.gmit.sw.state.State;
import ie.gmit.sw.utils.Assets;

import javax.imageio.*;
import java.io.*;
import java.util.*;

/**
 * Holds main methods for runs a game.Implements runnable to allow run a thread.
 * Thread allows to run separately from the rest of application.
 * Updates all variables, positions of object and draws graphics to the screen.
 * Followed by set of tutotorials: https://www.youtube.com/channel/UCaM7SQvF5q9sz4NgL16PNRAj.lc
 * @author Kamilka
 *
 */
public class GameView extends JPanel implements Runnable {

	private GameWindow gameWindow; // gameWindow object
	private static final long serialVersionUID = 777L;
	private Thread thread; // Thread to start and stop application
	private boolean running = false; //Controls running loop
	private int width, height;// Game width and height in pixels
	public String title;// Game window title
	private BufferStrategy bs;
	private Graphics g;// Graphics object
	private KeyboardInput keyboardInput;// keyboardInput object
	private Camera camera; // camera game object
	private Handler handler;// handler object
	private MouseInput mouseInput;// mouse object

	// States 
	public State gameState;
	public State menuState;

	/**
	 * @param title of a game window
	 * @param width of a game window in a pixels
	 * @param height a game window in a pixels
	 */
	public GameView(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyboardInput = new KeyboardInput();
		mouseInput = new MouseInput();

	}

	/**
	 * Initiaze graphics, mouse and keyboard input
	 */
	private void init() {
		gameWindow = new GameWindow(title, width, height);
		gameWindow.getFrame().addKeyListener(keyboardInput);
		gameWindow.getFrame().addMouseListener(mouseInput);
		gameWindow.getFrame().addMouseMotionListener(mouseInput);
		gameWindow.getCanvas().addMouseListener(mouseInput);
		gameWindow.getCanvas().addMouseMotionListener(mouseInput);

		// testImage = ImageLoader.loadImage("/images/sprites/default/sheet.png");
		Assets.init();
		handler = new Handler(this);// takes gameView object
		camera = new Camera(handler, 0, 0);// Initialise to 0,0 position
		handler = new Handler(this);// takes gameView object
		gameState = new GameState(handler);// Passes instance this gameView class
		menuState = new MenuState(handler);// Passes instance this gameView class
		State.setState(menuState);//Sets the current state which is render first to the screen

	}
 
	/**
	 * Calls many times, sets and update a game state
	 */
	private void tick() {
		keyboardInput.tick();
		//Checks if current state exist
		if (State.getState() != null) {
			//Update current state
			State.getState().tick();
		}

	}

	private void paintComponent() {
		// source:https://docs.oracle.com/javase/9/docs/api/java/awt/image/BufferStrategy.html
		bs = gameWindow.getCanvas().getBufferStrategy();
		// BufferStrategy - tells computer how to draw things on the screen
		if (bs == null) {
			gameWindow.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		// Clears the screen with given width and height
		g.clearRect(0, 0, width, height);
		// Draw
		// Graphics2D g2d = (Graphics2D) g;
		// AffineTransform at = AffineTransform.getShearInstance(1, 0);
		// g2d.transform(at);
		if (State.getState() != null) {
			State.getState().paintComponent(g);
		}

		// End drawing
		bs.show();
		g.dispose();

	}

	public void run() {
		init();

		// Runs in the same speed at every computer
		int fps = 60;// Frames per sec, amount of time that tick and render method runs
		double timePerTick = 1000000000 / fps;// (NanoTime) Max amount of time allow to have to run tick and render
												// method to achieve 60 frame/sec
		double delta = 0;// Amount time before call tick and render method
		long now;// Current time of a coputer
		long lastTime = System.nanoTime();// Current time in nano sec
		long timer = 0;
		int tick = 0;

		// Game loop updates object variables and renders picture to the screen
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;// Amount of time to call tick and render method
			timer += now - lastTime;// Adds the amount of time that is passed since code above last ran
			lastTime = now;// current time
			// Check if tick and render methods needs to be call
			if (delta >= 1) {
				// Update variables
				tick();
				// Paints graphic to the screen
				paintComponent();
				tick++;
				delta--;
			}
			if (timer >= 1000000000) {
				//System.out.println("Tick and frames" + tick);// Amount of tick
				tick = 0;
				timer = 0;
			}
		}

		// Stops the thread
		stop();

	}

	/**
	 * @return keyboard input
	 */
	public KeyboardInput getKeyboardInput() {
		return keyboardInput;
	}

	/**
	 * @return mouse input
	 */
	public MouseInput getMouseInput() {
		return mouseInput;
	}

	/**
	 * @return game camera object
	 */
	public Camera getCamera() {
		return camera;
	}

	// Getters for width and height
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// Starts a thread which passes GameView class
	public synchronized void start() {
		//Checks if the game is running
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		// Starts call run method
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