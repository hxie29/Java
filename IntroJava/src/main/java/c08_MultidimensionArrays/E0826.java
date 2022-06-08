package c08_MultidimensionArrays;/* (Row sorting) Implement the following method to sort the rows in a twodimensional
array. A new array is returned and the original array is intact.
public static double[][] sortRows(double[][] m)
Write a test program that prompts the user to enter a 4 * 4 matrix of double
values and displays a new row-sorted matrix.

Enter a 4−by−4 matrix row by row:
0.15 0.875 0.375 0.225
0.55 0.005 0.225 0.015
0.30 0.12 0.4 0.008
0.07 0.021 0.14 0.2

The row−sorted array is
0.15 0.225 0.375 0.875
0.005 0.015 0.225 0.55
0.008 0.12 0.30 0.4
0.021 0.07 0.14 0.2 */

import java.util.Scanner;
public class E0826 {

    public static void main(String[] args) {
        double[][] m = readMatrix();
        double[][] sortedM = sortRows(m);
        printMatrix(sortedM);
    }
    
    // Generate two 4X4 matrix
    public static double[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 4 by 4 matrix row by row:");
        double[][] matrix = new double[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        input.close();
        return matrix;
    }

    // sort each row in ascending order
    public static double[][] sortRows(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                double min = m[i][j];
                int index = j;
                for (int k = j + 1; k < m[i].length; k++) {
                    if (m[i][k] < min) {
                        index = k;
                        min = m[i][k];
                    }
                }
                if (index != j) {
                    double temp = m[i][j];
                    m[i][j] = min;
                    m[i][index] = temp;
                }
            }
        }
        return m;
    }

    // print double matrix
    public static void printMatrix(double[][] matrix) {
        System.out.println("The row-sorted array is:");
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
   }

        
}
