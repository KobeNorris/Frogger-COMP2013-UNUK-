package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import main.Element.Background.BackgroundImageView;
import main.Element.Background.BackgroundImageView;
//import main.Element.End.EndView;
import main.Element.End.EndView;
import main.Element.Frogger.*;
import main.Element.Obstacle.Car.CarView;
import main.Element.Obstacle.ObstacleView;
import main.Element.Obstacle.Truck.ShortTruck.ShortTruckView;
import main.Element.Obstacle.Truck.LongTruck.LongTruckView;
import main.Element.Platform.Log.LogView;
import main.Element.Platform.Turtle.DryTurtle.DryTurtleView;
import main.Element.Platform.Turtle.WetTurtle.WetTurtleView;
import main.Element.Score.DigitView;
import main.Element.Score.PlayerScore.PlayerScoreView;
//import main.Element.Platform.Log.LogView;
//import main.Element.Platform.Turtle.DryTurtle.DryTurtleView;
//import main.Element.Platform.Turtle.WetTurtle.WetTurtleView;

public class GameApplication extends Application{
    private static GameApplication instance = null;
    String filePathToBackground = "file:src/img/Background/";
    String filePathToLog = "file:src/img/log/";
    String filePathToCar = "file:src/img/Obstacle/Car/";
    String filePathToTruck = "file:src/img/Obstacle/Truck/";
    String filePathToFrogger = "file:src/img/FroggerAction/";

    AnimationTimer timer;
    MyStage background;
    FroggerView frogger;
    DigitView playerScoreBoard[];

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
        BackgroundImageView froggerback = new BackgroundImageView();

        background.add(froggerback);

        background.add(new LogView("middle", -250, 170, 170, 170, 1));
        background.add(new LogView("middle", 0, 170, 170, 170, 1));
        background.add(new LogView("middle", 250, 170, 170, 170, 1));
        background.add(new LogView("middle", 500, 170, 170, 170, 1));
        background.add(new LogView("short", -200, 328,140, 140, 0.5));
        background.add(new LogView("short", 0, 328,140, 140, 0.5));
        background.add(new LogView("short", 200, 328,140, 140, 0.5));
        background.add(new LogView("short", 400, 328, 150, 150, 0.5));
        background.add(new LogView("short", 600, 328,140, 140, 0.5));
        background.add(new LogView("long", 0, 274,280, 280, 1.5));
        background.add(new LogView("long", 333, 274,280, 280, 1.5));
        background.add(new LogView("long", 666, 274,280, 280, 1.5));
        background.add(new EndView(14,97, 63, 63));
        background.add(new EndView(142,97, 63, 63));
        background.add(new EndView(271,97, 63, 63));
        background.add(new EndView(399,97, 63, 63));
        background.add(new EndView(528,97, 63, 63));

        background.add(new DryTurtleView(-100, 376, 130, 130, -1.25));
        background.add(new WetTurtleView(100, 376, 130, 130, -1.25));
        background.add(new DryTurtleView(300, 376, 130, 130, -1.25));
        background.add(new WetTurtleView(500, 376, 130, 130, -1.25));
        background.add(new DryTurtleView(700, 376, 130, 130, -1.25));

        background.add(new WetTurtleView(-150, 217, 130, 130, -1.25));
        background.add(new DryTurtleView(50, 217, 130, 130, -1.25));
        background.add(new WetTurtleView(250, 217, 130, 130, -1.25));
        background.add(new DryTurtleView(450, 217, 130, 130, -1.25));
        background.add(new WetTurtleView(650, 217, 130, 130, -1.25));

//        background.add(new CarView("right", 80, 701, 50, 2));
//        background.add(new CarView("right", 300, 701,  50, 2));
//        background.add(new CarView("right", 400, 701, 50, 2));
//        background.add(new CarView("right", 570, 701, 50, 2));
//        background.add(new ShortTruckView("right", 0, 649, 120, 1));
//        background.add(new ShortTruckView("right", 300, 649, 120, 1));
//        background.add(new ShortTruckView("right", 600, 649, 120, 1));
//        background.add(new ShortTruckView("right", 720, 649, 120, 1));
//        background.add(new CarView("left", 100, 597, 50, -1));
//        background.add(new CarView("left", 250, 597, 50, -1));
//        background.add(new CarView("left", 400, 597, 50, -1));
//        background.add(new CarView("left", 550, 597, 50, -1));
//        background.add(new LongTruckView("right", 0, 540, 200, 1));
//        background.add(new LongTruckView("right", 500, 540, 200, 1));
//        background.add(new CarView("left", 500, 490, 50, -5));

        background.add(new PlayerScoreView(110, 0, 90));
        initNumber(200, 30);

        frogger = new FroggerView();
        background.add(frogger);
        background.start();
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (frogger.checkScore())
                    updateScore(frogger.getPoints());
                if (frogger.getStop()) {
                    System.out.print("STOP:");
                    background.stopMusic();
                    stop();
                    background.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
//                    alert.setHeaderText("Your High Score: "+ frogger.getPoints()+"!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();
                }
            }
        };
    }

    public void updateScore(int num) {
        int shift = 0, digit, tempNum;
        for (int iTemp = 0; iTemp < 5; iTemp++){
            tempNum = num / 10;
            digit = num - tempNum * 10;
            num = tempNum;
            this.playerScoreBoard[iTemp].setDigit(digit);
            shift += 30;
        }
    }

    public void initNumber(double posX, double posY) {
        this.playerScoreBoard = new DigitView[5];
        int shift = 0;
        for (int iTemp = 0; iTemp < 5; iTemp++){
            this.playerScoreBoard[iTemp] = new DigitView(posX - shift, posY, 30);
            background.add(this.playerScoreBoard[iTemp]);
            shift += 30;
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
