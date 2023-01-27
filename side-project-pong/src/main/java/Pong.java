import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;


public class Pong {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        MenuFrame menuFrame = new MenuFrame();
        menuFrame.setVisible(true);
        float gainAmount = 45f;
        File audio = new File("sound.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audio);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-gainAmount);
        while(true){
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
}
