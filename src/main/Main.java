package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.Actor.*;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    background = new MyStage();
	    Scene scene  = new Scene(background,600,800);

		BackgroundImage froggerback = new BackgroundImage("file:src/img/background.png");

		background.add(froggerback);

		background.add(new Log("file:src/img/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/img/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/img/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/img/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/img/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/img/logs.png", 300, 400, 276, -2));
		//background.add(new Log("file:src/img/logs.png", 300, 800, 276, -2));
		background.add(new Log("file:src/img/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/img/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/img/log3.png", 150, 490, 329, 0.75));
		//background.add(new Log("file:src/img/log3.png", 150, 570, 329, 0.75));

		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		animal = new Animal("file:src/img/froggerUp.png");
		background.add(animal);
		background.add(new Obstacle("file:src/img/truck1"+"Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/img/truck1"+"Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/img/truck1"+"Right.png", 600, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/img/truck1"+"Right.png", 720, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/img/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/img/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/img/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/img/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/img/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/img/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/img/car1Left.png", 500, 490, -5, 50, 50));
//		background.add(new Digit(0, 30, 60, 100, 25));
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		setNumber(0, 150, 35);
		start();
	}

	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints(), 150, 35);
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }

	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

//    public void setNumber(int n) {
//    	int shift = 0;
//    	while (n > 0) {
//    		  int d = n / 10;
//    		  int k = n - d * 10;
//    		  n = d;
//    		  background.add(new Digit(k, 30, 60, 100 - shift, 35));
//    		  shift+=30;
//    		}
//    }

	public void setNumber(int n, int posX, int posY) {
		int shift = 0;
		for (int iTemp = 0; iTemp < 5; iTemp++){
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			background.add(new Digit(k, 30, 60, posX - shift, posY));
			shift+=30;
		}
	}
}
