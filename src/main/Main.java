package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.Actor.*;

public class Main{
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	public static void main(String[] args) {
		GameApplication test = GameApplication.getInstance();
		test.play();
//		GameApplication test2 = new GameApplication();
//		test2.play();
	}
}
