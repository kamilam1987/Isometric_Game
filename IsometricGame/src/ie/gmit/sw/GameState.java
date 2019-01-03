package ie.gmit.sw;

import java.awt.Graphics;

public class GameState extends State{
	
	//Declare variables
	private Player player;//Player object

	//Constructor
	public GameState(GameView gameView){
		super(gameView);
		player = new Player(gameView,100,100);
	}
	
	//Updates variables or objects
	@Override
	public void tick() {
		player.tick();
		
	}

	@Override
	public void paintComponent(Graphics g) {
		player.paintComponent(g);
		
	}

}
