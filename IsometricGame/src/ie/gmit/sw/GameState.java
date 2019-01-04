package ie.gmit.sw;

import java.awt.Graphics;

public class GameState extends State{
	
	//Declare variables
	private Player player;//Player object
	private Environment environment;

	//Constructor
	public GameState(GameView gameView){
		super(gameView);
		player = new Player(gameView,100,100);
		environment = new Environment("resources/environment/environment.txt");
	}
	
	//Updates variables or objects
	@Override
	public void tick() {
		environment.tick();
		player.tick();
		
	}

	@SuppressWarnings("exports")
	@Override
	public void paintComponent(Graphics g) {
		environment.paintComponent(g);
		player.paintComponent(g);
		//Tile.tiles[3].paintComponent(g, 0, 0);
		//Tile.tiles[0].paintComponent(g, 20, 10);
		
		//Tile.tiles[2].paintComponent(g, 0, 0);
		
	}

}
