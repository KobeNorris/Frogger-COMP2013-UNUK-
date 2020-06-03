package controller;

import gameApp.Main;
import javafx.fxml.*;
import util.SceneSwitcher;

import java.io.IOException;

/**
 * <h1>MenuController</h1>
 *
 * <p>This class is the controller for start menu, it could use {@link SceneSwitcher}
 * jump to different pages according to player's choice:
 *          <p>1. Game difficulty selection page {@link DifficultyLevelSelectionController};
 *          <p>2. First page of game introduction {@link controller.helpPagesController.FirstPageController};
 *          <p>3. High score page {@link HighScoreController}.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 * @since 1.0
 * @see SceneSwitcher
 * @see DifficultyLevelSelectionController
 * @see controller.helpPagesController.FirstPageController
 * @see HighScoreController
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

    /**
     * This method allow player to exit the game smoothly.
     */
    @FXML
    private void exitGame(){
        Main.getPresentStage().close();
    }
}
