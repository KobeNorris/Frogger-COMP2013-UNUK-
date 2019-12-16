package util;

import com.end.EndView;
import controller.gameController.GameController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.exit;

/**
 *<h1>MapReader</h1>
 *
 * <p>This class is applied to read in the game map provided by users. In order to
 * improve game's extendability. By using {@link ElementFactory} as the builder of
 * the game element, builder design pattern is applied to this project.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 * @since 1.0
 * @see ElementFactory
 */
public class MapReader {
    /**
     * Target game mode
     */
    private static String gameMode;
    /**
     * Whether the program is going to enable change ends
     */
    private static Boolean enableChangeEnd;
    /**
     * Target number of life player has
     */
    private static int numOfLife;
    /**
     * Target number of time player has
     */
    private static int numOfTime;

    /**
     * This method will read in the map file according to the file path provided by
     * user and load the responding game elements to the game map.
     *
     * @param filePath The file path points towards the map file
     * @param controller The present controller of game
     * @throws IOException Invalid file path
     */
    public static void generateMap(String filePath, GameController controller)throws IOException {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] parameter = bufferedReader.readLine().split(" ");
        gameMode = parameter[0];
        enableChangeEnd = Boolean.valueOf(parameter[1]);
        numOfLife = Integer.valueOf(parameter[2]);
        numOfTime = Integer.valueOf(parameter[3]);
        String elementInfo = bufferedReader.readLine();


        while(elementInfo != null) {
            parameter = elementInfo.split(" ");
            switch(parameter[0]){
                case "log":
                    if(parameter[1].equals("short"))
                        controller.add(ElementFactory.logProvider(parameter[1], Double.valueOf(parameter[2]), Double.valueOf(parameter[3]),140, Double.valueOf(parameter[4])));
                    else if(parameter[1].equals("middle"))
                        controller.add(ElementFactory.logProvider(parameter[1], Double.valueOf(parameter[2]), Double.valueOf(parameter[3]),170, Double.valueOf(parameter[4])));
                    else if(parameter[1].equals("long"))
                        controller.add(ElementFactory.logProvider(parameter[1], Double.valueOf(parameter[2]), Double.valueOf(parameter[3]),280, Double.valueOf(parameter[4])));
                    break;
                case "crocodileBody":
                    controller.add(ElementFactory.crocodileBodyProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),90, Double.valueOf(parameter[3])));
                    break;
                case "crocodileHead":
                    controller.add(ElementFactory.crocodileHeadProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),60, Double.valueOf(parameter[3])));
                    break;
                case "wetTurtle":
                    controller.add(ElementFactory.wetTurtleProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),130, Double.valueOf(parameter[3])));
                    break;
                case "dryTurtle":
                    controller.add(ElementFactory.dryTurtleProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),130, Double.valueOf(parameter[3])));
                    break;
                case "car":
                    controller.add(ElementFactory.carProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),50, Double.valueOf(parameter[3])));
                    break;
                case "shortTruck":
                    controller.add(ElementFactory.shortTruckProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),120, Double.valueOf(parameter[3])));
                    break;
                case "longTruck":
                    controller.add(ElementFactory.longTruckProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),200, Double.valueOf(parameter[3])));
                    break;
                case "snake":
                    controller.add(ElementFactory.snakeProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),55, Double.valueOf(parameter[3])));
                    break;
                default:
            }
            elementInfo = bufferedReader.readLine();
        }
        controller.endList = new EndView[5];
        controller.endList[0] = ElementFactory.endProvider(14,97, 63, 63);
        controller.endList[1] = ElementFactory.endProvider(142,97, 63, 63);
        controller.endList[2] = ElementFactory.endProvider(271,97, 63, 63);
        controller.endList[3] = ElementFactory.endProvider(399,97, 63, 63);
        controller.endList[4] = ElementFactory.endProvider(528,97, 63, 63);
        controller.add(controller.endList[0]);
        controller.add(controller.endList[1]);
        controller.add(controller.endList[2]);
        controller.add(controller.endList[3]);
        controller.add(controller.endList[4]);

        controller.frogger = ElementFactory.froggerProvider();
        controller.frogger.setGameMode(gameMode);
        controller.frogger.setChangeEndMode(enableChangeEnd);
        controller.add(controller.frogger);

        controller.initInfo(gameMode);
    }
}
