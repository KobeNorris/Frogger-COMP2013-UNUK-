package main.Element.Background;

		import javafx.scene.image.Image;
		import main.Element.*;

public class BackgroundImageView extends View {

	public BackgroundImageView(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));

	}

}
