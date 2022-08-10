package c32_Muiltithreading;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class EightQueenParallel {
    private static final ArrayList<ArrayList<int[]>> solutions = new ArrayList<>();
    public static final int SIZE = 8;
    private static final int[][] queens = new int[SIZE][SIZE];

    public static ArrayList<ArrayList<int[]>> findAllSolutions(){
        for (int[] queen : queens){
            Arrays.fill(queen, -1);
        }
        search();
        return solutions;
//        There are in total 92 solutions for Eight Queen game.
    }
    // search for n solutions

    public static void search(int set) {
        // all column values in queens[] are -1 so far
        queens[set][0] = set;
        while (true) {
            int row = (solutions.get(set).size() == 0) ? 1 : SIZE -1;
            while (row >= 1 && row < SIZE) {
                int column = findPosition(set, row);
                if (column < 0) {
                    queens[set][row] = -1;
                    row--;
                }
                else {
                    queens[set][row] = column;
                    row++;
                }
            }
            if (row != 0) {
                int[] solution = new int[SIZE];
                System.arraycopy(queens[set], 0, solution, 0, queens.length);
                solutions.get(set).add(solution);
            }
            else
                break;
        }
    }
    private static void search() {
        // initial the first search
        new Thread(() -> {
            solutions.add(new ArrayList<>());
            search(0);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i < queens.length; i++) {
            int column = i;
            solutions.add(new ArrayList<>());
            new Thread(() -> search(column)).start();
        }
    }

    private static int findPosition(int set, int row) {
        // queens[k] start is now -1
        int start = queens[set][row] + 1;

        for (int j = start; j < SIZE; j++) {
            if (isValid(row,j, set))
                return j;
        }
        return -1;
    }

    private static boolean isValid(int row, int column, int set) {
        for (int i = 1; i <= row; i++) {
            if (queens[set][row - i] == column || queens[set][row - i] == column - i || queens[set][row - i] == column + i)
                return false;
        }
        return true;
    }

}
