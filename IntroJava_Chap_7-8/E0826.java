/* (Row sorting) Implement the following method to sort the rows in a twodimensional
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
        double[][] sorted = m;
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < sorted[i].length; j++) {
                double min = sorted[i][j];
                int index = j;
                for (int k = j + 1; k < sorted[i].length; k++) {
                    if (sorted[i][k] < min) {
                        index = k;
                        min = sorted[i][k];
                    }
                }
                if (index != j) {
                    double temp = sorted[i][j];
                    sorted[i][j] = min;
                    sorted[i][index] = temp;
                }
            }
        }
        return sorted;
    }

    // print double matrix
    public static void printMatrix(double[][] matrix) {
        System.out.println("The row-sorted array is:");
       for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix[i].length; j++) {
               System.out.print(matrix[i][j] + " ");
           }
           System.out.println();
       }
   }

        
}
