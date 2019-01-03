package ie.gmit.sw;

import java.awt.Graphics;

public class GameState extends State{
	
	//Declare variables
	private Player player;//Player object

	//Constructor
	public GameState(){
		player = new Player(100,100);
	}
	@Override
	public void tick() {
		player.tick();
		
	}

	@Override
	public void paintComponent(Graphics g) {
		player.paintComponent(g);
		
	}

}
