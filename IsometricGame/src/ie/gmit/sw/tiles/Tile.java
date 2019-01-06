package ie.gmit.sw.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	//Declare static variables
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile waterTile = new WaterTile(1);
	
	
	
	protected BufferedImage texture;
	protected final int id;

	public static final int TILE_WIDTH = 128;
	public static final int TILE_HEIGHT = 64;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;

	}

	// Takes also position onthe screen
	public void paintComponent(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);

	}

	// Player is allowed to walk on the tile
	public boolean isSolid() {
		return false;
	}

	public void tick() {

	}

	public int getId() {
		return id;

	}

}
