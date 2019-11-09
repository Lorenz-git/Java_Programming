package tdgame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import tdgame.Handler;

public class MouseManager implements MouseListener, MouseMotionListener{

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	
	
	public MouseManager() {

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
		// TODO Auto-generated method stub
		
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

}
