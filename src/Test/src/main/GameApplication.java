package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Element.Background.BackgroundImageController;
import main.Element.Frogger.*;
import main.Element.Obstacle.Car.CarController;
import main.Element.Obstacle.ObstacleController;
import main.Element.Obstacle.Truck.ShortTruck.ShortTruckController;
import main.Element.Obstacle.Truck.LongTruck.LongTruckController;
import main.Element.Platform.Log.LogController;

public class GameApplication extends Application{
    private static GameApplication instance = null;
    String filePathToBackground = "file:src/img/Background/";
    String filePathToLog = "file:src/img/log/";
    String filePathToCar = "file:src/img/Obstacle/Car/";
    String filePathToTruck = "file:src/img/Obstacle/Truck/";
    String filePathToFrogger = "file:src/img/FroggerAction/";

    AnimationTimer timer;
    MyStage background;
    FroggerController frogger;

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
        BackgroundImageController froggerback = new BackgroundImageController(filePathToBackground + "background.png");

        background.add(froggerback);
        background.add(new LogController("short", 0, 165, 0.75,166, 166));
        background.add(new LogController("short", 220, 165, 0.75,166, 166));
        background.add(new LogController("short", 440, 165, 0.75,166, 166));
        background.add(new LogController("long", 400, 328, -2,276, 276));
        background.add(new LogController("long", 800, 328, -2,276, 276));
//        background.add(new LogController("short", 270, 150, 0.75,329, 329));
//        background.add(new LogController("short", 490, 150, 0.75,329, 329));

        background.add(new CarController("right", 80, 701, 2, 50, 50));
        background.add(new CarController("right", 300, 701, 2, 50, 50));
        background.add(new CarController("right", 400, 701, 2, 50, 50));
        background.add(new CarController("right", 570, 701, 2, 50, 50));
        background.add(new ShortTruckController("right", 0, 649, 1, 120, 120));
        background.add(new ShortTruckController("right", 300, 649, 1, 120, 120));
        background.add(new ShortTruckController("right", 600, 649, 1, 120, 120));
        background.add(new ShortTruckController("right", 720, 649, 1, 120, 120));
        background.add(new CarController("left", 100, 597, -1, 50, 50));
        background.add(new CarController("left", 250, 597, -1, 50, 50));
        background.add(new CarController("left", 400, 597, -1, 50, 50));
        background.add(new CarController("left", 550, 597, -1, 50, 50));
        background.add(new LongTruckController("right", 0, 540, 1, 200, 200));
        background.add(new LongTruckController("right", 500, 540, 1, 200, 200));
        background.add(new CarController("left", 500, 490, -5, 50, 50));

        frogger = new FroggerController();
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
