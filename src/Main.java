import gameApp.GameApp;

/**
 * Main class extends from Application, launch different stages of game and store the present points
 * player gains and the difficulty player reached. During the execution of the program, Main will keep
 * supervise whether game status has been changed.
 *
 * Refactor:
 *      1. Removed the game scene initialisation code to improve code extendability & reusability;
 *      2. Removed the digit display function and transform it into part of the scene initialisation
 */
public class Main {
    public static void main(String[] args){
        GameApp t = GameApp.getInstance();
        t.startGame();
    }
}
