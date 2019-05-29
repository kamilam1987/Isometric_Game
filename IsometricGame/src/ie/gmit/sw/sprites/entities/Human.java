package ie.gmit.sw.sprites.entities;

import ie.gmit.sw.Handler;
import ie.gmit.sw.tiles.Tile;

/**
 * Returns position and size of a Human to the screen.
 * Checks for collision using moving position and bounds.
 * Human is no longer able to cross water tiles.
 * @author Kamila Michel 
 *
 */
public abstract class Human extends Entity {

	// Declare variables
	protected int health; // Human health
	protected float speed; // Human speed
	protected float xMove, yMove;//

	public static final int DEFAULT_HEALTH = 5;
	public static final float DEFAULT_SPEED = 2.0f;
	public static final int DEFAULT_HUMAN_WIDTH = 100;
	public static final int DEFAULT_HUMAN_HEIGHT = 64;

	/**
	 * @param handler object
	 * @param x axis position on the map
	 * @param y axis position on the map
	 * @param width of an entity in pixels
	 * @param height of an entity in pixels
	 */
	public Human(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		if (!collision(xMove, 0f))
			moveX();
		if (!collision(0f, yMove))
			moveY();

	}

	/**
	 * Collision detection
	 * Move only on x-axis
	 */
	public void moveX() {
		// Player moving right
		if (xMove > 0) {// Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;

			if (!collisionWithWater(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithWater(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}

		} else if (xMove < 0) {// Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;

			if (!collisionWithWater(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithWater(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
			}

		}
	}

	/**
	 * Move only on y-axis
	 * Calculates position to move on y-axis when collision is detected between
	 * water tile and a player. player has to move then in different direction
	 */
	public void moveY() {
		if (yMove < 0) {// Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;

			if (!collisionWithWater((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
					&& !collisionWithWater((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
			}

		} else if (yMove > 0) {// Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

			if (!collisionWithWater((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
					&& !collisionWithWater((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
			}

		}
	}

	/**
	 * @return Human health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Checks if the tile is walkable
	 * @param x position on the map
	 * @param y position on the map
	 * @return water tile
	 */
	protected boolean collisionWithWater(int x, int y) {
		return handler.getEnvironment().getTile(x, y).isSolid();
	}

	public void setHealth(int health) {
		this.health = health;
	}
 
	/**
	 * @return human speed
	 */
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @return xMove moving position on x axis
	 */
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return yMove moving position on y axis
	 */
	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
