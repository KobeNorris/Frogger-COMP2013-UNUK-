package gameApp;

import controller.gameController.GameController;
import util.FileProcessor;
import util.SceneSwitcher;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * <h1>Main</h1>
 *
 *      <p>GameApp class extends from {@link Application}, launch different stages of game and store the present points
 *      player gains and the difficulty player reached by using {@link SceneSwitcher}. During the execution of the program, Main will keep
 *      supervise whether game status has been changed.
 *
 *      <br>Refactor:<br>
 *          1. Removed the game scene initialisation code to improve code extendability and reusability;<br>
 *          2. Removed the digit display function and transform it into part of the scene initialisation;<br>
 *          3. The program will jump to start menu first {@link SceneSwitcher#jumpToMenu()}<br>
 *
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.3
 * @since 1.0
 * @see Application
 * @see SceneSwitcher
 */
public class Main extends Application{
    /**
     * The time counter of the game
     */
    private static AnimationTimer timer;
    /**
     * Present game stage
     */
    private static Stage presentStage;
    /**
     * Present game controller
     */
    private static GameController controller;
    /**
     * Player's point and present game difficulty
     */
    public static int points = 0, difficulty;
    /**
     * Get the present stage of the game
     *
     * @return Present game stage
     */
    public static Stage getPresentStage(){return presentStage;}
    /**
     * Set target controller to be the present controller which is used to observe game status
     *
     * @param targetController The controller of present game mode
     */
    public static void setController(GameController targetController){controller = targetController;}

    public static void main(String[] args){
        launch(args);
    }

    /**
     * Store the present stage of the game and jump to the start menu {@link SceneSwitcher#jumpToMenu()}
     * and launch the game menu scene as the initial game stage.
     *
     * @see SceneSwitcher#jumpToMenu()
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
     * <p>
     * This function prepares for the switch of scenes after the termination of
     * game. It will judge whether player's present score is high enough to be
     * recorded into the high score list.
     * </p>
     *
     * @param filePath: The absolute file path direct to the file storing game's
     *                  present high score.
     */
    private static void switchPreparation(String filePath){
        try{
            FileProcessor i = new FileProcessor();
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
     * <p>
     * Observe the update of the points and life of the frogger and then
     * switch to other pages if game is ended. Here a scene switcher is
     * applied to professionally taking charge of the process of changing
     * scenes.
     * </p>
     *
     * @see GameController
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
