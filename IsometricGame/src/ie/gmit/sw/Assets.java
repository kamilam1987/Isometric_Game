package ie.gmit.sw;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {

	private static final int width = 32, height = 32;
	public static BufferedImage player, dirt, stone, tree;
	public static BufferedImage player1;
	public static BufferedImage grass;
	public static BufferedImage chest;
	public static BufferedImage water;
	public static BufferedImage three;
	

	// Loads everything for the game
	public static void init() {
		Sprite sheet = new Sprite(ImageLoader.loadImage("/images/sprites/default/sheet.png"));
		player1 = ImageLoader.loadImage("/images/sprites/person/0003.png");
		grass = ImageLoader.loadImage("/images/ground/0000.png");
		chest = ImageLoader.loadImage("/images/objects/0003.png");
		water = ImageLoader.loadImage("/images/ground/0004.png");
		three = ImageLoader.loadImage("/images/objects/0005.png");


		player = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		//grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, height, width, height);

	}

}
