package controller.gameController;

import com.end.EndView;
import com.icon.LifeIconView;
import com.icon.PauseIconView;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import com.View;
import com.frogger.FroggerView;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import util.ElementFactory;
import util.FileProcessor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * <h1>GameController</h1>
 *
 * <p>This class is the basic class for game stages refactored from the original World.
 * It contains methods to update the game information for example: Scores, life and
 * remaining time. It keeps the {@link FroggerView} simultaneously, and it will
 * change the status od each end in every 5 seconds.
 *
 * <br>
 * Each of those data has 2 methods:
 *      <br>1. Initialise;
 *      <br>2. Update.
 *
 *
 * <br>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.5
 * @since 1.0
 * @see FroggerView
 */
public abstract class GameController{
    /**
     * The time counter of the game controller and all elements in side
     */
    public AnimationTimer timer;
    /**
     * The instance of frogger
     */
    public static FroggerView frogger;
    /**
     * The status of the game
     */
    public boolean restart = false, pause = false, running = true;
    /**
     * The data demonstration components
     */
    protected Text playerScoreBoard, playerTimeBoard, highScore, gameMode;
    /**
     * Time bar for visualising the time count down
     */
    protected Rectangle timeBar;
    /**
     * The last time counter's value
     */
    protected long lastTimer;
    /**
     * The remaining number of time intervals
     */
    protected int leftEndChangeTime = 5;

    protected ImageView[] lifeIcon;
    protected ImageView pauseIcon;
    public static EndView[] endList;
    public static String filePath = "";

    /**
     * The gameStage pane keeps all game elements
     */
    @FXML
    protected Pane gameStage;

