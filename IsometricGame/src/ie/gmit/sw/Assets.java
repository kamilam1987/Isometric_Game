package ie.gmit.sw;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {

	private static final int width = 32, height = 32;
	public static BufferedImage player, dirt, stone, tree;
	//public static BufferedImage player1;
	public static BufferedImage[] player_front;
	public static BufferedImage[] player_back;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage grass;
	public static BufferedImage chest;
	public static BufferedImage water;
	public static BufferedImage three;
	public static BufferedImage[] start_button;
	

	// Loads everything for the game
	public static void init() {
		Sprite sheet = new Sprite(ImageLoader.loadImage("/images/sprites/default/sheet.png"));
		
		//player1 = ImageLoader.loadImage("/images/sprites/person/0003.png");
		grass = ImageLoader.loadImage("/images/ground/0000.png");
		chest = ImageLoader.loadImage("/images/objects/0003.png");
		water = ImageLoader.loadImage("/images/ground/0004.png");
		three = ImageLoader.loadImage("/images/objects/0005.png");

		player_front = new BufferedImage[3];
		player_front[0] = ImageLoader.loadImage("/images/sprites/person/0009.png");
		player_front[1] = ImageLoader.loadImage("/images/sprites/person/0010.png");
		player_front[2] = ImageLoader.loadImage("/images/sprites/person/0011.png");
		player_left = new BufferedImage[3];
		player_left[0] = ImageLoader.loadImage("/images/sprites/person/0003.png");
		player_left[1] = ImageLoader.loadImage("/images/sprites/person/0004.png");
		player_left[2] = ImageLoader.loadImage("/images/sprites/person/0005.png");
		player_right = new BufferedImage[3];
		player_right[0] = ImageLoader.loadImage("/images/sprites/person/0009.png");
		player_right[1] = ImageLoader.loadImage("/images/sprites/person/0010.png");
		player_right[2] = ImageLoader.loadImage("/images/sprites/person/0011.png");
		player_back =new BufferedImage[3];
		player_back[0] = ImageLoader.loadImage("/images/sprites/person/0000.png");
		player_back[1] = ImageLoader.loadImage("/images/sprites/person/0001.png");
		player_back[2] = ImageLoader.loadImage("/images/sprites/person/0002.png");
		
		start_button = new BufferedImage[2];
		start_button[0]= ImageLoader.loadImage("/images/sprites/default/start1.png");
		start_button[1]= ImageLoader.loadImage("/images/sprites/default/start2.png");
		
		
		player = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		//grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, height, width, height);
		

	}

}
