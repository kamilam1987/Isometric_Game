package ie.gmit.sw;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

	// Declare variables
	protected Handler handler;// handler object
	protected float x, y;// position on the screen
	protected int width, height;// Entity size
	protected Rectangle bounds;// Collision bounds

	// Constructor takes x-axis and y-axis
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0,0,width, height);// Takes x,y position of a player and width and height of the player
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// Updates variables
	public abstract void tick();

	// Draws to the screen
	@SuppressWarnings("exports")
	public abstract void paintComponent(Graphics g);

}
