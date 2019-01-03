package ie.gmit.sw;

import java.awt.Graphics;

public abstract class Entity {
	
	//Declare variables
	protected float x, y;//position on the screen
	
	//Constructor takes x-axis and y-axis
	public Entity(float x, float y) {
		this.x = x;
		this.y= y;
	}
	
	//Updates variables
	public abstract void tick();
	//Draws to the screen
	public abstract void paintComponent(Graphics g);

}
