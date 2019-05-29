package ie.gmit.sw.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import ie.gmit.sw.Handler;

/**
 * Handles user interface objects 
 * Checks mouse click events
 * @author Kamilka
 *
 */
public class UIController {

	private Handler handler;
	private ArrayList<UserInterface> obj;
	
	/**
	 * @param handler object
	 */
	public UIController(Handler handler) {
		this.handler = handler;
		obj = new ArrayList<UserInterface>();
	}
	
	/**
	 * Loop thought objects and updates them
	 */
	public void tick() {
		for(UserInterface o: obj)
			o.tick();
	}
	
	/**
	 * Loop thought objects and paint them on the screen
	 */
	public void paintComponent(Graphics g) {
		for(UserInterface o: obj)
			o.paintComponent(g);
		
	}
	
	public void onMouseMove(MouseEvent e) {
		for(UserInterface o: obj)
			o.onMouseMove(e);

	}

	//Detect if the object is clicked
	public void onMouseRelease(MouseEvent e) {
		for(UserInterface o: obj)
			o.onMouseRelease(e);

	}
	
	public void addObj(UserInterface o) {
		obj.add(o);
	}
	
	public void removeObj(UserInterface o) {
		obj.remove(o);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<UserInterface> getObj() {
		return obj;
	}

	public void setObj(ArrayList<UserInterface> obj) {
		this.obj = obj;
	}
	
	
	
	
}
