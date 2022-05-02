/* (Points nearest to each other) Listing 8.3 gives a program that finds two points in
a two-dimensional space nearest to each other. Revise the program so it finds two
points in a three-dimensional space nearest to each other. Use a two-dimensional
array to represent the points. */

public class E0807 {
    public static void main(String[] args) {
        double[][] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1}, 
                            {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, 
                            {-1.5, 4, 2}, {5.5, 4, -0.5}};
        int p1 = 0, p2 = 1;
        double shortestDistance = distance(p1, p2, points);

        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (shortestDistance > distance(i, j, points)) {
                    p1 = i;
                    p2 = j;
                    shortestDistance = distance(i, j, points);
                }
            }
        }
        System.out.println("The shortest distance between points is " + shortestDistance + " bewtween point " + p1 + " and point " + p2);
    }

    // Calculate distance between two points in a space
    public static double distance(int p1, int p2, double[][]points) {
        double sum = 0;
        for (int i = 0; i < points[0].length; i++) {
            sum += Math.pow((points[p1][i] - points[p2][i]), 2);
        }
        return Math.pow(sum, 0.5);
    }
    
}
