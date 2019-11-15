package tdgame.input;

import java.awt.FileDialog;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import tdgame.Handler;
import tdgame.states.State;
import tdgame.utils.Utils;

public class KeyManager implements KeyListener{
	private Handler handler;
	private boolean[] keys;
	
	public KeyManager(Handler handler) {
		keys = new boolean[256];
		this.handler = handler;
	}
	
	public void tick() {
		
	}


	public void keyTyped(KeyEvent e) {
		
		
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
		
		//MAP EDITOR KEYBOARD CONTROLS
		if(State.getState() instanceof tdgame.states.MapEditorState) {
			//SAVE CURRENT WORLD
			if(keys[KeyEvent.VK_S]&&keys[KeyEvent.VK_CONTROL]) {
				FileDialog fd = new FileDialog(handler.getGame().getDisplay().getFrame(), "Select where to save the map", FileDialog.SAVE);
				fd.setDirectory("C:\\");
				fd.setFile("*.txt");
				fd.setVisible(true);
				String filename = fd.getDirectory() + fd.getFile();
				handler.getWorld().saveWorld(filename);
				
				keys[KeyEvent.VK_S]=false;
				keys[KeyEvent.VK_CONTROL]=false;
			}
			//LOAD WORLD
			if(keys[KeyEvent.VK_O]&&keys[KeyEvent.VK_CONTROL]) {
				FileDialog fd = new FileDialog(handler.getGame().getDisplay().getFrame(), "Choose a map to load", FileDialog.LOAD);
				fd.setDirectory("C:\\");
				fd.setFile("*.txt");
				fd.setVisible(true);
				String filename = fd.getDirectory() + fd.getFile();
				handler.getWorld().loadWorld(filename);
				
				keys[KeyEvent.VK_O]=false;
				keys[KeyEvent.VK_CONTROL]=false;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
		
	}
	
	public boolean[] getKeys(){
		return keys;
	}
}
