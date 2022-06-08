package c08_MultidimensionArrays;

/* (Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players take turns
marking an available cell in a 3 * 3 grid with their respective tokens (either X
or O). When one player has placed three tokens in a horizontal, vertical, or diagonal
row on the grid, the game is over and that player has won. A draw (no winner)
occurs when all the cells on the grid have been filled with tokens and neither
player has achieved a win. Create a program for playing a tic-tac-toe game.
The program prompts two players to alternately enter an X token and O token.
Whenever a token is entered, the program redisplays the board on the console and
determines the status of the game (win, draw, or continue).
| | | |
| |X| |
| | | |
Enter a row (0, 1, or 2) for player X: 1
Enter a column (0, 1, or 2) for player X: 1
*/
import java.util.Arrays;
import java.util.Scanner;
public class E0809 {
    public static void main(String[] args) {
        int[][] board = initiateBoard();
        int status = 0;
     
        while(status == 0) {
            String[][] boardStr = translate(board);
            printBoard(boardStr);
            status = verifyGame(board);
            System.out.println(status);
            //Check winner or continue
            switch (status) {
                case 0 -> enterMoves(board);
                case 1 -> System.out.println("X player won.");
                case 2 -> System.out.println("O player won.");
                case 3 -> System.out.println("It is a draw.");
            }
        }
    }
    // Print board with symbols
    public static void printBoard(String[][] boardStr) {
        System.out.println("-------------");
        for (String[] strings : boardStr) {
            System.out.printf("| %1S | %1S | %1S |\n", strings[0], strings[1], strings[2]);
            System.out.println("-------------");
        }
    }
    
    //Initiate an empty game board
    public static int[][] initiateBoard(){
        int[][] board = new int[3][3];
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
                if (board[i][j] == 1) str[i][j] = "X";
                if (board[i][j] == 2) str[i][j] = "O";                
            }
        }
        return str;
    }

    // verify game status
    public static int verifyGame(int[][] board) {
        if (diagonal(1, board) || horizontal(1, board) || vertical(1, board)) return 1;
        else if (diagonal(2, board) || horizontal(2, board) || vertical(2, board)) return 2;
        else if (!fullBoard(board)) return 0;
        else return 3;
    }

    // verify horizontal case
    public static boolean horizontal(int n, int[][]board) {
        for (int[] ints : board) {
            if (ints[0] == n && ints[1] == n && ints[2] == n) return true;
        }
        return false;
    }

    // verify vertical case
    public static boolean vertical(int n, int[][]board) {
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == n && board[1][i] == n && board[2][i] == n) return true;
        }
        return false;
    }

    // verify diagonal case
    public static boolean diagonal(int n, int[][]board) {
        boolean majorDiagonal = true;
        boolean minorDiagonal = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != n) {
                majorDiagonal = false;
                break;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][2 - i] != n) {
                minorDiagonal = false;
                break;
            }
        }
        return majorDiagonal || minorDiagonal;
    }

    public static boolean fullBoard(int[][] board) {
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 0) return false;
            }
        }
        return true;
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
        boolean xMove = (count % 2 == 0);
        if (xMove) {
            System.out.println("Enter a row (0, 1, or 2 for player X: ");
            int index1 = input.nextInt();
            System.out.println("Enter a column (0, 1, or 2 for player X: ");
            int index2 = input.nextInt();
            if (board[index1][index2] == 0) board[index1][index2] = 1;
            else System.out.println("The block has been taken.");
        }
        else {
            System.out.println("Enter a row (0, 1, or 2 for player O: ");
            int index1 = input.nextInt();
            System.out.println("Enter a column (0, 1, or 2 for player : ");
            int index2 = input.nextInt();
            if (board[index1][index2] == 0) board[index1][index2] = 2;
            else System.out.println("The block has been taken.");
        }
    }
}
