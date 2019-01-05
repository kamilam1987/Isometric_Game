package ie.gmit.sw;

import java.awt.Graphics;

//Loading Environment from a file
public class Environment {
	private int width, height;// Size of a map
	private int[][] tiles;
	private int posX, posY;// Player position
	private Handler handler; //handler object

	// Environment constructor takes a path of a file
	public Environment(Handler handler, String path) {
		this.handler = handler;
		loadEnvironment(path);
	}

	// Updates position of a tiles
	public void tick() {

	}

	// Finds the id in this tiles
	public Tile getTile(int x, int y) {
		//check boundary of a map
		if(x<0 || y<0 || x>= width || y>= height)
			return Tile.grassTile;
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.waterTile;
		return t;
	}

	// Paint tiles to the screen
	public void paintComponent(Graphics g) {
		int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		for (int y = yStart; y < yEnd; y++) {
			//Can see only tiles instead of the whole map
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).paintComponent(g,(int)( x * Tile.TILE_WIDTH - handler.getCamera().getxOffset()),(int)( y * Tile.TILE_HEIGHT- handler.getCamera().getyOffset()));

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
