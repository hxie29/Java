package c08_MultidimensionArrays;/* (Game: connect four) Connect four is a two-player board game in which the
players alternately drop colored disks into a seven-column, six-row vertically
suspended grid, as shown below. 
The objective of the game is to connect four same-colored disks in a row, a column,
or a diagonal before your opponent can do likewise. The program prompts
two players to drop a red or yellow disk alternately. In the preceding figure, the
red disk is shown in a dark color and the yellow in a light color. Whenever a disk
is dropped, the program redisplays the board on the console and determines the
status of the game (win, draw, or continue).
Drop a yellow disk at column (0–6): 6
| | | | | | | |
| | | | | | | |
| | | |R| | | |
| | | |Y|R|Y| |
| | |R|Y|Y|Y|Y|
|R|Y|R|Y|R|R|R|
The yellow player won */

import java.util.Arrays;
import java.util.Scanner;

public class E0820 {
    public static void main(String[] args) {
        int[][] board = initiateBoard();
        int status = 0;
     
        while(status == 0) {
            String[][] boardStr = translate(board);
            printBoard(boardStr);
            status = verifyGame(board);
            //System.out.println(status);
            //Check winner or continue
            switch (status) {
                case 0 -> enterMoves(board);
                case 1 -> System.out.println("Red player won.");
                case 2 -> System.out.println("Yellow player won.");
                case 3 -> System.out.println("It is a draw.");
            }
        }
    }
    // Print board with symbols
    public static void printBoard(String[][] boardStr) {
        for (String[] strings : boardStr) {
            for (String string : strings) {
                System.out.printf("|%1S", string);
            }
            System.out.println("|");
        }
        System.out.println("-----------------");
    }
    
    //Initiate an empty game board
    public static int[][] initiateBoard(){
        int[][] board = new int[6][7];
        for (int[] ints : board) {
            Arrays.fill(ints, 0);
        }
        return board;
    }
    //  Translate board score to symbols
    public static String[][] translate(int[][] board) {
        String[][] str = new String[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) str[i][j] = " ";
                if (board[i][j] == 1) str[i][j] = "R";
                if (board[i][j] == 2) str[i][j] = "Y";                
            }
        }
        return str;
    }
    
     // verify game status
     public static int verifyGame(int[][] board) {
        if (horizontal(1, board)) return 1;
        else if (horizontal(2, board)) return 2;
        else if (!fullBoard(board)) return 0;
        else return 3;
    }

    // verify horizontal case
    public static boolean horizontal(int n, int[][]board) {
        int count;
        for (int i = board.length -1; i > 0; i--) {
            for(int j = 0; j < board[i].length - 3; j++) {
                count = 1;
                if (board[i][j] == n) {
                    int k = 1;
                    while (k < 4) {
                        if (board[i][j+k] == n) {
                            count++;
                            k++;
                        }
                        else break;
                    }
                }
                if (count == 4) return true;
            }
        }
        return false;
    }

     // Prompt to enter moves for a play
     public static void enterMoves(int[][] board) {
        Scanner input = new Scanner(System.in);
        int count = 0;
         for (int[] ints : board) {
             for (int anInt : ints) {
                 if (anInt != 0) count++;
             }
         }
        boolean redMove = (count % 2 == 0);
        if (redMove) {
            System.out.println("Enter a column number (0 to 6) for player Red: ");
            int column = input.nextInt();
            if (column < 0 || column >= board[0].length) System.out.println("Invalid input.");
            else {
                for (int i = board.length -1; i >= 0; i--) {
                    if (i == 0 && board[i][column] != 0) {
                        System.out.println("The column is full.");
                        break;
                    }
                    if (board[i][column] == 0) {
                        board[i][column] = 1;
                        break;
                    }
                }
            }
        }
        else {
            System.out.println("Enter a column number (0 to 6) for player Yellow:");
            int column = input.nextInt();
            if (column < 0 || column >= board[0].length) System.out.println("Invalid input.");
            else{
                for (int i = board.length -1; i >= 0; i--) {
                    if (i == 0 && board[i][column] != 0) {
                        System.out.println("The column is full.");
                        break;
                    }
                    if (board[i][column] == 0) {
                        board[i][column] = 2;
                        break;
                    }
                }
            }
        }
    }

    // check full board
    public static boolean fullBoard(int[][] board) {
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 0) return false;
            }
        }
        return true;
    }
}
