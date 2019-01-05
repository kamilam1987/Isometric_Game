package ie.gmit.sw;

public class Camera {
	// Declare variables
	private float xOffset, yOffset;// position from original position
	private GameView gameView;

	public Camera(GameView gameView,float xOffset, float yOffset) {
		this.gameView = gameView;
		this.xOffset = xOffset;
		this.yOffset = yOffset;

	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		
	}
	
	//Centre camera on the player
	public void centerCamera(Entity e) {
		xOffset = e.getX() - gameView.getWidth()/2 + e.getWidth()/2;
		yOffset = e.getY() - gameView.getHeight()/2 + e.getHeight()/2;
		
		
	}

}
