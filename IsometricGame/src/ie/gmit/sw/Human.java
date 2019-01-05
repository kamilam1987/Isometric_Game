package ie.gmit.sw;

//Collision detection 
public abstract class Human extends Entity {

	// Declare variables
	protected int health; // Human health
	protected float speed; // Human speed
	protected float xMove, yMove;//

	public static final int DEFAULT_HEALTH = 5;
	public static final float DEFAULT_SPEED = 2.0f;
	public static final int DEFAULT_HUMAN_WIDTH = 100;
	public static final int DEFAULT_HUMAN_HEIGHT = 64;

	// Human constructor that takes x,y position
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

	// Collision detection
	// Move only on x-axis
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

	// Move only on y-axis
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

	public int getHealth() {
		return health;
	}

	protected boolean collisionWithWater(int x, int y) {
		return handler.getEnvironment().getTile(x, y).isSolid();
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
