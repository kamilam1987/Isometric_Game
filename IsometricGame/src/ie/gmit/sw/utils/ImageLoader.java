package ie.gmit.sw.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Loads images to the screen with specified path. Images are stored in BufferedImage object.
 * @author Kamilka
 *
 */
public class ImageLoader {
	@SuppressWarnings("exports")
	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
