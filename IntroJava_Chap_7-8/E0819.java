/* (Pattern recognition: four consecutive equal numbers) Write the following
method that tests whether a two-dimensional array has four consecutive numbers
of the same value, either horizontally, vertically, or diagonally:
public static boolean isConsecutiveFour(int[][] values)

Write a test program that prompts the user to enter the number of rows and
columns of a two-dimensional array then the values in the array, and displays true
if the array contains four consecutive numbers with the same value. Otherwise,
the program displays false.*/

import java.util.Scanner;
public class E0819 {

    public static void main(String[] args) {
        int[][] m = readMatrix();
        printMatrix(m);
        isConsecutiveFour(m);
    }

     // Generate m by n matrix
     public static int[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows and volumns of the array");
        int row = input.nextInt();
        int column = input.nextInt();
        int[][] matrix = new int[row][column];
        System.out.println("Enter the array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        input.close();
        return matrix;
    }
    
     // print integer matrix
     public static void printMatrix(int[][] matrix) {
         System.out.println("The array is:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // check if matrix has consecutive four numbers
    public static void isConsecutiveFour(int[][] matrix) {
        if (horizontal(matrix) || vertical(matrix) || diagonal(matrix))
            System.out.println("True");
        else System.out.println("False");
    }
    // 

    // verify horizontal case
    public static boolean horizontal(int[][]matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 3; j++) {
                int count = 1;
                int n = 1;
                while (n < 4) {
                    if (matrix[i][j] == matrix[i][j+n]) {
                        count++;
                        n++;
                    }
                    else break;
                }
                if (count == 4) {
                    System.out.println("Horizontal 4 at row " + i);
                    return true;
                }
            }
        }
        return false;
    }

    // verify vertical case
    public static boolean vertical(int[][]matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length - 3; j++) {
                int count = 1;
                int n = 1;
                while (n < 4) {
                    if (matrix[j][i] == matrix[j+n][i]) {
                        count++; 
                        n++;
                    }
                    else break;
                }
                if (count == 4) {
                    System.out.println("Vertical 4 at column " + i);
                    return true;
                }
            }
        }
        return false;
    }

    // verify diagonal case
    public static boolean diagonal(int[][]matrix) {
        boolean majorDiagonal = false;
        boolean minorDiagonal = false;

        // check for major diagonal
        for (int i = 0; i < matrix.length - 3; i++) { 
            for (int j = 0; j < matrix[i].length -3; j++) {
                int count = 1;
                int n = 1;
                while (n < 4) {
                    if (matrix[i][j] == matrix[i+n][j+n]) {
                        count++;
                        n++;
                    }
                    else break;
                }
                if (count == 4) {
                    majorDiagonal = true;
                    System.out.println("Major diagonal 4 starts at block " + i + " " + j);
                    break;
                }
            }
            if (majorDiagonal) break;
        }

        // check for minor diagonal
        for (int i = 0; i < matrix.length - 3; i++) { 
            for (int j = 3; j < matrix[i].length ; j++) {
                int count = 1;
                int n = 1;
                while (n < 4) {
                    if (matrix[i][j] == matrix[i+n][j-n]) {
                        count++;
                        n++;
                    }
                    else break;
                }
                if (count == 4) {
                    minorDiagonal = true;
                    System.out.println("Minor diagonal 4 starts at block " + i + " " + j);
                    break;
                }
            }
            if (minorDiagonal) break;
        }

        boolean diagonal = majorDiagonal || minorDiagonal;
        return diagonal;
    }
}
