package controller.gameController;

import javafx.scene.paint.Color;
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

import java.util.ArrayList;

/**
 * This class is the basic class for game stages refactored from the original World.
 * It contains methods to update the game information for example: Scores, life and
 * remaining time. It keeps the frogger entity simultaneously, and it will
 * change the status od each end in every 5 seconds.
 *
 * Each of those data has 2 methods:
 *      1. Initialise;
 *      2. Update.
 */
public abstract class GameController{
    public AnimationTimer timer;
    public static FroggerView frogger;
    public boolean restart = false, pause = false, running = true;
    protected static Text playerScoreBoard, playerTimeBoard, playerLifeBoard, gameMode;
    protected long lastTimer;
    protected int leftEndChangeTime = 5;

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
     * This method updates player's present score
     *
     * @param presentScore Present score player gaines
     */
    public void updateScore(int presentScore) {
        playerScoreBoard.setText("score: " + presentScore);
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
        if(presentTime > 60)
            playerTimeBoard.setFill(Color.GREEN);
        else if(presentTime > 30)
            playerTimeBoard.setFill(Color.ORANGE);
        else if(presentTime > 0)
            playerTimeBoard.setFill(Color.RED);
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
        playerLifeBoard.setText(presentLife + " - UP");
        if(presentLife > 2)
            playerLifeBoard.setFill(Color.GREEN);
        else if(presentLife == 2)
            playerLifeBoard.setFill(Color.ORANGE);
        else if(presentLife == 1)
            playerLifeBoard.setFill(Color.RED);
    }

    /**
     * This method initialise player's present score and display it to
     * the player.
     *
     * @param presentScore
     */
    public void initScore(int presentScore) {
        playerScoreBoard = new Text(50, 70, "score: " + presentScore);
        playerScoreBoard.setFont(Font.font ("Verdana", 20));
        playerScoreBoard.setFill(Color.rgb(255,255,255));
        this.gameStage.getChildren().add(playerScoreBoard);
    }

    /**
     * This method initialise player's present remaining time and display it to
     * the player.
     *
     * @param presentTime
     */
    public void initTime(int presentTime) {
        playerTimeBoard = new Text(430, 50, "Time: " + presentTime);
        playerTimeBoard.setFont(Font.font ("Verdana", 30));
        playerTimeBoard.setFill(Color.GREEN);
        this.gameStage.getChildren().add(playerTimeBoard);
    }

    /**
     * This method initialise player's present life and display it to
     * the player.
     *
     * @param presentLife
     */
    protected void initLife(int presentLife) {
        playerLifeBoard = new Text(55, 40, presentLife + " - UP");
        playerLifeBoard.setFont(Font.font ("Verdana", 30));
        playerLifeBoard.setFill(Color.GREEN);
        this.gameStage.getChildren().add(playerLifeBoard);
    }

    /**
     *
     */
    public void initGameMode(String gameMode){
        this.gameMode = new Text(210, 40, gameMode + " Mode");
        this.gameMode.setFont(Font.font ("Verdana", 30));
        this.gameMode.setFill(Color.WHITE);
        this.gameStage.getChildren().add(this.gameMode);
    }

    /**
     * Stop current game stage.
     */
    public void stopGame() {
        frogger.resetPresentHighestPosition();
        stop();
    }

    /**
     * Add View type elements
     */
    protected void add(View view) {
        gameStage.getChildren().add(view);
    }

    /**
     * Remove View type elements.
     */
    public void remove(View view) {
        gameStage.getChildren().remove(view);
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
        timer.stop();
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
