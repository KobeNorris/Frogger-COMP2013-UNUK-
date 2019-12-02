package code.com.background;

		import javafx.scene.image.Image;
		import code.com.View;

public class BackgroundImageView extends View {
    private BackgroundImageModel model;
    private BackgroundImageController controller;

	public BackgroundImageView() {
		creatBackgroundModel();
        creatBackgroundController(this.model);
        setImage(new Image(this.model.getFilePathToBackgroundImage(), 600, 800, true, true));
	}

    public void creatBackgroundModel(){
        this.model = new BackgroundImageModel();
    }

    public void creatBackgroundController(BackgroundImageModel model){
	    this.controller = new BackgroundImageController(model);
    }

	public void act(long timer){};
}