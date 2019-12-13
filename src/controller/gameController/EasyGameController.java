package controller.gameController;

import javafx.fxml.FXML;
import util.ElementFactory;

/**
 * This function initialise the information demonstration and load the map for easy game mode.
 * It applied {@link ElementFactory} to add elements to the scene in order to im[rove the extendability.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 */
public class EasyGameController extends GameController{
    /**
     * Add the easy game mode's map and initialise the data demonstration.
     */
    @FXML
    protected void initialize(){
        initGameStage();

        this.add(ElementFactory.logProvider("middle", -250, 170, 170, 1));
        this.add(ElementFactory.logProvider("middle", 0, 170, 170, 1));
        this.add(ElementFactory.logProvider("middle", 250, 170, 170, 1));
        this.add(ElementFactory.logProvider("middle", 500, 170, 170, 1));
        this.add(ElementFactory.logProvider("short", -200, 328, 140, 0.5));
        this.add(ElementFactory.logProvider("short", 0, 328, 140, 0.5));
        this.add(ElementFactory.logProvider("short", 200, 328, 140, 0.5));
        this.add(ElementFactory.logProvider("short", 400, 328, 140, 0.5));
        this.add(ElementFactory.logProvider("short", 600, 328, 140, 0.5));
        this.add(ElementFactory.logProvider("long", 0, 274, 280, 1.5));
        this.add(ElementFactory.logProvider("long", 333, 274, 280, 1.5));
        this.add(ElementFactory.logProvider("long", 666, 274, 280, 1.5));

        this.add(ElementFactory.endProvider(14,97, 63, 63));
        this.add(ElementFactory.endProvider(142,97, 63, 63));
        this.add(ElementFactory.endProvider(271,97, 63, 63));
        this.add(ElementFactory.endProvider(399,97, 63, 63));
        this.add(ElementFactory.endProvider(528,97, 63, 63));

        this.add(ElementFactory.dryTurtleProvider(-100, 376, 130, -1.25));
        this.add(ElementFactory.wetTurtleProvider(100, 376, 130, -1.25));
        this.add(ElementFactory.dryTurtleProvider(300, 376, 130, -1.25));
        this.add(ElementFactory.wetTurtleProvider(500, 376, 130, -1.25));
        this.add(ElementFactory.dryTurtleProvider(700, 376, 130, -1.25));

        this.add(ElementFactory.wetTurtleProvider(-150, 217, 130, -1.25));
        this.add(ElementFactory.dryTurtleProvider(50, 217, 130, -1.25));
        this.add(ElementFactory.wetTurtleProvider(250, 217, 130, -1.25));
        this.add(ElementFactory.dryTurtleProvider(450, 217, 130, -1.25));
        this.add(ElementFactory.wetTurtleProvider(650, 217, 130, -1.25));

        this.add(ElementFactory.carProvider("right", 50, 701, 50, 2));
        this.add(ElementFactory.carProvider("right", 300, 701, 50, 2));
        this.add(ElementFactory.carProvider("right", 550, 701, 50, 2));
        this.add(ElementFactory.shortTruckProvider("right", 0, 649, 120, 1));
        this.add(ElementFactory.shortTruckProvider("right", 300, 649, 120, 1));
        this.add(ElementFactory.shortTruckProvider("right", 600, 649, 120, 1));
        this.add(ElementFactory.carProvider("left", 100, 597, 50, -1));
        this.add(ElementFactory.carProvider("left", 300, 597, 50, -1));
        this.add(ElementFactory.carProvider("left", 500, 597, 50, -1));
        this.add(ElementFactory.longTruckProvider("right", 0, 540, 200, 1));
        this.add(ElementFactory.longTruckProvider("right", 500, 540, 200, 1));
        this.add(ElementFactory.carProvider("left", 500, 490, 50, -5));

        frogger = ElementFactory.froggerProvider();
        frogger.setGameMode("Easy");
        this.add(frogger);

        initTime(60);
        initScore(0);
        initLife(3);
        initGameMode("Easy");

        start();
    }

    /**
     * Disabled the changes amongst ends
     *
     * @param timer The time counter initialise by controller himself
     */
    @Override
    public void act(long timer){
        long timeInterval = 1000000000L ;
        if((timer - this.lastTimer) > timeInterval){
            this.lastTimer = timer;
            frogger.deductTime();
            updateTime(frogger.getRemainingTime());
        }
    }
}
