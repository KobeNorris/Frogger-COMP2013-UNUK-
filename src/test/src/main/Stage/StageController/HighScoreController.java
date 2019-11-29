package main.Stage.StageController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.GameApplication;
import main.util.SceneController;


import java.io.IOException;

public class HighScoreController {
    @FXML
    private void jumpToMenu()throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/main/Stage/StageView/MenuView.fxml"));
//        Scene gameMenu = new Scene(root, 600, 800);
//        GameApplication.getPresentStage().setScene(gameMenu);
//        GameApplication.getPresentStage().setResizable(false);
//        GameApplication.getPresentStage().show();
        SceneController.jumpToMenu();
    }
}
