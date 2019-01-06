package ie.gmit.sw.state;

import java.awt.Graphics;

import ie.gmit.sw.Handler;

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
	
	//protected GameView gameView;
	protected Handler handler;
	
	//State constructor takes a gameView object
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void paintComponent(Graphics g);

}
