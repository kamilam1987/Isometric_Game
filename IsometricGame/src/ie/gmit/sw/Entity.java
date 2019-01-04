package ie.gmit.sw;

import java.awt.Graphics;

public abstract class Entity {

	// Declare variables
	protected float x, y;// position on the screen
	protected int width, height;// Entity size

	// Constructor takes x-axis and y-axis
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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
