package tdgame.entities.creatures;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import tdgame.Handler;
import tdgame.entities.Entity;
import tdgame.gfx.Assets;

public class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 1f;
	public static final int DEFAULT_CREATURE_WIDTH=32;
	public static final int DEFAULT_CREATURE_HEIGHT=32;
	

	private Handler handler;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y) {
		super(x, y, Creature.DEFAULT_CREATURE_HEIGHT, Creature.DEFAULT_CREATURE_WIDTH);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		this.handler = handler;
		
		xMove=0;
		yMove=0;
	}
	
	public void move() {
		x+=xMove;
		y+=yMove;
	}

	public void tick() {
		getInput();
		move();
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().getKeys()[KeyEvent.VK_W]) {
			yMove = -speed;
		}
		if(handler.getKeyManager().getKeys()[KeyEvent.VK_S]) {
			yMove = speed;
		}
		if(handler.getKeyManager().getKeys()[KeyEvent.VK_A]) {
			xMove = -speed;
		}
		if(handler.getKeyManager().getKeys()[KeyEvent.VK_D]) {
			xMove = speed;
		}
	}


	public void render(Graphics g) {
		g.drawImage(Assets.blueEnemy, (int)x, (int)y, width, height, null);
	}
	
	//GET AND SET
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
}
