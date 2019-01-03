package ie.gmit.sw;

public abstract class Human extends Entity{

	//Declare variables
	protected int health; // Human health
	
	//Human constructor that takes x,y position
	public Human(float x, float y) {
		super(x, y);
		health = 5;
	}

}
