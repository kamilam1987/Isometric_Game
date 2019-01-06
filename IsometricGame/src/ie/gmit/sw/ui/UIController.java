package ie.gmit.sw.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import ie.gmit.sw.Handler;

public class UIController {

	private Handler handler;
	private ArrayList<UserInterface> obj;
	
	public UIController(Handler handler) {
		this.handler = handler;
		obj = new ArrayList<UserInterface>();
	}
	
	public void tick() {
		for(UserInterface o: obj)
			o.tick();
	}
	
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
