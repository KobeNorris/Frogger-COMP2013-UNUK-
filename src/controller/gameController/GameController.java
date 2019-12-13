package controller.gameController;

import javafx.scene.image.Image;
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

import javax.swing.text.html.ImageView;
import java.util.ArrayList;

/**
 * This class is the basic class for game stages refactored from the original World.
 * It contains methods to update the game information for example: Scores, life and
 * remaining time. It keeps the frogger entity simultaneously, and it will
 * change the status od each end in every 5 seconds.
 *
 * <p>
 * Each of those data has 2 methods:
 *      <p>1. Initialise;
 *      <p>2. Update.
 *
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.5
 */
public abstract class GameController{
    public AnimationTimer timer;
    public static FroggerView frogger;
    public boolean restart = false, pause = false, running = true;
    protected Text playerScoreBoard, playerTimeBoard, playerLifeBoard, gameMode;
    protected long lastTimer;
    protected int leftEndChangeTime = 5;

    protected ImageView[] lifeIcon;

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
        playerLifeBoard.setText(presentLife + "-UP");
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
     * @param presentScore Player's present score
     */
    public void initScore(int presentScore) {
        playerScoreBoard = new Text(20, 70, "SCORE\n" + presentScore);
        playerScoreBoard.setFont(Font.font ("Press Start 2P", 18));
        playerScoreBoard.setFill(Color.rgb(255,255,255));
        this.gameStage.getChildren().add(playerScoreBoard);
    }

    /**
     * This method initialise player's present remaining time and display it to
     * the player.
     *
     * @param presentTime Player's present remaining time
     */
    public void initTime(int presentTime) {
        playerTimeBoard = new Text(430, 40, "Time: " + presentTime);
        playerTimeBoard.setFont(Font.font ("Press Start 2P", 20));
        playerTimeBoard.setFill(Color.GREEN);
        this.gameStage.getChildren().add(playerTimeBoard);
    }

//    /**
//     * This method initialise player's present life and display it to
//     * the player.
//     *
//     * @param presentLife Player's present life
//     */
//    protected void initLife(int presentLife) {
//        playerLifeBoard = new Text(30, 40, presentLife + "-UP");
//        playerLifeBoard.setFont(Font.font ("Press Start 2P", 25));
//        playerLifeBoard.setFill(Color.GREEN);
//        this.gameStage.getChildren().add(playerLifeBoard);
////        lifeIcon = new ImageView[3];
////        for(int iTemp = 0; iTemp < 3; iTemp++){
////            lifeIcon[iTemp] = new ImageView(new Image(getClass().class.getResourceAsStream("@/img/StageImg/openCG.gif"));
////        }
//    }

    /**
     * Initialize the game mode demonstration
     *
     * @param gameMode The mode of the present mode
     */
    public void initGameMode(String gameMode){
        this.gameMode = new Text(170, 40, gameMode + " Mode");
        this.gameMode.setFont(Font.font ("Press Start 2P", 30));
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
     *
     * @param view Present frogger view
     */
    protected void add(View view) {
        gameStage.getChildren().add(view);
    }

    /**
     * Remove View type elements.
     *
     * @param view Present frogger view
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

    public void initLife(int num){
        lifeIcon = new ImageView[num];
        for(int iTemp = 0; iTemp < num; iTemp++){
            lifeIcon[iTemp] = new ImageView();
        }
    }
}
