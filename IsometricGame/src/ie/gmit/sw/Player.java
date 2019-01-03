package ie.gmit.sw;

import java.awt.Graphics;

public class Player extends Human{

	public Player(float x, float y) {
		super(x, y);
		
	}

	//Updates variables
	@Override
	public void tick() {
		
		
	}

	//Draws to the screen
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, null);
		
	}

}
