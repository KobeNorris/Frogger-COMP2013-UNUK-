package main.Stage.StageController;

import javafx.fxml.*;
import javafx.scene.control.*;
import main.util.SceneSwitcher;

import java.io.IOException;

public class MenuController {
    @FXML
    private Button startButton;
    @FXML
    private Button rulesButton;
    @FXML
    private Button highScoreButton;

    @FXML
    public void jumpToGame() throws IOException {
//        SceneSwitcher.jumpToGame();
        SceneSwitcher.jumpToHardGame();
    }

    @FXML
    private void jumpToHighScore()throws IOException {
        SceneSwitcher.jumpToHighScore();
    }


}
