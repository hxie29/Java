package c32_Muiltithreading;

import java.util.Arrays;

public class E3216 {
    public static void main(String[] args) {
        // Create a list
        final int N = 2000;
        double[][] matrix1 = new double[N][N];
        for (double[] value : matrix1) Arrays.fill(value, 1);

        double[][] matrix2 = new double[N][N];
        for (double[] doubles : matrix2) Arrays.fill(doubles, 1);

        long startTime = System.currentTimeMillis();
        double[][] result = ParallelMatrixAddition.parallelAddMatrix(matrix1, matrix2);
        long endTime = System.currentTimeMillis();
        System.out.println("The number of processors is " + Runtime.getRuntime().availableProcessors());
        System.out.println("Time is " + (endTime - startTime) + " milliseconds");

        double[][] result2 = new double[N][N];
        startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result2[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Sequential Time is " + (endTime - startTime) + " milliseconds");
    }
}
