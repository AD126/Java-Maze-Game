import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    JFrame frameMainMenu = new JFrame("Maze");
    JButton play, instructions;
    MazeCanvas MazePanel;

    public MainMenu() {
        MazePanel = new MazeCanvas();
        JPanel panel = new JPanel();

        play = new JButton("play");
        play.setFont(new Font("Verdana", Font.BOLD, 32));
        play.setBounds(100, 100, 100, 50);

        instructions = new JButton("instructions");
        instructions.setFont(new Font("Verdana", Font.BOLD, 32));
        instructions.setBounds(100, 200, 100, 50);
        instructions.setSize(100, 100);

        frameMainMenu.add(MazePanel);
        //MazePanel.add(play);
        frameMainMenu.add(play, BorderLayout.SOUTH);
        frameMainMenu.add(instructions, BorderLayout.SOUTH);

        frameMainMenu.setSize(500, 500);
        frameMainMenu.getContentPane().setLayout(new BoxLayout(frameMainMenu.getContentPane(), BoxLayout.Y_AXIS));
        frameMainMenu.setLocationRelativeTo(null);
        frameMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        frameMainMenu.setVisible(true);

        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frameMainMenu.dispose();
                new MazeFrame(15);
            }
        });

        instructions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFrame frame = new JFrame("Instructions");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                JLabel textLabel = new JLabel("" + "<html>" +
                        "1. Player starts as the blue character.<br> " +
                        "2. Player must collect at least 7/10 gold coins to see the exit.<br> " +
                        "3. To collect a gold coin, you must answer the given question correctly. <br>" +
                        "4. Once player has answered enough questions correctly, they will see the red finish point. <br>" +
                        "5. Head to red finish point to win. </html>");
                frame.getContentPane().add(textLabel, BorderLayout.CENTER);

                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}

