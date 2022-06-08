package c08_MultidimensionArrays;/* (Column sorting) Implement the following method to sort the columns in a two
dimensional array. A new array is returned and the original array is intact.
public static double[][] sortColumns(double[][] m)

Enter a 4−by−4 matrix row by row:
0.15 0.875 0.375 0.225
0.55 0.005 0.225 0.015
0.30 0.12 0.4 0.008
0.07 0.021 0.14 0.2

The column−sorted array is
0.07 0.005 0.14 0.008
0.15 0.021 0.225 0.015
0.30 0.12 0.375 0.2
0.55 0.875 0.4 0.225 */

import java.util.Scanner;
public class E0827 {

    public static void main(String[] args) {
        double[][] m = readMatrix();
        double[][] sortedM = sortColumn(m);
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
    public static double[][] sortColumn(double[][] m) {
        for (int j = 0; j < m[0].length; j++) {
            for (int i = 0; i < m.length; i++) {
                double min = m[i][j];
                int index = i;
                for (int k = i + 1; k < m.length; k++) {
                    if (m[k][j] < min) {
                        index = k;
                        min = m[k][j];
                    }
                }
                if (index != i) {
                    double temp = m[i][j];
                    m[i][j] = min;
                    m[index][j] = temp;
                }
            }
        }
        return m;
    }

    // print double matrix
    public static void printMatrix(double[][] matrix) {
        System.out.println("The column-sorted array is:");
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
   }

        
}
