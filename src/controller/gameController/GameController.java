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

public abstract class GameController{
    public AnimationTimer timer;
    public static FroggerView frogger;
    public boolean restart = false, pause = false, running = true;
    //    protected static DigitView playerScoreBoard[], playerLifeBoard;
    protected static Text playerScoreBoard, playerTimeBoard, playerLifeBoard;
//    protected static Text playerTimeBoard;
    protected long lastTimer;
    protected int leftEndChangeTime = 5;

    @FXML
    protected Pane gameStage;

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

    public void updateScore(int presentScore) {
        playerScoreBoard.setText("score: " + presentScore);
    }

    public void updateTime(int presentTime){
        playerTimeBoard.setText(presentTime + "");
        if(presentTime > 60)
            playerTimeBoard.setFill(Color.GREEN);
        else if(presentTime > 30)
            playerTimeBoard.setFill(Color.ORANGE);
        else if(presentTime > 0)
            playerTimeBoard.setFill(Color.RED);
    }

    public void updateLife(int presentLife) {
        playerLifeBoard.setText(presentLife + " - UP");
        if(presentLife > 2)
            playerLifeBoard.setFill(Color.GREEN);
        else if(presentLife == 2)
            playerLifeBoard.setFill(Color.ORANGE);
        else if(presentLife == 1)
            playerLifeBoard.setFill(Color.RED);
    }

    public void initScore(int presentScore) {
        playerScoreBoard = new Text(50, 70, "score: " + presentScore);
        playerScoreBoard.setFont(Font.font ("Verdana", 20));
        playerScoreBoard.setFill(Color.rgb(255,255,255));
        this.gameStage.getChildren().add(playerScoreBoard);
    }

    public void initTime(int presentTime) {
        playerTimeBoard = new Text(500, 50, presentTime + "");
        playerTimeBoard.setFont(Font.font ("Verdana", 30));
        playerTimeBoard.setFill(Color.GREEN);
        this.gameStage.getChildren().add(playerTimeBoard);
    }

    public void initLife(int presentLife) {
        playerLifeBoard = new Text(55, 40, presentLife + " - UP");
        playerLifeBoard.setFont(Font.font ("Verdana", 30));
        playerLifeBoard.setFill(Color.GREEN);
        this.gameStage.getChildren().add(playerLifeBoard);
    }

    public void stopGame() {
        frogger.resetPresentHighestPosition();
        stop();
    }

    public void add(View view) {
        gameStage.getChildren().add(view);
    }

    public void remove(View view) {
        gameStage.getChildren().remove(view);
    }

    public void start() {
        createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void createTimer() {
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

    public <A extends View> ArrayList<A> getObjects(Class<A> cls) {
        ArrayList<A> objectArray = new ArrayList<A>();
        for (Node n: gameStage.getChildren()) {
            if (cls.isInstance(n)) {
                objectArray.add((A)n);
            }
        }
        return objectArray;
    }

    public boolean checkPause(){
        if(pause){
            pause = false;
            return true;
        }else
            return false;
    }

    public boolean checkRestart(){
        if(restart){
            restart = false;
            return true;
        }else
            return false;
    }

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
