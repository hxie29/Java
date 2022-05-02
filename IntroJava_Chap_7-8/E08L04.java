//Verify a Sudoku answer

import java.util.Scanner;

public class E08L04 {
    public static void main(String[] args) {
        //Read a Sudoku answer
        int[][] solution = readSudoku();
        System.out.println(verify(solution) ? "Valid solution." : "Invalid solution.");
        
    }
    
    // read a sudoku answer
    public static int[][] readSudoku() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Sudoku solution: ");
        int[][] solution = new int[9][9];
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                solution[i][j] = input.nextInt();
            }
        }
        input.close();
        return solution;
    }

    // verify solution
    public static boolean verify(int[][] solution) {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                // verify if numbers are between 1 to 9, and if numbers satisfy grid requirements
                if (solution[i][j] < 1 || solution[i][j] > 9 || !validGrid (i, j, solution)) return false;
            }
        }
        return true;
    }

    // verify grid requirement
    public static boolean validGrid(int i, int j, int[][] solution) {
        // verify if the number is unique in each row
        for (int column = 0; column < solution[i].length; column++) {
            if (column != j && solution [i][j] == solution [i][column]) return false;
        }

        // verify if the number is unique in each column
        for (int row = 0; row < solution.length; row++) {
            if (row != i && solution [row][j] == solution [i][j]) return false;
        }

        // verify if 3x3 block is unique
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int column = (j / 3) * 3; column < (j / 3) * 3 + 3; column++) {
                if (row != i && column != j && solution [row][column] == solution [i][j]) return false;
            }
        }
        return true;
    }
}
