package course;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements KeyListener {
	
	public boolean up, down, left, right;

	
	public void keyTyped(KeyEvent e) {
		
	}

	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			up = true;
		}
		else if(code == KeyEvent.VK_S) {
			down = true;
		}
		else if(code == KeyEvent.VK_D) {
			right = true;
		}
		else if(code == KeyEvent.VK_A) {
			left = true;
		}
	}

	
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			up = false;
		}
		else if(code == KeyEvent.VK_S) {
			down = false;
		}
		else if(code == KeyEvent.VK_D) {
			right = false;
		}
		else if(code == KeyEvent.VK_A) {
			left = false;
		}
		
	}

}
