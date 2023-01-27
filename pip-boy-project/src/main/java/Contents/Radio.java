package Contents;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Radio extends JPanel {
    private JList<String> stationList;
    private JButton playButton;
    private JButton stopButton;
    private String[] stations;
    private Clip clip;

    public Radio() {
        setLayout(new BorderLayout());
        stations = new String[]{"Station1", "Station2", "Station3"};
        stationList = new JList<>(stations);
        playButton = new JButton("Play");
        stopButton = new JButton("Stop");
        add(stationList, BorderLayout.WEST);
        add(playButton, BorderLayout.CENTER);
        add(stopButton, BorderLayout.EAST);

        playButton.addActionListener(e -> {
            String station = stationList.getSelectedValue();
            String filePath = "path/to/mp3/" + station + ".mp3";
            File audioFile = new File(filePath);

            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                AudioFormat format = audioStream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(audioStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        stopButton.addActionListener(e -> {
            if (clip != null) {
                clip.stop();
            }
        });
    }
}