package ie.gmit.sw;

import java.awt.Graphics;

public abstract class State {
	
	//Declare variables
	private static State currentState = null;//State object
	
	
	//Refers to a game state manager
	public static State getState() {
		return currentState;
	}
	public static void setState(State state) {
		currentState = state;
	}
	
	protected GameView gameview;
	
	//State constructor takes a gameView object
	public State(GameView gameview) {
		this.gameview = gameview;
	}
	
	public abstract void tick();
	public abstract void paintComponent(Graphics g);

}
