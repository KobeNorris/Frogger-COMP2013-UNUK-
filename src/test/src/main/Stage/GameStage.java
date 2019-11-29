package main.Stage;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import main.Element.Background.BackgroundImageView;
import main.Element.End.EndView;
import main.Element.Frogger.FroggerView;
import main.Element.Obstacle.Car.CarView;
import main.Element.Obstacle.Truck.LongTruck.LongTruckView;
import main.Element.Obstacle.Truck.ShortTruck.ShortTruckView;
import main.Element.Platform.Log.LogView;
import main.Element.Platform.Turtle.DryTurtle.DryTurtleView;
import main.Element.Platform.Turtle.WetTurtle.WetTurtleView;
import main.Element.Score.DigitView;
import main.Element.Score.PlayerScore.PlayerScoreView;
import main.MyStage;

public class GameStage extends MyStage {
    FroggerView frogger;
    DigitView playerScoreBoard[], playerLifeBoard;

    public void initGameBackGround(){
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

//        this.add(new CarView("right", 80, 701, 50, 2));
//        this.add(new CarView("right", 300, 701,  50, 2));
//        this.add(new CarView("right", 400, 701, 50, 2));
//        this.add(new CarView("right", 570, 701, 50, 2));
//        this.add(new ShortTruckView("right", 0, 649, 120, 1));
//        this.add(new ShortTruckView("right", 300, 649, 120, 1));
//        this.add(new ShortTruckView("right", 600, 649, 120, 1));
//        this.add(new ShortTruckView("right", 720, 649, 120, 1));
//        this.add(new CarView("left", 100, 597, 50, -1));
//        this.add(new CarView("left", 250, 597, 50, -1));
//        this.add(new CarView("left", 400, 597, 50, -1));
//        this.add(new CarView("left", 550, 597, 50, -1));
//        this.add(new LongTruckView("right", 0, 540, 200, 1));
//        this.add(new LongTruckView("right", 500, 540, 200, 1));
//        this.add(new CarView("left", 500, 490, 50, -5));

        this.add(new PlayerScoreView(110, 0, 90));
        initNumber(200, 30);
        initLife(400,30);

        frogger = new FroggerView();
        this.add(frogger);
        playMusic();
        start();
    }

    public void updateScore(int num) {
        int digit, tempNum;
        for (int iTemp = 0; iTemp < 5; iTemp++){
            tempNum = num / 10;
            digit = num - tempNum * 10;
            num = tempNum;
            this.playerScoreBoard[iTemp].setDigit(digit);
        }
    }

    public void updateLife(int num) {
        this.playerLifeBoard.setDigit(num);
    }

    public void initNumber(double posX, double posY) {
        this.playerScoreBoard = new DigitView[5];
        int shift = 0;
        for (int iTemp = 0; iTemp < 5; iTemp++){
            this.playerScoreBoard[iTemp] = new DigitView(posX - shift, posY, 30);
            this.add(this.playerScoreBoard[iTemp]);
            shift += 30;
        }
    }

    public void initLife(double posX, double posY) {
        this.playerLifeBoard = new DigitView(posX, posY, 30);
        this.add(this.playerLifeBoard);
    }

    public void stopGame() {
        stop();
        System.out.print("STOP:");
        stopMusic();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("You Have Won The Game!");
//                    alert.setHeaderText("Your High Score: "+ frogger.getPoints()+"!");
        alert.setContentText("Highest Possible Score: 800");
        alert.show();
    }
}
