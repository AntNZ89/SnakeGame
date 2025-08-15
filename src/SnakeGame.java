import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.swing.*;
import javax.swing.event.*;


public class SnakeGame extends JFrame {
    // start attributes
    private JButton bLEFT = new JButton();
    private JButton bDOWN = new JButton();
    private JButton bUP = new JButton();
    private JButton bRIGHT = new JButton();
    int[][] GameField = create2dArray();
    int head1 = 0;
    int head2 = 1;
    int tail1 = 0;
    int tail2 = 0;
    int foodR = 5;
    int foodC = 5;
    int count = 0;
    int temp1 = 0;
    int temp2 = 0;


    LinkedList<String> stringList = new LinkedList<>();




    private JButton bCLEAR = new JButton();
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
        bCLEAR.setBounds(176, 56, 80, 24);
        bCLEAR.setFont(new Font("Dialog", Font.BOLD, 11));
        bCLEAR.setText("CLEAR");
        bCLEAR.setMargin(new Insets(2, 2, 2, 2));
        bCLEAR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bCLEAR_ActionPerformed(evt);
            }
        });
        cp.add(bCLEAR);
        // end components

        setVisible(true);
    } // end of public SnakeGame

    // start methods

    public static void main(String[] args) {
        new SnakeGame();
    } // end of main

    public void bLEFT_ActionPerformed(ActionEvent evt) {
        // TODO add your code here


        if (head2 > 0 && tail2 != head2-1) {

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


        if (head1 < GameField.length-1 && tail1 != head1+1) {

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




        if (head1 > 0 && tail1 != head1-1) {

            if (count == 0){

                GameField[tail1][tail2] = 0;
                GameField[head1][head2] = 0;

                tail2 = head2;
                tail1 = head1;
                head1--;

                GameField[tail1][tail2] = 1;
                GameField[head1][head2] = 1;

            }
            else {

                stringList.add("UP");

                GameField[tail1][tail2] = 0;
                GameField[head1][head2] = 0;

                temp1 = tail1;
                temp2 = tail2;

                tail2 = head2;
                tail1 = head1;
                head1--;


                GameField[tail1][tail2] = 1;
                GameField[head1][head2] = 1;


                if (stringList.isEmpty()){
                    System.out.println("CAN'T DO THAT");
                }
                else if(Objects.equals(stringList.get(0), "RIGHT")){

                    tail2 = temp2 + 1;

                    GameField[tail1][tail2] = 1;

                    stringList.removeFirst();
                }
                else if (Objects.equals(stringList.get(0), "UP")){



                    tail1 = temp1 -1;



                    GameField[tail1][tail2] = 1;



                    stringList.removeFirst();


                }


            }





        } // end of if

        if (GameField[foodR][foodC] == GameField[head1][head2]){

            tail1++;
            foodC = 0;
            foodR = 0;

            GameField[tail1][tail2] = 1;



            count++;

            for (int c = 0 ; c < 2 ; c++){

                stringList.add("UP");


            }


        }



        print2dArray(GameField);
        System.out.println(tail1);

    } // end of bUP_ActionPerformed

    public void bRIGHT_ActionPerformed(ActionEvent evt) {
        // TODO add your code here




        if (head2 < GameField[0].length-1 && tail2 != head2+1) {

            if (count == 0){

                GameField[tail1][tail2] = 0;
                GameField[head1][head2] = 0;

                tail2 = head2;
                tail1 = head1;
                head2++;

                GameField[tail1][tail2] = 1;
                GameField[head1][head2] = 1;

            }
            else {

                stringList.add("RIGHT");

                if (!stringList.isEmpty()){
                    GameField[tail1][tail2] = 0;
                    GameField[head1][head2] = 0;

                    temp1 = tail1;
                    temp2 = tail2;

                    tail2 = head2;
                    tail1 = head1;
                    head2++;

                    GameField[tail1][tail2] = 1;
                    GameField[head1][head2] = 1;



                }

                if (stringList.isEmpty()){
                    System.out.println("CAN'T DO THAT");
                }
                else if(Objects.equals(stringList.get(0), "RIGHT")){


                    tail2 = temp2 + 1;

                    GameField[tail1][tail2] = 1;

                    stringList.removeFirst();








                }



            }





        } // end of if





        if (GameField[foodR][foodC] == GameField[head1][head2]){

            tail2--;
            foodC = 0;
            foodR = 0;

            GameField[tail1][tail2] = 1;



            count++;

            for (int c = 0 ; c < 2 ; c++){

                stringList.add("RIGHT");


            }


        }



        System.out.println(tail1);
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



    public void bCLEAR_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

        GameField[tail1][tail2] = 1;
        GameField[head1][head2] = 1;
        print2dArray(GameField);

    } // end of bCLEAR_ActionPerformed

    // end methods
} // end of class SnakeGame
