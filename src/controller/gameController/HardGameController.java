package controller.gameController;

import com.background.BackgroundImageView;
import com.end.EndView;
import com.frogger.FroggerView;
import com.gameMode.GameModeView;
import com.obstacle.car.CarView;
import com.obstacle.snake.SnakeView;
import com.obstacle.truck.longTruck.LongTruckView;
import com.obstacle.truck.shortTruck.ShortTruckView;
import com.platform.crocodile.crocodileBody.CrocodileBodyView;
import com.platform.crocodile.crocodileHead.CrocodileHeadView;
import com.platform.log.LogView;
import com.platform.turtle.dryTurtle.DryTurtleView;
import com.platform.turtle.wetTurtle.WetTurtleView;
import javafx.fxml.FXML;

import java.util.Date;
import java.util.Random;

/**
 * This function initialise the information demonstration and load the map for Hard game mode.
 * It enable the change of Ends status.
 */
public class HardGameController extends GameController{
    protected static EndView[] endList;
    /**
     * Add the easy game mode's map and initialise the data demonstration.
     */
    @FXML
    protected void initialize(){
        initGameStage();
        BackgroundImageView froggerBack = new BackgroundImageView();

        this.add(froggerBack);

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

        this.add(new GameModeView("Hard", 240, 10));

        frogger = FroggerView.getFroggerView();
        frogger.setGameMode("Hard");
        frogger.changeEnd();
        this.add(frogger);

        initTime(90);
        initScore(0);
        initLife(3);
        start();
    }

    /**
     * This function changes the status of ends, there is going to be only one
     * pair of CrocEnd and BugEnd exist simultaneously at most. And if there is
     * only one End left, it will be set to BugEnd.
     */
    public static void changeEnd(){
        int emptyEndCounter = 0;
        Date date = new Date();
        Random rand = new Random(date.getTime());
        for(int iTemp = 0; iTemp < 5; iTemp++){
            if(!endList[iTemp].checkStatusFROGOCCUPIED()){
                emptyEndCounter++;
                endList[iTemp].occupyEnd("empty");
            }
        }
        if(emptyEndCounter > 0){
            int tempCounter = 0;
            int targetIndex = rand.nextInt(emptyEndCounter);
            targetIndex++;
            for(int iTemp = 0; iTemp < 5; iTemp++){
                if(endList[iTemp].checkStatusEMPTY()){
                    tempCounter++;
                }
                if(targetIndex == tempCounter){
                    endList[iTemp].occupyEnd("bug");
                    break;
                }
            }
            if(emptyEndCounter > 1){
                tempCounter = 0;
                targetIndex = rand.nextInt(emptyEndCounter-1);
                targetIndex++;
                for(int iTemp = 0; iTemp < 5; iTemp++){
                    if(endList[iTemp].checkStatusEMPTY())
                        tempCounter++;
                    if(targetIndex == tempCounter){
                        endList[iTemp].occupyEnd("croc");
                        break;
                    }
                }
            }
        }
    }
}
