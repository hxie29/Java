package c08_MultidimensionArrays;/* (Algebra: multiply two matrices) Write a method to multiply two matrices. The
header of the method is: public static double[][] multiplyMatrix(double[][] a, double[][] b)
To multiply matrix a by matrix b, the number of columns in a must be the same as
the number of rows in b, and the two matrices must have elements of the same or
compatible types. Let c be the result of the multiplication. Assume the column size
of matrix a is n. Each element cij is ai1 * b1j + ai2 * b2j + g + ain * bnj.
Write a test program that prompts the user to enter two 3 * 3 matrices and displays their product.
*/
import java.util.Scanner;
public class E0806 {
    public static void main(String[] args) {

        //Gnerate two 3X3 matrix
        double[][] m1 = readMatrix();
        double[][] m2 = readMatrix();

        double[][] m3 = multiplyMatrix(m1, m2);
        displayMultiply (m1, m2, m3);

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
        return matrix;
    }

    // Multiply two matrix
    public static double[][] multiplyMatrix(double[][]m1, double[][]m2) {
        double[][] m3 = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
               for (int k = 0; k < m2[i].length; k++) {
                    m3[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return m3;
    }

    // Display results
    public static void displayMultiply(double[][]m1, double[][]m2, double[][]m3) {
        System.out.println("The multiplication of the matrices is:");
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                System.out.printf("%-5.1f \t", m1[i][j]);
            }
            System.out.print((i == m1.length / 2) ? "*\t" : " \t");
            for (int j = 0; j < m2[i].length; j++) {
                System.out.printf("%-5.1f \t", m2[i][j]);
            }
            System.out.print((i == m1.length / 2) ? "=\t" : " \t");
            for (int j = 0; j < m3[i].length; j++) {
                System.out.printf("%-5.1f ", m3[i][j]);
            }
            System.out.println();
        }
    }
    
}
