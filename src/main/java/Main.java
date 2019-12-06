package main.java;

import main.java.controller.gameController.GameController;
import main.java.util.FileProcesscer;
import main.java.util.SceneSwitcher;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class extends from Application, launch different stages of game and store the present points
 * player gains and the difficulty player reached. During the execution of the program, Main will keep
 * supervise whether game status has been changed.
 *
 * Refactor:
 *      1. Removed the game scene initialisation code to improve code extendability & reusability;
 *      2. Removed the digit display function and transform it into part of the scene initialisation
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
     * Store the present stage of the game and jump to the start menu and launch the game menu
     * scene as the initial game stage.
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
     * This function prepares for the switch of scenes after the termination of
     * game. It will judge whether player's present score is high enough to be
     * recorded into the high score list.
     *
     * @param filePath: The absolute file path direct to the file storing game's
     *                  present high score.
     */
    private static void switchPreparation(String filePath){
        try{
            FileProcesscer i = new FileProcesscer();
            i.readFile(filePath);
            points = controller.frogger.getPoints();
            if(i.checkInsertable(controller.frogger.getPoints())){
                SceneSwitcher.jumpToInputName();
            }else{
                SceneSwitcher.jumpToHighScore();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Observe the update of the points & life of the frogger and then
     * switch to other pages if game is ended. Here a scene switcher is
     * applied to professionally taking charge of the process of changing
     * scenes.
     */
    private static void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long timer) {
                if (controller.frogger.checkAttribute("Score"))
                    controller.updateScore(controller.frogger.getPoints());
                if(controller.frogger.checkAttribute("Life"))
                    controller.updateLife(controller.frogger.getLife());
                if(controller.checkPause())
                    controller.stop();
                if(controller.checkRestart())
                    controller.start();
                if (controller.frogger.getStop()){
                    controller.frogger.resetFroggerModelToStart();
                    controller.stopGame();
                    stop();
                    switchPreparation("src/main/resources/highScoreFile/rank.txt");
                    controller.frogger.resetPoints();
                }
            }
        };
    }

    /**
     * Creates and starts the timer and begins observing the change of frogger's
     * status.
     */
    public static void start() {
        createTimer();
        timer.start();
    }
}
