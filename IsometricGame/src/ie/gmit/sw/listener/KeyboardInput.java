package ie.gmit.sw.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right;

	public KeyboardInput() {
		keys = new boolean[256];// separate id for each key on the keyboard
	}

	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
