package main.java.util;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import main.java.controller.gameController.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import main.java.Main;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * This class is applied as a kit to switch the scenes of window. It will
 * switch the background music simultaneously to provide better user experience.
 * During the process of switching to game scenes, a key board listener will be
 * added to the scene to enable players to pause and restart the game.
 */
public class SceneSwitcher {
    private static GameController controller;

    /**
     * Jumps from present page to Menu page and change the bgm to "Menu"
     *
     * @throws IOException  Exceptions happen in the process of load FXML file
     */
    public static void jumpToMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(Main.class.getResource("/main/java/view/MenuView.fxml"));
        Scene gameMenu = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameMenu);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    /**
     * Jumps from present page to Difficulty Level Selection page and change the bgm to "Menu"
     *
     * @throws IOException  Exceptions happen in the process of load FXML file
     */
    public static void jumpToDifficultyLevelSelection() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(Main.class.getResource("/main/java/view/DifficultyLevelSelectionView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    /**
     * Jumps from present page to First Help page and change the bgm to "Menu"
     *
     * @throws IOException  Exceptions happen in the process of load FXML file
     */
    public static void jumpToFirstHelpPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(Main.class.getResource("/main/java/view/helpPagesView/FirstHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    /**
     * Jumps from present page to Second Help page and change the bgm to "Menu"
     *
     * @throws IOException  Exceptions happen in the process of load FXML file
     */
    public static void jumpToSecondHelpPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(Main.class.getResource("/main/java/view/helpPagesView/SecondHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    /**
     * Jumps from present page to Third Help page and change the bgm to "Menu"
     *
     * @throws IOException  Exceptions happen in the process of load FXML file
     */
    public static void jumpToThirdHelpPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(Main.class.getResource("/main/java/view/helpPagesView/ThirdHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    /**
     * Jumps from present page to Fourth Help page and change the bgm to "Menu"
     *
     * @throws IOException  Exceptions happen in the process of load FXML file
     */
    public static void jumpToFourthHelpPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(Main.class.getResource("/main/java/view/helpPagesView/FourthHelpPageView.fxml"));
        Scene gameDifficultyLevelSelection = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameDifficultyLevelSelection);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Menu");
    }

    /**
     * Jumps from present page to Easy Game page and change the bgm to "Game"
     *
     * @throws IOException  Exceptions happen in the process of load FXML file
     */
    public static void jumpToEasyGame() throws IOException {
        Main.diffficulty = 1;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/java/view/gameView/EasyGameView.fxml"));
        Scene game  = new Scene(loader.load(),600,800);
        controller = loader.<GameController>getController();
        game.addEventHandler(KeyEvent.KEY_PRESSED, new KeyBoardListener());
        Main.setController(controller);
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    /**
     * Jumps from present page to Hard Game page and change the bgm to "Game"
     *
     * @throws IOException  Exceptions happen in the process of load FXML file
     */
    public static void jumpToHardGame() throws IOException {
        Main.diffficulty = 1;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/java/view/gameView/HardGameView.fxml"));
        Scene game  = new Scene(loader.load(),600,800);
        controller = loader.<GameController>getController();
        game.addEventHandler(KeyEvent.KEY_PRESSED, new KeyBoardListener());
        Main.setController(controller);
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    /**
     * Jumps from present page to Infinite Game page and change the bgm to "Game"
     *
     * @throws IOException  Exceptions happen in the process of load FXML file
     */
    public static void jumpToInfiniteGame() throws IOException {
        Main.diffficulty = 1;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main/java/view/gameView/InfiniteGameView.fxml"));
        Scene game  = new Scene(loader.load(),600,800);
        controller = loader.<GameController>getController();
        game.addEventHandler(KeyEvent.KEY_PRESSED, new KeyBoardListener());
        Main.setController(controller);
        Main.getPresentStage().setScene(game);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("Game");
        Main.start();
    }

    /**
     * Jumps from present page to High Score page and change the bgm to "Score Board"
     *
     * @throws IOException  Exceptions happen in the process of load FXML file
     */
    public static void jumpToHighScore() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(Main.class.getResource("/main/java/view/HighScoreView.fxml"));
        Scene gameHighScore = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameHighScore);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("ScoreBoard");
    }

    /**
     * Jumps from present page to Input Name page and change the bgm to "Score Board"
     *
     * @throws IOException  Exceptions happen in the process of load FXML file
     */
    public static void jumpToInputName() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(Main.class.getResource("/main/java/view/InputNameView.fxml"));
        Scene inputNameField = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(inputNameField);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
        MusicPlayer.loadMusic("ScoreBoard");
    }

    /**
     * This a key board listener class which will only be applied within scene switcher, when player
     * pressed SPACE on their key board, the game will be paused and restarted after the second tap
     * on SPACE.
     */
    public static class KeyBoardListener implements EventHandler<javafx.scene.input.KeyEvent> {
        @Override
        public void handle(KeyEvent event){
            switch(event.getCode()){
                case SPACE:
                    if(controller.running){
                        controller.pause = true;
                        controller.frogger.blockMove();
                    }else{
                        controller.restart = true;
                        controller.frogger.releaseMove();
                    }
                    controller.running = !controller.running;
            }
        }
    }
}