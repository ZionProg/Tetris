package tilegame.board;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import tilegame.display.Display;
import tilegame.objects.T;
import tilegame.objects.I;
import tilegame.objects.L;
import tilegame.objects.O;
import tilegame.objects.S;
import tilegame.objects.Shape;
import tilegame.objects.square.Square;

public class Board {
	public static final Dimension DIMENSION = new Dimension(Display.DIMENSION.width / 30, Display.DIMENSION.height /30);
	private boolean[][] board;
	private Square[][] SquareLocation;
	private ArrayList<Shape> shapes;
	
	public Board(ArrayList<Shape> s) {
		board = new boolean[DIMENSION.height][DIMENSION.width];
		shapes = s;
	}
	
	public void incertToBoard(int col,int row) {
		board[row][col] = true;
	}
	
	public boolean[][] getBoard(){
		return board;
	}
	
	public void wasCollision() {
		Square[] squares = shapes.get(shapes.size()-1).getSquares();
		
		for (int i = 0; i < squares.length; i++) {
			Point point = squares[i].getPosition();
			board[(int)point.y / 30][(int)point.x / 30] = true;
		}
		Shape newShape = null;
		
		int random = (int) Math.ceil(Math.random() * 6);

		System.out.println(random);
		
		switch (random) {
		case 1:
			newShape = new S();
			break;
		case 2:
			newShape = new I();
			break;
		case 3:
			newShape = new O();
			break;	
		case 4:
			newShape = new T();
			break;
		case 5:
			newShape = new L();
			break;
		}
		shapes.add(newShape);	
	}
}
