package tilegame.objects;

import java.awt.Point;

import tilegame.gfx.Assets;
import tilegame.objects.square.Square;

public class I extends Shape{

	public I() {
		buildShape();
	}
	
	@Override
	protected void buildShape() {
		//top right    middle right   middle left  top left
		//    [0]               [1]                  [2]           [3]
		
		Point topRight = new Point(30*5,0);
		Point midRight = new Point(30*6,0);
		Point midLeft = new Point(30*7,0);
		Point topLeft = new Point(30*8,0);

		squares[0] = new Square(Assets.getInstance().getBlueSquare(), new Point(topRight),new Point(-2,0));
		squares[1] = new Square(Assets.getInstance().getBlueSquare(), new Point(midRight),new Point(-1,0));
		squares[2] = new Square(Assets.getInstance().getBlueSquare(), new Point(midLeft),new Point(1,0));
		squares[3] = new Square(Assets.getInstance().getBlueSquare(), new Point(topLeft),new Point(2,0));
	}
}
