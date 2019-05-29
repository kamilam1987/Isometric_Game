package ie.gmit.sw;

import ie.gmit.sw.camera.Camera;
import ie.gmit.sw.environment.Environment;
import ie.gmit.sw.listener.KeyboardInput;
import ie.gmit.sw.listener.MouseInput;
import ie.gmit.sw.view.GameView;

/**
 * @author Kamilka
 *
 *         Allows to pass handler object and access any object that are needed
 */
public class Handler {

	/**
	 * Declare variables
	 */
	private GameView gameView;
	private Environment environment;

	/**
	 * Constructor which takes gameView object
	 */
	public Handler(GameView gameView) {
		this.gameView = gameView;
	}

	/**
	 * @return game canvas
	 */
	public GameView getGameView() {
		return gameView;
	}

	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}

	/**
	 * @return game map with entities
	 */
	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	/**
	 * @return width of game screen in pixels
	 */
	public int getWidth() {
		return gameView.getWidth();
	}

	/**
	 * @return height of a game screen in pixels
	 */
	public int getHeight() {
		return gameView.getHeight();
	}

	/**
	 * @return getKeyboardInput which controls the player movement around the map
	 */
	public KeyboardInput getKeybordInput() {
		return gameView.getKeyboardInput();
	}

	/**
	 * @return camera that follows the player
	 */
	public Camera getCamera() {
		return gameView.getCamera();
	}

	/**
	 * @return mouse input uses for click event
	 */
	public MouseInput getMouseInput() {
		return gameView.getMouseInput();
	}

}
