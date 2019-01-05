package ie.gmit.sw;

import java.awt.image.BufferedImage;

public class PlayerAnimation {
	private int speed, index;//Index of an array, speed sets switch 
	private BufferedImage[] frames;//number of frames per image
	private long lastTime, timer;//time to swich index
	
	public PlayerAnimation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index =0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public BufferedImage getFrame() {
		return frames[index];
		
	}
	
	//Update time
	public void tick() {
		timer+=System.currentTimeMillis() -lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer>speed) {
			index++;
			timer =0;
			if(index >= frames.length) {
				index=0;
			}
			
		}
	}
	

}
