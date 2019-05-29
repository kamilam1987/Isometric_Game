package ie.gmit.sw.state;

import java.awt.Graphics;

import ie.gmit.sw.Handler;
import ie.gmit.sw.ui.ClickListener;
import ie.gmit.sw.ui.UIController;
import ie.gmit.sw.ui.UIStartButton;
import ie.gmit.sw.utils.Assets;

/**
 * Returns start button to the menu screen on mouse click Changes state from
 * menu state to game state
 * 
 * @author Kamilka
 *
 */
public class MenuState extends State {

	private UIController uIController;

	// Constructor
	public MenuState(Handler handler) {
		super(handler);
		this.uIController = new UIController(handler);
		handler.getMouseInput().setUIController(uIController);

		// Adds start button

		/**
		 * Switches to game state when user press on the start button
		 */
		uIController.addObj(new UIStartButton(200, 200, 250, 120, Assets.start_button, new ClickListener() {

			@Override
			public void click() {
				handler.getMouseInput().setUIController(null);
				State.setState(handler.getGameView().gameState);

			}
		}));

	}

	@Override
	public void tick() {
		uIController.tick();

	}

	@Override
	public void paintComponent(Graphics g) {
		uIController.paintComponent(g);

	}

}
