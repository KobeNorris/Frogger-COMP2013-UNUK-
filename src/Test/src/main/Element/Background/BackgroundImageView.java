package main.Element.Background;

		import javafx.scene.image.Image;
		import main.Element.View;

public class BackgroundImageView extends View {
    private BackgroundImageModel model;
    private BackgroundImageController controller;
    private String filePathToBackgroundImage = "file:src/img/Background/background.png";

	public BackgroundImageView() {
		setImage(new Image(this.filePathToBackgroundImage, 600, 800, true, true));
		creatBackgroundModel();
        creatBackgroundController(this.model);
	}

    public void creatBackgroundModel(){
        this.model = new BackgroundImageModel();
    }

    public void creatBackgroundController(BackgroundImageModel model){
	    this.controller = new BackgroundImageController(model);
    }

	public void act(long timer){};
}