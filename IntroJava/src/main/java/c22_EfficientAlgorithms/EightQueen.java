package c22_EfficientAlgorithms;

import java.util.ArrayList;

public class EightQueen {
    private static final ArrayList<int[]> solutions = new ArrayList<>();
    public static final int SIZE = 8;
    private static final int[] queens = {-1,-1,-1,-1,-1,-1,-1,-1};

    public static ArrayList<int[]> main(){
        search();
        return solutions;
//        There are in total 92 solutions for Eight Queen game.
    }
    // search for n solutions
    private static void search() {
        // all column values in queens[] are -1 so far
        while (true) {
            int row = (solutions.size() == 0) ? 0 : SIZE -1;
            while (row >= 0 && row < SIZE) {
                int column = findPosition(row);
                if (column < 0) {
                    queens[row] = -1;
                    row--;
                }
                else {
                    queens[row] = column;
                    row++;
                }
            }
            if (row != -1) {
                int[] solution = new int[SIZE];
                System.arraycopy(queens, 0, solution, 0, queens.length);
                solutions.add(solution);
            }
            else
                break;
        }
    }

    private static int findPosition(int row) {
        // queens[k] start is now -1
        int start = queens[row] + 1;

        for (int j = start; j < SIZE; j++) {
            if (isValid(row,j))
                return j;
        }
        return -1;
    }

    private static boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++) {
            if (queens[row - i] == column || queens[row - i] == column - i || queens[row - i] == column + i)
                return false;
        }
        return true;
    }

}
