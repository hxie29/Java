import java.util.Scanner;

/* (All closest pairs of points) Revise Listing 8.3, FindNearestPoints.java, to display
all closest pairs of points with the same minimum distance.
Enter 8 points: 0 0 1 1 −1 −1 2 2 −2 −2 −3 −3 −4 −4 5 5
The closest two points are (0.0, 0.0) and (1.0, 1.0)
The closest two points are (0.0, 0.0) and (−1.0, −1.0)
The closest two points are (1.0, 1.0) and (2.0, 2.0)
The closest two points are (−1.0, −1.0) and (−2.0, −2.0)
The closest two points are (−2.0, −2.0) and (−3.0, −3.0)
The closest two points are (−3.0, −3.0) and (−4.0, −4.0)
Their distance is 1.4142135623730951 */

public class E0808 {
    public static void main(String[] args) {
        double[][] points = readMatrix();
        double[][] distanceOfAllPoints = distanceArray(points);
        sortDistance(distanceOfAllPoints);

        double minDistance = distanceOfAllPoints[0][2];
        System.out.println("The closest two points are " + printPoint(distanceOfAllPoints[0][0], points) + " and " 
        + printPoint(distanceOfAllPoints[0][1], points));
        for (int i = 1; i < distanceOfAllPoints.length; i++) {
            if (distanceOfAllPoints[i][2] == minDistance) {
                System.out.println("The closest two points are " + printPoint(distanceOfAllPoints[i][0], points) + " and " 
                + printPoint(distanceOfAllPoints[i][1], points));
            }

        }
        System.out.println("Their distance is " + minDistance);
    }

    // Generate two 8x2 matrix
    public static double[][] readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 8 points (x, y):");
        double[][] matrix = new double[8][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        input.close();
        return matrix;
    }

     // Calculate distance between two points in a space
     public static double[][] distanceArray(double[][]points) {
        double[][] array = new double[points.length * (points.length - 1) / 2][3];
        int i = 0;
        for (int j = 0; j < points.length; j++) {
            for (int k = j+1; k < points.length; k++) {
                array[i][0] = j;
                array[i][1] = k;
                array[i][2] = distance(j, k, points);
                i++;
            }
        }
        return array;
    }
    

    // Calculate distance between two points in a space
    public static double distance(int p1, int p2, double[][]points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            sum += Math.pow((points[p1][i] - points[p2][i]), 2);
        }
        return Math.pow(sum, 0.5);
    }

    // Sort all distances of a pair of points in ascending order
    public static void sortDistance(double[][] list) {
        for (int i = 0; i < list.length; i++) {
            double minDistance = list[i][2];
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (minDistance > list[j][2]) {
                    minIndex = j;
                    minDistance = list[j][2];
                }
            }
            if (minIndex != i) {
                double[] temp = list[minIndex];
                list[minIndex] = list [i];
                list[i] = temp;
            }
        }
    }

    // print coordinates of a point
    public static String printPoint(double n, double[][] points) {
        int index = (int)n;
        String str = "(" + points[index][0] + ", " + points[index][1] + ")";
        return str;
    }
    
}