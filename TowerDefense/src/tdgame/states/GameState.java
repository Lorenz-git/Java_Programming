package tdgame.states;

import java.awt.Graphics;

import tdgame.Handler;
import tdgame.entities.creatures.Creature;
import tdgame.worlds.World;

public class GameState extends State{
	
	private World world;
	
	private Creature creature;
	
	private Handler handler;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		this.handler = handler;
		
		creature = new Creature(handler, 300, 300);
	}
	
	public void tick() {
		world.tick();
		creature.tick();
		
	}

	public void render(Graphics g) {
		
		world.render(g);
		
		creature.render(g);
		
	}

}
