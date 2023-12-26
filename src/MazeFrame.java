import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;


/**
 * A class that encompasses the elements of the game board including
 * the maze GUI and the buttons for movement.
 */
public class MazeFrame {

    public static JFrame frameMazeFrame = new JFrame("Maze");
    JPanel p = new JPanel(new BorderLayout());
    JPanel p2 = new JPanel(new BorderLayout());

    /**
     * Constructs the maze frame with a board and a player along with
     * all the button listeners for movement.
     *
     * @param level
     */
    public MazeFrame(int level) {

        final Board test = new Board(level, level, level);
        final Player player = new Player(test);

        p.add(test, BorderLayout.CENTER);
        p.setFocusable(true);
        frameMazeFrame.add(p, BorderLayout.CENTER);
        frameMazeFrame.add(p2, BorderLayout.SOUTH);

        // allows player to use w,a,s,d as arrow keys
        p.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT) player.moveLeft(test);
                if (e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT) player.moveRight(test);
                if (e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP) player.moveUp(test);
                if (e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN) player.moveDown(test);
            }
        });

        frameMazeFrame.setSize(500, 500);
        frameMazeFrame.setLocationRelativeTo(null);
        frameMazeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMazeFrame.setResizable(false);
        frameMazeFrame.setBackground(Color.green);
        frameMazeFrame.setVisible(true);
    }

    /**
     * Constructor for maze frame that displays the win frame.
     *
     * @param level The size of the Frame
     * @param coinsCollected The amount of coins collected by the player.
     */
    public MazeFrame(int level, int coinsCollected) {

        frameMazeFrame.dispose();
        JFrame frame2 = new JFrame();

        JLabel textLabel = new JLabel("<html>Congratulations! You got: " +Questions.coins + "/10 coins <br>", JLabel.CENTER);
        textLabel.setFont(new Font("Verdana", Font.BOLD, 32));

        frame2.getContentPane().setBackground(Color.green);
        frame2.add(textLabel, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(700, 500);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }

    // To Display the lost screen
    public static void livesGone() {
        frameMazeFrame.dispose();
        new MainMenu();
        JFrame frame3 = new JFrame();

        JLabel textLabel = new JLabel("<html>You Lost<br>", JLabel.CENTER);
        textLabel.setFont(new Font("Verdana", Font.BOLD, 32));

        frame3.getContentPane().setBackground(Color.red);
        frame3.add(textLabel, BorderLayout.CENTER);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(500, 500);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
    }
}
