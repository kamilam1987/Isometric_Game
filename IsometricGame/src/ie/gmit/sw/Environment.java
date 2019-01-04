package ie.gmit.sw;

import java.awt.Graphics;

//Loading Environment from a file
public class Environment {
	private int width, height;// Size of a map
	private int[][] tiles;
	private int posX, posY;// Player position

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
				getTile(x, y).paintComponent(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);

			}
		}

	}

	// Responsible for lading Environment
	private void loadEnvironment(String path) {
		// Testing
		/*
		 * width = 5; height = 5; tiles = new int[width][height];
		 * 
		 * for (int x = 0; x < width; x++) { for (int y = 0; y < height; y++) {
		 * tiles[x][y] = 0; }
		 * 
		 * } }
		 */
		String file = Utils.loadFile(path);
		String[] tokens = file.split("\\s");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		posX = Utils.parseInt(tokens[2]);
		posY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}

		}
	}
}
