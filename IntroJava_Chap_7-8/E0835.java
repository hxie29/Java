/* (Largest block) Given a square matrix with the elements 0 or 1, write a program to
find a maximum square submatrix whose elements are all 1s. Your program should
prompt the user to enter the number of rows in the matrix. The program then displays
the location of the first element in the maximum square submatrix and the number of rows in the submatrix. 

Enter the number of rows in the matrix: 5
Enter the matrix row by row:
1 0 1 0 1
1 1 1 0 1
1 0 1 1 1
1 0 1 1 1
1 0 1 1 1
The maximum square submatrix is at (2, 2) with size 3 */

import java.util.Scanner;
public class E0835 {

    public static void main(String[] args) {
        int[][] handblock = {{1, 0, 1, 0, 1},
                             {1, 1, 1, 0, 1},
                             {1, 0, 1, 1, 1},
                             {1, 0, 1, 1, 1},
                             {1, 0, 1, 1, 1}};
        System.out.println("The example block is:");
        printMatrix(handblock);
        //find sub blocks and sizes
        int[][] subBlock1 = sub(handblock);
        System.out.println("the sizes of blocks from each point is:");
        printMatrix(subBlock1);
        // find largest block and its size
        largestBlock(subBlock1);
        
        int[][] block = readMatrix();
        System.out.println("The computer generated random block is:");
        printMatrix(block);
        
        int[][] subBlock2 = sub(block);
        System.out.println("the sizes of blocks from each point is:");
        printMatrix(subBlock2);
        largestBlock(subBlock2);
    }

    // print integer matrix
    public static void printMatrix(int[][] matrix) {
       for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix[i].length; j++) {
               System.out.print(matrix[i][j] + " ");
           }
           System.out.println();
       }
   }

    // Generate n by n matrix
    public static int[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n for n by n matrix:");
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random() + 0.5);
            }
        }
        input.close();
        return matrix;
    }

    // find sub blocks and sizes
    public static int[][] sub(int[][] block) {
        int[][] sub = new int [block.length][block.length];
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++) {
                sub[i][j] = findSize(i, j, block);
            }
        }
        return sub;
    }

    // find size from one point in a block
    public static int findSize(int i, int j, int[][] block) {
        int size = 1;
        while (i + size <= block.length && j + size <= block.length) {
            if (!sameBlock(i, j, size, block)) {
                break;
            }
            else size++;
        }
        size--;
        return size;
    }

    // Verify a block
    public static boolean sameBlock(int i, int j, int size, int[][]block) {
        int n = block[i][j];
        for (int a = i; a < i + size; a++) {
            for (int b = j; b < j + size; b++) {
                if (block[a][b] != n) return false;
            }
        }
        return true;
    }
    
    // Find the largest size
    public static void largestBlock(int[][] subBlock){
        int index1 = 0;
        int index2 = 0;
        int max = subBlock[0][0];
        for (int i = 0; i < subBlock.length; i++) {
            for (int j = 0; j < subBlock.length; j++) {
                if (subBlock[i][j] > max) {
                    index1 = i;
                    index2 = j;
                    max = subBlock[index1][index2];
                }
            }
        }
        System.out.println("The maximum square submatrix is at (" + index1 + ", " + index2 + ") with size of " + max);
    }
}
