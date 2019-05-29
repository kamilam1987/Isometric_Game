package ie.gmit.sw.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 * Creates game menu screen
 * @author Kamilka
 *
 */
public abstract class UserInterface {
	protected float x, y;
	protected int width, height;
	protected boolean hover = false;
	protected Rectangle bounds;

	/**
	 * @param x position of a game menu
	 * @param y position of a game menu
	 * @param width of a game menu in pixels
	 * @param height of a game menu in pixels
	 */
	public UserInterface(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int)x, (int)y,width, height );
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

	//Hover over button
	public void onMouseMove(MouseEvent e) {
		//Checks if mouse is on the button
		if(bounds.contains(e.getX(), e.getY()))
			hover = true;
		else
			hover=false;

	}

	//Detect if the object is clicked
	public void onMouseRelease(MouseEvent e) {
		if(hover)
			click();

	}

	public abstract void tick();

	public abstract void paintComponent(Graphics g);

	public abstract void click();

}
