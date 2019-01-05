package ie.gmit.sw;

public class Camera {
	// Declare variables
	private float xOffset, yOffset;// position from original position
	private Handler handler;

	public Camera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
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

	
	

	
		
		

	

	// Centre camera on the player
	public void centerCamera(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		

	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		
	}

}
