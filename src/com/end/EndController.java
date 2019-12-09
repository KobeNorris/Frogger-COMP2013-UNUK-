package com.end;

import com.Controller;

/**
 * This is the controller class for view which stores End's present status
 */
public class EndController implements Controller {
    public EndModel model;

    public EndController(EndModel model){
        this.model = model;
    }

    /**
     * Sets the status of End to target status
     *
     * @param type Target status of the End
     */
    public void setStatus(String type){
        switch(type){
            case "frog":
                model.setStatus(EndModel.Status.FROGOCCUPIED);
                break;
            case "bug":
                model.setStatus(EndModel.Status.BUGOCCUPIED);
                break;
            case "croc":
                model.setStatus(EndModel.Status.CROCOCCUPIED);
                break;
            case "empty":
                model.setStatus(EndModel.Status.EMPTY);
                break;

            default:
        }
    }
}
