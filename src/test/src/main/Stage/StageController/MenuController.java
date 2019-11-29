package main.Stage.StageController;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.*;
import main.GameApplication;
import main.Stage.GameStage;
import main.util.SceneController;
import main.util.*;

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
//        GameStage background = new GameStage();
//        background.initGameBackGround();
//        Scene game  = new Scene(background,600,800);
//        GameApplication.setBackground(background);
//        GameApplication.getPresentStage().setScene(game);
//        GameApplication.getPresentStage().setResizable(false);
//        GameApplication.getPresentStage().show();
        SceneController.jumpToGame();
    }

    @FXML
    private void jumpToHighScore()throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/main/Stage/StageView/HighScoreView.fxml"));
//        Scene gameHighScore = new Scene(root, 600, 800);
//        GameApplication.getPresentStage().setScene(gameHighScore);
//        GameApplication.getPresentStage().setResizable(false);
//        GameApplication.getPresentStage().show();
        SceneController.jumpToHighScore();
    }


}
