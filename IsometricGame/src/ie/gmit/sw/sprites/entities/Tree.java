package ie.gmit.sw.sprites.entities;

import java.awt.Graphics;

import ie.gmit.sw.Handler;
import ie.gmit.sw.tiles.Tile;
import ie.gmit.sw.utils.Assets;

/**
 * Render tree object to the screen  with specified size and position
 * Sets boundary for collision detection with the player.
 * @author Kamila
 *
 */
public class Tree extends Obstacles {

	/**
	 * @param handler object
	 * @param x axis tree position on the screen
	 * @param y axis tree position on the screen
	 */
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);
		 
		/**
		 * Sets boundary for collision between player and tree
		 */
		bounds.x = 15;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 10;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(Assets.three, (int) (x - handler.getCamera().getxOffset()),
				(int) (y - handler.getCamera().getyOffset()), width, height, null);

	}
}
