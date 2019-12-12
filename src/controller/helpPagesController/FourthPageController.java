package controller.helpPagesController;

import util.SceneSwitcher;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * This class is the controller for start menu, it could jump to the next and
 * previous page to present page if they exists.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 */
public class FourthPageController {
    /**
     * Jumps from present page to Third page
     *
     * @throws IOException Invalid FXML file
     */
    @FXML
    public void jumpToThirdHelpPage() throws IOException {
        SceneSwitcher.jumpToThirdHelpPage();
    }

    /**
     * Jumps from present stage to the start menu
     *
     * @throws IOException Invalid FXML file
     */
    @FXML
    private void jumpToMenu()throws IOException {
        SceneSwitcher.jumpToMenu();
    }
}
