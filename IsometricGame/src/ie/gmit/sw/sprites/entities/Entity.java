package ie.gmit.sw.sprites.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import ie.gmit.sw.Handler;

/**
 * Returns position and size of entity. Checks for collision between player and entities.
 * @author Kamilka
 *
 */
public abstract class Entity {

	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;

	/**
	 * @param handler helper object
	 * @param x axis position on the screen
	 * @param y axis position on the screen
	 * @param width Entity width in pixels
	 * @param height Entity height in pixels
	 */
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		/**
		 * Takes x,y position of a player and width and height of the player
		 */
		bounds = new Rectangle(0,0,width, height);
	}
 
	/**
	 * @return player x-axis on the screen
	 */
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}
 
	/**
	 * @return entity y-axis on the screen
	 */
	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return width of the entity in pixels
	 */
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return height of the entity in pixels
	 */
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	//Returns rectangle over entity
	/**
	 * @param xOff screen offset at x coordinate
	 * @param yOff screen offset at y coordinate
	 * @return rectangle with area around the entity
	 */
	public Rectangle getCollisionBounds(float xOff, float yOff) {
		return new Rectangle ((int)(x + bounds.x + xOff), (int)(y + bounds.y + yOff),bounds.width, bounds.height);
		
	}
	
	/**
	 * Checks for collision with entity
	 * @param xOff screen offset at x coordinate
	 * @param yOff screen offset at y coordinate
	 * @return stops on collision 
	 */
	public boolean collision(float xOff, float yOff) {
		for(Entity e : handler.getEnvironment().getEntityManager().getEntities()) {
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds( xOff,  yOff)))
				return true;
		}
		return false;
		
	}

	// Updates variables
	public abstract void tick();

	// Draws to the screen
	@SuppressWarnings("exports")
	public abstract void paintComponent(Graphics g);

}
