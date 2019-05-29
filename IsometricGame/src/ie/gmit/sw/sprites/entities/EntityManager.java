package ie.gmit.sw.sprites.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import ie.gmit.sw.Handler;

/**
 * Manages all entities in a game which are hold in ArrayList
 * @author Kamila Michel
 *
 */
public class EntityManager {

	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;// Holds list of entities

	/**
	 * @param handler object
	 * @param player Stores player object
	 */
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		add(player);//Adds player

	}

	/**
	 * Loop true entities objects and update them
	 * Sort entities
	 */
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

	/**
	 * @return handler object
	 */
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
 
	/**
	 * @return player object
	 */
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return entities object
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	/**
	 * @param e Adds entity to ArrayList
	 */
	public void add(Entity e) {
		entities.add(e);

	}

	/**
	 * Sort entity and checks which entity should be render first
	 */
	private Comparator<Entity> sorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity first, Entity second) {
			if (first.getY() + first.getHeight() < second.getY() + second.getHeight())
				return -1;
			return 1;
		}

	};// Compares entity

}
