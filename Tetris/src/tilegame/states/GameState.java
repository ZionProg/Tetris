package tilegame.states;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import tilegame.board.Board;
import tilegame.display.Display;
import tilegame.keymanager.KeyManager;
import tilegame.objects.L;
import tilegame.objects.I;
import tilegame.objects.Shape;
import tilegame.objects.O;
import tilegame.objects.S;
import tilegame.objects.square.Square;

public class GameState extends State {
	private KeyManager keyManager;
	private ArrayList<Shape> shapes;
	private Board gameBoard;
	
	public GameState(KeyManager key) {
		keyManager = key;
		keyManager.setState(this); // need to delete
		shapes = new ArrayList<>();
		shapes.add(new I()); // need edit
		gameBoard = new Board(shapes);
	}
	
	@Override
	public void tick() {
		Shape lastShape = shapes.get(shapes.size()-1);	
		Square[] squares = lastShape.getSquares();
	
		for (int i = 0; i < squares.length; i++) {
			if(lastShape.getCanMove())
			lastShape.setCanMove(squares[i].collisionHandler(gameBoard, 0, 30));
	}	
		if(lastShape.getCanMove()) {
			for (int i = 0; i < squares.length; i++) {
				squares[i].tick();
			}
		}
		lastShape.setCanMove(true);
	}
	
	@Override
	public void render(Graphics g) {
		g.clearRect(0, 0, Display.DIMENSION.width, Display.DIMENSION.height);
		for (int i = 0; i < shapes.size(); i++) {
			Square[] squares = shapes.get(i).getSquares();
			for (int j = 0;j < squares.length; j++) {
					squares[j].render(g);
				}
			}
		}
	
	public void needMove(int xDirection,int yDirection) {
		Shape lastShape = shapes.get(shapes.size()-1);
		Square[] squares = lastShape.getSquares();
			
		for (int i = 0; i < squares.length; i++) {
				if(lastShape.getCanMove())
					lastShape.setCanMove(squares[i].collisionHandler(gameBoard, xDirection, yDirection));
		}
		
		if (lastShape.getCanMove()) {
			for (int i = 0; i < squares.length; i++) {
				squares[i].Move(xDirection,yDirection,true);
			}
		}
		lastShape.setCanMove(true);
	}
	
	public void needReverse() {
		Shape lastShape = shapes.get(shapes.size()-1);
		Square[] squares = lastShape.getSquares();
		Point direction = new Point(0,0);
		
		for (int i = 0; i < squares.length; ++i) {
			if(lastShape.getCanMove()) {
				direction = squares[i].checkWhichRank(lastShape,false);
				lastShape.setCanMove(squares[i].collisionHandler(gameBoard, direction.x, direction.y));
			}	
		}
		
		if (lastShape.getCanMove()) {
			for (int i = 0; i < squares.length; ++i) {
				direction = squares[i].checkWhichRank(lastShape,true);
				squares[i].Move(direction.x, direction.y,false);
			}
		}
		lastShape.setCanMove(true);
	}
}
