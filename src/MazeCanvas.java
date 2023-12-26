import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MazeCanvas extends JPanel {
    int t = 0;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;
    Image enemy = new ImageIcon("Images/blueMan.png").getImage();
    Image MainTitle = new ImageIcon("Images/MainTitle.png").getImage();
    public static Timer myTimer;
    Timer mouseTimer;

    public MazeCanvas() {
        myTimer = new Timer(10, new ActionListener() { //Lower the delay, faster the game goes
            @Override
            public void actionPerformed(ActionEvent evt) {
                //move();
                repaint();
            }
        });
        myTimer.start();
        t += 1;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        Color backgroundColor = Color.black;
        g.setColor(backgroundColor);
        g.fillRect(0, 0, 500, 500);
        //g.setColor(Color.red);
        //g.fillRect(t, 100, 10, 10);
        g2D.drawImage(MainTitle, x, y, null);

    }

    void move() {
        if(x>=550-enemy.getWidth(null) || x<-10) {
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;
        if(y>=400-enemy.getHeight(null) || y<-45) {
            yVelocity = yVelocity * -1;
        }
        y = y + yVelocity;
    }

    public static void main(String[] args) {
        MazeCanvas canvas = new MazeCanvas();
        JFrame fr = new JFrame();
        fr.setSize(990, 690);
        JButton start = new JButton("START");
        fr.add(canvas);
        fr.add(start, BorderLayout.SOUTH);
        fr.setVisible(true);
    }
}
