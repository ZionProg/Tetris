package tilegame.states;

import java.awt.Graphics;

import tilegame.interfaces.TickAndRender;
import tilegame.keymanager.KeyManager;

public class State implements TickAndRender {
	private State whichState;
	//private MainMenu mainMenu;
	private GameState gameState;
	//private PauseState pauseState;
	//private LosingState losingState;
	//private WinState winState;

	State() { 
		// this constructor will prevent stack overflow.
		// this constructor will only be called from classes that are in the same package. 
		// classes from outside the package will only be able to use the constructor with the Assets parameter			  
	}
	
	public State(KeyManager key) {
		whichState = null;
		//mainMenu = new...
		gameState = new GameState(key);
	}
	
	@Override
	public void tick() {
		whichState.tick();
	}

	@Override
	public void render(Graphics g) {
		whichState.render(g);
	}
	
	public State getWhichState() {
		return whichState;
	}

	public void setWhichState(State whichState) {
		this.whichState = whichState;
	}
	
	public GameState getGameState() {
		return gameState;
	}
}
