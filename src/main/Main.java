package main;

import javafx.animation.AnimationTimer;
import main.Actor.*;

public class Main{
	AnimationTimer timer;
	MyStage background;
	Frogger frogger;
	public static void main(String[] args) {
		GameApplication test = GameApplication.getInstance();
		test.play();
	}
}
