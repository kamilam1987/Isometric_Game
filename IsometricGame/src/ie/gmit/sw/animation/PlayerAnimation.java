package ie.gmit.sw.animation;

import java.awt.image.BufferedImage;

/**
 * Returns image and sets speed for player animation
 * @author Kamila Michel
 *
 */
public class PlayerAnimation {
	private int speed, index;// 
	private BufferedImage[] frames;
	private long lastTime, timer;

	/**
	 * @param speed Index of an array, speed sets switch
	 * @param frames number of frames per image
	 */
	public PlayerAnimation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}

	/**
	 * @return Returns animation image index
	 */
	public BufferedImage getFrame() {
		return frames[index];

	}

	/**
	 * Update animation time
	 */
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if (timer > speed) {
			index++;
			timer = 0;
			if (index >= frames.length) {
				index = 0;
			}

		}
	}

}
