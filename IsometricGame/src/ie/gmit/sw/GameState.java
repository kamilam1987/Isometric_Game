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

	@SuppressWarnings("exports")
	@Override
	public void paintComponent(Graphics g) {
		player.paintComponent(g);
		Tile.tiles[0].paintComponent(g, 0, 0);
		Tile.tiles[0].paintComponent(g, 20, 10);
		
		Tile.tiles[2].paintComponent(g, 0, 0);
		
	}

}
