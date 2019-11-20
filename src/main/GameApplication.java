package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.Actor.*;

public class GameApplication extends Application{
    private static GameApplication instance = null;
    String filePathToBackground = "file:src/img/Background/";
    String filePathToLog = "file:src/img/log/";
    String filePathToCar = "file:src/img/Obstacle/Car/";
    String filePathToTruck = "file:src/img/Obstacle/Truck/";
    String filePathToFrogger = "file:src/img/FroggerAction/";

    AnimationTimer timer;
    MyStage background;
    Frogger frogger;

    public static GameApplication getInstance(){
        if(instance == null)
            instance = new GameApplication();
        return instance;
    }


    public void play(){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        background = new MyStage();
        Scene scene  = new Scene(background,600,800);

        initGameBackGround();
        primaryStage.setScene(scene);
        primaryStage.show();
        start();
    }

    public void initGameBackGround(){
        BackgroundImage froggerback = new BackgroundImage(filePathToBackground + "background.png");

        background.add(froggerback);
        background.add(new Log(filePathToLog + "log3.png", 150, 0, 166, 0.75));
        background.add(new Log(filePathToLog + "log3.png", 150, 220, 166, 0.75));
        background.add(new Log(filePathToLog + "log3.png", 150, 440, 166, 0.75));
        background.add(new Log(filePathToLog + "logs.png", 300, 400, 276, -2));
        background.add(new Log(filePathToLog + "logs.png", 300, 800, 276, -2));
        background.add(new Log(filePathToLog + "log3.png", 150, 270, 329, 0.75));
        background.add(new Log(filePathToLog + "log3.png", 150, 490, 329, 0.75));

        background.add(new Turtle(500, 376, -1, 130, 130));
        background.add(new Turtle(300, 376, -1, 130, 130));
        background.add(new WetTurtle(700, 376, -1, 130, 130));
        background.add(new WetTurtle(600, 217, -1, 130, 130));
        background.add(new WetTurtle(400, 217, -1, 130, 130));
        background.add(new WetTurtle(200, 217, -1, 130, 130));
        background.add(new End(13,96));
        background.add(new End(141,96));
        background.add(new End(270,96));
        background.add(new End(399,96));
        background.add(new End(528,96));
        background.add(new Obstacle(filePathToCar + "car1Right.png", 80, 701, 2, 50, 50));
        background.add(new Obstacle(filePathToCar + "car1Right.png", 300, 701, 2, 50, 50));
        background.add(new Obstacle(filePathToCar + "car1Right.png", 400, 701, 2, 50, 50));
        background.add(new Obstacle(filePathToCar + "car1Right.png", 570, 701, 2, 50, 50));
        background.add(new Obstacle(filePathToTruck + "truck1"+"Right.png", 0, 649, 1, 120, 120));
        background.add(new Obstacle(filePathToTruck + "truck1"+"Right.png", 300, 649, 1, 120, 120));
        background.add(new Obstacle(filePathToTruck + "truck1"+"Right.png", 600, 649, 1, 120, 120));
        background.add(new Obstacle(filePathToTruck + "truck1"+"Right.png", 720, 649, 1, 120, 120));
        background.add(new Obstacle(filePathToCar + "car1Left.png", 100, 597, -1, 50, 50));
        background.add(new Obstacle(filePathToCar + "car1Left.png", 250, 597, -1, 50, 50));
        background.add(new Obstacle(filePathToCar + "car1Left.png", 400, 597, -1, 50, 50));
        background.add(new Obstacle(filePathToCar + "car1Left.png", 550, 597, -1, 50, 50));
        background.add(new Obstacle(filePathToTruck + "truck2Right.png", 0, 540, 1, 200, 200));
        background.add(new Obstacle(filePathToTruck + "truck2Right.png", 500, 540, 1, 200, 200));
        background.add(new Obstacle(filePathToCar + "car1Left.png", 500, 490, -5, 50, 50));
        frogger = new Frogger(filePathToFrogger + "froggerUp.png");
        background.add(frogger);
        setNumber(0, 150, 35);
        background.start();
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (frogger.changeScore())
                    setNumber(frogger.getPoints(), 150, 35);
                if (frogger.getStop()) {
                    System.out.print("STOP:");
                    background.stopMusic();
                    stop();
                    background.stop();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+ frogger.getPoints()+"!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();
                }
            }
        };
    }

    public void setNumber(int num, int posX, int posY) {
        int shift = 0, digit, tempNum;
        for (int iTemp = 0; iTemp < 5; iTemp++){
            tempNum = num / 10;
            digit = num - tempNum * 10;
            num = tempNum;
            background.add(new Digit(digit, 30, 60, posX - shift, posY));
            shift+=30;
        }
    }

    public void stop() {
        timer.stop();
    }

    public void start() {
        background.playMusic();
        createTimer();
        timer.start();
    }
}
