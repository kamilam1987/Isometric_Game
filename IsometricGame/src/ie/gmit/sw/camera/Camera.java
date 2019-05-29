package ie.gmit.sw.camera;

import ie.gmit.sw.Handler;
import ie.gmit.sw.sprites.entities.Entity;

/**
 * Returns camera that follows the player
 * 
 * @author Kamilka
 *
 */
public class Camera {

	private float xOffset, yOffset;
	private Handler handler;

	/**
	 * @param handler helper object
	 * @param xOffset y position from original position
	 * @param yOffset y position from original position
	 */
	public Camera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;

	}

	/**
	 * @return Returns x coordinate offset position
	 */
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	/**
	 * @return Returns y coordinate offset position
	 */
	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	//
	/**
	 * @param e Centre camera on the player
	 */
	public void centerCamera(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;

	}

	/**
	 * @param xAmt adds x position to xOffset
	 * @param yAmt adds x position to yOffset
	 */
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;

	}

}
