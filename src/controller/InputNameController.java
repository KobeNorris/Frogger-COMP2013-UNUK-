package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

//import main.GameApp;

import java.io.IOException;

import gameApp.Main;
import util.FileProcesscer;
import util.SceneSwitcher;

/**
 * This class is the controller of input name field page controller, it will insert present player's name and score into
 * the high score file.
 */
public class InputNameController {
    @FXML private TextField nameInputField;

    /**
     * Insert name into the high score file
     *
     * @throws IOException
     */
    @FXML
    public void insertRank() throws IOException {
        FileProcesscer i = new FileProcesscer(10);
        try{
            i.readFile("resources/highScoreFile/rank.txt");
            i.insertElement(nameInputField.getText().trim(), Main.points);
            i.writeFile("resources/highScoreFile/rank.txt");
        }catch(Exception e){
            System.out.println(e);
        }
        SceneSwitcher.jumpToHighScore();
    }
}
