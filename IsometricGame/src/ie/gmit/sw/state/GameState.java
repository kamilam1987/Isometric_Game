package ie.gmit.sw.state;

import java.awt.Graphics;

import ie.gmit.sw.Handler;
import ie.gmit.sw.environment.Environment;

/**
 * Utilise a State class and returns environment from txt file with specified
 * path.
 * 
 * @author Kamilka
 *
 */
public class GameState extends State {

	private Environment environment;

	/**
	 * @param handler object
	 */
	public GameState(Handler handler) {
		super(handler);
		environment = new Environment(handler, "resources/environment/environment.txt");
		handler.setEnvironment(environment);

		// gameView.getCamera().move(50, 100);//Takes x,y offsets to move a camera
	}

	@Override
	public void tick() {
		environment.tick();
		// player.tick();
		// gameView.getCamera().move(1, 1 );//Moves camera by x,y axis

	}

	@Override
	public void paintComponent(Graphics g) {
		environment.paintComponent(g);
		// player.paintComponent(g);

		// Tile.tiles[3].paintComponent(g, 0, 0);
		// Tile.tiles[0].paintComponent(g, 20, 10);

		// Tile.tiles[2].paintComponent(g, 0, 0);

	}

}
