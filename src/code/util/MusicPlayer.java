package code.util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MusicPlayer {
    private static MediaPlayer mediaPlayer;
    private static String onPlayMusic = "";

    public static void loadMusic(String stage) {
        if(!onPlayMusic.equals(stage)){
            if(!onPlayMusic.equals("")){
                mediaPlayer.stop();
            }
            String musicFile;

            switch(stage){
                case "GameOriginal":
                    musicFile = "src/resource/audio/Frogger Main Song Theme (loop).mp3";
                    break;
                case "Menu":
                    musicFile = "src/resource/audio/MenuMusic.mp3";
                    break;
                case "Game":
                    musicFile = "src/resource/audio/GameMusic.mp3";
                    break;
                case "ScoreBoard":
                    musicFile = "src/resource/audio/ScoreBoardMusic.mp3";
                    break;
                default:
                    musicFile = "src/resource/audio/NewBaoDao.mp3";
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

    public static void stopMusic() {
        onPlayMusic = "";
        mediaPlayer.stop();
    }
}
