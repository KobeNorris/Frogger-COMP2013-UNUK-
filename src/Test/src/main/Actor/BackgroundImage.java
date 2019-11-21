package main.Actor;

		import javafx.scene.image.Image;
		import main.Element.*;

public class BackgroundImage extends Viewer {

	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));

	}

}
