package main.java.controller;

import main.java.util.SceneSwitcher;
import javafx.fxml.FXML;

import java.io.IOException;

public class DifficultyLevelSelectionController {
    @FXML
    public void jumpToEasyGame() throws IOException {
        SceneSwitcher.jumpToEasyGame();
    }

    @FXML
    public void jumpToHardGame() throws IOException {
        SceneSwitcher.jumpToHardGame();
    }

    @FXML
    public void jumpToInfiniteGame() throws IOException {
        SceneSwitcher.jumpToInfiniteGame();
    }

    @FXML
    private void jumpToMenu()throws IOException {
        SceneSwitcher.jumpToMenu();
    }
}