    /**
     * This function initialise the game stage Pane and add two Key board event listener to
     * the Pane to observe player's keyboard inputs.
     */
    public void initGameStage(){
        gameStage.sceneProperty().addListener(new ChangeListener<Scene>() {

            @Override
            public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
                if (newValue != null) {
                    newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                            if(gameStage.getOnKeyReleased() != null)
                                gameStage.getOnKeyReleased().handle(event);
                            ArrayList<View> viewArrayList = getObjects(View.class);
                            for (View anView: viewArrayList) {
                                if (anView.getOnKeyReleased() != null) {
                                    anView.getOnKeyReleased().handle(event);
                                }
                            }
                        }

                    });

                    newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                            if(gameStage.getOnKeyPressed() != null)
                                gameStage.getOnKeyPressed().handle(event);
                            ArrayList<View> viewArrayList = getObjects(View.class);
                            for (View anView: viewArrayList) {
                                if (anView.getOnKeyPressed() != null) {
                                    anView.getOnKeyPressed().handle(event);
                                }
                            }
                        }

                    });
                }

            }

        });
    }

    /**
     * This function changes the status of ends, there is going to be only one
     * pair of CrocEnd and BugEnd exist simultaneously at most. And if there is
     * only one End left, it will be set to BugEnd.
     */
    public static void changeEnd(){
        int emptyEndCounter = 0;
        Date date = new Date();
        Random rand = new Random(date.getTime());
        for(int iTemp = 0; iTemp < 5; iTemp++){
            if(!endList[iTemp].checkStatusFROGOCCUPIED()){
                emptyEndCounter++;
                endList[iTemp].occupyEnd("empty");
            }
        }
        if(emptyEndCounter > 0){
            int tempCounter = 0;
            int targetIndex = rand.nextInt(emptyEndCounter);
            targetIndex++;
            for(int iTemp = 0; iTemp < 5; iTemp++){
                if(endList[iTemp].checkStatusEMPTY()){
                    tempCounter++;
                }
                if(targetIndex == tempCounter){
                    endList[iTemp].occupyEnd("bug");
                    break;
                }
            }
            if(emptyEndCounter > 1){
                tempCounter = 0;
                targetIndex = rand.nextInt(emptyEndCounter-1);
                targetIndex++;
                for(int iTemp = 0; iTemp < 5; iTemp++){
                    if(endList[iTemp].checkStatusEMPTY())
                        tempCounter++;
                    if(targetIndex == tempCounter){
                        endList[iTemp].occupyEnd("croc");
                        break;
                    }
                }
            }
        }
    }

    /**
     * This method will initialize the game information demonstration according to
     * the mode of game stage. It will use {@link FileProcessor} to read the high
     * score file and get present high score. The initialised components include:
     *     <br>1. Life;
     *     <br>2. Score;
     *     <br>3. Remaining time;
     *     <br>4. Game mode;
     *     <br>5. Present high score.
     *
     * @param gameMode Present game's mode
     */
    public void initInfo(String gameMode){
        int highScore = -1;
        FileProcessor i = new FileProcessor(10);
        try{
            i.readFile("src/main/resources/highScoreFile/rank.txt");
            highScore = i.getHighScore();
        }catch(Exception e){
            System.out.println(e);
        }

        initLife(frogger.getLife());
        initScore(frogger.getPoints());
        initTime(frogger.getRemainingTime());
        initGameMode(gameMode);
        initHighScore(highScore);
        pauseIcon = ElementFactory.pauseIconViewProvider(190, 425, 230);
        this.gameStage.getChildren().add(pauseIcon);
    }

    /**
     * This method initialise player's present score and display it to
     * the player.
     *
     * @param presentScore Player's present score
     */
    public void initScore(int presentScore) {
        this.playerScoreBoard = new Text(40, 40, "SCORE\n" + presentScore);
        this.playerScoreBoard.setFont(Font.font ("Press Start 2P", 20));
        this.playerScoreBoard.setFill(Color.rgb(90,180,255));
        this.playerScoreBoard.setTextAlignment(TextAlignment.CENTER);
        this.gameStage.getChildren().add(playerScoreBoard);
    }

    /**
     * This method initialise player's present remaining time and display it to
     * the player.
     *
     * @param presentTime Player's present remaining time
     */
    public void initTime(int presentTime) {
        this.playerTimeBoard = new Text(430, 825, "Time: " + presentTime);
        this.playerTimeBoard.setFont(Font.font ("Press Start 2P", 20));
        this.gameStage.getChildren().add(playerTimeBoard);
        this.timeBar = new Rectangle( this.gameStage.getPrefWidth() - 20 * presentTime/60, 25);
        this.gameStage.getChildren().add(timeBar);
        this.timeBar.setX(10);
        this.timeBar.setY(830);
    }

    /**
     * This method initialise player's present life and display it to
     * the player.
     *
     * @param presentLife Player's present life
     */
    public void initLife(int presentLife){
        double positionX = 5;
        this.lifeIcon = new ImageView[presentLife];
        for(int iTemp = 0; iTemp < presentLife; iTemp++){
            this.lifeIcon[iTemp] = ElementFactory.lifeIconViewProvider(positionX,800,30);
            this.gameStage.getChildren().add(this.lifeIcon[iTemp]);
            positionX += 35;
        }
    }

    /**
     * Initialize the game mode demonstration
     *
     * @param gameMode The mode of the present mode
     */
    public void initGameMode(String gameMode){
        this.gameMode = new Text(160, 40, gameMode + " Mode");
        this.gameMode.setFont(Font.font ("Press Start 2P", 30));
        this.gameMode.setFill(Color.WHITE);
        this.gameStage.getChildren().add(this.gameMode);
    }

    /**
     * Initialize the demonstration of the highest score player has achieved
     * presently. And it could demonstrate it to the player.
     *
     * @param highScore Present highest score player has achieved.
     */
    public void initHighScore(int highScore){
        if(highScore < 0)
            this.highScore = new Text(430, 40, "HI-SCORE\nEMPTY");
        else
            this.highScore = new Text(430, 40, "HI-SCORE\n" + highScore);
        this.highScore.setFont(Font.font ("Press Start 2P", 20));
        this.highScore.setFill(Color.rgb(90,180,255));
        this.highScore.setTextAlignment(TextAlignment.CENTER);
        this.gameStage.getChildren().add(this.highScore);
    }

    /**
     * This method updates player's present score
     *
     * @param presentScore Present score player gaines
     */
    public void updateScore(int presentScore) {
        playerScoreBoard.setText("SCORE\n" + presentScore);
    }

    /**
     * This method updates player's present remaining time, if the
     * time is less than 60 seconds, it will be demonstrated in
     * orange and if it is less than 30, it will be demonstrated
     * in red.
     *
     * @param presentTime Present remaining time player has
     */
    public void updateTime(int presentTime){
        playerTimeBoard.setText("Time: " + presentTime);
        timeBar.setWidth((this.gameStage.getPrefWidth() - 20) * presentTime/60);
        timeBar.setX((this.gameStage.getPrefWidth() - 20) * (1 - (double)presentTime/60) + 10);
        if(presentTime > 40){
            playerTimeBoard.setFill(Color.rgb(10,225,10));
            timeBar.setFill(Color.rgb(10,225,10));
        }
        else if(presentTime > 20){
            playerTimeBoard.setFill(Color.ORANGE);
            timeBar.setFill(Color.ORANGE);
        }
        else if(presentTime > 0){
            playerTimeBoard.setFill(Color.RED);
            timeBar.setFill(Color.RED);
        }
    }

    /**
     * This method updates player's present life number, if the
     * life is less than 3, it will be demonstrated in orange,
     * and if it is less than 2, which means it is the last chance,
     * it will be demonstrated in red.
     *
     * @param presentLife Present life player has
     */
    public void updateLife(int presentLife) {
        for(int iTemp = presentLife; iTemp < lifeIcon.length; iTemp++){
            this.gameStage.getChildren().remove(lifeIcon[iTemp]);
        }
    }

    /**
     * Stop current game stage.
     */
    public void stopGame() {
        this.frogger.resetPresentHighestPosition();
        stop();
    }

    /**
     * Add View type elements
     *
     * @param view Present frogger view
     */
    public void add(View view) {
        this.gameStage.getChildren().add(view);
    }

    /**
     * Remove View type elements.
     *
     * @param view Present frogger view
     */
    public void remove(View view) {
        this.gameStage.getChildren().remove(view);
    }

    /**
     * Start the timer
     */
    public void start() {
        createTimer();
        timer.start();
    }

    /**
     * Stop the timer
     */
    public void stop() {
        this.timer.stop();
    }

    /**
     * Create a timer and apply it to all the View elements inside
     */
    private void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                ArrayList<View> viewArrayList = getObjects(View.class);

                for (View anView: viewArrayList) {
                    anView.act(now);
                }
            }
        };
    }

    /**
     * This functions selects out elements will target class
     *
     * @param cls Target element
     * @param <A> Target element type, always implements View interface
     * @return An array list of target type containing in this controller
     */
    private <A extends View> ArrayList<A> getObjects(Class<A> cls) {
        ArrayList<A> objectArray = new ArrayList<A>();
        for (Node n: gameStage.getChildren()) {
            if (cls.isInstance(n)) {
                objectArray.add((A)n);
            }
        }
        return objectArray;
    }

    /**
     * Check whether player wants to pause the game.
     *
     * @return True, if it is been paused, false otherwise.
     */
    public boolean checkPause(){
        if(pause){
            pause = false;
            pauseIcon.setVisible(true);
            return true;
        }else
            return false;
    }

    /**
     * Check whether player wants to restart the game.
     *
     * @return True, if it is been paused, false otherwise.
     */
    public boolean checkRestart(){
        if(restart){
            restart = false;
            pauseIcon.setVisible(false);
            return true;
        }else
            return false;
    }

    /**
     * This method will update player's remaining time and change the status of ends
     * every 5 seconds.
     *
     * @param timer The time counter initialise by controller himself
     */
    public void act(long timer){
        long timeInterval = 1000000000L ;
        if((timer - this.lastTimer) > timeInterval){
            this.lastTimer = timer;
            if(leftEndChangeTime == 0){
                leftEndChangeTime = 5;
                frogger.changeEnd();
            }else{
                leftEndChangeTime--;
            }
            frogger.deductTime();
            updateTime(frogger.getRemainingTime());
        }
    }
}
