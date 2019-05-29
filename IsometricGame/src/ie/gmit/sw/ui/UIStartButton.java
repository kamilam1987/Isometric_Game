package ie.gmit.sw.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Render start button image with specified size
 * Change colour of start button when user click on it 
 * @author Kamila
 *
 */
public class UIStartButton extends UserInterface{
	
	//declare variables
	private BufferedImage[] img;
	private ClickListener click;

	/**
	 * @param x axis position of start button 
	 * @param y axis position of start button
	 * @param width of start button
	 * @param height of start button
	 * @param img hold start image button
	 * @param click on mouse input
	 */
	public UIStartButton(float x, float y, int width, int height, BufferedImage[] img, ClickListener click) {
		super(x, y, width, height);
		this.img = img;
		this.click = click;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintComponent(Graphics g) {
		if(hover)
			g.drawImage(img[1],(int)x,(int)y, width, height, null);
			else
				g.drawImage(img[0],(int)x,(int)y, width, height, null);
	}

	@Override
	public void click() {
		click.click();
		
	}

}
