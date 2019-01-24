package tilegame.keymanager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tilegame.Game;
import tilegame.states.GameState;
import tilegame.states.State;

public class KeyManager implements KeyListener {
	
	private State StateReference;
	
	public KeyManager() {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(StateReference instanceof GameState) {
			if(e.getKeyCode() == KeyEvent.VK_UP)
				((GameState) StateReference).needReverse();
			
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				((GameState) StateReference).needMove(30,0);
			
			else if (e.getKeyCode() == KeyEvent.VK_LEFT)
				((GameState) StateReference).needMove(-30,0);
			
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				((GameState) StateReference).needMove(0,30);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(" is relesed");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setState(State state) {
		StateReference = state;
	}
}
