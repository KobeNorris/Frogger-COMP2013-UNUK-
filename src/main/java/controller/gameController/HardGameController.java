package main.java.controller.gameController;

import main.java.com.background.BackgroundImageView;
import main.java.com.end.EndView;
import main.java.com.frogger.FroggerView;
import main.java.com.gameMode.GameModeView;
import main.java.com.obstacle.car.CarView;
import main.java.com.obstacle.snake.SnakeView;
import main.java.com.obstacle.truck.longTruck.LongTruckView;
import main.java.com.obstacle.truck.shortTruck.ShortTruckView;
import main.java.com.platform.crocodile.crocodileBody.CrocodileBodyView;
import main.java.com.platform.crocodile.crocodileHead.CrocodileHeadView;
import main.java.com.platform.log.LogView;
import main.java.com.platform.turtle.dryTurtle.DryTurtleView;
import main.java.com.platform.turtle.wetTurtle.WetTurtleView;
import main.java.com.score.playerScore.PlayerScoreView;
import javafx.fxml.FXML;

import java.util.Date;
import java.util.Random;

public class HardGameController extends GameController{
    protected static EndView[] endList;

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

        this.add(new PlayerScoreView(120, 10, 90));
        this.add(new GameModeView("Hard", 350, 10));

        frogger = FroggerView.getFroggerView();
        frogger.setGameMode("Hard");
        frogger.enableChangeEnd();
        this.add(frogger);

        initScore(210, 45);
        initLife(105,0.5);
        start();
    }

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

    @Override
    public void act(long timer){}
}
