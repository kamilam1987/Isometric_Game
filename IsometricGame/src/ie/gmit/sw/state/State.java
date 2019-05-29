package ie.gmit.sw.state;

import java.awt.Graphics;

import ie.gmit.sw.Handler;

/**
 * Keeps methods for every single state. It's able to draw to the screen directly.
 * @author Kamilka
 *
 */
public abstract class State {
	
	private static State currentState = null;//State object
	
	/**
	 * @return Refers to a game state manager and returns current state of a game
	 */
	public static State getState() {
		return currentState;
	}
	/**
	 * @param state Renders game state which is currently set
	 */
	public static void setState(State state) {
		currentState = state;
	}
	
	//protected GameView gameView;
	protected Handler handler;
	
	/**
	 * @param handler object
	 */
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void paintComponent(Graphics g);

}
