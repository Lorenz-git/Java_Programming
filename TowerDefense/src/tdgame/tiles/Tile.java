package tdgame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256]; //all different tiles
	public static Tile emptyTile = new EmptyTile(0);
	public static Tile grassTile = new GrassTile(1);
	public static Tile rockTile = new RockTile(2);
	public static Tile pathTile = new PathTile(3);
	public static Tile pathEntryTile = new PathEntryTile(4);
	public static Tile pathExitTile = new PathExitTile(5);
	
	//CLASS
	public static final int TILEWIDTH = 48, TILEHEIGHT = 48;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}
	
}
