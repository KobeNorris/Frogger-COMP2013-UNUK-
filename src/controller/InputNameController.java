package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

//import main.GameApp;

import java.io.IOException;

import gameApp.Main;
import util.FileProcessor;
import util.SceneSwitcher;

/**
 * This class is the controller of input name field page controller, it will insert present player's name and score into
 * the high score file.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 */
public class InputNameController {
    @FXML private TextField nameInputField;

    /**
     * Insert name into the high score file
     *
     * @throws IOException Invalid file path
     */
    @FXML
    public void insertRank() throws IOException {
        FileProcessor i = new FileProcessor(10);
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
