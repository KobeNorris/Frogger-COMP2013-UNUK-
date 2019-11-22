package main.Element.Background;

		import javafx.scene.image.Image;
		import main.Element.*;

public class BackgroundImageViewer extends Viewer {

	public BackgroundImageViewer(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));

	}

}
