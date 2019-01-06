package ie.gmit.sw.environment;

import java.awt.Graphics;

import ie.gmit.sw.EntityManager;
import ie.gmit.sw.Handler;
import ie.gmit.sw.Player;
import ie.gmit.sw.Tile;
import ie.gmit.sw.Tree;
import ie.gmit.sw.Utils;

//Loading Environment from a file
public class Environment {
	private int width, height;// Size of a map
	private int[][] tiles;
	private int posX, posY;// Player position
	private Handler handler; //handler object
	private EntityManager entityManager;

	// Environment constructor takes a path of a file
	public Environment(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		entityManager.add(new Tree(handler, 500,100));
		entityManager.add(new Tree(handler, 300,300));
		entityManager.add(new Tree(handler, 300,500));
		loadEnvironment(path);
		entityManager.getPlayer().setX(posX);
		entityManager.getPlayer().setY(posY);
		
	}
	

	public EntityManager getEntityManager() {
		return entityManager;
	}


	// Updates position of a tiles
	public void tick() {
		entityManager.tick();

	}
	
	//Gets with of a map 
	public int getWidth() {
		return width;
	}
	//Gets height of a map
		public int getHeight() {
			return height;
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
		entityManager.paintComponent(g);

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
