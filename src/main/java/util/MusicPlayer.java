package main.java.util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * This class is removed form the original MyStage class and presently
 * being used as a professional media player. It is developed to handle
 * background music switching process, is the background music is not
 * changed, music will not be switched.
 */
public class MusicPlayer {
    private static MediaPlayer mediaPlayer;
    private static String onPlayMusic = "";

    /**
     * This method will identify whether same music has been loaded and if not
     * it will stop present music and start playing the new background music
     *
     * @param stage
     */
    public static void loadMusic(String stage) {
        if(!onPlayMusic.equals(stage)){
            if(!onPlayMusic.equals("")){
                mediaPlayer.stop();
            }
            String musicFile;

            switch(stage){
                case "GameOriginal":
                    musicFile = "src/main/resources/audio/Frogger Main Song Theme (loop).mp3";
                    break;
                case "Menu":
                    musicFile = "src/main/resources/audio/MenuMusic.mp3";
                    break;
                case "Game":
                    musicFile = "src/main/resources/audio/GameMusic.mp3";
                    break;
                case "ScoreBoard":
                    musicFile = "src/main/resources/audio/ScoreBoardMusic.mp3";
                    break;
                default:
                    musicFile = "src/main/resources/audio/NewBaoDao.mp3";
            }
            onPlayMusic = stage;
            Media sound = new Media(new File(musicFile).toURI().toString());
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            playMusic();
        }
    }

    public static void playMusic() {
        mediaPlayer.play();
    }

    public static void pauseMusic() {mediaPlayer.pause();}

    /**
     * By stopping the music, the onPlayMusic will be set to EMPTY
     */
    public static void stopMusic() {
        onPlayMusic = "";
        mediaPlayer.stop();
    }
}
