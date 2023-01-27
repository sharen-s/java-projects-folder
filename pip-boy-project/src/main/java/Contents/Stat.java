package Contents;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Stat extends JPanel{
private JLabel HPLabel;
private JLabel levelLabel;
private JLabel expLabel;
private JProgressBar levelBar;



    public Stat(){

        setBackground(Color.BLACK);
        setLayout(null); //set layout as null
        levelBar = new JProgressBar();
        levelBar.setMinimum(0);
        levelBar.setMaximum(100);
        levelBar.setValue(19);
        levelBar.setStringPainted(false);
        levelBar.setBounds(450,0,150,25);
        levelBar.setForeground(new Color(28, 236, 63, 160));
        levelBar.setBackground(new Color(0,0,0,0));
        levelBar.setBorderPainted(true);
        add(levelBar);


        Color buttonsCustomColor = new Color(8, 250, 48, 205);
        setBackground(Color.BLACK);
        setLayout(new FlowLayout());

        HPLabel=new JLabel("HP: 90/90 ");
        HPLabel.setForeground(buttonsCustomColor);
        HPLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        add(HPLabel);

        levelLabel=new JLabel("Level: 1");
        levelLabel.setForeground(buttonsCustomColor);
        levelLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        add(levelLabel);
        add(levelBar);

        expLabel=new JLabel("AP 70/70");
        expLabel.setForeground(buttonsCustomColor);
        expLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        add(expLabel);

}

        public void setHP(int health){
        HPLabel.setText("HP: " + health);
        }

        public void setLevel(int level) {
                levelLabel.setText("Level: " + level);
                levelBar.setValue(level);

        }

        public void setExp(int exp) {
                expLabel.setText("Experience: " + exp);
        }
}