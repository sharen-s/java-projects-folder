import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

 GamePanel panel;
 GameFrame(){
  MenuFrame menuFrame = new MenuFrame();
  Color customColor = new Color(232, 143, 199);
  panel = new GamePanel();
  this.add(panel);
  this.setTitle("Pong Game");
  this.setResizable(false);
  this.setBackground(customColor);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.pack();
  this.setVisible(true);
  this.setLocationRelativeTo(null);
 }

}
