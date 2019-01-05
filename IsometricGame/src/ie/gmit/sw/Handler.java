package ie.gmit.sw;

//Allows to pass handler object and allows to access any object that are needed
public class Handler {

	// Declare variables
	private GameView gameView; // gameView object
	private Environment environment; // environment object

	// Constructor
	public Handler(GameView gameView) {
		this.gameView = gameView;
	}

	public GameView getGameView() {
		return gameView;
	}

	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	public int getWidth() {
		return gameView.getWidth();
	}
	public int getHeight() {
		return gameView.getHeight();
	}
	public KeyboardInput getKeybordInput() {
		return gameView.getKeyboardInput();
	}
	public Camera getCamera() {
		return gameView.getCamera();
	}

}
