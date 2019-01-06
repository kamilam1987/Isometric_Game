package ie.gmit.sw;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIStartButton extends UserInterface{
	
	//declare variables
	private BufferedImage[] img;
	private ClickListener click;

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
