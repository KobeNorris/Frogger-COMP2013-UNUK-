package main.java.controller.helpPagesController;

import main.java.util.SceneSwitcher;
import javafx.fxml.FXML;

import java.io.IOException;

public class FirstPageController {
    @FXML
    public void jumpToSecondHelpPage() throws IOException {
        SceneSwitcher.jumpToSecondHelpPage();
    }

    @FXML
    private void jumpToMenu()throws IOException {
        SceneSwitcher.jumpToMenu();
    }
}
