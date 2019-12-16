package controller.gameController;

import com.end.EndView;
import javafx.fxml.FXML;
import util.ElementFactory;
import util.MapReader;

import java.util.Date;
import java.util.Random;

/**
 * <h1>HardGameController</h1>
 *
 * <P>This class extends from {@link GameController} and initialises the information demonstration and load the map for Hard game mode.
 * It enable the change of Ends status.
 * It applied {@link ElementFactory} to add elements to the scene in order to im[rove the extendability.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see GameController
 * @see ElementFactory
 */
public class HardGameController extends GameController{
    /**
     * Add the easy game mode's map and initialise the data demonstration.
     */
    @FXML
    protected void initialize(){
        initGameStage();

        try{
            MapReader.generateMap("src/main/resources/map/Map.txt", this);
        }catch(Exception e){
            System.out.println(e);
        }

//        this.add(ElementFactory.logProvider("middle", 0, 170, 170, 1));
//        this.add(ElementFactory.logProvider("middle", 250, 170, 170, 1));
//        this.add(ElementFactory.logProvider("middle", 500, 170, 170, 1));
//        this.add(ElementFactory.crocodileBodyProvider(-230, 150, 90, 1));
//        this.add(ElementFactory.crocodileHeadProvider(-145, 150, 60, 1));
//        this.add(ElementFactory.logProvider("short", 0, 328, 140, 0.5));
//        this.add(ElementFactory.logProvider("short", 250, 328, 140, 0.5));
//        this.add(ElementFactory.logProvider("short", 500, 328, 140, 0.5));
//        this.add(ElementFactory.logProvider("short", 750, 328, 140, 0.5));
//        this.add(ElementFactory.logProvider("long", 0, 274, 280, 1.5));
//        this.add(ElementFactory.logProvider("long", 500, 274, 280, 1.5));
//
//        endList = new EndView[5];
//        endList[0] = ElementFactory.endProvider(14,97, 63, 63);
//        endList[1] = ElementFactory.endProvider(142,97, 63, 63);
//        endList[2] = ElementFactory.endProvider(271,97, 63, 63);
//        endList[3] = ElementFactory.endProvider(399,97, 63, 63);
//        endList[4] = ElementFactory.endProvider(528,97, 63, 63);
//        this.add(endList[0]);
//        this.add(endList[1]);
//        this.add(endList[2]);
//        this.add(endList[3]);
//        this.add(endList[4]);
//
//        this.add(ElementFactory.wetTurtleProvider(-250, 376, 130, -1.25));
//        this.add(ElementFactory.dryTurtleProvider(0, 376, 130, -1.25));
//        this.add(ElementFactory.wetTurtleProvider(250, 376, 130, -1.25));
//        this.add(ElementFactory.wetTurtleProvider(500, 376, 130, -1.25));
//
//        this.add(ElementFactory.wetTurtleProvider(-150, 217, 130, -1.25));
//        this.add(ElementFactory.dryTurtleProvider(100, 217, 130, -1.25));
//        this.add(ElementFactory.wetTurtleProvider(350, 217, 130, -1.25));
//        this.add(ElementFactory.wetTurtleProvider(600, 217, 130, -1.25));
//
//        this.add(ElementFactory.snakeProvider(0, 420, 60, 2));
//
//        this.add(ElementFactory.carProvider(80, 701, 50, 2));
//        this.add(ElementFactory.carProvider(300, 701, 50, 2));
//        this.add(ElementFactory.carProvider(400, 701, 50, 2));
//        this.add(ElementFactory.carProvider(570, 701, 50, 2));
//        this.add(ElementFactory.shortTruckProvider(0, 649, 120, 1));
//        this.add(ElementFactory.shortTruckProvider(300, 649, 120, 1));
//        this.add(ElementFactory.shortTruckProvider(600, 649, 120, 1));
//        this.add(ElementFactory.shortTruckProvider(720, 649, 120, 1));
//        this.add(ElementFactory.carProvider(100, 597, 50, -1));
//        this.add(ElementFactory.carProvider(250, 597, 50, -1));
//        this.add(ElementFactory.carProvider(400, 597, 50, -1));
//        this.add(ElementFactory.carProvider(550, 597, 50, -1));
//        this.add(ElementFactory.longTruckProvider(0, 540, 200, 1));
//        this.add(ElementFactory.longTruckProvider(500, 540, 200, 1));
//        this.add(ElementFactory.carProvider(500, 490, 50, -5));
//        this.add(ElementFactory.carProvider(800, 490, 50, -5));

//        frogger = ElementFactory.froggerProvider();
//        frogger.setGameMode("Hard");
//        frogger.changeEnd();
//        this.add(frogger);
//
//        initInfo("Hard");

        start();
    }
}
