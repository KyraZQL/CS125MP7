
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class MP7 {
    public static int[][] theGame = new int[4][4];


    static void add(int n) {
        Random random = new Random();
        int num, newElement;
        int x, y, i;
        num = random.nextInt(10) + 0;
        newElement = num % 2;
        x = num % 4;
        y = num % 4;
        if (newElement != 0)
            num = 2;
        else
            num = 4;

        if (n == 0) {
            theGame[x][y] = num;
        } else if (n == 1) {
            if (theGame[3][y] == 0)
                theGame[3][y] = num;
            else
                for (i = 0; i < 4; i++)
                    if (theGame[3][i] == 0) {
                        theGame[3][i] = num;
                        break;
                    }
        } else if (n == 2) {
            if (theGame[0][y] == 0)
                theGame[0][y] = num;
            else
                for (i = 0; i < 4; i++)
                    if (theGame[0][i] == 0) {
                        theGame[0][i] = num;
                        break;
                    }
        } else if (n == 3) {
            if (theGame[x][3] == 0)
                theGame[x][3] = num;
            else
                for (i = 0; i < 4; i++)
                    if (theGame[i][3] == 0) {
                        theGame[i][3] = num;
                        break;
                    }
        } else if (n == 4) {
            if (theGame[x][0] == 0)
                theGame[x][0] = num;
            else
                for (i = 0; i < 4; i++)
                    if (theGame[i][0] == 0) {
                        theGame[i][0] = num;
                        break;
                    }
        }
    }

    public static void displaygrid() {
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(String.format("%4d",theGame[i][j]) + " ");
            }
        }
        System.out.println();
    }


    public static boolean right() {
        int i, j, t;

        boolean flag = false;
        for (i = 0; i < 4; i++) {
            int n = 4;
            for (int k = n; k > 0; k--) {
                for (j = 3; j > 0; j--) {
                    {
                        if (theGame[i][j] == 0)
                            for (t = j; t > 0; t--) {
                                theGame[i][t] = theGame[i][t - 1];
                                theGame[i][t - 1] = 0;

                                flag = true;
                            }
                    }
                }
            }
            for (j = 3; j > 0; j--) {
                if (theGame[i][j] == theGame[i][j - 1]) {
                    theGame[i][j] *= 2;

                    if (theGame[i][j] == 2048)
                        return false;
                    for (t = j - 1; t > 0; t--) {
                        theGame[i][t] = theGame[i][t - 1];
                        theGame[i][t - 1] = 0;

                        flag = true;
                    }
                }
            }
        }
        if (flag) {
            add(4);
        }
        return true;
    }

    public static boolean left() {
        int i, j, t;
        boolean flag = false;
        for (i = 0; i < 4; i++) {
            int n = 4;
            for (int k = n; k > 0; k--) {
                for (j = 0; j < 3; j++) {
                    {
                        if (theGame[i][j] == 0)
                            for (t = j; t < 3; t++) {
                                theGame[i][t] = theGame[i][t + 1];
                                theGame[i][t + 1] = 0;
                                flag = true;
                            }
                    }
                }
            }
            for (j = 0; j < 3; j++) {
                if (theGame[i][j] == theGame[i][j + 1]) {
                    theGame[i][j] *= 2;

                    if (theGame[i][j] == 2048)
                        return false;
                    for (t = j + 1; t < 3; t++) {
                        theGame[i][t] = theGame[i][t + 1];
                        theGame[i][t + 1] = 0;
                        flag = true;
                    }
                }
            }
        }
        if (flag) {
            add(3);
        }
        return true;
    }

    public static boolean up() {
        int i, j, t;

        boolean flag = false;
        for (j = 0; j < 4; j++) {
            int n = 4;
            for (int k = n; k > 0; k--) {
                for (i = 0; i < 3; i++) {
                    if (theGame[i][j] == 0) {
                        for (t = i; t < 3; t++) {
                            theGame[t][j] = theGame[t + 1][j];
                            theGame[t + 1][j] = 0;

                            flag = true;
                        }
                    }
                }
            }
            for (i = 0; i < 3; i++) {
                if (theGame[i][j] == theGame[i + 1][j]) {
                    theGame[i][j] *= 2;

                    if (theGame[i][j] == 2048)
                        return false;
                    for (t = i + 1; t < 3; t++) {
                        theGame[t][j] = theGame[t + 1][j];
                        theGame[t + 1][j] = 0;
                        flag = true;
                    }
                }
            }
        }
        if (flag) {
            add(1);
        }
        return true;
    }

    public static boolean down() {
        int i, j, t;

        boolean flag = false;
        for (j = 0; j < 4; j++) {
            int n = 4;
            for (int k = n; k > 0; k--) {

                for (i = 3; i > 0; i--) {
                    if (theGame[i][j] == 0) {
                        for (t = i; t > 0; t--) {
                            theGame[t][j] = theGame[t - 1][j];
                            theGame[t - 1][j] = 0;
                            flag = true;
                        }
                    }
                }
            }
            for (i = 3; i > 0; i--) {
                if (theGame[i][j] == theGame[i - 1][j]) {
                    theGame[i][j] *= 2;

                    if (theGame[i][j] == 2048)
                        return false;
                    for (t = i - 1; t > 0; t--) {
                        theGame[t][j] = theGame[t - 1][j];
                        theGame[t - 1][j] = 0;
                        flag = true;
                    }
                }
            }
        }
        if (flag) {
            add(2);
        }
        return true;
    }


    public static boolean mov() {

        boolean flag = true;

        Scanner s = new Scanner(System.in);

        char ch = s.next().charAt(0);
        if (ch == 'R' || ch == 'r') {
            flag = right();
        } else if (ch == 'D' || ch == 'd') {
            flag = down();
        } else if (ch == 'L' || ch == 'l') {
            flag = left();
        } else if (ch == 'U' || ch == 'u') {
            flag = up();
        } else if (ch == 'Q' || ch == 'q') {
            System.out.println("Thank You");
            System.exit(0);

        } else {
            System.out.println("Please enter again!");
        }
        if (!flag) {
            System.out.println("Game is over.");
        }
        return flag;
    }

    public static boolean gameCheck()
    {
        int i,j;


        for (i = 0; i < 4; i++)
        {
            for (j = 1;j < 4; j++)
                if (theGame[i][j - 1] == theGame[i][j]||theGame[i][j-1]==0)
                    return false;
        }


        for (i = 0; i < 4; i++)
        {
            for (j = 1; j< 4; j++)
                if (theGame[j - 1][i] == theGame[j][i]||theGame[j-1][i]==0)
                    return false;
        }
        System.out.println ();
        return true;
    }

    public static void main(String[] args) throws IOException {

        add(0);
        displaygrid();
        while (mov()) {
            displaygrid();
            if (gameCheck())
                break;
        }
    }
}
