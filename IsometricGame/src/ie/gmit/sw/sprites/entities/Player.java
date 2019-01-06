package ie.gmit.sw.sprites.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ie.gmit.sw.Handler;
import ie.gmit.sw.animation.PlayerAnimation;
import ie.gmit.sw.utils.Assets;

public class Player extends Human {

	// Declare variable
	private PlayerAnimation anFront, anLeft, anRight, anBack;;//animation object

	// Player constructor takes a gameView object and x-axis, y-axis
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Human.DEFAULT_HUMAN_WIDTH, Human.DEFAULT_HUMAN_HEIGHT);
		
		//Sets boundary for player collision
		bounds.x = 50;
		bounds.y = 50;
		bounds.width = 15;
		bounds.height = 15;
		
		//Animation
		anFront = new PlayerAnimation(200, Assets.player_front);
		anBack = new PlayerAnimation(200, Assets.player_back);
		anLeft = new PlayerAnimation(200, Assets.player_left);
		anRight = new PlayerAnimation(200, Assets.player_right);
		

	}

	// Updates variables or objects
	@Override
	public void tick() {
		anFront.tick();
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
		g.drawImage(getCurrentAnimation(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		
	}
	
	private BufferedImage getCurrentAnimation(){
		if(xMove < 0){
			return anLeft.getFrame();
		}else if(xMove > 0){
			return anRight.getFrame();
		}else if(yMove < 0){
			return anBack.getFrame();
		}else{
			return anFront.getFrame();
		}
	}

}
