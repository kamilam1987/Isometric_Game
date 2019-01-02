package ie.gmit.sw;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width= 32, height = 32;
	public static BufferedImage player, dirt, grass, stone, tree;
	//Loads everything for the game
	public static void init() {
		Sprite sheet = new Sprite(ImageLoader.loadImage("/images/sprites/default/sheet.png"));
		
		player = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width *2, 0, width, height);
		stone = sheet.crop(width*3, 0, width, height);
		tree = sheet.crop(0, height, width, height);
		
	}
	
	

}
