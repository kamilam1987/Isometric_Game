package ie.gmit.sw.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Returns tile with specified width and height in pixels and individual id number for each tile. 
 * Checks if player can walk on specified tile.Tile array holds instance of every single tile in a game.
 * @author Kamilka
 *
 */
public class Tile {

	public static Tile[] tiles = new Tile[256];//Number of tiles
	public static Tile grassTile = new GrassTile(0);//Grass tile with id 0
	public static Tile waterTile = new WaterTile(1);//Water tile with id 1
	
	protected BufferedImage texture;//Tile image
	protected final int id;//Individual number for each tile

	public static final int TILE_WIDTH = 128;
	public static final int TILE_HEIGHT = 64;

	/**
	 * @param texture tile image
	 * @param id number for each tiles
	 */
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;//Uses id as index for array

	}

	// Takes also position on the screen
	public void paintComponent(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);

	}

	/**
	 * @return Player is allowed to walk on the tile
	 */
	public boolean isSolid() {
		return false;
	}

	public void tick() {

	}

	/**
	 * @return tile id
	 */
	public int getId() {
		return id;

	}

}
