package tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import tilegame.display.Display;
import tilegame.interfaces.TickAndRender;
import tilegame.keymanager.KeyManager;
import tilegame.states.State;

public class Game implements Runnable,TickAndRender {

	// Display variables (window+canvas)
	private Display display;
	private int width, height;
	private String title;
	///////////////////////////////////////////////////////////////

	// Thread variables
	private Thread thread;
	private boolean isRunning;
	///////////////////////////////////////////////////////////////

	// Graphics+Assests variables
	private BufferStrategy bufferStrategy;
	private int howManyBuffers;
	private Graphics graphics;
	/////////////////////////////////////////////////////////////////

	// Runnable+gameLoop variables
	private final int fps = 60; // how many ticks and render we want per one second
	private final double timePerTick = 1000000000 / fps;	// one second in nanos divided by the fps
	private double delta;
	private long now;
	private long lastTime;
	////////////////////////////////////////////////////////////////
	
	//State
	private State currentState;
	////////////////////////////////////////////////////////////////
	//keyManager
	private KeyManager keyListener;
	
	public Game(String t) {
		title = t;
		isRunning = false;
		howManyBuffers = 3; // 3 is the recommended and don't need more
	}

	private void init() { // initialize everything
		display = new Display(title);
		keyListener = new KeyManager();
		display.getFrame().addKeyListener(keyListener);
		currentState = new State(keyListener);
	}
	

	@Override
	public void run() {
		init();
		isRunning = true;
		delta = 0;
		now = 0;
		lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		currentState.setWhichState(currentState.getGameState());
		
		while (isRunning) { // Game loop
				now = System.nanoTime();
				delta += (now - lastTime) / timePerTick;
				timer += now - lastTime; // for checking fps ,can delete
				lastTime = now;
				
				if(delta >= 1) {
					tick();
					render(graphics);
					ticks++; // for checking fps can delete
					delta--;
				}
				
				// for checking fps, can delete
				if(timer >= 1000000000) {
					System.out.println("ticks and frames: " + ticks);
					ticks = 0;
					timer = 0;
				}		
			}
		}
	
	@Override
	public void tick() {	//Updates everything
		if (currentState.getWhichState() != null) {
			currentState.getWhichState().tick();
		}
	}

	@Override
	public void render(Graphics g) { // Draw everything
		bufferStrategy = display.getCanvas().getBufferStrategy(); // on which buffer to paint
		if (bufferStrategy == null) {
			display.getCanvas().createBufferStrategy(howManyBuffers);
			return; // only if there was no BS
		}
		g = bufferStrategy.getDrawGraphics(); // graphics gets his paint brash which allows it to paint
		// Clear before paint
		g.clearRect(0, 0, width, height); // clear the whole screen
	// Draw Here!
		if (currentState.getWhichState() != null) {
			currentState.getWhichState().render(g);
		}

		// End Drawing!
		bufferStrategy.show(); // this will draw everything on the buffers
		g.dispose(); // this will dispose of the graphics object	
	}

	public synchronized void start() {
		if (isRunning) // will check if game is already running so to not mess up the thread
			return;
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!isRunning) // same for not running
			return;
		isRunning = false;
		try {
			thread.join(); // closes the thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
