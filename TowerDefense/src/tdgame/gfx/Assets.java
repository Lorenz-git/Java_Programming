package tdgame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage grass, rock, path, empty;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		grass = sheet.crop(0, 0, width, height);
		rock = sheet.crop(width, 0, width, height);
		path = sheet.crop(2 * width, 0, width, height);
		empty = sheet.crop(3 * width, 0, width, height);
		
		
	}
	
}
