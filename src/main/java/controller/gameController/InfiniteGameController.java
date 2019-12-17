package controller.gameController;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import com.end.EndView;
import gameApp.Main;
import util.ElementFactory;
import util.MapReader;

/**
 * <h1>InfiniteGameController</h1>
 *
 * <p>This class extends from {@link NormalGameController} and initialises the information demonstration
 * and load the map for infinite game mode. It enables the change of Ends status and the
 * infinite playing terms. It applied {@link ElementFactory} to add elements to the scene
 * in order to im[rove the extendability.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see NormalGameController
 * @see ElementFactory
 */
public class InfiniteGameController extends GameController{
    /**
     * The demonstration board of the current difficulty level
     */
    private static Text playerDifficultyLevelBoard;
    /**
     * Add the infinite game mode's map and initialise the data demonstration.
     */
    public void initialize(){
        initGameStage();

        try{
//            MapReader.generateMap("src/main/resources/map/InfiniteMap.txt", this);
            MapReader.generateMap(this.filePath, this);
        }catch(Exception e){
            System.out.println(e + "\nIn NormalGameController");
        }
        initLevel(1);

        start();
    }

    /**
     * Reset the frogger and ends back to the start status and position
     */
    public static void resetGame(){
        updateDifficulty(++Main.difficulty);
        for(int iTemp = 0; iTemp < 5; iTemp++){
            endList[iTemp].occupyEnd("empty");
        }
        frogger.changeEnd();
    }

    /**
     * Update the difficulty stored in the Main class.
     *
     * @param presentLevel Present difficulty level player has reached
     */
    public static void updateDifficulty(int presentLevel){
        playerDifficultyLevelBoard.setText("Difficulty " + presentLevel);
    }

    /**
     * initialise the difficulty level.
     *
     * @param presentLevel Present difficulty level player has reached
     */
    public void initLevel(int presentLevel){
        playerDifficultyLevelBoard = new Text(170, 70, "Difficulty " + presentLevel);
        playerDifficultyLevelBoard.setFont(Font.font ("Press Start 2P", 20));
        playerDifficultyLevelBoard.setFill(Color.RED);
        this.gameStage.getChildren().add(playerDifficultyLevelBoard);
    }
}
