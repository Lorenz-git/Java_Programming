package tdgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import tdgame.Handler;
import tdgame.states.State;
import tdgame.utils.Utils;

public class MouseManager implements MouseListener, MouseMotionListener{
	
	private Handler handler;

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	
	
	public MouseManager(Handler handler) {
		this.handler= handler;
	}
	//GETTERS
	
	public boolean isLeftPressed() {
		return leftPressed;
	}
	
	public boolean isRightPressed() {
		return rightPressed;
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	//IMPLEMENTED METHODS
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	public void mouseClicked(MouseEvent e) {
		
		//MAP EDITOR MOUSE CONTROLS
		if(State.getState() instanceof tdgame.states.MapEditorState) {		
			//EDIT TILES
			if(e.getButton()== MouseEvent.BUTTON1) { 
				if(handler.getKeyManager().getKeys()[KeyEvent.VK_1]==true) {
					handler.getWorld().placeTile(0);
				}
				else if(handler.getKeyManager().getKeys()[KeyEvent.VK_2]==true) {
					handler.getWorld().placeTile(1);
				}
				else if(handler.getKeyManager().getKeys()[KeyEvent.VK_3]==true) {
					handler.getWorld().placeTile(2);
				}
				else if(handler.getKeyManager().getKeys()[KeyEvent.VK_4]==true) {
					handler.getWorld().placeTile(3);
				}
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			leftPressed=true;
		}
		else if(e.getButton()==MouseEvent.BUTTON3) {
			rightPressed=true;
		}
		
	}

	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			leftPressed=false;	
		}
		else if(e.getButton()==MouseEvent.BUTTON3) {
			rightPressed=false;
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
