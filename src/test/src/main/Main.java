package main;

import controller.gameController.GameController;
import util.FileProcesscer;
import util.SceneSwitcher;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    private static AnimationTimer timer;
    private static Stage presentStage;
    private static GameController controller;
    public static int points = 0, diffficulty = 1;
    public static Stage getPresentStage(){return presentStage;}
    public static void setController(GameController targetController){controller = targetController;}

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.presentStage = primaryStage;
        SceneSwitcher.jumpToMenu();
    }

    /**
     * Create another thread to observe the update of the points & life of the frogger
     * and switch to other pages if the game is ended
     */
    public static void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long timer) {
                if (controller.frogger.checkScore())
                    controller.updateScore(controller.frogger.getPoints());
                if(controller.frogger.checkLife())
                    controller.updateLife(controller.frogger.getLife());
                if (controller.frogger.getStop()){
                    controller.frogger.resetFroggerModelToStart();
                    controller.stopGame();
                    stop();
                    try{
                        FileProcesscer i = new FileProcesscer(5);
                        i.readFile("src/resource/highScoreFile/rank.txt");
                        points = controller.frogger.getPoints();
                        if(i.checkInsertable(controller.frogger.getPoints())){
                            SceneSwitcher.jumpToInputName();
                        }else{
                            SceneSwitcher.jumpToHighScore();
                        }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    controller.frogger.resetPoints();
                }
            }
        };
    }

    /**
     * Create the observer and start the observation
     */
    public static void start() {
        createTimer();
        timer.start();
    }
}
