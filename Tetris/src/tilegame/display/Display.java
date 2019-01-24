package tilegame.display;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
	public static final Dimension DIMENSION = new Dimension(450, 660);
	private JFrame frame;
	private Canvas canvas;
	private String title;
	
	public Display(String t) {
		title = t;
		createDisplay();
	}
	
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(DIMENSION);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		canvas.setPreferredSize(DIMENSION);
		canvas.setMaximumSize(DIMENSION);
		canvas.setMinimumSize(DIMENSION);
		addToFrame(canvas);
		canvas.setFocusable(false);
		
	}
	
	public void addToFrame(Component c) {
		frame.add(c);
		
		if(c instanceof Canvas)
			frame.pack(); // adjust the window to the canvas
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	public JFrame getFrame() {
		return frame;
	}
}
