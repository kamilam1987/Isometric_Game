package ie.gmit.sw;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

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
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
		// player.tick();
		// Sort entities array
		entities.sort(sorter);

	}

	public void paintComponent(Graphics g) {
		for (Entity e : entities) {
			e.paintComponent(g);
		}
		// player.paintComponent(g);

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

	// Adss entity to ArrayList
	public void add(Entity e) {
		entities.add(e);

	}

	private Comparator<Entity> sorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity first, Entity second) {
			// Sort entity and checks which entity should be render first
			if (first.getY() + first.getHeight() < second.getY() + second.getHeight())
				return -1;
			return 1;
		}

	};// Compares entity

}
