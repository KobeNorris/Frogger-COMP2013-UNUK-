package controller.gameController;

import javafx.fxml.FXML;
import util.MapReader;

/**
 * <h1>NormalGameController</h1>
 *
 * <P>This class extends from {@link GameController} and initialises the information demonstration and load the map for Hard game mode.
 * It enable the change of Ends status.
 * It applied {@link MapReader} to read in a game map in txt type and load game elements to the scene in order to im[rove the extendability.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see GameController
 * @see MapReader
 */
public class NormalGameController extends GameController{
    /**
     * Applied {@link MapReader} to read in and load the game map in txt file type and construct the
     * the game stage
     */
    @FXML
    protected void initialize(){
        initGameStage();

        try{
            MapReader.generateMap(this.filePath, this);
        }catch(Exception e){
            System.out.println(e + "\nIn NormalGameController");
        }

        start();
    }
}
