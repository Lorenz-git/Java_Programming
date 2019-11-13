package tdgame.states;

import java.awt.Graphics;

import tdgame.Handler;
import tdgame.worlds.World;

public class MapEditorState extends State{

private World world;
		
	private Handler handler;

	public MapEditorState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		this.handler = handler;
	}
	
	public void tick() {
		world.tick();		
	}

	public void render(Graphics g) {
		world.render(g);
	}

}
