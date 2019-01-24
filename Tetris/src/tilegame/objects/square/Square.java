package tilegame.objects.square;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import tilegame.board.Board;
import tilegame.display.Display;
import tilegame.interfaces.TickAndRender;
import tilegame.objects.I;
import tilegame.objects.S;
import tilegame.objects.Shape;

public class Square implements TickAndRender {
		
	public static final Dimension DIMENSION = new Dimension(30, 30);
	private Point position;
	private Point rank;
	private BufferedImage sprite; 
	private int numOfTicks;
	
	public Square(BufferedImage image,Point point,Point p) {
		sprite = image;
		position = point;
		numOfTicks  = 0;
		rank = p;
	}

	@Override
	public void tick() {
		if(numOfTicks++ == 60) {
			numOfTicks = 0;
			position.setLocation(position.x, position.y + 30);
		}		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, position.x, position.y,null);
	}

	public void Move(int xDirection,int yDirection,boolean stopTicks) {
		if(stopTicks)
			numOfTicks = 0;
		
		position.setLocation(position.x + xDirection, position.y + yDirection);
	}	
	
	public boolean collisionHandler(Board gameBoard,int xDirection,int yDirection) {
		boolean[][] board = gameBoard.getBoard();
		
		if((position.x + xDirection) >= Display.DIMENSION.getWidth() || (position.x + xDirection) < 0)
			return false;
		
		if((position.y + yDirection) >= Display.DIMENSION.getHeight()) {
			gameBoard.wasCollision();
			return false;
		}
				
		if(board[(int) ((position.y + yDirection) / DIMENSION.getHeight())][(int) ((position.x + xDirection) / DIMENSION.getWidth())] == true) {
			gameBoard.wasCollision();
			return false;
		}
		return true;
	}
	
	public Point checkWhichRank(Shape lastShape,boolean set) {
		Point newPoint = null;
		
		if(lastShape instanceof S)
			return rotateS(set);
		
		if (rank.equals(new Point(0,0))) {
			newPoint = new Point(0,0);
			return newPoint;
		}
		else if (rank.equals(new Point(-1,0))) {
			if (set)
				rank = new Point(0,1);
				
			newPoint = new Point(30,-30);
			if(lastShape instanceof I) {
				fixPosition(newPoint, -15, 15, 15,-15);
			}
			return newPoint;
		}
		else if (rank.equals(new Point(-2,0))) {
			if(set)
				rank = new Point(0,2);
				
			newPoint =  new Point(60,-60);
			if(lastShape instanceof I)
				fixPosition(newPoint, -15, 15, 15,-15);
			
			return newPoint;
		}
		else if (rank.equals(new Point(1,0))) {
			if(set)
				rank = new Point(0,-1);
				
			newPoint = new Point(-30,30);
			if(lastShape instanceof I)
				fixPosition(newPoint, 15, 15, -15,-15);
			
			return newPoint;
		}
		else if (rank.equals(new Point(2,0))) {
			if(set) 
				rank = new Point(0,-2);
				
			newPoint = new Point(-60, 60);
			if(lastShape instanceof I)
				fixPosition(newPoint, 15, 15, -15,-15);
				
			return newPoint;
		}
		else if (rank.equals(new Point(0,1))) {
			if(set)
				rank = new Point(1,0);
				
			newPoint = new Point(30,30);
			if(lastShape instanceof I)
				fixPosition(newPoint, -15, -15, -15,-15);
				
			return newPoint;
		}
		else if (rank.equals(new Point(0,2))) {
			if(set) 
				rank  = new Point(2,0);
				
			newPoint = new Point(60,60);
			if(lastShape instanceof I)
				fixPosition(newPoint, -15, -15, -15,-15);
				
			return newPoint;
		}
		else if (rank.equals(new Point(0,-1))) {
			if(set)
				rank = new Point(-1,0);

				newPoint = new Point(-30,-30);
			if(lastShape instanceof I)
				fixPosition(newPoint, 15, -15, 15,-15);
			
			return newPoint;
		}
		else if (rank.equals(new Point(0,-2))) {
			if(set)
				rank = new Point(-2,0);
			
			newPoint = new Point(-60,-60);
			if(lastShape instanceof I)
				fixPosition(newPoint, 15, -15, 15,-15);
				
			return newPoint;
		}
		newPoint = new Point(0,0);
		return newPoint;
	}
	
	private Point rotateS(boolean set) {
		if (rank.equals(new Point(1, 1))) {
			if(set) {
				rank = new Point(-1, 1);
			}
			return new Point(-60,0);
		}	
		else if (rank.equals(new Point(-1, -1))) {
			if (set) {
				rank = new Point(-1,2);
			}
			return new Point(0,-60);
		}
		else if (rank.equals(new Point(-1,1))) {
			if (set) {
				rank = new Point(1,1);
			}
			return new Point(60,0);
		}
		else if (rank.equals(new Point(-1,2))) {
			if (set) {
				rank = new Point(-1,-1);
			}
			return new Point(0, 60);
		}
		return new Point(0,0);
	}

	private void fixPosition(Point point,int a,int b,int c,int d) {
		point.x += a;
		point.x += b; //to fix position so that it will be synced with the screen
		point.y += c;
		point.y += d; //to fix position so that it will be synced with the screen
	}

	public Point getPosition() {
		return position;
	}	
	
	public void setPosition(Point point) {
		position = point;
	}
	
	public Point getRank() {
		return rank;
	}
	public void setRank(Point point) {
		rank = point;
	}
}
