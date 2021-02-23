package Tools;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class Music {

    private static final String MAIN_MENU_THEME = "src/Asset/Sons/Anna_KANZIG.mp3";
    private static final String GAME_THEME = "src/Asset/Sons/Anna_KANZIG.mp3";
    private static MediaPlayer mediaPlayer;
    private static double volume = 0.1;

    public static void startMainMenuMusic() {
        if( mediaPlayer != null ) mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(Paths.get(MAIN_MENU_THEME).toUri().toString()));
        mediaPlayer.setCycleCount(10);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();

    }

    public static void startGameMusic() {
        if( mediaPlayer != null )mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(Paths.get(GAME_THEME).toUri().toString()));
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public static void setVolume(double volume) {
        Music.volume = volume;
        if(mediaPlayer!=null) mediaPlayer.setVolume(volume);
    }


}
