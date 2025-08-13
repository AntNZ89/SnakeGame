import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class SnakeGame extends JFrame {
    // start attributes
    private JButton bLEFT = new JButton();
    private JButton bDOWN = new JButton();
    private JButton bUP = new JButton();
    private JButton bRIGHT = new JButton();
    int[][] GameField = create2dArray();
    int head1 = 1;
    int head2 = 0;
    int tail1 = 0;
    int tail2 = 0;
    int temp;




    // end attributes

    public SnakeGame() {
        // Frame init
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 300;
        int frameHeight = 300;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("SnakeGame");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // start components

        bLEFT.setBounds(8, 192, 80, 32);
        bLEFT.setFont(new Font("Dialog", Font.BOLD, 11));
        bLEFT.setText("LEFT");
        bLEFT.setMargin(new Insets(2, 2, 2, 2));
        bLEFT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bLEFT_ActionPerformed(evt);
            }
        });
        cp.add(bLEFT);
        bDOWN.setBounds(96, 192, 88, 32);
        bDOWN.setFont(new Font("Dialog", Font.BOLD, 11));
        bDOWN.setText("DOWN");
        bDOWN.setMargin(new Insets(2, 2, 2, 2));
        bDOWN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bDOWN_ActionPerformed(evt);
            }
        });
        cp.add(bDOWN);
        bUP.setBounds(96, 152, 88, 32);
        bUP.setFont(new Font("Dialog", Font.BOLD, 11));
        bUP.setText("UP");
        bUP.setMargin(new Insets(2, 2, 2, 2));
        bUP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bUP_ActionPerformed(evt);
            }
        });
        cp.add(bUP);
        bRIGHT.setBounds(192, 192, 80, 32);
        bRIGHT.setFont(new Font("Dialog", Font.BOLD, 11));
        bRIGHT.setText("RIGHT");
        bRIGHT.setMargin(new Insets(2, 2, 2, 2));
        bRIGHT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bRIGHT_ActionPerformed(evt);
            }
        });
        cp.add(bRIGHT);
        // end components

        setVisible(true);
    } // end of public SnakeGame

    // start methods

    public static void main(String[] args) {
        new SnakeGame();
    } // end of main

    public void bLEFT_ActionPerformed(ActionEvent evt) {
        // TODO add your code here


        if (head2 > 0) {

            GameField[tail1][tail2] = 0;
            GameField[head1][head2] = 0;

            tail2 = head2;
            tail1 = head1;
            head2--;

            GameField[tail1][tail2] = 1;
            GameField[head1][head2] = 1;

        } // end of if





        print2dArray(GameField);

    } // end of bLEFT_ActionPerformed

    public void bDOWN_ActionPerformed(ActionEvent evt) {
        // TODO add your code here


        if (head1 < GameField.length-1) {

            GameField[tail1][tail2] = 0;
            GameField[head1][head2] = 0;

            tail2 = head2;
            tail1 = head1;
            head1++;

            GameField[tail1][tail2] = 1;
            GameField[head1][head2] = 1;

        } // end of if





        print2dArray(GameField);

    } // end of bDOWN_ActionPerformed

    public void bUP_ActionPerformed(ActionEvent evt) {
        // TODO add your code here


        if (head1 > 0) {

            GameField[tail1][tail2] = 0;
            GameField[head1][head2] = 0;

            tail2 = head2;
            tail1 = head1;
            head1--;

            GameField[tail1][tail2] = 1;
            GameField[head1][head2] = 1;

        } // end of if




        print2dArray(GameField);

    } // end of bUP_ActionPerformed

    public void bRIGHT_ActionPerformed(ActionEvent evt) {
        // TODO add your code here




        if (head2 < GameField[0].length-1) {

            GameField[tail1][tail2] = 0;
            GameField[head1][head2] = 0;

            tail2 = head2;
            tail1 = head1;
            head2++;

            GameField[tail1][tail2] = 1;
            GameField[head1][head2] = 1;

        } // end of if


        print2dArray(GameField);
    } // end of bRIGHT_ActionPerformed







    public static void print2dArray(int[][] array){

        String s = "";

        for (int c = 0; c < array.length ; c++) {
            for (int r = 0; r < array[0].length; r++ ) {

                s += array[c][r];

            } // end of for
            s += "\n";
        } // end of for

        System.out.println(s);

    }







    public static int[][] create2dArray(){

        int[][] array = new int[10][10];

        for (int c = 0 ; c < array.length ; c++){
            for (int r = 0; r < array[0].length ; r++) {

                array[c][r] = 0;


            } // end of for
        }

        return array;

    }



    // end methods
} // end of class SnakeGame
