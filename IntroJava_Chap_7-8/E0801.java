/* (Sum elements row by row) Write a method that returns the sum of all the elements
in a specified row
*/

import java.util.Scanner;
public class E0801 {
    public static void main(String[]args) {
        double[][] m = readMatrix();
        displaySumMatrix(m);

    }
    
    // read a 3 by 4 matrix
    public static double[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3 by 4 matrix row by row");
        double[][] matrix = new double[3][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        input.close();
        return matrix;
    }

    // display sum of elements in each row from the matrix
    public static void displaySumMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum +=matrix[i][j];
            }
            System.out.println("Sum of the elements at row " + i + " is " + sum);
        }
    }
}
