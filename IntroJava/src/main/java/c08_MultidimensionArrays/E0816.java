package c08_MultidimensionArrays;/* ((Sort two-dimensional array) Write a method to sort a two-dimensional array
using the following header:
public static void sort(int m[][])
The method performs a primary sort on rows, and a secondary sort on columns.
For example, the following array
{{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}}
will be sorted to
{{4, 5},{4, 2},{4, 1},{1, 7},{1, 2},{1, 1}}.
*/
import java.util.Scanner;
public class E0816 {

    public static void main(String[] args) {
        int[][] m = readMatrix();
        System.out.println("Matrix before being sorted: ");
        printMatrix(m);
        sort(m);
        System.out.println("Matrix after being sorted: ");
        printMatrix(m);
    }

    // Generate n by n matrix
    public static int[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows and volumns of the array");
        int row = input.nextInt();
        int column = input.nextInt();
        int[][] matrix = new int[row][column];
        System.out.println("Enter the matrix");
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
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    // Sort matrix in descending order (bubble sort)
    public static void sort(int[][] matrix) {
        int count = matrix.length;
        // Sort by row first
        while (count != 0) {
            count = 0;
            for (int i = 0; i < matrix.length - 1; i++) {
                if (matrix[i+1][0] > matrix[i][0]) {
                    int[] temp = matrix[i];
                    matrix[i] = matrix[i+1];
                    matrix[i+1] = temp;
                    count++;
                }
            }
        }
        // Sort by column if row number is the same
    }

}
