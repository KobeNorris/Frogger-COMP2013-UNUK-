package controller;

import javafx.fxml.*;
import util.SceneSwitcher;

import java.io.IOException;

/**
 * This class is the controller for start menu, it could jump to different
 * pages according to player's choice:
 *          <p>1. Game difficulty selection page;
 *          <p>2. First page of game introduction;
 *          <p>3. High score page.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 */
public class MenuController {
    /**
     * Jumps from present stage to the game difficulty selection page
     *
     * @throws IOException Invalid FXML file
     */
    @FXML
    public void jumpToDifficultyLevelSelection() throws IOException {
        SceneSwitcher.jumpToDifficultyLevelSelection();
    }

    /**
     * Jumps from present stage to the first page of game introduction
     *
     * @throws IOException Invalid FXML file
     */
    @FXML
    public void jumpToFirstHelpPage() throws IOException {
        SceneSwitcher.jumpToFirstHelpPage();
    }

    /**
     * Jumps from present stage to the high score page
     *
     * @throws IOException Invalid FXML file
     */
    @FXML
    private void jumpToHighScore()throws IOException {
        SceneSwitcher.jumpToHighScore();
    }


}
