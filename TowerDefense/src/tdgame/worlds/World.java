package tdgame.worlds;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import tdgame.Handler;
import tdgame.tiles.Tile;
import tdgame.utils.Point;
import tdgame.utils.Utils;

public class World {
	private Handler handler;
	private int height, width;
	private int[][] worldTiles;
	private int entryX, entryY, exitX, exitY;
	private Point[] worldPath;
	
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

		g.setColor(Color.black);
		for(int i = 1; i < worldPath.length; ++i) {
			g.drawLine((int)(worldPath[i-1].getX()*Tile.TILEWIDTH+0.5*Tile.TILEWIDTH), 
					   (int)(worldPath[i-1].getY()*Tile.TILEWIDTH+0.5*Tile.TILEWIDTH),
					   (int)(worldPath[i].getX()*Tile.TILEHEIGHT+0.5*Tile.TILEHEIGHT),
					   (int)(worldPath[i].getY()*Tile.TILEHEIGHT+0.5*Tile.TILEHEIGHT));
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[worldTiles[x][y]];
		if(t==null) {
			return Tile.emptyTile;
		}
		return t;
	}
	
	public void loadWorld(String path) {
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
		ArrayList<Point> points = new ArrayList<Point>();
		for(int i = width * height + 6; i < tokens.length; i += 2) {
			points.add(new Point(Utils.parseInt(tokens[i]), Utils.parseInt(tokens[i+1])));
		}
		worldPath = points.toArray(new Point[points.size()]);
	}
	
	public void saveWorld(String path) {
		try {
			PrintWriter writer = new PrintWriter(path);
			writer.println(width + " " + height); 
			writer.println(entryX + " " + entryY);
			writer.println(entryX + " " + entryY);
			for(int y = 0; y < height; ++y) {
				String line = "";
				for(int x = 0; x < width; ++x) {
					line= line+ worldTiles[x][y]+ " ";
				}
				writer.println(line);
			}
			String pathString = "";
			for(Point p : worldPath) {
				pathString += p.getX()+" "+p.getY()+" ";
			}
			writer.println(pathString);
			
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void placeTile(int x) {
		worldTiles[handler.getMouseManager().getMouseX()/Tile.TILEWIDTH][handler.getMouseManager().getMouseY()/Tile.TILEHEIGHT] = x;
	}
	
	public Level createLevel() {
		return new Level(this);
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

	public Point[] getWorldPath() {
		return worldPath;
	}

	public void setWorldPath(Point[] path) {
		this.worldPath = path;
	}



	
	
	
}
