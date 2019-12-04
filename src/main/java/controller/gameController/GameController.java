package main.java.controller.gameController;

import main.java.com.View;
import main.java.com.frogger.FroggerView;
import main.java.com.score.DigitView;
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

public abstract class GameController {
    public AnimationTimer timer;
    public static FroggerView frogger;
    protected static DigitView playerScoreBoard[], playerLifeBoard;

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

    public void updateScore(int num) {
        int digit, tempNum;
        for (int iTemp = 0; iTemp < 5; iTemp++){
            tempNum = num / 10;
            digit = num - tempNum * 10;
            num = tempNum;
            playerScoreBoard[iTemp].setDigit(digit);
        }
    }

    public void updateLife(int num) {
        playerLifeBoard.setDigit(num);
    }

    public void initScore(double posX, double posY) {
        this.playerScoreBoard = new DigitView[5];
        int shift = 0;
        for (int iTemp = 0; iTemp < 5; iTemp++){
            this.playerScoreBoard[iTemp] = new DigitView(posX - shift, posY, 30);
            this.gameStage.getChildren().add(this.playerScoreBoard[iTemp]);
            shift += 30;
        }
    }

    public void initLife(double posX, double posY) {
        this.playerLifeBoard = new DigitView(posX, posY, 40);
        this.gameStage.getChildren().add(this.playerLifeBoard);
        this.playerLifeBoard.setDigit(frogger.getLife());
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

    public abstract void act(long now);
}
