package StageController;

import Main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


import java.io.IOException;

public class HighScoreController {
    @FXML
    private void jumpToMenu()throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../StageView/MenuView.fxml"));
        Scene gameMenu = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameMenu);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
    }
}
