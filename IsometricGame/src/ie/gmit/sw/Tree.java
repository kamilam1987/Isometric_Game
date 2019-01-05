package ie.gmit.sw;

import java.awt.Graphics;

public class Tree extends Obstacles {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT *2);
		// TODO Auto-generated constructor stub
		//Sets boundary for collision between player and tree
		bounds.x = 15;
		bounds.y = (int)(height/1.5f);
		bounds.width = width - 10;
		bounds.height = (int)(height - height/1.5f);
	}
	
	
			

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(Assets.three,(int)(x - handler.getCamera().getxOffset()),(int)(y - handler.getCamera().getyOffset()),width,height,null);
		
	}
}
