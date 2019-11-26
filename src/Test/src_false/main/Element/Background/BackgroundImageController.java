package main.Element.Background;

import main.Element.*;

public class BackgroundImageController extends Controller {
    private View view;

    public BackgroundImageController(String imageLink){
        this.view = new BackgroundImageView(imageLink);
    }

    @Override
    public void act(long timer){}

    @Override
    public View getView(){
        return this.view;
    }
}
