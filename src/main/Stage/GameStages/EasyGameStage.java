package main.Stage.GameStages;

import main.Element.Background.BackgroundImageView;
import main.Element.End.EndView;
import main.Element.Frogger.FroggerView;
import main.Element.Obstacle.Car.CarView;
import main.Element.Obstacle.Truck.LongTruck.LongTruckView;
import main.Element.Obstacle.Truck.ShortTruck.ShortTruckView;
import main.Element.Platform.Log.LogView;
import main.Element.Platform.Turtle.DryTurtle.DryTurtleView;
import main.Element.Platform.Turtle.WetTurtle.WetTurtleView;
import main.Element.Score.PlayerScore.PlayerScoreView;

public class EasyGameStage extends GameStage {

    @Override
    public void initGameBackGround(int difficulty){
        BackgroundImageView froggerback = new BackgroundImageView();

        this.add(froggerback);

        this.add(new LogView("middle", -250, 170, 170, 170, 1*difficulty));
        this.add(new LogView("middle", 0, 170, 170, 170, 1*difficulty));
        this.add(new LogView("middle", 250, 170, 170, 170, 1*difficulty));
        this.add(new LogView("middle", 500, 170, 170, 170, 1*difficulty));
        this.add(new LogView("short", -200, 328,140, 140, 0.5*difficulty));
        this.add(new LogView("short", 0, 328,140, 140, 0.5*difficulty));
        this.add(new LogView("short", 200, 328,140, 140, 0.5*difficulty));
        this.add(new LogView("short", 400, 328, 150, 150, 0.5*difficulty));
        this.add(new LogView("short", 600, 328,140, 140, 0.5*difficulty));
        this.add(new LogView("long", 0, 274,280, 280, 1.5*difficulty));
        this.add(new LogView("long", 333, 274,280, 280, 1.5*difficulty));
        this.add(new LogView("long", 666, 274,280, 280, 1.5*difficulty));

        this.add(new EndView(14,97, 63, 63));
        this.add(new EndView(142,97, 63, 63));
        this.add(new EndView(271,97, 63, 63));
        this.add(new EndView(399,97, 63, 63));
        this.add(new EndView(528,97, 63, 63));

        this.add(new DryTurtleView(-100, 376, 130, 130, -1.25*difficulty));
        this.add(new WetTurtleView(100, 376, 130, 130, -1.25*difficulty));
        this.add(new DryTurtleView(300, 376, 130, 130, -1.25*difficulty));
        this.add(new WetTurtleView(500, 376, 130, 130, -1.25*difficulty));
        this.add(new DryTurtleView(700, 376, 130, 130, -1.25*difficulty));

        this.add(new WetTurtleView(-150, 217, 130, 130, -1.25*difficulty));
        this.add(new DryTurtleView(50, 217, 130, 130, -1.25*difficulty));
        this.add(new WetTurtleView(250, 217, 130, 130, -1.25*difficulty));
        this.add(new DryTurtleView(450, 217, 130, 130, -1.25*difficulty));
        this.add(new WetTurtleView(650, 217, 130, 130, -1.25*difficulty));

        this.add(new CarView("right", 50, 701, 50, 2*difficulty));
        this.add(new CarView("right", 300, 701,  50, 2*difficulty));
        this.add(new CarView("right", 550, 701, 50, 2*difficulty));
        this.add(new ShortTruckView("right", 0, 649, 120, 1*difficulty));
        this.add(new ShortTruckView("right", 300, 649, 120, 1*difficulty));
        this.add(new ShortTruckView("right", 600, 649, 120, 1*difficulty));
        this.add(new CarView("left", 100, 597, 50, -1*difficulty));
        this.add(new CarView("left", 300, 597, 50, -1*difficulty));
        this.add(new CarView("left", 500, 597, 50, -1*difficulty));
        this.add(new LongTruckView("right", 0, 540, 200, 1*difficulty));
        this.add(new LongTruckView("right", 500, 540, 200, 1*difficulty));
        this.add(new CarView("left", 500, 490, 50, -5*difficulty));

        this.add(new PlayerScoreView(110, 0, 90));
        initNumber(200, 30);
        initLife(400,30);

        frogger = FroggerView.getFroggerView();
        this.add(frogger);
        start();
    }
}
