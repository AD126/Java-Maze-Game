import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Questions {

    // x variable used to track how many doors the player has gone through
    public int x = Player.doorsopened;
    public static int coins = 0;

    // 1D array to hold all 10 questions
    public String[] questions =
            {"Examine the following: double[][] values = { {1.2, 9.0, 3.2}, {9.2, 0.5, -1.2}, {7.3, 7.9, 4.8} } ; what is in values[2][1] ?",

                    "Given the following: double[][] things = { {1.2, 9.0, 8.7, 1.0}, {9.2, 0.5, 0.0, 5.2}, {7.3, 7.9, 1.2, 3.9} };" +
                            "\n" + "What is the value of things.length ?",

                    "Given the following: long [][] stuff ;" +
                            "\n" +
                            "Which of the following statements constructs an array with 5 rows of 7 columns each and assign its reference to stuff?",

                    "Each piece of data in an array is BEST described as a what?",

                    "Which BEST describes an array?",

                    "Each element in an array can be accessed using its what?",

                    "Why are arrays useful?",

                    "Which of the following statements correctly declares a two-dimensional integer array?",

                    "How would you get the value 6 out of the following 2D array int[][] a = {{2, 4, 6, 8}, {1, 2, 3, 4}};?",

                    "How many columns does a have if it is created as follows int[][] a = {{2, 4, 6, 8}, {1, 2, 3, 4}};?"};

    // 2D array that has 10 rows (questions) and 4 columns (options for each question)
    public String[][] options = {
            {"7.9", "7.3", "9.2", "0.5"},
            {"4", "12", "3", "7"},
            {"stuff = new stuff[5][7]", "stuff = long[5][7]", "stuff = new long[5][7]", "stuff = long[7][5]"},
            {"Integer and String", "Element", "Item", "Elephant"},
            {"A data structure - Stores a collection of values under one name", "A list - Stores a list of numbers", "A data collection - Stores a list of variables", "A list - Stores a list of strings"},
            {"By counting in the items in the array", "By printing the items in the array", "Position or index in the array", "By printing and counting the entire array"},
            {"It saves storage space storing under one name", "You can store thing related on different topics", "You can store integers and strings together", "You may have lots of related data that you don't want to store separately"},
            {"int matrix[ ] = new int[5,4];", "int matrix[ ][ ] = new int[5][4];", "int matrix[ ]; matrix = new int[5,4];", "int matrix[ ][ ] = int[5][4];"},
            {"a[0][3]", "a[0][2]", "a [1][3]", "a[2][0]"},
            {"3", "2", "4", "a[2][0]"}
    };
    public String[] answers = {"7.9", "3", "stuff = new long[5][7]", "Element",
            "A data structure - Stores a collection of values under one name", "Position or index in the array",
            "You may have lots of related data that you don't want to store separately",
            "int matrix[ ][ ] = new int[5][4];", "a[0][2]", "4"}; //10 answers as there are 10 questions

    // JFrame for Questions
    public JFrame questionframe = new JFrame();

    // JTextField for Questions
    JTextField textfield = new JTextField();

    // JTextArea for Questions
    JTextArea textarea = new JTextArea();

    // JButtons for Questions
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();

    // JLabel for Questions
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();


    public Questions() {

        Timer timer;
        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                questionframe.dispose();
            }
        });
        // Properties of Question Frame
        questionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionframe.setSize(1050, 700);
        questionframe.getContentPane().setBackground(new Color(50, 50, 50));
        questionframe.setLayout(null);
        questionframe.setResizable(true);
        questionframe.setLocationRelativeTo(null);
        questionframe.setVisible(true);

        textfield.setBounds(0, 0, 1050, 50); // Sets location and size of text field
        textfield.setBackground(new Color(25, 25, 25)); // Sets Background Colour of text field
        textfield.setForeground(new Color(25, 255, 0)); // Sets colour of text field
        textfield.setFont(new Font("Ink Free", Font.BOLD, 30)); // Sets font type and size for text field
        textfield.setBorder(BorderFactory.createBevelBorder(1)); // Border style for text area
        textfield.setHorizontalAlignment(JTextField.CENTER); // Alligns text inside text field to be centered
        textfield.setEditable(false); // Sets Edible as false
        textfield.setText("Question " + (x + 1)); // Text inside text field

        textarea.setBounds(0, 50, 1050, 100); // Sets location and size of text area
        textarea.setLineWrap(true); // Sets Line Wrap as true
        textarea.setWrapStyleWord(true); // Sets Wrapping Style of words as true
        textarea.setBackground(new Color(25, 25, 25)); // Sets Background Colour of text area
        textarea.setForeground(new Color(25, 255, 0)); // Sets colour of text area
        textarea.setFont(new Font("MV Boli", Font.BOLD, 20)); // Sets font type and size for text area
        textarea.setBorder(BorderFactory.createBevelBorder(1)); // Border style for text area
        textarea.setEditable(false); // Sets Edible as false
        textarea.setText(questions[x]); // Text inside text area

        buttonA.setBounds(0, 200, 100, 100); // Sets location and size of button
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35)); // Sets font type and size of text in button
        buttonA.setFocusable(false); // Sets button focus to false
        // Action Listenter to check if player got the right answer or not
        buttonA.addActionListener(a -> {
            System.out.println(checkAnswer(0));
            if(answers[x] != answer_labelA.getText())
                answer_labelA.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelB.getText())
                answer_labelB.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelC.getText())
                answer_labelC.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelD.getText())
                answer_labelD.setForeground(new Color(255,0,0));
            timer.start();
        });
        buttonA.setText("A"); // Text inside Button

        buttonB.setBounds(0, 300, 100, 100);// Sets location and size of button
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35)); // Sets font type and size of text in button
        buttonB.setFocusable(false); // Sets button focus to false
        // Action Listenter to check if player got the right answer or not
        buttonB.addActionListener(a -> {
            System.out.println(checkAnswer(1));
            if(answers[x] != answer_labelA.getText())
                answer_labelA.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelB.getText())
                answer_labelB.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelC.getText())
                answer_labelC.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelD.getText())
                answer_labelD.setForeground(new Color(255,0,0));
            timer.start();
        });
        buttonB.setText("B"); // Text inside Button

        buttonC.setBounds(0, 400, 100, 100); // Sets location and size of button
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35)); // Sets font type and size of text in button
        buttonC.setFocusable(false); // Sets button focus to false
        // Action Listenter to check if player got the right answer or not
        buttonC.addActionListener(a -> {
            System.out.println(checkAnswer(2));
            if(answers[x] != answer_labelA.getText())
                answer_labelA.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelB.getText())
                answer_labelB.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelC.getText())
                answer_labelC.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelD.getText())
                answer_labelD.setForeground(new Color(255,0,0));
            timer.start();
        });
        buttonC.setText("C"); // Text inside Button

        buttonD.setBounds(0, 500, 100, 100); // Sets location and size of button
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35)); // Sets font type and size of text in button
        buttonD.setFocusable(false); // Sets button focus to false
        // Action Listenter to check if player got the right answer or not
        buttonD.addActionListener(a -> {
            System.out.println(checkAnswer(3));
            if(answers[x] != answer_labelA.getText())
                answer_labelA.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelB.getText())
                answer_labelB.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelC.getText())
                answer_labelC.setForeground(new Color(255,0,0));
            if(answers[x] != answer_labelD.getText())
                answer_labelD.setForeground(new Color(255,0,0));
            timer.start();
        });
        buttonD.setText("D"); // Text inside Button

        answer_labelA.setBounds(125, 200, 900, 100); // Sets size for the label
        answer_labelA.setBackground(new Color(50, 50, 50)); // Sets Background Colour for label
        answer_labelA.setForeground(new Color(25, 255, 0)); // Sets colour for label
        answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 25)); // Sets type and size of font
        answer_labelA.setText(options[x][0]); // Sets text for the label

        answer_labelB.setBounds(125, 300, 900, 100); // Sets size for the label
        answer_labelB.setBackground(new Color(50, 50, 50)); // Sets Background Colour for label
        answer_labelB.setForeground(new Color(25, 255, 0)); // Sets colour for label
        answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 25)); // Sets type and size of font
        answer_labelB.setText(options[x][1]); // Sets text for the label

        answer_labelC.setBounds(125, 400, 900, 100); // Sets size for the label
        answer_labelC.setBackground(new Color(50, 50, 50)); // Sets Background Colour for label
        answer_labelC.setForeground(new Color(25, 255, 0)); // Sets colour for label
        answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 25)); // Sets type and size of font
        answer_labelC.setText(options[x][2]); // Sets text for the label


        answer_labelD.setBounds(125, 500, 900, 100); // Sets size for the label
        answer_labelD.setBackground(new Color(50, 50, 50)); // Sets Background Colour for label
        answer_labelD.setForeground(new Color(25, 255, 0)); // Sets colour for label
        answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 25)); // Sets type and size of font
        answer_labelD.setText(options[x][3]); // Sets text for the label

        // Add elements to the Question Frame
        questionframe.add(answer_labelA);
        questionframe.add(answer_labelB);
        questionframe.add(answer_labelC);
        questionframe.add(answer_labelD);
        questionframe.add(buttonA);
        questionframe.add(buttonB);
        questionframe.add(buttonC);
        questionframe.add(buttonD);
        questionframe.add(textarea);
        questionframe.add(textfield);

    }


    // Checks to see if the player got the question correct. Returns a boolean
    public boolean checkAnswer(int y) {
        boolean toReturn = false;
        if (options[x][y].equals(answers[x])) {
            toReturn = true;
            coins++;
        } else {

            Board.lives--;
        }
        //questionframe.dispose();
        if (Board.lives == 0) {
            MazeFrame.livesGone();
        }
        return toReturn;
    }
}