package tilegame.objects;

import tilegame.objects.square.Square;

public abstract class Shape {
	
	public final static byte SIZE = 4;
	protected boolean canMove;
	protected Square[] squares;
	
	public Shape() {
		squares = new Square[SIZE];
		canMove = true;
	}
	
	protected abstract void buildShape();
	
	public Square[] getSquares() {
		return squares;
	}
	
	public boolean getCanMove() {
		return canMove;
	}
	
	public void setCanMove(boolean bool) {
		canMove = bool;
	}
}
