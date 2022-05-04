/* (Latin square) A Latin square is an n-by-n array filled with n different Latin letters,
each occurring exactly once in each row and once in each column. Write a program that prompts 
the user to enter the number n and the array of characters, as shown in the sample output, 
and checks if the input array is a Latin square. The characters are the first n characters starting from A.

Enter number n: 4
Enter 4 rows of letters separated by spaces:
A B C D
B A D C
C D B A
D C A B
The input array is a Latin square */

import java.util.Scanner;
public class E0836 {

    public static void main(String[] args) {
        char[][] block = readMatrix();
        
        printMatrix(block);
        System.out.println(isLatinSqaure(block)? "The input array is a Latin square." : "The input array is not a Latin square.");
    }

    // print char matrix
    public static void printMatrix(char[][] matrix) {
       for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix[i].length; j++) {
               System.out.print(matrix[i][j] + " ");
           }
           System.out.println();
       }
   }

    // Generate n by n char matrix
    public static char[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n for n by n matrix:");
        int n = input.nextInt();
        char limit = (char)('A' + n -1);
        char[][] matrix = new char[n][n];
        int restart = 1;
        System.out.println("Enter " + n + "rows with " + n + " different letters seperated by spaces:");
        while (restart == 1){
            restart = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    char letter = input.next().charAt(0);
                    if (letter >= 'A' && letter <= limit) {
                        matrix[i][j] = letter;
                    }
                    else {
                        System.out.println("Wrong input: the letters must be from A to " + (limit + ""));
                        restart = 1;
                        break;
                    }
                }
                if (restart == 1) break;
            }
        }
        input.close();
        return matrix;
    }

    // Verify a Latin square
    public static boolean isLatinSqaure(char[][]block) {
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block.length; j++) {
                if (!unique(i, j, block)) return false;
            }
        }
        return true;
    }

    //verify a unique element in row and column of a block
    public static boolean unique(int i, int j, char[][]block) {
        char letter = block[i][j];
        // Verify this row
        for (int k = 0; k < block[i].length; k++) {
            if (block[i][k] == letter && k != j) return false;
        }

        // Verify this column
        for (int k = 0; k < block.length; k++) {
            if (block[k][j] == letter && k != i) return false;
        }

        return true;
    }
    
}
