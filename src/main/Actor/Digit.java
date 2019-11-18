package main.Actor;

import javafx.scene.image.Image;
import main.Actor.Actor;

public class Digit extends Actor {
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int sizeX, int sizeY, int x, int y) {
		im1 = new Image("file:src/img/"+n+".png", sizeX, sizeY, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
