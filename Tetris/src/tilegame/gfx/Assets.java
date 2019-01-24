package tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static Assets assets = new Assets();
	//sprites---------------------------------------------
	private BufferedImage redSquare;
	private BufferedImage blueSquare;
	private BufferedImage purpleSquare;
	private BufferedImage yellowSquare;
	private BufferedImage orangeSquare;
	private BufferedImage paleBlueSquare;
	private BufferedImage greenSquare;

	private Assets() {
		//SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/mysheet.png"));
		redSquare = ImageLoader.loadImage("/textures/red.png");
		blueSquare = ImageLoader.loadImage("/textures/blue.png");
		purpleSquare = ImageLoader.loadImage("/textures/purple.png");
		yellowSquare = ImageLoader.loadImage("/textures/yellow.png");
		orangeSquare = ImageLoader.loadImage("/textures/orange.png");
		paleBlueSquare = ImageLoader.loadImage("/textures/paleBlue.png");
		greenSquare = ImageLoader.loadImage("/textures/green.png");
		//sprites--------------------------------------------------	
	}	
	public static Assets getInstance() {
		return assets;
	}
	
	public BufferedImage getRedSquare() {
		return redSquare;
	}
	public BufferedImage getBlueSquare() {
		return blueSquare;
	}
	public BufferedImage getPurpleSquare() {
		return purpleSquare;
	}
	public BufferedImage getYellowSquare() {
		return yellowSquare;
	}
	public BufferedImage getOrangeSquare() {
		return orangeSquare;
	}
	public BufferedImage getPaleBlueSquare() {
		return paleBlueSquare;
	}
	public BufferedImage getGreenSquare() {
		return greenSquare;
	}
	
	
}
