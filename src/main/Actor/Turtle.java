package main.Actor;

import javafx.scene.image.Image;
import main.Actor.Actor;

public class Turtle extends Actor {
	Image turtle1;
	Image turtle2;
	Image turtle3;
	String filePath = "file:src/img/Turtle/";

	private int speed;
	int i = 1;
	boolean bool = true;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image(filePath + "turtleAnimation1.png", w, h, true, true);
		turtle2 = new Image(filePath + "turtleAnimation2.png", w, h, true, true);
		turtle3 = new Image(filePath + "turtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
