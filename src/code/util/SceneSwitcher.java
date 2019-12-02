package code.util;

import code.stage.gameStages.EasyGameStage;
import code.stage.gameStages.GameStage;
import code.stage.gameStages.HardGameStage;
import code.stage.gameStages.InfiniteGameStage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import code.Main;

import java.io.IOException;

public enum SceneSwitcher {
    ;

    public static void jumpToMenu() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/code/stage/stageView/MenuView.fxml"));
        Scene gameMenu = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameMenu);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToDifficultyLevelSelection() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/code/stage/stageView/DifficultyLevelSelectionView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToFirstHelpPage() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/code/stage/stageView/helpPagesView/FirstHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToSecondHelpPage() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/code/stage/stageView/helpPagesView/SecondHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToThirdHelpPage() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/code/stage/stageView/helpPagesView/ThirdHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToFourthHelpPage() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/code/stage/stageView/helpPagesView/FourthHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToGame(){
        Main.diffficulty = 1;
        GameStage background = new GameStage();
        background.initGameBackGround();
        Scene game  = new Scene(background,600,800);
        Main.setBackground(background);
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    public static void jumpToEasyGame(){
        Main.setPresentMode("Easy");
        Main.diffficulty = 1;
        GameStage background = new EasyGameStage();
        background.initGameBackGround();
        Scene game  = new Scene(background,600,800);
        Main.setBackground(background);
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    public static void jumpToHardGame(){
        Main.setPresentMode("Hard");
        Main.diffficulty = 1;
        GameStage background = new HardGameStage();
        background.initGameBackGround();
        Scene game  = new Scene(background,600,800);
        Main.setBackground(background);
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    public static void jumpToInfiniteGame(){
        Main.setPresentMode("Infinite");
        Main.diffficulty = 1;
        GameStage background = new InfiniteGameStage();
        background.initGameBackGround();
        Scene game  = new Scene(background,600,800);
        Main.setBackground(background);
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    public static void jumpToHighScore()throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/code/stage/stageView/HighScoreView.fxml"));
        Scene gameHighScore = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameHighScore);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("ScoreBoard");
    }

    public static void jumpToInputName()throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/code/stage/stageView/InputNameView.fxml"));
        Scene inputNameField = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(inputNameField);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("ScoreBoard");
    }
}