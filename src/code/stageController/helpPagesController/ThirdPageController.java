package code.stageController.helpPagesController;

import code.util.SceneSwitcher;
import javafx.fxml.FXML;

import java.io.IOException;

public class ThirdPageController {
    @FXML
    public void jumpToSecondHelpPage() throws IOException {
        SceneSwitcher.jumpToSecondHelpPage();
    }

    @FXML
    public void jumpToFourthHelpPage() throws IOException {
        SceneSwitcher.jumpToFourthHelpPage();
    }

    @FXML
    private void jumpToMenu()throws IOException {
        SceneSwitcher.jumpToMenu();
    }
}
