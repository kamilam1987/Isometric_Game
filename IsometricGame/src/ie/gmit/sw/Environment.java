package ie.gmit.sw;

import java.awt.Graphics;

//Loading Environment from a file
public class Environment {
	private int width, height;// Size of a map
	private int[][] tiles;

	// Environment constructor takes a path of a file
	public Environment(String path) {
		loadEnvironment(path);
	}

	// Updates position of a tiles
	public void tick() {

	}

	// Finds the id in this tiles
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.grassTile;
		return t;
	}

	// Paint tiles to the screen
	public void paintComponent(Graphics g) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTile(x, y).paintComponent(g, x * Tile.TILE_WIDTH, y*Tile.TILE_HEIGHT);
				
				
			}
		}

	}

	// Responsible for lading Environment
	private void loadEnvironment(String path) {
		// Testing
		width = 5;
		height = 5;
		tiles = new int[width][height];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < width; y++) {
				tiles[x][y] = 0;
			}

		}
	}

}
