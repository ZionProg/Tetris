package tilegame.objects;

import java.awt.Point;

import tilegame.display.Display;
import tilegame.gfx.Assets;
import tilegame.objects.square.Square;

public class T extends Shape {
	
	public T() {
		buildShape();
	}

	@Override
	protected void buildShape() {
		// up		  left     down	right
		// [0]		  [1]	      [2]	     [3]
		
//		Point up = new Point(Display.DIMENSION.width / 2, 30);
//		Point left = new Point((int)(up.x - Square.DIMENSION.getWidth()),30 + 30);
//		Point down = new Point(up.x, 30+30);
//		Point right = new Point((int)(up.x + Square.DIMENSION.getWidth()), 30+30);
		
		Point up = new Point(30*7,0);
		Point left = new Point(30*6,0+30);
		Point down = new Point(30*7,0+30);
		Point right = new Point(30*8,0+30);

		squares[0] = new Square(Assets.getInstance().getRedSquare(), new Point(up),new Point(0,1));
		squares[1] = new Square(Assets.getInstance().getRedSquare(), new Point(left),new Point(-1,0));
		squares[2] = new Square(Assets.getInstance().getRedSquare(), new Point(down),new Point(0,0));
		squares[3] = new Square(Assets.getInstance().getRedSquare(), new Point(right),new Point(1,0));
	}
}
