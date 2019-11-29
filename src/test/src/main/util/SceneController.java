package main.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.GameApplication;
import main.Stage.GameStage;

import java.io.IOException;

public enum SceneController {
    SINGLETON;

    public static void jumpToMenu() throws IOException {
        Parent root = FXMLLoader.load(GameApplication.class.getResource("/main/Stage/StageView/MenuView.fxml"));
        Scene gameMenu = new Scene(root, 600, 800);
        GameApplication.getPresentStage().setScene(gameMenu);
        GameApplication.getPresentStage().setResizable(false);
        GameApplication.getPresentStage().show();
    }

    public static void jumpToGame() throws IOException {
        GameStage background = new GameStage();
        background.initGameBackGround();
        Scene game  = new Scene(background,600,800);
        GameApplication.setBackground(background);
        GameApplication.getPresentStage().setScene(game);
        GameApplication.getPresentStage().setResizable(false);
        GameApplication.getPresentStage().show();
    }

    public static void jumpToHighScore()throws IOException {
        Parent root = FXMLLoader.load(GameApplication.class.getResource("/main/Stage/StageView/HighScoreView.fxml"));
        Scene gameHighScore = new Scene(root, 600, 800);
        GameApplication.getPresentStage().setScene(gameHighScore);
        GameApplication.getPresentStage().setResizable(false);
        GameApplication.getPresentStage().show();
    }
}