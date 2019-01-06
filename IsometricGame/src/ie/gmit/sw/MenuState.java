package ie.gmit.sw;

import java.awt.Graphics;

public class MenuState extends State {

	private UIController uIController;

	// Constructor
	MenuState(Handler handler) {
		super(handler);
		this.uIController = new UIController(handler);
		handler.getMouseInput().setUIController(uIController);

		//Adds start button
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

	@SuppressWarnings("exports")
	@Override
	public void paintComponent(Graphics g) {
		uIController.paintComponent(g);

	}

}
