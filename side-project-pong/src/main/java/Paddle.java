import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle{

    int id;
    int yVelocity;
    int speed = 10;

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
         this.id = id;
    }

    public void keyPressed(KeyEvent event){
        switch(id) {
            case 1:
                if (event.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                if (event.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if (event.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                if (event.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }

    public void keyReleased(KeyEvent event){
        switch(id) {
            case 1:
                if (event.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                if (event.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (event.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                if (event.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(10);
                    move();
                }
                break;
        }
    }

    public void setYDirection (int yDirection){
        yVelocity = yDirection;
    }

    public void move(){
        y = y + yVelocity;

    }
    public void draw(Graphics g){
        Color customPaddle1 = new Color(246, 74, 138);
        Color customPaddle2 = new Color( 181, 51, 137);
        if(id == 1)
            g.setColor(customPaddle1);
        else
            g.setColor(customPaddle2);
        g.fillRect(x,y,width,height);

    }
}
