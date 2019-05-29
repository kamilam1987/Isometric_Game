package ie.gmit.sw.sprites.entities;

import java.awt.Graphics;

import ie.gmit.sw.Handler;

/**
 * Returns position of obstacles on the screen. Uses only for static entities
 * @author Kamila Michel
 *
 */
public class Obstacles extends Entity {

	/**
	 * @param handler object
	 * @param x position on the screen on x-axis
	 * @param y position on the screen on y-axis
	 * @param width of a obstacles in pixels
	 * @param height of a obstacles in pixels
	 */
	public Obstacles(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);

	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub

	}

}
