import Contents.Radio;
import Contents.Stat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PipBoy extends JFrame {

    private JPanel mainPanel;
    private JLabel backgroundImage;
    private JButton statButton;
    private JButton invButton;
    private JButton dataButton;
    private JButton mapButton;
    private JButton radioButton;
    private JPanel buttonPanel;
    private JPanel subStatMenuPanel;
    private Stat statPanel;
    private Radio radioPanel;
    private boolean statPanelVisible = false;
    private static Color greenBarColor = new Color(38, 248, 19, 50);


    public static void main(String[] args) {
        new PipBoy();
    }

    public PipBoy() {
        createFrame();
        createBackground();
        createButtons();
        statButtonActions();
        radioButtonActions();
    }

    public void createFrame() {
        // Set the frame's properties
        setTitle("Pip-Boy");
        setSize(1100, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void createBackground() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // Create a button panel and set its layout
        buttonPanel = new JPanel();
        buttonPanel.setBounds(385, 0, 300, 30);
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setLayout(new FlowLayout());
        mainPanel.add(buttonPanel);

        // Create a subMenu panel and set its layout
        subStatMenuPanel = new JPanel();
        subStatMenuPanel.setBounds(365, 25, 200, 30);
        subStatMenuPanel.setBackground(Color.darkGray);
        subStatMenuPanel.setOpaque(true);
        subStatMenuPanel.setLayout(new FlowLayout());
        subStatMenuPanel.setVisible(false);

        // Create background image and set its properties
        backgroundImage = new JLabel(new ImageIcon("pipboy.png"));
        backgroundImage.setBounds(0, 0, 1050, 800);
        mainPanel.setBackground(Color.darkGray);
        mainPanel.add(backgroundImage);
        mainPanel.add(subStatMenuPanel);
        // Add the main panel to the frame
        add(mainPanel);

        // Show the frame
        setVisible(true);
    }

    public void createButtons() {
        // Create buttons and add them to the button panel
        statButton = new JButton("STAT");
        invButton = new JButton("INV");
        dataButton = new JButton("DATA");
        mapButton = new JButton("MAP");
        radioButton = new JButton("RADIO");

        setTransparent(statButton);
        setTransparent(invButton);
        setTransparent(dataButton);
        setTransparent(mapButton);
        setTransparent(radioButton);

        buttonPanel.add(statButton);
        buttonPanel.add(invButton);
        buttonPanel.add(dataButton);
        buttonPanel.add(mapButton);
        buttonPanel.add(radioButton);
    }

    public void statButtonActions() {
        // Create Stat panel and add it to the main panel
        statPanel = new Stat();
        statPanel.setBounds(92, 720, 900, 30);
        statPanel.setBackground(greenBarColor);
        statButton.setBorder(null);
        statPanel.setVisible(false);
        mainPanel.add(statPanel);

        //sub menu panel buttons

        JButton statusButton = new JButton("STATUS");
        JButton specialButton = new JButton("SPECIAL");
        JButton perksButton = new JButton("PERKS");

        statusButton.setBorder(null);
        specialButton.setBorder(null);
        perksButton.setBorder(null);

        setTransparent(statusButton);
        setTransparent(specialButton);
        setTransparent(perksButton);

        subStatMenuPanel.add(statusButton);
        subStatMenuPanel.add(specialButton);
        subStatMenuPanel.add(perksButton);


        // add action listener to the stat button
        statButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statPanelVisible = !statPanelVisible;
                statPanel.setVisible(statPanelVisible);
                subStatMenuPanel.setVisible(statPanelVisible);
            }
        });
    }

    public void radioButtonActions() {
        // Create Radio panel and add it to the main panel
        radioPanel = new Radio();
        radioPanel.setBounds(250, 0, 600, 30);
        radioButton.setBorder(null);
        radioPanel.setVisible(false);
        mainPanel.add(radioPanel);

        // add action listener to the radio button
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioPanel.setVisible(!radioPanel.isVisible());
            }
        });
    }

    public static void setTransparent(JButton button) {
        Color buttonsCustomColor = new Color(35, 227, 115);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(buttonsCustomColor);
    }


}