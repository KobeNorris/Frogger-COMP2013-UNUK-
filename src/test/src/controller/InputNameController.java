package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import main.Main;

import java.io.IOException;
import util.FileProcesscer;
import util.SceneSwitcher;

public class InputNameController {
    @FXML private TextField nameInputField;

    @FXML
    public void insertRank() throws IOException {
        FileProcesscer i = new FileProcesscer(5);
        try{
            i.readFile("src/resource/highScoreFile/rank.txt");
            i.insertElement(nameInputField.getText().trim(), Main.points);
            i.writeFile("src/resource/highScoreFile/rank.txt");
        }catch(Exception e){
            System.out.println(e);
        }
        SceneSwitcher.jumpToHighScore();
    }
}
