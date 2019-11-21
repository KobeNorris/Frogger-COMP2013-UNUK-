package main.Element.Frogger;

import javafx.scene.input.KeyCode;
import main.Element.Frogger.*;

public class FroggerController {
    private FroggerViewer froggerViewer;
    private FroggerModel froggerModel;

    public FroggerController(){
        this.froggerModel = new FroggerModel();
        this.froggerViewer = this.froggerViewer.getFrogger();
        this.froggerViewer.setController(this);
    }

    public void moveInstruction(KeyCode pressedKey){
        if(this.froggerModel.noMove){

        }else{
            this.froggerViewer.keyBoardPress(pressedKey);
            checkDeath();
        }
    }

    public void checkDeath(){

    }
}
