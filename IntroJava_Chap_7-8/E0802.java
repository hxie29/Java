/* (Average the major diagonal in a matrix) Write a method that averages all the
numbers in the major diagonal in an n * n matrix of double values
*/

import java.util.Scanner;
public class E0802 {
    public static void main(String[]args) {
        double[][] m = readMatrix();
        averageMajorDiagonal(m);

    }
    
    // read a 4 by 4 matrix
    public static double[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 4 by 4 matrix row by row");
        double[][] matrix = new double[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        input.close();
        return matrix;
    }

    // display sum of elements in each row from the matrix
    public static void averageMajorDiagonal(double[][] matrix) {
        double sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum +=matrix[i][i];
        }
        double average = sum / matrix.length;
        System.out.println("Average of the elements in the major diagonal is " + average);
    }
}
