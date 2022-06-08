package c08_MultidimensionArrays;/* (Explore matrix) Write a program that prompts the user to enter the length of a
square matrix, randomly fills in 0s and 1s into the matrix, prints the matrix, and
finds the rows, columns, and diagonals with all 0s or 1s. 

Enter the size for the matrix: 4
0111
0000
0100
1111
All 0s on row 2
All 1s on row 4
No same numbers on a column
No same numbers on the major diagonal
No same numbers on the sub−diagonal
*/
import java.util.Scanner;
public class E0814 {

    public static void main(String[] args) {
        int[][] m = readMatrix();
        printMatrix(m);
        checkMatrix(m);
    }

    // Generate n by n matrix
    public static int[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n for n by n matrix:");
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random() + 0.5);
            }
        }
        input.close();
        return matrix;
    }

    // print integer matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }

    // Check same elements in row, column and diagonals
    public static void checkMatrix(int[][] matrix) {
        if (horizontal(1, matrix) != -1) System.out.println("All 1s on row " + horizontal(1, matrix));
        if (horizontal(0, matrix) != -1) System.out.println("All 0s on row " + horizontal(0, matrix));
        if (horizontal(0, matrix) == -1 && horizontal(1, matrix) == -1) System.out.println("No same numbers on a row.");
        if (vertical(1, matrix) != -1) System.out.println("All 1s on column " + vertical(1, matrix));
        if (vertical(0, matrix) != -1) System.out.println("All 0s on column " + vertical(0, matrix));
        if (vertical(0, matrix) == -1 && vertical(1, matrix) == -1) System.out.println("No same numbers on a column.");
        boolean[] diagonal0 = diagonal(0, matrix);
        boolean[] diagonal1 = diagonal(1, matrix);
        if (!diagonal0[0] && !diagonal1[0]) System.out.println("No same numbers on major diagonal.");
        if (!diagonal0[1] && !diagonal1[1]) System.out.println("No same numbers on minor diagonal.");
        if (diagonal0[0]) System.out.println("All 0s on major diagonal.");
        if (diagonal0[1]) System.out.println("All 0s on minor diagonal.");
        if (diagonal1[0]) System.out.println("All 1s on major diagonal.");
        if (diagonal1[1]) System.out.println("All 1s on minor diagonal.");
        
    }

    // verify horizontal case
    public static int horizontal(int n, int[][]matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == n) count++;
            }
            if (count == matrix[i].length) return i;
        }
        return -1;
    }

    // verify vertical case
    public static int vertical(int n, int[][]matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int count = 0;
            for (int[] ints : matrix) {
                if (ints[i] == n) count++;
            }
            if (count == matrix[i].length) return i;
        }
        return -1;
    }

    // verify diagonal case
    public static boolean[] diagonal(int n, int[][]matrix) {
        boolean majorDiagonal = true;
        boolean minorDiagonal = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != n) {
                majorDiagonal = false;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix.length - 1 - i] != n) {
                minorDiagonal = false;
                break;
            }
        }
        return new boolean[]{majorDiagonal, minorDiagonal};
    }

}
