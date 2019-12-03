package code.stageController.gameController;

import code.Main;
import code.com.background.BackgroundImageView;
import code.com.end.EndView;
import code.com.frogger.FroggerView;
import code.com.gameMode.GameModeView;
import code.com.obstacle.car.CarView;
import code.com.obstacle.truck.longTruck.LongTruckView;
import code.com.obstacle.truck.shortTruck.ShortTruckView;
import code.com.platform.log.LogView;
import code.com.platform.turtle.dryTurtle.DryTurtleView;
import code.com.platform.turtle.wetTurtle.WetTurtleView;
import code.com.score.DigitView;
import code.com.score.playerScore.PlayerScoreView;

public class InfiniteGameController extends HardGameController{
    private static DigitView tempDigitView;

    @Override
    public void initialize(){
        initGameStage();
        BackgroundImageView froggerBack = new BackgroundImageView();

        this.add(froggerBack);

        this.add(new LogView("middle", 0, 170, 170, 170, 1));
        this.add(new LogView("middle", 333, 170, 170, 170, 1));
        this.add(new LogView("middle", 666, 170, 170, 170, 1));
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
        this.add(new GameModeView(350, 10));

        frogger = FroggerView.getFroggerView();
        frogger.enableChangeEnd();
        this.add(frogger);

        initScore(210, 45);
        initLife(105,0.5);
        initLevel(450,40);
        start();
    }

    public static void resetGame(){
        updateDifficulty(++Main.diffficulty);
        for(int iTemp = 0; iTemp < 5; iTemp++){
            endList[iTemp].occupyEnd("empty");
        }
        frogger.enableChangeEnd();
    }

    public static void updateDifficulty(int num){
        tempDigitView.setDigit(num);
    }

    public void initLevel(double posX, double posY){
        tempDigitView = new DigitView(posX, posY, 30);
        updateDifficulty(Main.diffficulty);
        this.add(tempDigitView);
    }
}
