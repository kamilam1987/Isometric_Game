package ie.gmit.sw;

import java.awt.Graphics;

public class Player extends Human{

	//Declare variable
	private GameView gameView;
	public Player(GameView gameView, float x, float y) {
		super(x, y);
		this.gameView = gameView;
		
	}

	//Updates variables or objects
	@Override
	public void tick() {
		if(gameView.getKeyboardInput().up)
			y-=3;
		if(gameView.getKeyboardInput().down)
			y+=3;
		if(gameView.getKeyboardInput().left)
			x-=3;
		if(gameView.getKeyboardInput().right)
			x+=3;
		
		
	}

	//Draws to the screen
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, null);
		
	}

}
