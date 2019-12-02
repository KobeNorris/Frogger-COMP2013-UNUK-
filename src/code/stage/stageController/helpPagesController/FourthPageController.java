package code.stage.stageController.helpPagesController;

import code.util.SceneSwitcher;
import javafx.fxml.FXML;

import java.io.IOException;

public class FourthPageController {
    @FXML
    public void jumpToThirdHelpPage() throws IOException {
        SceneSwitcher.jumpToThirdHelpPage();
    }

    @FXML
    private void jumpToMenu()throws IOException {
        SceneSwitcher.jumpToMenu();
    }
}
