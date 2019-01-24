package tilegame.objects;

import java.awt.Point;

import tilegame.gfx.Assets;
import tilegame.objects.square.Square;

public class L extends Shape {

	public L() {
		buildShape();
	}
	
	@Override
	protected void buildShape() {
		
		//[top]         [mid]         [bottom]     [bottom-right]
		// [0]             [1]              [2]                   [3]
		
		Point top = new Point(30*5,30*0);
		Point mid = new Point(30*5,30*1);
		Point bottom = new Point(30*5,30*2);
		Point bottomRight = new Point(30*6,30*2);

		squares[0] = new Square(Assets.getInstance().getGreenSquare(), new Point(top),new Point(0,2));
		squares[1] = new Square(Assets.getInstance().getGreenSquare(), new Point(mid),new Point(0,1));
		squares[2] = new Square(Assets.getInstance().getGreenSquare(), new Point(bottom),new Point(0,0));
		squares[3] = new Square(Assets.getInstance().getGreenSquare(), new Point(bottomRight),new Point(1,0));
	}

}
