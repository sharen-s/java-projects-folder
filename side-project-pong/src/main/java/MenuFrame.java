import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class MenuFrame extends JFrame {
    private JButton startButton;
//    private JButton settingsButton;
    private JButton exitButton;
    private JPanel menuPanel;
    Color fontCustomColor = new Color(239, 50, 165);
    Color buttonCustomColor = new Color(255, 188, 213);
    Color borderCustomColor = new Color(248, 50, 171);
    Font customFont = new Font("DialogInput", Font.BOLD|Font.ITALIC, 20);

    public MenuFrame() {
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.pink);
        setTitle("Pong Game - Menu");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        startButton = new JButton("Start Game");
        startButton.setForeground(fontCustomColor);
        startButton.setBackground(buttonCustomColor);
        startButton.setFont(customFont);
        startButton.setFocusPainted(false);
        startButton.setBorder(new LineBorder(borderCustomColor, 1));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // start the game by creating a new GameFrame
                GameFrame gameFrame = new GameFrame();
                gameFrame.setVisible(true);
                // hide the menu frame
                setVisible(false);
            }
        });
        add(startButton);

//        settingsButton = new JButton("Settings");
//        settingsButton.setForeground(fontCustomColor);
//        settingsButton.setBackground(buttonCustomColor);
//        settingsButton.setFont(customFont);
//        settingsButton.setFocusPainted(false);
//        settingsButton.setBorder(new LineBorder(borderCustomColor, 1));
//        settingsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                coming soon
//
//                setVisible(false);
//            }
//        });
//        add(settingsButton);

        exitButton = new JButton("Exit");
        exitButton.setForeground(fontCustomColor);
        exitButton.setBackground(buttonCustomColor);
        exitButton.setFont(customFont);
        exitButton.setFocusPainted(false);
        exitButton.setBorder(new LineBorder(borderCustomColor, 1));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }
}