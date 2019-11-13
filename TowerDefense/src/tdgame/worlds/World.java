package tdgame.worlds;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import tdgame.Handler;
import tdgame.tiles.Tile;
import tdgame.utils.Utils;

public class World {
	private Handler handler;
	private int height, width;
	private int[][] worldTiles;
	private int entryX, entryY, exitX, exitY;
	
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
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		
		entryX = Utils.parseInt(tokens[2]);
		entryY = Utils.parseInt(tokens[3]);
		exitX = Utils.parseInt(tokens[4]);
		exitY = Utils.parseInt(tokens[5]);
		
		worldTiles = new int[width][height];
		for(int x = 0; x < width; ++x) {
			for(int y = 0; y < height; ++y) {
				worldTiles[x][y] = Utils.parseInt(tokens[(x+y*width)+6]);
			}
		}
	}
	
	public void saveWorld(String path, Handler handler) {
		Utils.writeFileFromWorld(path, handler);
	}
	
	public void placeTile(int x) {
		worldTiles[handler.getMouseManager().getMouseX()/Tile.TILEWIDTH][handler.getMouseManager().getMouseY()/Tile.TILEHEIGHT] = x;
	}
	
	//GETTERS AND SETTERS
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getEntryX() {
		return entryX;
	}

	public void setEntryX(int entryX) {
		this.entryX = entryX;
	}

	public int getEntryY() {
		return entryY;
	}

	public void setEntryY(int entryY) {
		this.entryY = entryY;
	}

	public int getExitX() {
		return exitX;
	}

	public void setExitX(int exitX) {
		this.exitX = exitX;
	}

	public int getExitY() {
		return exitY;
	}

	public void setExitY(int exitY) {
		this.exitY = exitY;
	}
	
	public int[][] getWorldTiles() {
		return worldTiles;
	}



	
	
	
}
