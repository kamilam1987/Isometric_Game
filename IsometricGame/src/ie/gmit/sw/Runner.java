package ie.gmit.sw;

import ie.gmit.sw.view.GameView;

/**
 * Takes a gameView object and starts run method using thread which runs a game.
 * 
 * @author Kamila Michel
 * 
 */
public class Runner {
	/**
	 * @param args Returns game screen with specified size and title.
	 */
	public static void main(String[] args) {

		GameView gameView = new GameView("GMIT - B.Sc. in Computing (Software Development)", 1280, 640);
		gameView.start();
	}
}