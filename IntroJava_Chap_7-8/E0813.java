import java.util.Scanner;

/* (Locate the smallest element) Write the following method that returns the location
of the smallest element in a two-dimensional array.
public static int[] locateSmallest(double[][] a)
The return value is a one-dimensional array that contains two elements. These
two elements indicate the row and column indices of the smallest element in the
two-dimensional array. Write a test program that prompts the user to enter a twodimensional
array and displays the location of the smallest element in the array.
*/

public class E0813 {
    public static void main(String[] args) {
        double[][] matrix = readMatrix();
        int[] smallestIndex = getSmallIndex(matrix);
        System.out.println("The location of the smallest elements if at (" + smallestIndex[0] + ", " + smallestIndex[1] + ").");

    }

    // Generate m by n matrix
    public static double[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows and volumns of the array");
        int row = input.nextInt();
        int column = input.nextInt();
        double[][] matrix = new double[row][column];
        System.out.println("Enter the array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        input.close();
        return matrix;
    }

    public static int[] getSmallIndex(double[][] matrix) {
        int index0 = 0;
        int index1 = 0;
        double smallest = matrix[index0][index1];
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < smallest) {
                    index0 = i;
                    index1 = j;
                    smallest = matrix[i][j];
                }
            }
        }
        int[] index = {index0, index1};
        return index;
    }
    
}
