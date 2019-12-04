package main.java;

import main.java.controller.gameController.GameController;
import main.java.util.FileProcesscer;
import main.java.util.SceneSwitcher;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class extends from Application, launch different stages of game and store the present points
 * player gains and the difficulty player reached
 */
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

    /**
     * Store the present stage of the game and jump to the start menu
     *
     * @param primaryStage: Solid parameter, change it to switch between different stages
     */
    @Override
    public void start(Stage primaryStage) {
        try{
            Main.presentStage = primaryStage;
            SceneSwitcher.jumpToMenu();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Observe the update of the points & life of the frogger
     * and switch to other pages if game is ended
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
                        FileProcesscer i = new FileProcesscer();
                        i.readFile("src/main/resources/highScoreFile/rank.txt");
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

    public static void start() {
        createTimer();
        timer.start();
    }
}
