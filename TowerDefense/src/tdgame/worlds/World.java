package tdgame.worlds;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
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
		if(handler.getMouseManager().isLeftPressed()) {
			try {
				if(handler.getKeyManager().getKeys()[KeyEvent.VK_1]==true) {
					placeTile(0);
				}
				else if(handler.getKeyManager().getKeys()[KeyEvent.VK_2]==true) {
					placeTile(1);
				}
				else if(handler.getKeyManager().getKeys()[KeyEvent.VK_3]==true) {
					placeTile(2);
				}
				else if(handler.getKeyManager().getKeys()[KeyEvent.VK_4]==true) {
					placeTile(3);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
		width = 20;
		height = 15;
		worldTiles = new int[width][height];
		
		for(int x = 0; x < width; ++x) {
			for(int y = 0; y < height; ++y) {
				worldTiles[x][y] = 3;
			}
		}
	}
	
	private void saveWorld(String path) {
		
	}
	
	public void placeTile(int x) {
		worldTiles[handler.getMouseManager().getMouseX()/Tile.TILEWIDTH][handler.getMouseManager().getMouseY()/Tile.TILEHEIGHT] = x;
	}
	
	
}
