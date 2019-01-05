package ie.gmit.sw;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {

	private Handler handler;// handler object
	private Player player;// player object
	private ArrayList<Entity> entities;// list of entities

	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		add(player);

	}

	public void tick() {
		for (int i=0; i<entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
		//player.tick();

	}

	public void paintComponent(Graphics g) {
		for (Entity e: entities ) {
			e.paintComponent(g);
		}
		//player.paintComponent(g);

	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	//Adss entity to ArrayList
	public void add(Entity e) {
		entities.add(e);
		
	}

}
