package main.java.controller.gameController;

import main.java.com.background.BackgroundImageView;
import main.java.com.end.EndView;
import main.java.com.frogger.FroggerView;
import main.java.com.gameMode.GameModeView;
import main.java.com.obstacle.car.CarView;
import main.java.com.obstacle.truck.longTruck.LongTruckView;
import main.java.com.obstacle.truck.shortTruck.ShortTruckView;
import main.java.com.platform.log.LogView;
import main.java.com.platform.turtle.dryTurtle.DryTurtleView;
import main.java.com.platform.turtle.wetTurtle.WetTurtleView;
import main.java.com.score.playerScore.PlayerScoreView;
import javafx.fxml.FXML;
import main.java.com.background.BackgroundImageView;

public class EasyGameController extends GameController{
    @FXML
    protected void initialize(){
        initGameStage();
        BackgroundImageView froggerback = new BackgroundImageView();

        this.add(froggerback);

        this.add(new LogView("middle", -250, 170, 170, 170, 1));
        this.add(new LogView("middle", 0, 170, 170, 170, 1));
        this.add(new LogView("middle", 250, 170, 170, 170, 1));
        this.add(new LogView("middle", 500, 170, 170, 170, 1));
        this.add(new LogView("short", -200, 328,140, 140, 0.5));
        this.add(new LogView("short", 0, 328,140, 140, 0.5));
        this.add(new LogView("short", 200, 328,140, 140, 0.5));
        this.add(new LogView("short", 400, 328, 150, 150, 0.5));
        this.add(new LogView("short", 600, 328,140, 140, 0.5));
        this.add(new LogView("long", 0, 274,280, 280, 1.5));
        this.add(new LogView("long", 333, 274,280, 280, 1.5));
        this.add(new LogView("long", 666, 274,280, 280, 1.5));

        this.add(new EndView(14,97, 63, 63));
        this.add(new EndView(142,97, 63, 63));
        this.add(new EndView(271,97, 63, 63));
        this.add(new EndView(399,97, 63, 63));
        this.add(new EndView(528,97, 63, 63));

        this.add(new DryTurtleView(-100, 376, 130, 130, -1.25));
        this.add(new WetTurtleView(100, 376, 130, 130, -1.25));
        this.add(new DryTurtleView(300, 376, 130, 130, -1.25));
        this.add(new WetTurtleView(500, 376, 130, 130, -1.25));
        this.add(new DryTurtleView(700, 376, 130, 130, -1.25));

        this.add(new WetTurtleView(-150, 217, 130, 130, -1.25));
        this.add(new DryTurtleView(50, 217, 130, 130, -1.25));
        this.add(new WetTurtleView(250, 217, 130, 130, -1.25));
        this.add(new DryTurtleView(450, 217, 130, 130, -1.25));
        this.add(new WetTurtleView(650, 217, 130, 130, -1.25));

        this.add(new CarView("right", 50, 701, 50, 2));
        this.add(new CarView("right", 300, 701,  50, 2));
        this.add(new CarView("right", 550, 701, 50, 2));
        this.add(new ShortTruckView("right", 0, 649, 120, 1));
        this.add(new ShortTruckView("right", 300, 649, 120, 1));
        this.add(new ShortTruckView("right", 600, 649, 120, 1));
        this.add(new CarView("left", 100, 597, 50, -1));
        this.add(new CarView("left", 300, 597, 50, -1));
        this.add(new CarView("left", 500, 597, 50, -1));
        this.add(new LongTruckView("right", 0, 540, 200, 1));
        this.add(new LongTruckView("right", 500, 540, 200, 1));
        this.add(new CarView("left", 500, 490, 50, -5));

        this.add(new PlayerScoreView(120, 10, 90));
        this.add(new GameModeView("Easy", 350, 10));

        frogger = FroggerView.getFroggerView();
        frogger.setGameMode("Easy");
        this.add(frogger);

        initScore(210, 45);
        initLife(105,0.5);
        start();
    }

    @Override
    public void act(long timer){}
}
