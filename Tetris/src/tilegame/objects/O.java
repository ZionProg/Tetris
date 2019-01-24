package tilegame.objects;

import java.awt.Point;

import tilegame.gfx.Assets;
import tilegame.objects.square.Square;

public class O  extends Shape{

	public O(){
		buildShape();
	}
	
	@Override
	protected void buildShape() {
		//top-right        top-left          bottom-right          bottom-left
		//    [0]                 [1]                      [3]                       [2]
		Point topLeft = new Point(30*6,30*0);
		Point topRight = new Point(30*7,30*0);
		Point bottomLeft = new Point(30*6,30*1);
		Point bottomRight = new Point(30*7,30*1);
		

		squares[0] = new Square(Assets.getInstance().getOrangeSquare(), new Point(topLeft),new Point(-1,1));
		squares[1] = new Square(Assets.getInstance().getOrangeSquare(), new Point(topRight),new Point(1,1));
		squares[2] = new Square(Assets.getInstance().getOrangeSquare(), new Point(bottomLeft),new Point(-1,-1));
		squares[3] = new Square(Assets.getInstance().getOrangeSquare(), new Point(bottomRight),new Point(1,-1));
		
	}

}
