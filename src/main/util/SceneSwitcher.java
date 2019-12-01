package main.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.Main;
import main.Stage.GameStages.GameStage;
import main.Stage.GameStages.EasyGameStage;
import main.Stage.GameStages.HardGameStage;

import java.io.IOException;

public enum SceneSwitcher {
    SINGLETON;

    public static void jumpToMenu() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/main/Stage/StageView/MenuView.fxml"));
        Scene gameMenu = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameMenu);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToGame(){
        GameStage background = new GameStage();
        background.initGameBackGround(Main.diffficulty);
        Scene game  = new Scene(background,600,800);
        Main.setBackground(background);
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    public static void jumpToEasyGame(){
        GameStage background = new EasyGameStage();
        background.initGameBackGround(Main.diffficulty);
        Scene game  = new Scene(background,600,800);
        Main.setBackground(background);
        Main.setPresentMode("Easy");
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    //Remember to set difficulty back to 1
    public static void jumpToHardGame(){
        GameStage background = new HardGameStage();
        background.initGameBackGround(Main.diffficulty);
        Scene game  = new Scene(background,600,800);
        Main.setBackground(background);
        Main.setPresentMode("Hard");
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    public static void jumpToInfiniteGame(){
        GameStage background = new GameStage();
        background.initGameBackGround(1);
        Scene game  = new Scene(background,600,800);
        Main.setBackground(background);
        Main.setPresentMode("Infinite");
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    public static void jumpToHighScore()throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/main/Stage/StageView/HighScoreView.fxml"));
        Scene gameHighScore = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameHighScore);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("ScoreBoard");
    }

    public static void jumpToInputName()throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/main/Stage/StageView/InputNameView.fxml"));
        Scene inputNameField = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(inputNameField);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("ScoreBoard");
    }
}