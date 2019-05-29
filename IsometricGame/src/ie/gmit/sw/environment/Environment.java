package ie.gmit.sw.environment;

import java.awt.Graphics;

import ie.gmit.sw.Handler;
import ie.gmit.sw.sprites.entities.EntityManager;
import ie.gmit.sw.sprites.entities.Player;
import ie.gmit.sw.sprites.entities.Tree;
import ie.gmit.sw.tiles.Tile;
import ie.gmit.sw.utils.Utils;

/**
 * Loading Environment from a a text file and calculates camera position at the screen.
 * @author Kamila Michel
 *
 */
public class Environment {
	
	/**
	 * @param width, height Size of a map
	 * @param tiles array for creating environment
	 * @param posX, posY Player position on the map
	 */
	private int width, height;
	private int[][] tiles;
	private int posX, posY; 
	private Handler handler; 
	private EntityManager entityManager;

	/**
	 * @param handler helper object
	 * @param path takes a path of a environment text file
	 */
	public Environment(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		entityManager.add(new Tree(handler, 500, 100));
		entityManager.add(new Tree(handler, 300, 300));
		entityManager.add(new Tree(handler, 300, 500));
		loadEnvironment(path);
		//Player spawn position
		entityManager.getPlayer().setX(posX);
		entityManager.getPlayer().setY(posY);

	}

	/**
	 * @return entityManager which manages all entities
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	/**
	 *  Updates position of a tiles
	 */
	public void tick() {
		entityManager.tick();

	}

	/**
	 * @return width of a map
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return Gets height of a map
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Finds the id of a tile and check boundary of a map
	 * Indexing tile array
	 * @return default tile
	 */
	public Tile getTile(int x, int y) {
		
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.waterTile;
		return t;
	}

	
	/**
	 * @param g Paint tiles to the screen
	 * xStart Left tile that user can see on the screen that is visible
	 * xEnd Far right tile on the screen
	 * yStart top tile on the screen
	 * yEnd Button tile on the screen
	 * User sees only tiles instead of the whole map
	 */
	public void paintComponent(Graphics g) {
		int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		for (int y = yStart; y < yEnd; y++) {
			// 
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).paintComponent(g, (int) (x * Tile.TILE_WIDTH - handler.getCamera().getxOffset()),
						(int) (y * Tile.TILE_HEIGHT - handler.getCamera().getyOffset()));

			}
		}
		entityManager.paintComponent(g);

	}

	/**
	 * @param path for loading Environment
	 */
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
		/**
		 * Load file and splits on white space
		 * @param tokens Positions in the text file
		 * @param width it's the first position in the file returns weight of a map in tiles
		 * @param height it's the second position in the file and returns height of a map in tiles
		 * @param posX Spawn x position of a player
		 * @param posY Spawn y position of a player
		 */
		
		String file = Utils.loadFile(path);
		String[] tokens = file.split("\\s");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		posX = Utils.parseInt(tokens[2]);
		posY = Utils.parseInt(tokens[3]);

		/**
		 * Sets position in tokens array
		 */
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}

		}
	}
}
