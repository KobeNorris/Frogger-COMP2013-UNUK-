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

import java.util.Date;
import java.util.Random;

public class HardGameStage extends GameStage {
    private static EndView[] EndList;

    @Override
    public void initGameBackGround(int difficulty){
        BackgroundImageView froggerback = new BackgroundImageView();

        this.add(froggerback);

        this.add(new LogView("middle", 0, 170, 170, 170, 1*difficulty));
        this.add(new LogView("middle", 333, 170, 170, 170, 1*difficulty));
        this.add(new LogView("middle", 666, 170, 170, 170, 1*difficulty));
        this.add(new LogView("short", 0, 328,140, 140, 0.5*difficulty));
        this.add(new LogView("short", 250, 328,140, 140, 0.5*difficulty));
        this.add(new LogView("short", 500, 328,140, 140, 0.5*difficulty));
        this.add(new LogView("short", 750, 328, 150, 150, 0.5*difficulty));
        this.add(new LogView("long", 0, 274,280, 280, 1.5*difficulty));
        this.add(new LogView("long", 500, 274,280, 280, 1.5*difficulty));

        EndList = new EndView[5];
        EndList[0] = new EndView(14,97, 63, 63);
        EndList[1] = new EndView(142,97, 63, 63);
        EndList[2] = new EndView(271,97, 63, 63);
        EndList[3] = new EndView(399,97, 63, 63);
        EndList[4] = new EndView(528,97, 63, 63);
        this.add(EndList[0]);
        this.add(EndList[1]);
        this.add(EndList[2]);
        this.add(EndList[3]);
        this.add(EndList[4]);

        this.add(new WetTurtleView(-250, 376, 130, 130, -1.25*difficulty));
        this.add(new DryTurtleView(0, 376, 130, 130, -1.25*difficulty));
        this.add(new WetTurtleView(250, 376, 130, 130, -1.25*difficulty));
        this.add(new WetTurtleView(500, 376, 130, 130, -1.25*difficulty));

        this.add(new WetTurtleView(-150, 217, 130, 130, -1.25*difficulty));
        this.add(new DryTurtleView(100, 217, 130, 130, -1.25*difficulty));
        this.add(new WetTurtleView(350, 217, 130, 130, -1.25*difficulty));
        this.add(new WetTurtleView(600, 217, 130, 130, -1.25*difficulty));

//        this.add(new CarView("right", 80, 701, 50, 2*difficulty));
//        this.add(new CarView("right", 300, 701,  50, 2*difficulty));
//        this.add(new CarView("right", 400, 701, 50, 2*difficulty));
//        this.add(new CarView("right", 570, 701, 50, 2*difficulty));
//        this.add(new ShortTruckView("right", 0, 649, 120, 1*difficulty));
//        this.add(new ShortTruckView("right", 300, 649, 120, 1*difficulty));
//        this.add(new ShortTruckView("right", 600, 649, 120, 1*difficulty));
//        this.add(new ShortTruckView("right", 720, 649, 120, 1*difficulty));
//        this.add(new CarView("left", 100, 597, 50, -1*difficulty));
//        this.add(new CarView("left", 250, 597, 50, -1*difficulty));
//        this.add(new CarView("left", 400, 597, 50, -1*difficulty));
//        this.add(new CarView("left", 550, 597, 50, -1*difficulty));
//        this.add(new LongTruckView("right", 0, 540, 200, 1*difficulty));
//        this.add(new LongTruckView("right", 500, 540, 200, 1*difficulty));
//        this.add(new CarView("left", 500, 490, 50, -5*difficulty));
//        this.add(new CarView("left", 700, 490, 50, -5*difficulty));

        this.add(new PlayerScoreView(110, 0, 90));
        initNumber(200, 30);
        initLife(400,30);

        frogger = FroggerView.getFroggerView();
        this.add(frogger);
        start();
    }

    public static void changeEnd(){
        int emptyEndCounter = 0;
        Date date = new Date();
        Random rand = new Random(date.getTime());
        for(int iTemp = 0; iTemp < 5; iTemp++){
            if(!EndList[iTemp].checkStatusFROGOCCUPIED()){
                emptyEndCounter++;
                EndList[iTemp].occupyEnd("empty");
                System.out.println("iTemp: " + iTemp + " is empty");
            }else{
                System.out.println("iTemp: " + iTemp + " is frog");
            }
        }
        if(emptyEndCounter > 0){
            int tempCounter = 0;
            int targetIndex = rand.nextInt(emptyEndCounter);
            targetIndex++;
            System.out.println("TargetIndex is " + targetIndex);
            for(int iTemp = 0; iTemp < 5; iTemp++){
                if(EndList[iTemp].checkStatusEMPTY()){
                    tempCounter++;
                }
                if(targetIndex == tempCounter){
                    EndList[iTemp].occupyEnd("bug");
                    System.out.println("bug - " + iTemp);
                }
            }
//            if(emptyEndCounter > 1){
//                tempCounter = 0;
//                targetIndex = rand.nextInt(emptyEndCounter);
//                System.out.println("Target index - " + targetIndex);
//                for(int iTemp = 0; iTemp < 5; iTemp++){
//                    if(EndList[iTemp].checkStatusEMPTY())
//                        tempCounter++;
//                    if(targetIndex == tempCounter){
//                        EndList[iTemp].occupyEnd("croc");
//                        System.out.println("croc - " + iTemp);
//                    }
//                }
//            }
        }
    }
}
