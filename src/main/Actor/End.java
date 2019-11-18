package main.Actor;

import javafx.scene.image.Image;
import main.Actor.Actor;

public class End extends Actor {
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/img/End.png", 60, 60, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/img/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
