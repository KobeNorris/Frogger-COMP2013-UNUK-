package util;

import com.end.EndView;
import com.frogger.FroggerView;
import com.icon.LifeIconView;
import com.icon.PauseIconView;
import com.obstacle.car.CarView;
import com.obstacle.snake.SnakeView;
import com.obstacle.truck.LongTruckView;
import com.obstacle.truck.ShortTruckView;
import com.platform.crocodile.CrocodileBodyView;
import com.platform.crocodile.CrocodileHeadView;
import com.platform.log.LogView;
import com.platform.turtle.DryTurtleView;
import com.platform.turtle.WetTurtleView;

/**
 * This class is used as a factory to provide game elements to {@link controller.gameController.GameController}'s child class,
 * including:
 *      <p>1. {@link controller.gameController.EasyGameController};
 *      <p>2. {@link controller.gameController.HardGameController};
 *      <p>3. {@link controller.gameController.InfiniteGameController}.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.3
 */
public class ElementFactory {
    /**
     * This method implements the SINGLETON design pattern {@link FroggerView}
     *
     * @return The instance of frogger
     */
    public static FroggerView froggerProvider(){
        return FroggerView.getFroggerView();
    }

    /**
     * This constructor initialise the position and size of End {@link EndView}
     *
     * @param positionX End's X position
     * @param positionY End's Y position
     * @param width  End's width
     * @param height  End's height
     * @return The end's image view
     */
    public static EndView endProvider(int positionX, int positionY, double width, double height){
        return new EndView(positionX, positionY, width, height);
    }

    /**
     * This constructor initialise the position, size and speed of CarView {@link CarView}
     *
     * @param carType The direction of car image
     * @param positionX CarView's X position
     * @param positionY CarView's Y position
     * @param size  CarView's size
     * @param speed  CarView's speed
     * @return The car's image view
     */
    public static CarView carProvider(String carType, double positionX, double positionY, double size, double speed){
        return new CarView(carType, positionX, positionY, size, speed);
    }

    /**
     * This constructor initialise the position, size and speed of SnakeView {@link SnakeView}
     *
     * @param positionX SnakeView's X position
     * @param positionY SnakeView's Y position
     * @param size  SnakeView's size
     * @param speed  SnakeView's speed
     * @return The snake's image view
     */
    public static SnakeView snakeProvider(double positionX, double positionY, double size, double speed){
        return new SnakeView(positionX, positionY, size, speed);
    }

    /**
     * This constructor initialise the type, position, size and speed of LongTruckView {@link LongTruckView}
     *
     * @param longTruckType Type of the truck
     * @param positionX LongTruckView's X position
     * @param positionY LongTruckView's Y position
     * @param size  LongTruckView's size
     * @param speed  LongTruckView's speed
     * @return The long truck's image view
     */
    public static LongTruckView longTruckProvider(String longTruckType, double positionX, double positionY, double size, double speed){
        return new LongTruckView(longTruckType, positionX, positionY, size, speed);
    }

    /**
     * This constructor initialise the position, size and speed of ShortTruckView {@link ShortTruckView}
     *
     * @param shortTruckType Type of the truck
     * @param positionX ShortTruckView's X position
     * @param positionY ShortTruckView's Y position
     * @param size  ShortTruckView's size
     * @param speed  ShortTruckView's speed
     * @return The short truck's image view
     */
    public static ShortTruckView shortTruckProvider(String shortTruckType, double positionX, double positionY, double size, double speed){
        return new ShortTruckView(shortTruckType, positionX, positionY, size, speed);
    }

    /**
     * This constructor initialise the position, size and speed of CrocodileBodyView {@link CrocodileBodyView}
     *
     * @param positionX CrocodileBodyView's X position
     * @param positionY CrocodileBodyView's Y position
     * @param size CrocodileBodyView's size
     * @param speed CrocodileBodyView's speed
     * @return The crocodile body's image view
     */
    public static CrocodileBodyView crocodileBodyProvider(double positionX, double positionY, double size, double speed){
        return new CrocodileBodyView(positionX, positionY, size, speed);
    }

    /**
     * This constructor initialise the position, size and speed of CrocodileHeadView {@link CrocodileHeadView}
     *
     * @param positionX CrocodileHeadView's X position
     * @param positionY CrocodileHeadView's Y position
     * @param size  CrocodileHeadView's size
     * @param speed  CrocodileHeadView's speed
     * @return The crocodile head's image view
     */
    public static CrocodileHeadView crocodileHeadProvider(double positionX, double positionY, double size, double speed){
        return new CrocodileHeadView(positionX, positionY, size, speed);
    }

    /**
     * This constructor initialise the type, position, size and speed of LogView {@link LogView}
     *
     * @param type Type of the log View
     * @param positionX LogView's X position
     * @param positionY LogView's Y position
     * @param size  LogView's size
     * @param speed  LogView's speed
     * @return The log's image view
     */
    public static LogView logProvider(String type, double positionX, double positionY, double size, double speed){
        return new LogView(type, positionX, positionY, size, speed);
    }

    /**
     * This constructor initialise the position, size and speed of DryTurtleView {@link DryTurtleView}
     *
     * @param positionX DryTurtleView's X position
     * @param positionY DryTurtleView's Y position
     * @param size DryTurtleView's size
     * @param speed DryTurtleView's speed
     * @return The dry turtle's image view
     */
    public static DryTurtleView dryTurtleProvider(double positionX, double positionY, double size, double speed){
        return new DryTurtleView(positionX, positionY, size, speed);
    }

    /**
     * This constructor initialise the position, size and speed of WetTurtleView {@link WetTurtleView}
     *
     * @param positionX WetTurtleView's X position
     * @param positionY WetTurtleView's Y position
     * @param size  WetTurtleView's size
     * @param speed  WetTurtleView's speed
     * @return The wet turtle's image view
     */
    public static WetTurtleView wetTurtleProvider(double positionX, double positionY, double size, double speed){
        return new WetTurtleView(positionX, positionY, size, speed);
    }

    /**
     * This is the only constructor of lifeIconView, which takes the
     * icon's x position, y position and size of the image. Then, display
     * it to the player.
     *
     * @param positionX The position of life icon in X direction
     * @param positionY The position of life icon in Y direction
     * @param size The size of the image of life icon
     * @retrun The life icon's image view
     */
    public static LifeIconView lifeIconViewProvider(double positionX, double positionY, double size){
        return new LifeIconView(positionX, positionY, size);
    }

    /**
     * This is the only constructor of PauseIconView, which takes the
     * icon's x position, y position and size of the image. Then, display
     * it to the player.
     *
     * @param positionX The position of pause icon in X direction
     * @param positionY The position of pause icon in Y direction
     * @param size The size of the image of pause icon
     * @retrun The pause icon's image view
     */
    public static PauseIconView pauseIconViewProvider(double positionX, double positionY, double size){
        return new PauseIconView(positionX, positionY, size);
    }
}
