package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import main.java.Main;

import java.io.IOException;
import main.java.util.FileProcesscer;
import main.java.util.SceneSwitcher;

public class InputNameController {
    @FXML private TextField nameInputField;

    @FXML
    public void insertRank() throws IOException {
        FileProcesscer i = new FileProcesscer(5);
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
