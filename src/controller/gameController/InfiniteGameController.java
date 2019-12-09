package controller.gameController;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import com.end.EndView;
import com.frogger.FroggerView;
import com.obstacle.car.CarView;
import com.obstacle.snake.SnakeView;
import com.obstacle.truck.LongTruckView;
import com.obstacle.truck.ShortTruckView;
import com.platform.crocodile.CrocodileBodyView;
import com.platform.crocodile.CrocodileHeadView;
import com.platform.log.LogView;
import com.platform.turtle.DryTurtleView;
import com.platform.turtle.WetTurtleView;
import gameApp.Main;

/**
 * This function initialise the information demonstration and load the map for infinite game mode.
 * It enable the change of Ends status and the infinite playing terms.
 */
public class InfiniteGameController extends HardGameController{
    private static Text playerDifficultyLevelBoard;
    /**
     * Add the infinite game mode's map and initialise the data demonstration.
     */
    @Override
    public void initialize(){
        initGameStage();

        this.add(new LogView("middle", 0, 170, 170, 170, 1));
        this.add(new LogView("middle", 250, 170, 170, 170, 1));
        this.add(new LogView("middle", 500, 170, 170, 170, 1));
        this.add(new CrocodileBodyView(-230, 150, 90, 90, 1));
        this.add(new CrocodileHeadView(-145, 150, 60, 60, 1));
        this.add(new LogView("short", 0, 328,140, 140, 0.5));
        this.add(new LogView("short", 250, 328,140, 140, 0.5));
        this.add(new LogView("short", 500, 328,140, 140, 0.5));
        this.add(new LogView("short", 750, 328, 150, 150, 0.5));
        this.add(new LogView("long", 0, 274,280, 280, 1.5));
        this.add(new LogView("long", 500, 274,280, 280, 1.5));

        endList = new EndView[5];
        endList[0] = new EndView(14,97, 63, 63);
        endList[1] = new EndView(142,97, 63, 63);
        endList[2] = new EndView(271,97, 63, 63);
        endList[3] = new EndView(399,97, 63, 63);
        endList[4] = new EndView(528,97, 63, 63);
        this.add(endList[0]);
        this.add(endList[1]);
        this.add(endList[2]);
        this.add(endList[3]);
        this.add(endList[4]);

        this.add(new WetTurtleView(-250, 376, 130, 130, -1.25));
        this.add(new DryTurtleView(0, 376, 130, 130, -1.25));
        this.add(new WetTurtleView(250, 376, 130, 130, -1.25));
        this.add(new WetTurtleView(500, 376, 130, 130, -1.25));

        this.add(new WetTurtleView(-150, 217, 130, 130, -1.25));
        this.add(new DryTurtleView(100, 217, 130, 130, -1.25));
        this.add(new WetTurtleView(350, 217, 130, 130, -1.25));
        this.add(new WetTurtleView(600, 217, 130, 130, -1.25));

        this.add(new SnakeView(0, 420, 60, 2));

        this.add(new CarView("right", 80, 701, 50, 2));
        this.add(new CarView("right", 300, 701,  50, 2));
        this.add(new CarView("right", 400, 701, 50, 2));
        this.add(new CarView("right", 570, 701, 50, 2));
        this.add(new ShortTruckView("right", 0, 649, 120, 1));
        this.add(new ShortTruckView("right", 300, 649, 120, 1));
        this.add(new ShortTruckView("right", 600, 649, 120, 1));
        this.add(new ShortTruckView("right", 720, 649, 120, 1));
        this.add(new CarView("left", 100, 597, 50, -1));
        this.add(new CarView("left", 250, 597, 50, -1));
        this.add(new CarView("left", 400, 597, 50, -1));
        this.add(new CarView("left", 550, 597, 50, -1));
        this.add(new LongTruckView("right", 0, 540, 200, 1));
        this.add(new LongTruckView("right", 500, 540, 200, 1));
        this.add(new CarView("left", 500, 490, 50, -5));
        this.add(new CarView("left", 700, 490, 50, -5));

        frogger = FroggerView.getFroggerView();
        frogger.setGameMode("Infinite");
        frogger.changeEnd();
        this.add(frogger);

        initTime(90);
        initScore(0);
        initLife(3);
        initGameMode("Infinite");

        initLevel(1);

        start();
    }

    /**
     * Reset the frogger and ends back to the start status and position
     */
    public static void resetGame(){
        updateDifficulty(++Main.diffficulty);
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
        playerDifficultyLevelBoard.setText("Difficulty" + presentLevel);
    }

    /**
     * initialise the difficulty level.
     *
     * @param presentLevel Present difficulty level player has reached
     */
    public void initLevel(int presentLevel){
        playerDifficultyLevelBoard = new Text(240, 70, "Difficulty" + presentLevel);
        playerDifficultyLevelBoard.setFont(Font.font ("Verdana", 25));
        playerDifficultyLevelBoard.setFill(Color.RED);
        this.gameStage.getChildren().add(playerDifficultyLevelBoard);
    }
}
