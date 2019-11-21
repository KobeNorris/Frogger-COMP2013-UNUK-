package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.Element.Frogger.*;
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
    FroggerViewer frogger;

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
        frogger = frogger.getFrogger();
        frogger.init();
        background.add(frogger);
        background.start();
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
//                if (frogger.changeScore())
//                    setNumber(frogger.getPoints(), 150, 35);
//                if (frogger.getStop()) {
//                    System.out.print("STOP:");
//                    background.stopMusic();
//                    stop();
//                    background.stop();
//                    Alert alert = new Alert(AlertType.INFORMATION);
//                    alert.setTitle("You Have Won The Game!");
////                    alert.setHeaderText("Your High Score: "+ frogger.getPoints()+"!");
//                    alert.setContentText("Highest Possible Score: 800");
//                    alert.show();
//                }
            }
        };
    }

//    public void setNumber(int num, int posX, int posY) {
//        int shift = 0, digit, tempNum;
//        for (int iTemp = 0; iTemp < 5; iTemp++){
//            tempNum = num / 10;
//            digit = num - tempNum * 10;
//            num = tempNum;
//            background.add(new Digit(digit, 30, 60, posX - shift, posY));
//            shift+=30;
//        }
//    }

    public void stop() {
        timer.stop();
    }

    public void start() {
        background.playMusic();
        createTimer();
        timer.start();
    }
}
