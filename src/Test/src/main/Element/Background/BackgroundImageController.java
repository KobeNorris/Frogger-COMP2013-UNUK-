package main.Element.Background;

import main.Element.*;

public class BackgroundImageController extends Controller {
    private Viewer viewer;

    public BackgroundImageController(String imageLink){
        this.viewer = new BackgroundImageViewer(imageLink);
    }

    @Override
    public void act(long timer){}

    @Override
    public Viewer getViewer(){
        return this.viewer;
    }
}
