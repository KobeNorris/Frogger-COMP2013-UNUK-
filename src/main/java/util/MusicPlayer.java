package util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * <h1>MusicPlayer</h1>
 *
 * <p>This class is removed form the original MyStage class and presently
 * being used as a professional media player. It is developed to handle
 * background music switching process, is the background music is not
 * changed, music will not be switched.
 *
 * <p>It is applied in {@link SceneSwitcher}
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 * @since 1.0
 * @see SceneSwitcher
 */
public class MusicPlayer {
    private static MediaPlayer mediaPlayer;
    /**
     * The name of the current playing music
     */
    private static String onPlayMusic = "";
    private static String filePath = "src/main/resources/audio/";

    /**
     * This method will identify whether same music has been loaded and if not
     * it will stop present music and start playing the new background music
     *
     * @param stage Present music game stage is playing
     */
    public static void loadMusic(String stage) {
        if(!onPlayMusic.equals(stage)){
            if(!onPlayMusic.equals("")){
                mediaPlayer.stop();
            }
            String musicFile;

            switch(stage){
                case "GameOriginal":
                    musicFile = filePath + "Frogger Main Song Theme (loop).mp3";
                    break;
                case "Menu":
                    musicFile = filePath + "MenuMusic.mp3";
                    break;
                case "Game":
                    musicFile = filePath + "GameMusic.mp3";
                    break;
                case "ScoreBoard":
                    musicFile = filePath + "ScoreBoardMusic.mp3";
                    break;
                default:
                    musicFile = filePath + "NewBaoDao.mp3";
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

    /**
     * Get the name of present music name
     *
     * @return Present music name
     */
    public static String getPresentMusic(){
        return onPlayMusic;
    }
}
