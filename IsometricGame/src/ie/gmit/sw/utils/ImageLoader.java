package ie.gmit.sw.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/*private BufferedImage[] loadImages(String directory, BufferedImage[] img) throws Exception {
	File dir = new File(directory);
	File[] files = dir.listFiles();
	Arrays.sort(files, (s, t) -> s.getName().compareTo(t.getName()));

	img = new BufferedImage[files.length];
	for (int i = 0; i < files.length; i++) {
		img[i] = ImageIO.read(files[i]);
	}
	return img;
}*/

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
