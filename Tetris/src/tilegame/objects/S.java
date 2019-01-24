package tilegame.objects;

import java.awt.Point;

import tilegame.gfx.Assets;
import tilegame.objects.square.Square;

public class S extends Shape {

	public S(){
		buildShape();
	}
	
	@Override
	protected void buildShape() {
		//top-right   top-mid  bottom-mid  bottom-left
		//    [0]			  [1]			  [2]				 [3]
		
		Point topRight = new Point(30*7,30*0);
		Point topMid = new Point(30*6,30*0);
		Point bottomMid = new Point(30*6,30*1);
		Point bottomLeft = new Point(30*5,30*1);
		

		squares[0] = new Square(Assets.getInstance().getPurpleSquare(), new Point(topRight),new Point(1,1));
		squares[1] = new Square(Assets.getInstance().getPurpleSquare(), new Point(topMid),new Point(0,0));
		squares[2] = new Square(Assets.getInstance().getPurpleSquare(), new Point(bottomMid),new Point(0,0));
		squares[3] = new Square(Assets.getInstance().getPurpleSquare(), new Point(bottomLeft),new Point(-1,-1));
		
	}

}
