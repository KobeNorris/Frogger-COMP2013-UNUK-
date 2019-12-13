package controller.gameController;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import com.end.EndView;
import gameApp.Main;
import util.ElementFactory;

/**
 * This function initialise the information demonstration and load the map for infinite game mode.
 * It enable the change of Ends status and the infinite playing terms.
 * It applied {@link ElementFactory} to add elements to the scene in order to im[rove the extendability.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 */
public class InfiniteGameController extends HardGameController{
    private static Text playerDifficultyLevelBoard;
    /**
     * Add the infinite game mode's map and initialise the data demonstration.
     */
    @Override
    public void initialize(){
        initGameStage();

        this.add(ElementFactory.logProvider("middle", 0, 170, 170, 1));
        this.add(ElementFactory.logProvider("middle", 250, 170, 170, 1));
        this.add(ElementFactory.logProvider("middle", 500, 170, 170, 1));
        this.add(ElementFactory.crocodileBodyProvider(-230, 150, 90, 1));
        this.add(ElementFactory.crocodileHeadProvider(-145, 150, 60, 1));
        this.add(ElementFactory.logProvider("short", 0, 328, 140, 0.5));
        this.add(ElementFactory.logProvider("short", 250, 328, 140, 0.5));
        this.add(ElementFactory.logProvider("short", 500, 328, 140, 0.5));
        this.add(ElementFactory.logProvider("short", 750, 328, 140, 0.5));
        this.add(ElementFactory.logProvider("long", 0, 274, 280, 1.5));
        this.add(ElementFactory.logProvider("long", 500, 274, 280, 1.5));

        endList = new EndView[5];
        endList[0] = ElementFactory.endProvider(14,97, 63, 63);
        endList[1] = ElementFactory.endProvider(142,97, 63, 63);
        endList[2] = ElementFactory.endProvider(271,97, 63, 63);
        endList[3] = ElementFactory.endProvider(399,97, 63, 63);
        endList[4] = ElementFactory.endProvider(528,97, 63, 63);
        this.add(endList[0]);
        this.add(endList[1]);
        this.add(endList[2]);
        this.add(endList[3]);
        this.add(endList[4]);

        this.add(ElementFactory.wetTurtleProvider(-250, 376, 130, -1.25));
        this.add(ElementFactory.dryTurtleProvider(0, 376, 130, -1.25));
        this.add(ElementFactory.wetTurtleProvider(250, 376, 130, -1.25));
        this.add(ElementFactory.wetTurtleProvider(500, 376, 130, -1.25));

        this.add(ElementFactory.wetTurtleProvider(-150, 217, 130, -1.25));
        this.add(ElementFactory.dryTurtleProvider(100, 217, 130, -1.25));
        this.add(ElementFactory.wetTurtleProvider(350, 217, 130, -1.25));
        this.add(ElementFactory.wetTurtleProvider(600, 217, 130, -1.25));

        this.add(ElementFactory.snakeProvider(0, 420, 60, 2));

        this.add(ElementFactory.carProvider("right", 80, 701, 50, 2));
        this.add(ElementFactory.carProvider("right", 300, 701, 50, 2));
        this.add(ElementFactory.carProvider("right", 400, 701, 50, 2));
        this.add(ElementFactory.carProvider("right", 570, 701, 50, 2));
        this.add(ElementFactory.shortTruckProvider("right", 0, 649, 120, 1));
        this.add(ElementFactory.shortTruckProvider("right", 300, 649, 120, 1));
        this.add(ElementFactory.shortTruckProvider("right", 600, 649, 120, 1));
        this.add(ElementFactory.shortTruckProvider("right", 720, 649, 120, 1));
        this.add(ElementFactory.carProvider("left", 100, 597, 50, -1));
        this.add(ElementFactory.carProvider("left", 250, 597, 50, -1));
        this.add(ElementFactory.carProvider("left", 400, 597, 50, -1));
        this.add(ElementFactory.carProvider("left", 550, 597, 50, -1));
        this.add(ElementFactory.longTruckProvider("right", 0, 540, 200, 1));
        this.add(ElementFactory.longTruckProvider("right", 500, 540, 200, 1));
        this.add(ElementFactory.carProvider("left", 500, 490, 50, -5));
        this.add(ElementFactory.carProvider("left", 800, 490, 50, -5));

        frogger = ElementFactory.froggerProvider();
        frogger.setGameMode("Infinite");
        frogger.changeEnd();
        this.add(frogger);

        initInfo("Infi");

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
        playerDifficultyLevelBoard = new Text(180, 70, "Difficulty " + presentLevel);
        playerDifficultyLevelBoard.setFont(Font.font ("Press Start 2P", 20));
        playerDifficultyLevelBoard.setFill(Color.RED);
        this.gameStage.getChildren().add(playerDifficultyLevelBoard);
    }
}
