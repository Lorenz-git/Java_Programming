package tdgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	private boolean[] keys;
	
	public KeyManager() {
		keys = new boolean[256];
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
		
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
		
	}
}
