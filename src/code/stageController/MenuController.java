package code.stageController;

import javafx.fxml.*;
import javafx.scene.control.*;
import code.util.SceneSwitcher;

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
        SceneSwitcher.jumpToDifficultyLevelSelection();
    }

    @FXML
    public void jumpToFirstHelpPage() throws IOException {
        SceneSwitcher.jumpToFirstHelpPage();
    }

    @FXML
    private void jumpToHighScore()throws IOException {
        SceneSwitcher.jumpToHighScore();
    }


}
