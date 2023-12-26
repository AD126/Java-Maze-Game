import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * A class that creates all the elements necessary for a player
 * to traverse the maze.
 */
public class Player extends JPanel implements ActionListener {

    // doot varaible used to know if a player is occupied with a question
    public String door;

    public static int doorsopened = 0; // count number of doors are opened

    // x and y positions for the board
    private int xPos = 0;
    private int yPos = 0;

    private final Board board;

    /**
     * Constructor for the player that will be set on the specified
     * board. The player will automatically start at the top left
     * of the board
     *
     * @param board The board the player will play on.
     */
    public Player(Board board) {
        this.board = board;
        this.doorsopened = doorsopened;
        xPos = 1;
        yPos = 1;
    }

    /**
     * The method repaints the board.
     */
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /**
     * Inner class that allows for the keyboard input of
     * {w,a,s,d} to move up, left, down, right.
     */
    public class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == 'a' && board.get(xPos, yPos) != '+') moveLeft(board);
            if (e.getKeyChar() == 'w' && board.get(xPos, yPos) != '+') moveUp(board);
            if (e.getKeyChar() == 'd' && board.get(xPos, yPos) != '+') moveRight(board);
            if (e.getKeyChar() == 's' && board.get(xPos, yPos) != '+') moveDown(board);

        }
    }

    /**
     * Allows the player to move left, checking for if the player's next
     * move hits a win cell or a coin cell.
     *
     * @param board The board the player will move on.
     */
    public void moveLeft(Board board) {
        if ((board.get(xPos - 1, yPos) != '#') && (board.get(xPos - 1, yPos) != '=')) {
            board.set(xPos, yPos, 'O');
            if (board.get(xPos -= 1, yPos) == '8' && doorsopened == 10) Win();
            else if (board.get(xPos, yPos) == '+') {
                door();
                doorsopened++;
            } else board.set(xPos, yPos, 'X');
        }
    }

    /**
     * Allows the player to move right, checking for if the player's next
     * move hits a win cell or a coin cell.
     *
     * @param board The board the player will move on.
     */
    public void moveRight(Board board) {
        if ((board.get(xPos + 1, yPos) != '#') && (board.get(xPos + 1, yPos) != '=')) {
            board.set(xPos, yPos, 'O');
            if (board.get(xPos += 1, yPos) == '8' && doorsopened == 10) Win();
            else if (board.get(xPos, yPos) == '+') {
                door();
                doorsopened++;
            } else board.set(xPos, yPos, 'X');
        }
    }

    /**
     * Allows the player to move up, checking for if the player's next
     * move hits a win cell or a coin cell.
     *
     * @param board The board the player will move on.
     */
    public void moveUp(Board board) {
        if ((board.get(xPos, yPos - 1) != '#') && (board.get(xPos, yPos - 1) != '=')) {
            board.set(xPos, yPos, 'O');
            if (board.get(xPos, yPos -= 1) == '8' && doorsopened == 10) Win();
            else if (board.get(xPos, yPos) == '+') {
                door();
                doorsopened++;
            } else board.set(xPos, yPos, 'X');
        }
    }

    /**
     * Allows the player to move down, checking for if the player's next
     * move hits a win cell or a coin cell.
     *
     * @param board The board the player will move on.
     */
    public void moveDown(Board board) {
        if ((board.get(xPos, yPos + 1) != '#') && (board.get(xPos, yPos + 1) != '=')) {
            board.set(xPos, yPos, 'O');
            if (board.get(xPos, yPos += 1) == '8' && doorsopened == 10) Win();
            else if (board.get(xPos, yPos) == '+') {
                door();
                doorsopened++;
            } else board.set(xPos, yPos, 'X');
        }
    }

    // If player touches the winning red dot, Win function is called and presents the congratulations screen
    public static void Win() {
        new MazeFrame(20, doorsopened);
    }

    // If player touches yellow coin, door function will activate where the question screen will appear
    public void door() {
        new Questions();
        door = "occupied";
    }
}
