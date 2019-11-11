package tdgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tdgame.Handler;

public class KeyManager implements KeyListener{
	private boolean[] keys;
	
	public KeyManager() {
		keys = new boolean[256];
	}


	public void keyTyped(KeyEvent e) {
		
		
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;		
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
		
	}
	
	public boolean[] getKeys(){
		return keys;
	}
}
