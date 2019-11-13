package tdgame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 128, height = 128;
	
	public static BufferedImage grass, rock, path, empty, blueEnemy, pathEntry, pathExit;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		grass = sheet.crop(0, 0, width, height);
		rock = sheet.crop(width, 0, width, height);
		path = sheet.crop(2 * width, 0, width, height);
		empty = sheet.crop(3 * width, 0, width, height);
		blueEnemy = sheet.crop(4* width, 0, width, height);
		pathEntry = sheet.crop(5* width, 0, width, height);
		pathExit = sheet.crop(6* width, 0, width, height);
	}
	
}
