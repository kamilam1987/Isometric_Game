package ie.gmit.sw;

import java.awt.Graphics;

import ie.gmit.sw.environment.Environment;

public class GameState extends State {

	// Declare variables
	//private Player player;// Player object
	private Environment environment;

	// Constructor
	public GameState(Handler handler) {
		super(handler);
		environment = new Environment(handler, "resources/environment/environment.txt");
		handler.setEnvironment(environment);
		

		// gameView.getCamera().move(50, 100);//Takes x,y offsets to move a camera
	}

	// Updates variables or objects
	@Override
	public void tick() {
		environment.tick();
		//player.tick();
		// gameView.getCamera().move(1, 1 );//Moves camera by x,y axis

	}

	@SuppressWarnings("exports")
	@Override
	public void paintComponent(Graphics g) {
		environment.paintComponent(g);
		//player.paintComponent(g);

		// Tile.tiles[3].paintComponent(g, 0, 0);
		// Tile.tiles[0].paintComponent(g, 20, 10);

		// Tile.tiles[2].paintComponent(g, 0, 0);

	}

}
