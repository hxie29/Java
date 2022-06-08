package c10_ObjectOrientedThinking;/*
(Geometry: the bounding rectangle) A bounding rectangle is the minimum rectangle
that encloses a set of points in a two-dimensional plane, as shown in
Figure 10.24d. Write a method that returns a bounding rectangle for a set of
points in a two-dimensional plane, as follows:
public static MyRectangle2D getRectangle(double[][] points)
The Rectangle2D class is defined in Programming Exercise 10.13. Write a test
program that prompts the user to enter five points and displays the bounding
rectangle’s center, width, and height. Here is a sample run:
*/

import java.util.Scanner;
public class E1015 {
    public static void main(String[]args){
        double[][] points = new double[5][2];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter five points:");
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }
        MyRectangle2D r = getRectangle(points);
        
        System.out.println("The bounding rectangle's center is (" + r.getX() + ", " + r.getY() + "), width " 
                            + r.getWidth() + ", height " + r.getHeight());
        input.close();
    }

    public static MyRectangle2D getRectangle(double[][] points){
        double maxX = max(points, 0);
        double minX = min(points, 0);
        double maxY = max(points, 1);
        double minY = min(points, 1);

        double height = maxY - minY;
        double width = maxX - minX;
        double x = maxX - width/2;
        double y = maxY - height/2;
        return new MyRectangle2D(x, y, width, height);
    }

    public static double max(double[][] points, int index){
        double max = points[0][index];
        for (double[] point : points) {
            if (max < point[index]) {
                max = point[index];
            }
        }
        return max;
    }
    public static double min(double[][] points, int index){
        double min = points[0][index];
        for (double[] point : points) {
            if (min > point[index]) {
                min = point[index];
            }
        }
        return min;
    }
}
