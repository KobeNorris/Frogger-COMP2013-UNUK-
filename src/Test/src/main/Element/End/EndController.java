package main.Element.End;

import main.Element.Controller;

public class EndController extends Controller {
    private EndView view;
    private EndModel model;

    public EndController(int positionX, int positionY, double width, double height){
        this.model = new EndModel();
        this.view = new EndView(positionX, positionY, width, height);
    }

    public void reachEnd(){
        this.view.occupyEnd();
        this.model.setStatus(EndModel.Status.OCCUPIED);
    }

    @Override
    public void act(long timer){
    }

    @Override
    public EndView getView(){
        return this.view;
    }
}
