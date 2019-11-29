package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import main.Element.Frogger.FroggerView;
import main.Stage.GameStage;

import java.io.IOException;
import java.util.Optional;

public class GameApplication extends Application{
    AnimationTimer timer;
    private static Stage presentStage;
    private static Scene presentScene;
    public static Stage getPresentStage(){return presentStage;}

    private static GameStage background;
    public static void setBackground(GameStage targetStage){background = targetStage;}


    public void play(){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        GameApplication.presentStage = primaryStage;
        presentScene = new Scene(loadFXML("Stage/StageView/MenuView.fxml"), 600, 800);
        presentStage.setScene(presentScene);
        presentStage.show();

        start();
    }

    public static Parent loadFXML(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long timer) {
                if (FroggerView.checkScore())
                    background.updateScore(FroggerView.getPoints());
                if(FroggerView.checkLife())
                    background.updateLife(FroggerView.getLife());
//                if(FroggerView.pauseGame()){
//                    stop();
//                    if(FroggerView.restartGame())
//                        start();
//                }
                if (FroggerView.getStop()){
                    stop();
                    background.stopGame();
                    presentStage.close();
                }
            }
        };
    }

    public void start() {
        createTimer();
        timer.start();
    }
}
