package C11_InheritancePolymorphism;/*
(Largest rows and columns) Write a program that randomly fills in 0s and 1s
into an n-by-n matrix, prints the matrix, and finds the rows and columns with the
most 1s. (Hint: Use two ArrayLists to store the row and column indices with
the most 1s.) Here is a sample run of the program:

Enter the array size n: 4
The random array is
0011
0011
1101
1010
The largest row index: 2
The largest column index: 2, 3
*/

import java.util.ArrayList;
import java.util.Scanner;
public class E1109 {
    public static void main(String[] args){
        int[][] m = createMatrix();
        printMatrix(m);
        System.out.println("The largest row index: " + largestRow(m));
        System.out.println("The largest column index: " + largestColumn(m));
    }

    public static int[][] createMatrix(){
        System.out.println("Enter n for n by n matrix:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = (int)(Math.random() + 0.5);
            }
        }
        input.close();
        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        System.out.println("The random array is:");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> largestRow(int[][]matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = -1;
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == 1) count++;
            }
            if (max < count) {
                max = count;
                list.clear();
                list.add(i);
            }
            else if (max == count) {
                list.add(i);
            }
        }
        return list;  
    }

    public static ArrayList<Integer> largestColumn(int[][]matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = -1;
        for (int i = 0; i < matrix[0].length; i++) {
            int count = 0;
            for (int[] ints : matrix) {
                if (ints[i] == 1) count++;
            }
            if (max < count) {
                max = count;
                list.clear();
                list.add(i);
            }
            else if (max == count) {
                list.add(i);
            }
        }
        return list;  
    }

}
