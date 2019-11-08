package tdgame.states;

import java.awt.Graphics;

import tdgame.tiles.Tile;
import tdgame.worlds.World;

public class GameState extends State{
	
	private World world;

	public GameState() {
		world = new World("");
	}
	
	public void tick() {
		world.tick();
		
	}

	public void render(Graphics g) {
		
		world.render(g);

	}

}
