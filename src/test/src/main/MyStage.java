package main;

import java.io.File;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import main.Element.View;

public class MyStage extends World {
//	private AnimationTimer timer;
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
	}
	
	public MyStage() {
//		mediaPlayer.play();
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//			@Override
//			public void run()
//				mediaPlayer.seek(Duration.ZERO);
//		});
//		mediaPlayer.play();
	}
	
	public void playMusic() {
		String musicFile = "src/audio/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
