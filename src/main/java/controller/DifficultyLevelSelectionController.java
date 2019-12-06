package main.java.controller;

import main.java.util.SceneSwitcher;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * This class is the controller for game difficulty selection page, it could jump to
 * games with different difficulty according to player's choice:
 *          1. Easy game: Game with little traffic and lots of logs, and turtles. There is no snake in the middle
 *          lane and the crocodiles and bugs will not appear in the ends;
 *          2. Hard game: Game with more traffic and fewer logs, and turtles. There will be snake appears in the middle
 *          lane and the crocodiles and bugs will appear in the ends;
 *          3. Infinite game: Game with same mode as hard game, but in this mode, each time player passed the game, the
 *          difficulty will increase and so on and so forth till user has used up his 3 chances.
 */
public class DifficultyLevelSelectionController {
    /**
     * Jumps from present stage to the easy game mode
     *
     * @throws IOException Invalid FXML file
     */
    @FXML
    public void jumpToEasyGame() throws IOException {
        SceneSwitcher.jumpToEasyGame();
    }

    /**
     * Jumps from present stage to the hard game mode
     *
     * @throws IOException Invalid FXML file
     */
    @FXML
    public void jumpToHardGame() throws IOException {
        SceneSwitcher.jumpToHardGame();
    }

    /**
     * Jumps from present stage to the infinite game mode
     *
     * @throws IOException Invalid FXML file
     */
    @FXML
    public void jumpToInfiniteGame() throws IOException {
        SceneSwitcher.jumpToInfiniteGame();
    }

    /**
     * Jumps from present stage to the start menu
     *
     * @throws IOException Invalid FXML file
     */
    @FXML
    private void jumpToMenu()throws IOException {
        SceneSwitcher.jumpToMenu();
    }
}
