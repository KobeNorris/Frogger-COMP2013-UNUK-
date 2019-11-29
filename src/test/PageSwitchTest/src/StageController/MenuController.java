package StageController;

import Main.Main;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.*;

import java.io.IOException;

public class MenuController {
    @FXML
    private Button startButton;
    @FXML
    private Button rulesButton;
    @FXML
    private Button highScoreButton;

    @FXML
    public void beginGame(){
        /*System.out.println("Yes");*/
    }

    @FXML
    private void jumpToHighScore()throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../StageView/HighScoreView.fxml"));
        Scene gameHighScore = new Scene(root, 600, 800);
        Main.getPresentStage().setScene(gameHighScore);
        Main.getPresentStage().setResizable(false);
        Main.getPresentStage().show();
    }


}
