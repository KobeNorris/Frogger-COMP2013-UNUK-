package main.Actor;

import javafx.scene.image.Image;
import main.Actor.Actor;

public class Digit extends Actor {
	private String filePath = "file:src/img/Digit/";

	int dim;
	Image img;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int sizeX, int sizeY, int x, int y) {
		img = new Image(filePath + n + ".png", sizeX, sizeY, true, true);
		setImage(img);
		setX(x);
		setY(y);
	}
	
}
