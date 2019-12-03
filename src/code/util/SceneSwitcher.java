package code.util;

//import code.stage.stageController.gameController.EasyGameController;
//import code.stage.gameStages.GameController;
//import code.stage.gameStages.HardGameController;
//import code.stage.gameStages.InfiniteGameController;
import code.stageController.gameController.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import code.Main;
import javafx.scene.layout.Pane;

import java.io.IOException;

public enum SceneSwitcher {
    ;

    public static void jumpToMenu() throws IOException {
        Pane root = FXMLLoader.load(Main.class.getResource("/resource/stageView/MenuView.fxml"));
        Scene gameMenu = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameMenu);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToDifficultyLevelSelection() throws IOException {
        Pane root = FXMLLoader.load(Main.class.getResource("/resource/stageView/DifficultyLevelSelectionView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToFirstHelpPage() throws IOException {
        Pane root = FXMLLoader.load(Main.class.getResource("/resource/stageView/helpPagesView/FirstHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToSecondHelpPage() throws IOException {
        Pane root = FXMLLoader.load(Main.class.getResource("/resource/stageView/helpPagesView/SecondHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToThirdHelpPage() throws IOException {
        Pane root = FXMLLoader.load(Main.class.getResource("/resource/stageView/helpPagesView/ThirdHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToFourthHelpPage() throws IOException {
        Pane root = FXMLLoader.load(Main.class.getResource("/resource/stageView/helpPagesView/FourthHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    public static void jumpToEasyGame() throws IOException {
        Main.setPresentMode("Easy");
        Main.diffficulty = 1;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/resource/stageView/gameView/EasyGameView.fxml"));
        Scene game  = new Scene(loader.load(),600,800);
        Main.setController(loader.<GameController>getController());
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    public static void jumpToHardGame() throws IOException {
        Main.setPresentMode("Hard");
        Main.diffficulty = 1;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/resource/stageView/gameView/HardGameView.fxml"));
        Scene game  = new Scene(loader.load(),600,800);
        Main.setController(loader.<GameController>getController());
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    public static void jumpToInfiniteGame() throws IOException {
        Main.setPresentMode("Infinite");
        Main.diffficulty = 1;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/resource/stageView/gameView/InfiniteGameView.fxml"));
        Scene game  = new Scene(loader.load(),600,800);
        Main.setController(loader.<GameController>getController());
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    public static void jumpToHighScore() throws IOException {
        Pane root = FXMLLoader.load(Main.class.getResource("/resource/stageView/HighScoreView.fxml"));
        Scene gameHighScore = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameHighScore);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("ScoreBoard");
    }

    public static void jumpToInputName() throws IOException {
        Pane root = FXMLLoader.load(Main.class.getResource("/resource/stageView/InputNameView.fxml"));
        Scene inputNameField = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(inputNameField);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("ScoreBoard");
    }
}