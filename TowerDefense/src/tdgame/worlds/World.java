package tdgame.worlds;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import tdgame.Handler;
import tdgame.tiles.Tile;

public class World {
	private Handler handler;
	private int height, width;
	private int[][] worldTiles;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for(int y = 0; y < height; ++y) {
			for(int x = 0; x < width; ++x) {
				getTile(x,y).render(g, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[worldTiles[x][y]];
		if(t==null) {
			return Tile.emptyTile;
		}
		return t;
		
	}
	
	private void loadWorld(String path) {
		width = 5;
		height = 5;
		worldTiles = new int[width][height];
		
		for(int x = 0; x < width; ++x) {
			for(int y = 0; y < height; ++y) {
				worldTiles[x][y] = 3;
			}
		}
	}
	
	public void placeTile(MouseEvent e) {
		
	}
	
	
}
