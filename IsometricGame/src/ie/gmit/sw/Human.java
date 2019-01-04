package ie.gmit.sw;

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
	public Human(float x, float y, int width, int height) {
		super(x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		x+=xMove;
		y+=yMove;
	}

	public int getHealth() {
		return health;
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
