package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

//import main.GameApp;

import java.io.IOException;

import gameApp.Main;
import util.FileProcessor;
import util.SceneSwitcher;

/**
 * <h1>InputNameController</h1>
 *
 * <p>This class is the controller of input name field page controller, it will insert present player's name and
 * score into the high score file by using {@link FileProcessor}. Then jump to {@link HighScoreController} by using
 * {@link SceneSwitcher}
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 * @since 1.0
 * @see FileProcessor
 * @see HighScoreController
 * @see SceneSwitcher
 */
public class InputNameController {
    /**
     * The text field holds the name of current player
     */
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
            i.readFile("src/main/resources/highScoreFile/rank.txt");
            i.insertElement(nameInputField.getText().trim(), Main.points);
            i.writeFile("src/main/resources/highScoreFile/rank.txt");
        }catch(Exception e){
            System.out.println(e);
        }
        SceneSwitcher.jumpToHighScore();
    }
}
