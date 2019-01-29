package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	private boolean[] keys = new boolean[200];
	public boolean up, down, left, right,space, one, two;;
	
	
	public void update(){
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A]; // 37 - 65
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D]; // 39 - 68
		space = keys[KeyEvent.VK_SPACE];
		two = keys[KeyEvent.VK_2];
		one = keys[KeyEvent.VK_1];
	        
		/*for(int i = 0; i < keys.length; i++){
			if(keys[i]) 
			   System.out.println("KEY: " +i);
		}
		*/
		//System.out.println("KEY: " +KeyEvent.VK_A);
	}



	public void keyPressed(KeyEvent ke) {
     keys[ke.getKeyCode()] = true; // getKeyCode gets the ID of the key pressed; if the key a is pressed, ID = 65, and keys[65] = true 
		
	}


	public void keyReleased(KeyEvent ke) {
		keys[ke.getKeyCode()] = false; // set the released key to false
		
	}


	public void keyTyped(KeyEvent ke) {
		keys[ke.getKeyCode()] = false;
		
	}
	

}
