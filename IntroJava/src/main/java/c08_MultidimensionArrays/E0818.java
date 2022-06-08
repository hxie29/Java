package c08_MultidimensionArrays;/* (Shuffle rows) Write a method that shuffles the rows in a two-dimensional int
array using the following header:
public static void shuffle(int[][] m)
Write a test program that shuffles the following matrix:
int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}}; */

public class E0818 {

    public static void main(String[] args) {
        int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        shuffleRows(m);
        printMatrix(m);
    }
    
    // shuffle matrix's rows
    static void shuffleRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int j = (int)(Math.random() * matrix.length);
            for (int k = 0; k < matrix[i].length; k++) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = temp;
            }
        }
    }
     // print integer matrix
     static void printMatrix(int[][] matrix) {
         for (int[] ints : matrix) {
             for (int anInt : ints) {
                 System.out.print(anInt + " ");
             }
             System.out.println();
         }
    }
}
