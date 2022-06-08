package c08_MultidimensionArrays;/* (Game: find the flipped cell) Suppose you are given a 6-by-6 matrix filled with
0s and 1s. All rows and all columns have an even number of 1s. Let the user flip
one cell (i.e., flip from 1 to 0 or from 0 to 1) and write a program to find which
cell was flipped. Your program should prompt the user to enter a 6-by-6 array
with 0s and 1s and find the first row r and first column c where the even number
of the 1s property is violated (i.e., the number of 1s is not even). The flipped cell
is at (r, c). */


import java.util.Scanner;
public class E0823 {
    public static void main(String[] args) {
        int[][] m = readMatrix();
        checkFlip(m);
    }
    
    // Generate m by n matrix
    public static int[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 6 by 6 array");
        int[][] matrix = new int[6][6];
        System.out.println("Enter the array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        input.close();
        return matrix;
    }

    //check the flipped cell
    public static void checkFlip(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!columnEven(j, matrix) && !rowEven(i, matrix)) {
                    System.out.println("The flipped cell is at(" + i + ", " + j +")");
                    count++;
                    break;
                }
            }
            if (count == 1) break;
        }
    }

    //Even column
    public static boolean columnEven(int j, int[][] matrix) {
        int count = 0;
        for (int[] ints : matrix) {
            if (ints[j] == 1) count++;
        }
        return (count % 2 == 0);
    }

    //Even row
    public static boolean rowEven(int i, int[][] matrix) {
        int count = 0;
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == 1) count++;
        }
        return (count % 2 == 0);
    }
}
