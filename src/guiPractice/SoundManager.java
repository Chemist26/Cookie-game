package guiPractice;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SoundManager {
    private Clip clickSound;

    public SoundManager() {
        loadClickSound();
    }

    private void loadClickSound() {
        try {
            String soundFilePath = "res/clickCookie.wav";
            File soundFile = new File(soundFilePath);
            URL soundURL = soundFile.toURI().toURL();

            System.out.println("Sound URL: " + soundURL);

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            clickSound = AudioSystem.getClip();
            clickSound.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    public void playClickSound() {
        if (clickSound != null) {
            clickSound.stop();  // Stop any previous instances
            clickSound.setFramePosition(0);  // Rewind to the beginning
            clickSound.start();  // Play the sound
        }
    }
}
