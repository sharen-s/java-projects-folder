import javax.swing.*;
import java.awt.*;

public class Score extends Rectangle{

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;
    Image goodScore;


    Score(int GAME_WIDTH, int GAME_HEIGHT){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
        goodScore = new ImageIcon("animation.png").getImage();

    }

    public void draw(Graphics g){
        Color customerScoreColor = new Color(211, 5, 78, 221);
        g.setColor(customerScoreColor);
        g.setFont(new Font("sansserif", Font.PLAIN, 60));

        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);

        g.drawString(String.valueOf(player1/10) + String.valueOf(player1 %10), (GAME_WIDTH/2) - 85, 50);
        g.drawString(String.valueOf(player2/10) + String.valueOf(player2 %10), (GAME_WIDTH/2) + 20, 50);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(goodScore, 820, 325, 180, 230, null);
    }
}
