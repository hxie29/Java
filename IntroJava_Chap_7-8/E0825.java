/* (Markov matrix) An n * n matrix is called a positive Markov matrix if each
element is positive and the sum of the elements in each column is 1. Write the
following method to check whether a matrix is a Markov matrix:
public static boolean isMarkovMatrix(double[][] m)
Write a test program that prompts the user to enter a 3 * 3 matrix of double
values and tests whether it is a Markov matrix. Here are sample runs: */

import java.util.Scanner;
public class E0825 {

    public static void main(String[] args) {
        double[][] m = readMatrix();
        System.out.println(isMarkovMatrix(m) ? "It is a Markov matrix." : "It is not a Markov matrix.");
    }
    
    // Generate two 3X3 matrix
    public static double[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3 by 3 matrix row by row:");
        double[][] matrix = new double[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        input.close();
        return matrix;
    }

    public static boolean isMarkovMatrix(double[][] m) {
        // check if all elements are postive
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] < 0 || m[i][j] > 1) return false;
            }
        }

        double sum;
        /* check sums of each row
        for (int i = 0; i < m.length; i++) {
            sum = 0;
            for (int j = 0; j < m[i].length; j++) {
                sum += m[i][j];
            }
            System.out.println(sum);
            if (sum != 1.0) return false;
        }
        */
    
        // check sums of each column
        for (int j = 0; j < m[0].length; j++) {
            sum = 0;
            for (int i = 0; i < m.length; i++) {
                sum += m[i][j];
            }
            System.out.println(sum);
            if (sum != 1.0) return false;
        }
        return true;
    } 
}
