package tdgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tdgame.Handler;
import tdgame.utils.Utils;

public class KeyManager implements KeyListener{
	private Handler handler;
	private boolean[] keys;
	
	public KeyManager(Handler handler) {
		keys = new boolean[256];
		this.handler = handler;
	}


	public void keyTyped(KeyEvent e) {
		
		
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
		
		
		if(keys[KeyEvent.VK_S]&&keys[KeyEvent.VK_CONTROL]) {
			Utils.writeFileFromWorld("res/worlds/world2.txt", handler);
		}
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
		
	}
	
	public boolean[] getKeys(){
		return keys;
	}
}
