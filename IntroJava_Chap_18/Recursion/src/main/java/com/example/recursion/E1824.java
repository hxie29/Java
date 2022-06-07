/*Chess is played on a board with 64 squares arranged in an 8 * 8grid. The knight,
a piece in this game, can move only in an L-shaped pattern, that is, two squares
sideways and then one up or two squares up and one sideways. Can a knight access
every square of the chessboard from any other square using this pattern? Write a
recursive program that is able to show this.*/
package com.example.recursion;

public class E1824 {
    private static int x;
    private static int y;
    private static final int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static final int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };
    private static final int[][] matrix = new int[8][8];

    public static void main(String[] args) {
        x = (int)(Math.random() * 8);
        y = (int)(Math.random() * 8);
        solve();
    }

    public static void solve() {
        //If all squares has visits, then goal achieved, print the matrix showing each square's visits
        if (finished()) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }
        // if not, then generate a valid move, register the visit, and solve recursively
        else {
            generateMove();
            matrix[x][y]++;
            solve();
        }
    }

    public static void generateMove() {
        int direction = (int)(Math.random() * 8);
        x += xMove[direction];
        y += yMove[direction];
        // If move is not valid, generate move again
        if (!isValid()) {
            x -= xMove[direction];
            y -= yMove[direction];
            generateMove();
        }
    }
    private static boolean isValid() {
        return (x >= 0 && x < 8 && y>= 0 && y < 8);
    }

    public static boolean finished() {
        for (int[] rows : matrix) {
            for (int j: rows) {
                if (j == 0) return false;
            }
        }
        return true;
    }
}
