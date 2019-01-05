package ie.gmit.sw;

import java.awt.Graphics;

public class MenuState extends State{

	//Constructor
	MenuState(Handler handler){
		super(handler);
		
	}
	@Override
	public void tick() {
		//Switch to main game on two button mouse pressed
		if(handler.getMouseInput().isLPressed() && handler.getMouseInput().isRPressed())
			State.setState(handler.getGameView().gameState);
		
	}

	@SuppressWarnings("exports")
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
