package ie.gmit.sw;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Human {

	// Declare variable

	// Player constructor takes a gameView object and x-axis, y-axis
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Human.DEFAULT_HUMAN_WIDTH, Human.DEFAULT_HUMAN_HEIGHT);
		
		//Sets boundary
		bounds.x = 50;
		bounds.y = 50;
		bounds.width = 64;
		bounds.height = 15;
		

	}

	// Updates variables or objects
	@Override
	public void tick() {
		getInput();
		move();
		handler.getCamera().centerCamera(this);

	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeybordInput().up)
			yMove = -speed;
		if (handler.getKeybordInput().down)
			yMove = speed;
		if (handler.getKeybordInput().left)
			xMove = -speed;
		if (handler.getKeybordInput().right)
			xMove = speed;
	}

	// Draws to the screen
	@SuppressWarnings("exports")
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(Assets.player1, (int) (x - handler.getCamera().getxOffset()), (int)( y - handler.getCamera().getyOffset()), width, height, null);

		
	}

}
