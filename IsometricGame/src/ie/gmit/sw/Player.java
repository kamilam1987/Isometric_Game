package ie.gmit.sw;

import java.awt.Graphics;

public class Player extends Human {

	// Declare variable
	private GameView gameView;// GameView object

	// Player constructor takes a gameView object and x-axis, y-axis
	public Player(GameView gameView, float x, float y) {
		super(x, y, Human.DEFAULT_HUMAN_WIDTH, Human.DEFAULT_HUMAN_WIDTH);
		this.gameView = gameView;

	}

	// Updates variables or objects
	@Override
	public void tick() {
		getInput();
		move();

	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (gameView.getKeyboardInput().up)
			yMove = -speed;
		if (gameView.getKeyboardInput().down)
			yMove = speed;
		if (gameView.getKeyboardInput().left)
			xMove = -speed;
		if (gameView.getKeyboardInput().right)
			xMove = speed;
	}

	// Draws to the screen
	@SuppressWarnings("exports")
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(Assets.player1, (int) x, (int) y, width, height, null);

	}

}
