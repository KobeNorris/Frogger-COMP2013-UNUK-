package main.java.com.end;

import main.java.com.Controller;

public class EndController implements Controller {
    private EndModel model;

    public EndController(EndModel model){
        this.model = model;
    }

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
