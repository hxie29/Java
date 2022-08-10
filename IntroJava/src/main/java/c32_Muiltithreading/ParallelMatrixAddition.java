package c32_Muiltithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelMatrixAddition {
    public static double[][] parallelAddMatrix(double[][] a, double[][]b) {
        RecursiveTask<double[][]> task = new AddTask(a, b);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    private static class AddTask extends RecursiveTask<double[][]> {
        private static final int THRESHOLD = 20;
        private final double[][] a;
        private final double[][] b;

        public AddTask(double[][] a, double[][] b) {
            this.a = a;
            this.b = b;
        }

        @Override
        protected double[][] compute() {
            double[][] result = new double[a.length][a[0].length];
            if (a.length <= THRESHOLD && a[0].length <= THRESHOLD) {
                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[0].length; j++) {
                        result[i][j] = a[i][j] + b[i][j];
                    }
                }
                return result;
            }

            double[][] a1;
            double[][] a2;
            double[][] b1;
            double[][] b2;

            if (a.length > THRESHOLD) {
                a1 = new double[a.length/2][a[0].length];
                a2 = new double[a.length - a.length/2][a[0].length];
                b1 = new double[b.length/2][b[0].length];
                b2 = new double[b.length - b.length/2][b[0].length];
                AddTask task1 = new AddTask(a1,b1);
                double[][] c1 = task1.fork().join();
                double[][] c2 = new AddTask(a2,b2).compute();

                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[0].length; j++) {
                        if (i < a1.length)
                            result[i][j] = c1[i][j] + c1[i][j];
                        else
                            result[i][j] = c2[i-a1.length][j] + c2[i-a1.length][j];
                    }
                }
            }

            else {
                a1 = new double[a.length][a[0].length/2];
                a2 = new double[a.length][a[0].length - a[0].length/2];
                b1 = new double[b.length][b[0].length/2];
                b2 = new double[b.length][b[0].length - b[0].length/2];

                AddTask task1 = new AddTask(a1,b1);
                double[][] c1 = task1.fork().join();
                double[][] c2 = new AddTask(a2,b2).compute();

                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[0].length; j++) {
                        if (j < a1[0].length)
                            result[i][j] = c1[i][j] + c1[i][j];
                        else
                            result[i][j] = c2[i][j-a1[0].length] + c2[i][j- a1[0].length];
                    }
                }
            }
            return result;
        }
    }
}
