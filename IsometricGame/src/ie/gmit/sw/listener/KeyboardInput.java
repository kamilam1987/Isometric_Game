package ie.gmit.sw.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Used to control keyboard input with specified direction
 * @author Kamila Michel
 *
 */
public class KeyboardInput implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right;//Directions on the map

	public KeyboardInput() {
		keys = new boolean[256];// separate id for each key on the keyboard
	}

	/**
	 * Sets keyboard inputs for moving direction
	 */
	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
